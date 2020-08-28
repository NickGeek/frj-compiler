package wellFormedness;

import parser.Program;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefinedTypes implements WellFormednessRule<Program> {
	@Override
	public void check(Program program) throws MalformedException {
		var unknownTypes = program.classDeclarations
				.values()
				.stream()
				.flatMap(cd -> Stream.concat(cd.fields.values().stream(), cd.methods.values().stream().flatMap(method -> Arrays.stream(method.args))))
				.filter(binding -> !program.classDeclarations.containsKey(binding.type.name.replaceAll("@", "")))
				.map(binding -> new MalformedException(binding.pos().line, binding.pos().col, String.format("'%s' has not been declared.", binding.type.name)))
				.collect(Collectors.toList());

		if (!unknownTypes.isEmpty()) throw new MalformedException(unknownTypes);
	}
}
