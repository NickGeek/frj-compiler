package typing;

import com.google.common.collect.Streams;
import parser.*;
import parser.ProgramNode.LiftedType;
import parser.ProgramNode.Type;
import util.Pair;
import visitors.CollectorVisitor;

import java.util.*;
import java.util.stream.Collectors;

public class TypeCheckVisitor extends CollectorVisitor {
	public Type expected;
	public Type computed;
	public boolean cap = false;

	private final Program program;
	private final Aux aux;
	private Map<String, Type> gamma;

	public TypeCheckVisitor(Program program, Type expected) {
		this.program = program;
		this.aux = new Aux(program);
		this.gamma = new HashMap<>();
		this.expected = expected;
		this.computed = null;
	}

	@Override
	public void visitNew(Expression.InstantiationExpr expr) {
		var classDef = this.program.classDeclarations.get(expr.name);
		if (classDef == null || classDef.isInterface) {
			throw new TypeError(expr.pos(), String.format("No class with the name '%s' exists.", expr.name));
		}

		if (classDef.fields.size() != expr.args.length) {
			throw new TypeError(
					expr.pos(),
					String.format("Expected %d arguments, got %d.", classDef.fields.size(), expr.args.length)
			);
		}

		Set<Modifier> argMdfs = Arrays.stream(expr.args)
				.map(argExpr -> {
					this.visitExpecting(argExpr, Type.ANY);
					return this.computed.mdf;
				})
				.collect(Collectors.toSet());

		// T1 f1 . . . Tn fn = fields(imm C<T>) and cap; Σ; Γ |- ei: Ti[mdf = imm]
		if (this.expected.mdf != Modifier.MUT && argMdfs.stream().allMatch(mdf -> Modifier.canInto(mdf, Modifier.IMM))) {
			Streams.forEachPair(
					classDef.fields.values().stream(),
					Arrays.stream(expr.args),
					(fieldDec, argExpr) -> {
						this.visitExpecting(argExpr, fieldDec.type.withMdf(Modifier.IMM));
					}
			);

			var computed = new Type(expr.pos(), Modifier.IMM, expr.name);
			this.expect(expr, computed);
			return;
		}

		if (classDef.isCapability && !this.cap) {
			throw new TypeError(expr.pos(), "Object capabilities may only be created in mut methods on capability" +
					" classes or the main expression.");
		}

		Streams.forEachPair(
				classDef.fields.values().stream(),
				Arrays.stream(expr.args),
				(fieldDec, argExpr) -> this.visitExpecting(argExpr, fieldDec.type)
		);

//		boolean canPromote = !argMdfs.contains(Modifier.MUT) && !argMdfs.contains(Modifier.READ);
		boolean canPromote = false; // Constructor promotion works, but it isn't in the formalism yet, so disabling for now.

		Modifier mdf = canPromote ? Modifier.CAPSULE : Modifier.MUT;

		var computed = new Type(expr.pos(), mdf, expr.name);
		this.expect(expr, computed);
	}

	@Override
	public void visitNewSignal(Expression.SignalConstructionExpr expr) {
		this.scopeGamma(() -> {
			this.gamma = this.gamma
					.entrySet()
					.stream()
					.filter(entry -> entry.getValue().mdf == Modifier.IMM || entry.getValue().mdf == Modifier.CAPSULE)
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			// TODO: make sure we give a useful error here if we filter out things that are attempted to be used

			if (!(this.expected instanceof LiftedType)) {
				throw new TypeError(expr.pos(), "Unexpected signal.");
			}

			LiftedType expected = (LiftedType) this.expected;
			this.visitExpecting(expr.head, expected.innerType);
			this.visitExpecting(expr.tail, expected);
			this.expect(expr, expected);
		});
	}

	@Override
	public void visitEmptySignal(Expression.EmptySignalExpr expr) {
		this.expect(expr, LiftedType.ANY);
	}

	@Override
	public void visitLookup(Expression.LookupExpr expr) {
		if (expr.lookup == Expression.LookupExpr.Lookup.HEAD) {
			var liftedExpected = new LiftedType(this.expected.pos(), this.expected);

			// cap;Sigma;Gamma |- e : @T
			this.visitExpecting(expr.signalExpr, liftedExpected);
			this.expect(expr, ((LiftedType) this.computed).innerType);
		} else {
			this.visitExpecting(expr.signalExpr, this.expected);
			this.expect(expr, this.computed);
		}
	}

	@Override
	public void visitLet(Expression.LetExpr expr) {
		visitExpecting(expr.value, expr.type);


		this.scopeGamma(() -> {
			this.gamma.put(expr.name, expr.type);
			expr.boundTo.accept(this);
		});
	}

	@Override
	public void visitIdentifier(Expression.IdentifierExpr expr) {
		this.expect(expr, Objects.requireNonNull(this.gamma.get(expr.name)));
	}

