package typing;

import lombok.EqualsAndHashCode;
import parser.Program;
import parser.ProgramNode;
import wellFormedness.MalformedException;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

@EqualsAndHashCode
public class Interface {
	private final ProgramNode.ClassDeclaration classDec;

	public Interface(ProgramNode.ClassDeclaration classDec) {
		if (!classDec.isInterface) {
			throw new IllegalArgumentException("Only interface descriptions can be used.");
		}
		this.classDec = classDec;
	}

	public Stream<ProgramNode.Method> methods(Program program) {
		var allMethodHeaders = Arrays.stream(this.classDec.extend)
				.map(program.classDeclarations::get)
				.filter(Objects::nonNull)
				.flatMap(cd -> new Interface(cd).methods(program))
				.peek(method -> {
					var conflictingMethod = this.classDec.methods.get(method.name);
					if (conflictingMethod != null && !conflictingMethod.equals(method)) {
						throw new MalformedException(
								conflictingMethod.pos().line,
								conflictingMethod.pos().col,
								String.format("%s conflicts with %s", conflictingMethod, method)
						);
					}
				});

		var currentInterfaceMethods = this.classDec.methods.values().stream();

		return Stream.concat(currentInterfaceMethods, allMethodHeaders).distinct();
	}
}
