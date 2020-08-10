package aux;

import lombok.AllArgsConstructor;
import lombok.Value;
import parser.Modifier;
import parser.Program;
import parser.ProgramNode;
import typing.TypeError;

import java.util.*;

/**
 * Auxiliary functions for the auxiliary notation used in the formalism.
 */
@AllArgsConstructor
public class Aux {
	private final Program program;

	public ProgramNode.ClassDeclaration classOf(ProgramNode.Type t) {
		var concreteName = t.name.replaceAll("@", "");

		return Optional.ofNullable(this.program.classDeclarations.get(concreteName))
				.filter(cd -> !cd.isInterface)
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
		var method = Objects.requireNonNull(this.classOf(t).methods.get(methodName));
		ProgramNode.Type receiver = t;

		method = new ProgramNode.Method(
				method.pos(),
				receiver.mdf,
				receiver,
				method.returnType,
				method.name,
				Arrays.copyOfRange(method.args, 1, method.args.length),
				method.expression().orElseThrow()
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
				method.expression().orElseThrow()
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
				capsuleMethod.expression().orElseThrow()
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
}
