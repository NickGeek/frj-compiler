package wellFormedness;

import parser.Program;

import java.util.ArrayList;
import java.util.List;

public class RunChecks {
	public static List<WellFormednessRule.WellFormednessRunner> makeChecks(Program program) {
		var runners = new ArrayList<WellFormednessRule.WellFormednessRunner>();

		program.classDeclarations
				.values()
				.stream()
				.flatMap(cd -> cd.methods.values().stream())
				.forEach(method -> runners.add(p -> new MethodArgumentNaming().check(method.args)));

		return runners;
	}
}
