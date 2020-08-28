package wellFormedness;

import parser.Program;

import java.util.ArrayList;
import java.util.List;

public interface WellFormednessRule<T> {
	/**
	 * Run the well-formedness rule
	 * @param toCheck The structure that the rule checks (i.e. {@link antlrGenerated.FRJSimpleParser.ProgramContext} or {@link parser.ProgramNode.Method}.
	 * @throws MalformedException throws if the rule has been violated.
	 */
	void check(T toCheck) throws MalformedException;

	static void runAllProgramChecks(List<WellFormednessRunner> ruleRunners, Program program) {
		List<MalformedException> errors = new ArrayList<>();

		for (var runner : ruleRunners) {
			try {
				runner.accept(program);
			} catch (MalformedException e) {
				errors.add(e);
			}
		}

		if (!errors.isEmpty()) throw new MalformedException(errors);
	}

	@FunctionalInterface
	interface WellFormednessRunner {
		void accept(Program program) throws MalformedException;
	}
}
