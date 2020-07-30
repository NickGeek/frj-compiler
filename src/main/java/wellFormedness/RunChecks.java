package wellFormedness;

import parser.Program;

import java.util.ArrayList;
import java.util.List;

public class RunChecks {
	public static List<WellFormednessRule.WellFormednessRunner> makeChecks(Program program) {
		var runners = new ArrayList<WellFormednessRule.WellFormednessRunner>();

		runners.add(p -> new NoShadowing().check(p));
		runners.add(p -> new ClassDecExtendImplsCheck().check(p));
		runners.add(p -> new CheckVarsUsedAreInScope().check(p));
		runners.add(p -> new EmptySignalCheck().check(p));

		program.classDeclarations
				.values()
				.stream()
				.peek(cd -> new FieldMdfOnlyImmMut().check(cd))
				.flatMap(cd -> cd.methods.values().stream())
				.forEach(method -> {
					runners.add(p -> new MethodArgumentNaming().check(method.args));
					runners.add(p -> new CapsuleUsage().check(method));
				});

		return runners;
	}
}
