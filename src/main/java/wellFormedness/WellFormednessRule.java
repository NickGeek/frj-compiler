package wellFormedness;

import parser.Program;

import java.util.List;
import java.util.Optional;

public interface WellFormednessRule<T> {
	/**
	 * Run the well-formedness rule
	 * @param toCheck The structure that the rule checks (i.e. {@link antlrGenerated.FRJSimpleParser.ProgramContext} or {@link parser.ProgramNode.Method}.
	 * @throws MalformedException throws if the rule has been violated.
	 */
	void check(T toCheck) throws MalformedException;

	static Optional<String> runAllProgramChecks(List<WellFormednessRunner> ruleRunners, Program program) {
		var errors = new StringBuilder();

		for (var runner : ruleRunners) {
			try {
				runner.accept(program);
			} catch (MalformedException e) {
				errors.append(e.getLocalizedMessage()).append("\n");
			}
		}

		return errors.length() > 0 ? Optional.of(errors.toString()) : Optional.empty();
	}

	@FunctionalInterface
	interface WellFormednessRunner {
		void accept(Program program) throws MalformedException;
	}
}
