package typing;

import lombok.EqualsAndHashCode;
import parser.Program;
import parser.ProgramNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

@EqualsAndHashCode
public class Interface {
	private final ProgramNode.ClassDeclaration interfaceDec;

	public Interface(ProgramNode.ClassDeclaration interfaceDec) {
		if (!interfaceDec.isInterface) {
			throw new IllegalArgumentException("Only interface declarations can be used.");
		}
		this.interfaceDec = interfaceDec;
	}

	public Stream<ProgramNode.Method> methods(Program program) throws TypeError {
		return this.methods(program, new HashSet<>());
	}

	private Stream<ProgramNode.Method> methods(Program program, Set<String> visitedInterfaces) throws TypeError {
		visitedInterfaces.add(this.interfaceDec.name);

		var allMethodHeaders = Arrays.stream(this.interfaceDec.extend)
				.map(program.classDeclarations::get)
				.filter(Objects::nonNull)
				.filter(cd -> !visitedInterfaces.contains(cd.name))
				.flatMap(cd -> new Interface(cd).methods(program, visitedInterfaces))
				.peek(method -> {
					var conflictingMethod = this.interfaceDec.methods.get(method.name);
					if (conflictingMethod != null && !conflictingMethod.equals(method)) {
						throw new TypeError(
								conflictingMethod.pos(),
								String.format("%s conflicts with %s", conflictingMethod, method)
						);
					}
				});

		var currentInterfaceMethods = this.interfaceDec.methods.values().stream();

		return Stream.concat(currentInterfaceMethods, allMethodHeaders).distinct();
	}
}