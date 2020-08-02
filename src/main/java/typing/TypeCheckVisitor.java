package typing;

import aux.Aux;
import com.google.common.collect.Streams;
import parser.*;
import parser.ProgramNode.LiftedType;
import parser.ProgramNode.Type;
import visitors.CollectorVisitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		if (Modifier.canInto(Modifier.MUT, this.expected.mdf)) {
			Streams.forEachPair(
					classDef.fields.values().stream(),
					Arrays.stream(expr.args),
					(fieldDec, argExpr) -> this.visitExpecting(argExpr, fieldDec.type)
			);

			if (classDef.isCapability && !this.cap) {
				throw new TypeError(expr.pos(), "Object capabilities may only be created in mut methods on capability" +
						" classes or the main expression.");
			}

			var computed = new Type(expr.pos(), Modifier.MUT, expr.name);
			this.expect(expr, computed);
		} else if (Modifier.canInto(Modifier.IMM, this.expected.mdf)) {
			Streams.forEachPair(
					classDef.fields.values().stream(),
					Arrays.stream(expr.args),
					(fieldDec, argExpr) -> {
						this.visitExpecting(argExpr, fieldDec.type.compose(Modifier.IMM));
						if (!Modifier.canInto(this.computed.mdf, Modifier.IMM)) {
							throw new TypeError(
									argExpr.pos(),
									"Arguments must be immutable for creating an immutable object.\n" +
											"You could try using capsules."
							);
						}
					}
			);

			var computed = new Type(expr.pos(), Modifier.IMM, expr.name);
			this.expect(expr, computed);
		} else {
			throw new TypeError(expr.pos(), "Objects can only be created as mut/imm.");
		}
	}

	@Override
	public void visitNewSignal(Expression.SignalConstructionExpr expr) {
		var oldGamma = this.gamma;
		this.gamma = this.gamma
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue().mdf == Modifier.IMM || entry.getValue().mdf == Modifier.CAPSULE)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		if (!(this.expected instanceof LiftedType)) {
			throw new TypeError(expr.pos(), "Unexpected signal.");
		}

		LiftedType expected = (LiftedType) this.expected;
		this.visitExpecting(expr.head, expected.innerType);
		this.visitExpecting(expr.tail, expected);
		this.expect(expr, expected);

		this.gamma = oldGamma;
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

		var oldGamma = this.gamma;
		var scopedGamma = new HashMap<>(this.gamma);
		scopedGamma.put(expr.name, this.computed.withMdf(expr.type.mdf));
		this.gamma = scopedGamma;

		expr.boundTo.accept(this);

		this.gamma = oldGamma;
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
		// e_0 : T_0
		this.visitExpecting(expr.receiver, Type.ANY);
		var receiverType = this.computed;

		var method = this.aux.classOf(receiverType).methods.get(expr.methodName);
		if (method == null) {
			throw new TypeError(
					expr.pos(),
					String.format("Cannot find the method '%s' on %s", expr.methodName, receiverType)
			);
		}

		// T_0..T_n -> T in methTypes(T_0, m)
		var methTypes = this.aux.methTypes(receiverType, expr.methodName);
		if (!Modifier.canInto(this.expected.mdf, method.mdf)) { // mdf' <= mdf
			throw new TypeError(
					expr.pos(),
					String.format("Cannot go between %s to %s", this.expected.mdf, methTypes.original.mdf)
			);
		}

		ProgramNode.Method selectedMethod = switch (this.expected.mdf) {
			case CAPSULE -> methTypes.capsule;
			case IMM -> methTypes.imm;
			default -> methTypes.original;
		};

		// e_i : T_i
		Streams.forEachPair(
				Arrays.stream(selectedMethod.args),
				Arrays.stream(expr.arguments),
				(methodArg, argExpr) -> this.visitExpecting(argExpr, methodArg.type)
		);

		this.expect(expr, selectedMethod.returnType);
	}

	@Override
	public void visitLiftedCall(DotExpression.CallExpr expr) {
		// TODO
		throw new UnsupportedOperationException();
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
			throw new TypeError(expr.pos(), "Only mut objects may have their field's updated.");
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
}