	@Override
	public void visitLiteral(Expression.LiteralExpr<?> expr) {
		var computed = switch (expr.type) {
			case INTEGER -> new Type(expr.pos(), Modifier.CAPSULE, "Int");
			case FLOAT -> new Type(expr.pos(), Modifier.CAPSULE, "Float");
			case STRING -> new Type(expr.pos(), Modifier.CAPSULE, "String");
			case BOOLEAN -> new Type(expr.pos(), Modifier.CAPSULE, "Bool");
		};

		this.expect(expr, computed);
	}

	@Override
	public void visitCall(DotExpression.CallExpr expr) {
		this.visitExpecting(expr.receiver, Type.ANY.withMdf(this.expected.mdf));
		var receiverType = this.computed;

		var receiverClassDec = this.aux.classOf(receiverType);
		Optional<ProgramNode.Method> methodOpt = receiverClassDec.isInterface
				? this.aux.getInterfaceMethod(receiverClassDec, expr.methodName)
				: Optional.ofNullable(receiverClassDec.methods.get(expr.methodName));

		if (methodOpt.isEmpty()) {
			throw new TypeError(
					expr.pos(),
					String.format("Cannot find the method '%s' on %s", expr.methodName, receiverType)
			);
		}

		ProgramNode.Method method = methodOpt.get();

		if (expr.args.length != method.args.length) {
			throw new TypeError(
					expr.pos(),
					String.format("Expected %d arguments for '%s', got %d", method.args.length - 1, expr.methodName, expr.args.length - 1)
			);
		}

		// If we applied the (newImm) rule when we could've done (newMut), change the mdf here
		if (
				expr.receiver instanceof Expression.InstantiationExpr
						&& ((Expression.InstantiationExpr) expr.receiver).args.length == 0
						&& method.mdf == Modifier.MUT
		) {
			receiverType = receiverType.withMdf(Modifier.MUT);
		}

		if (expr.isLifted) {
			// validActor(T_0)
			if (!this.aux.isValidActor(receiverType)) {
				throw new TypeError(
						expr.pos(),
						String.format(
								"'%s' is not a valid actor. Actors must either be imm or be a capability class with only imm fields.",
								expr.receiver
						)
				);
			}
		}

		// T_0..T_n -> T in methTypes(T_0, m)
		var methTypes = this.aux.methTypes(receiverType, expr.methodName);
		// mdf' <= mdf
		if (!Modifier.canInto(receiverType.mdf, method.mdf)) {
			throw new TypeError(
					expr.pos(),
					String.format("Cannot go between %s and %s", receiverType.mdf.toString().toLowerCase(), method.mdf.toString().toLowerCase())
			);
		}

		ProgramNode.Method selectedMethod;
		if (Modifier.canInto(receiverType.mdf, Modifier.IMM) && this.canIntoMdfs(expr.args, methTypes.imm.args)) {
			selectedMethod = methTypes.imm;
		} else if (Modifier.canInto(receiverType.mdf, Modifier.CAPSULE) && this.canIntoMdfs(expr.args, methTypes.capsule.args)) {
			selectedMethod = methTypes.capsule;
		} else {
			selectedMethod = methTypes.original;
		}

		// e_0 : T_0
		this.scopeGamma(() -> this.visitExpecting(expr.receiver, selectedMethod.args[0].type));

		if (expr.isLifted) {
			// e_i : T_i forall i in 1..n
			Streams.forEachPair(
					Arrays.stream(selectedMethod.args).skip(1),
					Arrays.stream(expr.args).skip(1),
					(methodArg, argExpr) -> this.visitExpecting(argExpr, new LiftedType(methodArg.pos(), methodArg.type))
			);

			this.computed = selectedMethod.args[0].type;
			this.expect(expr, new LiftedType(expr.pos(), selectedMethod.returnType));
		} else {
			// e_i : T_i forall i in 1..n
			Streams.forEachPair(
					Arrays.stream(selectedMethod.args).skip(1),
					Arrays.stream(expr.args).skip(1),
					(methodArg, argExpr) -> this.visitExpecting(argExpr, methodArg.type)
			);

			this.computed = selectedMethod.args[0].type;
			this.expect(expr, selectedMethod.returnType);
		}
	}

	@Override
	public void visitLiftedCall(DotExpression.CallExpr expr) {
		this.visitCall(expr);
	}

	@Override
	public void visitFieldAccess(DotExpression.FieldAccessExpr expr) {
		this.visitExpecting(expr.receiver, Type.ANY);
		var receiverType = this.computed;
		var field = this.aux.fields(receiverType).get(expr.fieldName);
		if (field == null) {
			throw new TypeError(
					expr.pos(),
					String.format("No field '%s' on type '%s'", expr.fieldName, receiverType)
			);
		}

		var computed = field.type.compose(receiverType.mdf);
		this.expect(expr, computed);
	}

