import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Parser;
import parser.Program;
import typing.TypingRule;
import wellFormedness.NoDuplicateNames;
import wellFormedness.RunChecks;
import wellFormedness.WellFormednessRule;

public class Main {
	public static void main(String[] cliArgs) {
		var source = "interface A extends C { method Int foo(); }" +
				"interface B extends A { }" +
				"interface C extends B { }" +
				"interface D extends C { mut method Int foo(); }" +
				"main = true;";

		try {
			// Build parse tree
			var programContext = Parser.fromString(source);

			// Compute high level program object from the tree (duplicate names need to be removed because we use a Map data structure)
			new NoDuplicateNames().check(programContext);
			var program = Program.fromCtx(programContext);

			WellFormednessRule.runAllProgramChecks(
					RunChecks.makeChecks(program),
					program
			).ifPresent(Main::printErrorsAndQuit);

			TypingRule.getErrors(program).ifPresent(Main::printErrorsAndQuit);

//			var idk = program.classDeclarations.values().stream().filter(cd -> cd.isInterface).map(typing.Interface::new).map(i -> i.methods(program).collect(java.util.stream.Collectors.toList())).collect(java.util.stream.Collectors.toList());

			System.out.println("Done!");
		} catch (ParseCancellationException e) {
			printErrorsAndQuit(e.getLocalizedMessage());
		}
	}

	private static void printErrorsAndQuit(String errors) {
		System.err.println(errors);
		System.exit(1);
	}
}
