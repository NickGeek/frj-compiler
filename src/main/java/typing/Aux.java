package typing;

import com.google.common.collect.Streams;
import lombok.AllArgsConstructor;
import lombok.Value;
import parser.Modifier;
import parser.Program;
import parser.ProgramNode;

import java.util.*;
import java.util.stream.Stream;

/**
 * Auxiliary functions for the auxiliary notation used in the formalism.
 */
@AllArgsConstructor
public class Aux {
	private final Program program;

	public ProgramNode.ClassDeclaration classOf(ProgramNode.Type t) {
		var concreteName = t.name.replaceAll("@", "");

		return Optional.ofNullable(this.program.classDeclarations.get(concreteName))
				.orElseThrow(() -> new TypeError(
						t.pos(),
						String.format("'%s' does not exist or is not a class.", t)
				));
	}

	public Map<String, ProgramNode.BindingDeclaration> fields(ProgramNode.Type t) {
		return this.classOf(t).fields;
	}

	/**
	 * Implements multiple method types, which allows for promotion between reference capabilities.
	 *
	 * @param t The type of the receiver (T_0)
	 * @param methodName The base method to build on.
	 * @return The different method types possible for the given method.
	 */
	public MethodTypes methTypes(ProgramNode.Type t, String methodName) {
		ProgramNode.Type receiver = t;
		var receiverClassDec = this.classOf(receiver);
		Optional<ProgramNode.Method> methodOpt = receiverClassDec.isInterface
				? this.getInterfaceMethod(receiverClassDec, methodName)
				: Optional.ofNullable(receiverClassDec.methods.get(methodName));
		if (methodOpt.isEmpty()) {
			throw new TypeError(
					receiver.pos(),
					String.format("Cannot find the method '%s' on %s", methodName, receiver)
			);
		}

		ProgramNode.Method method = methodOpt.get();

		method = new ProgramNode.Method(
				method.pos(),
				receiver.mdf,
				receiver,
				method.returnType,
				method.name,
				Arrays.copyOfRange(method.args, 1, method.args.length),
				method.expression().orElse(null)
		);

		receiver = receiver.mdf == Modifier.MUT ? receiver.withMdf(Modifier.CAPSULE) : receiver;
		ProgramNode.Method capsuleMethod = new ProgramNode.Method(
				method.pos(),
				receiver.mdf,
				receiver,
				method.returnType.mdf == Modifier.MUT ? method.returnType.withMdf(Modifier.CAPSULE) : method.returnType,
				method.name,
				Arrays.stream(Arrays.copyOfRange(method.args, 1, method.args.length))
						.map(arg -> {
							if (arg.type.mdf != Modifier.MUT) return arg;
							return new ProgramNode.BindingDeclaration(
									arg.pos(),
									arg.type.withMdf(Modifier.CAPSULE),
									arg.name
							);
						})
						.toArray(ProgramNode.BindingDeclaration[]::new),
				method.expression().orElse(null)
		);

		ProgramNode.Method immMethod = new ProgramNode.Method(
				capsuleMethod.pos(),
				capsuleMethod.mdf == Modifier.READ ? Modifier.IMM : capsuleMethod.mdf,
				t.mdf == Modifier.MUT ? t.withMdf(Modifier.CAPSULE) : t,
				capsuleMethod.returnType.mdf == Modifier.READ ? capsuleMethod.returnType.withMdf(Modifier.IMM) : capsuleMethod.returnType,
				capsuleMethod.name,
				Arrays.stream(Arrays.copyOfRange(capsuleMethod.args, 1, capsuleMethod.args.length))
						.map(arg -> {
							if (arg.type.mdf != Modifier.READ) return arg;
							return new ProgramNode.BindingDeclaration(
									arg.pos(),
									arg.type.withMdf(Modifier.IMM),
									arg.name
							);
						})
						.toArray(ProgramNode.BindingDeclaration[]::new),
				capsuleMethod.expression().orElse(null)
		);

		return new MethodTypes(
				method,
				capsuleMethod,
				immMethod
		);
	}

	@Value
	public static class MethodTypes {
		public ProgramNode.Method original;
		public ProgramNode.Method capsule;
		public ProgramNode.Method imm;
	}

	public boolean isValidActor(ProgramNode.Type receiver) {
		var classDec = classOf(receiver);

		return receiver.mdf == Modifier.IMM ||
				(classDec.isCapability && classDec.fields.values().stream().allMatch(f -> f.type.mdf == Modifier.IMM));
	}

	/**
	 * Ensures that a given method will not be incorrectly overridden (due to a signature conflict) by C'.
	 *
	 * @param cP C', the class/interface that is being checked to see if it correctly overrides.
	 * @param method The method from the super-class/interface being checked against.
	 */
	public boolean overrideOk(ProgramNode.ClassDeclaration cP, ProgramNode.Method method) {
		return this.overrideOk(cP, method, new HashSet<>());
	}

	public Stream<String> getAllMethodNames(ProgramNode.ClassDeclaration interfaceDec) {
		return this.getAllMethodNames(interfaceDec, new HashSet<>());
	}

	public Optional<ProgramNode.Method> getInterfaceMethod(ProgramNode.ClassDeclaration interfaceDec, String name) {
		return this.getInterfaceMethods(interfaceDec, new HashSet<>())
				.filter(method -> method.name.equals(name))
				.findAny();
	}

	private boolean overrideOk(ProgramNode.ClassDeclaration cP, ProgramNode.Method method, Set<String> visited) {
		var parents = Optional.ofNullable(cP.extend).orElse(cP.impl);
		boolean parentsOk = Arrays.stream(parents)
				.filter(parent -> !visited.contains(parent))
				.peek(visited::add)
				.map(parent -> Objects.requireNonNull(this.program.classDeclarations.get(parent)))
				.allMatch(parent -> overrideOk(parent, method, visited));

		var alternateMethod = cP.methods.get(method.name);
		if (alternateMethod == null) return parentsOk;

		boolean isOk = Modifier.canInto(method.mdf, alternateMethod.mdf)
				&& method.returnType.equals(alternateMethod.returnType)
				&& Streams.zip(
						Arrays.stream(method.args).skip(1),
						Arrays.stream(alternateMethod.args).skip(1),
						(childArg, parentArg) -> parentArg.type.equals(childArg.type)).allMatch(argOk -> argOk);

		return isOk && parentsOk;
	}

	private Stream<String> getAllMethodNames(ProgramNode.ClassDeclaration interfaceDec, Set<String> visited) {
		assert interfaceDec.isInterface;
		var baseNames = interfaceDec.methods.keySet().stream();

		return Stream.concat(
				baseNames,
				Arrays.stream(interfaceDec.extend)
						.filter(parent -> !visited.contains(parent))
						.peek(visited::add)
						.map(this.program.classDeclarations::get)
						.flatMap(id -> this.getAllMethodNames(id, visited))
		);
	}

	private Stream<ProgramNode.Method> getInterfaceMethods(ProgramNode.ClassDeclaration interfaceDec, Set<String> visited) {
		assert interfaceDec.isInterface;
		var baseNames = interfaceDec.methods.values().stream();

		return Stream.concat(
				baseNames,
				Arrays.stream(interfaceDec.extend)
						.filter(parent -> !visited.contains(parent))
						.peek(visited::add)
						.map(this.program.classDeclarations::get)
						.flatMap(id -> this.getInterfaceMethods(id, visited))
		);
	}
}