	@Override
	public void visitFieldUpdate(DotExpression.FieldUpdateExpr expr) {
		this.visitExpecting(expr.receiver, Type.ANY);
		var receiverType = this.computed;
		if (receiverType.mdf != Modifier.MUT) {
			throw new TypeError(expr.pos(), "Only mut objects may have their fields updated.");
		}

		var field = this.aux.fields(receiverType).get(expr.fieldName);
		if (field == null) {
			throw new TypeError(
					expr.pos(),
					String.format("No field '%s' on type '%s'", expr.fieldName, receiverType)
			);
		}

		// e_2 : T_i
		this.visitExpecting(expr.value, field.type);

		// e_1.f_i = e_2 : T_i
		this.expect(expr, field.type);
	}

	@Override
	public void visitClassDeclaration(ProgramNode.ClassDeclaration classDec) {
		// overrideOk
		classDec.methods
				.values()
				.stream()
				.map(method -> new Pair<>(
						method,
						Arrays.stream(classDec.impl)
								.allMatch(name -> this.aux.overrideOk(this.program.classDeclarations.get(name), method))
				))
				.forEach(result -> {
					ProgramNode.Method method = result.getFirst();
					boolean isOk = result.getSecond();
					if (!isOk) {
						throw new TypeError(
								method.pos(),
								String.format(
										"'%s' overrides an existing method with the same name but with a different signature.",
										method.name
								)
						);
					}
				});

		// dom(C') ⊆ dom(C) forall C' in Cs
		Arrays.stream(classDec.impl)
				.map(this.program.classDeclarations::get)
				.flatMap(this.aux::getAllMethodNames)
				.forEach(name -> {
					if (!classDec.methods.containsKey(name)) {
						throw new TypeError(
								classDec.pos(),
								String.format(
										"'%s' does not implement '%s'",
										classDec.name,
										name
								)
						);
					}
				});

		// Check methods are OK
		this.cap = classDec.isCapability;
		classDec.methods.values().forEach(method -> method.accept(this));
	}

	@Override
	public void visitInterfaceDeclaration(ProgramNode.ClassDeclaration classDec) {
		// overrideOk
		classDec.methods
				.values()
				.stream()
				.map(method -> new Pair<>(
						method,
						Arrays.stream(classDec.extend)
								.allMatch(name -> this.aux.overrideOk(this.program.classDeclarations.get(name), method))
				))
				.forEach(result -> {
					ProgramNode.Method method = result.getFirst();
					boolean isOk = result.getSecond();
					if (!isOk) {
						throw new TypeError(
								method.pos(),
								String.format(
										"'%s' overrides an existing method with the same name but with a different signature.",
										method.name
								)
						);
					}
				});
	}

	@Override
	public void visitMethod(ProgramNode.Method method) {
		var _this = method.args[0].type;
		if (_this.mdf != method.mdf) {
			System.out.println("hi");
		}

		boolean oldCap = this.cap;
		this.cap = this.cap && method.mdf == Modifier.MUT;
		this.scopeGamma(() -> {
			this.gamma.put("this", method.args[0].type.withMdf(method.mdf));
			Arrays.stream(method.args).forEach(arg -> this.gamma.put(arg.name, arg.type));
			this.visitExpecting(method.expression().orElseThrow(), method.returnType);
		});
		this.cap = oldCap;
	}

	private void expect(Expression expr, Type computed) {
		boolean skipLiftedCheck = (computed instanceof LiftedType && this.expected.name.endsWith("@//Any//"))
				|| (this.expected instanceof LiftedType && computed.name.endsWith("@//Any//"));

		boolean skipCheck = this.expected.name.equals("//Any//") || computed.name.equals("//Any//") || skipLiftedCheck;

		if (!skipCheck && !this.expected.okayWithSub(this.program, computed)) {
			throw new TypeError(expr.pos(), String.format("Expected %s but got %s.", this.expected, computed));
		}
		this.computed = computed;
	}

	private void visitExpecting(Expression expr, Type expected) {
		Type oldExpected = this.expected;
		this.expected = expected;
		expr.accept(this);
		this.expected = oldExpected;
	}

	private void scopeGamma(Runnable scoped) {
		var oldGamma = new HashMap<>(this.gamma);
		scoped.run();
		this.gamma = oldGamma;
	}

	private boolean canIntoMdfs(Expression[] args, ProgramNode.BindingDeclaration[] targets) {
		if (args.length != targets.length) return false;

		// Start at 1 because the receiver has already been checked
		for (int i = 1; i < args.length; ++i) {
			var arg = args[i];
			var targetType = targets[i].type;

			var oldExpected = this.expected;
			try {
				this.visitExpecting(arg, targetType);
			} catch (TypeError e) {
				this.expected = oldExpected;
				return false;
			}
		}

		return true;
	}
}
