import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Parser;
import parser.Program;
import wellFormedness.NoDuplicateNames;
import wellFormedness.RunChecks;
import wellFormedness.WellFormednessRule;

public class Main {
	public static void main(String[] cliArgs) {
		var source = "interface Hello {\n" +
				"\tmethod String name();\n" +
				"}\n" +
				"\n" +
				"class Foo implements Hello {\n" +
				"\tmut String name;\n" +
				"\tmethod String name(Int hey, Int hey2) = this.name;\n" +
				"}\n" +
				"\n" +
				"main = new Foo().name();";

		try {
			var programContext = Parser.fromString(source);
			new NoDuplicateNames().check(programContext);

			var program = Program.fromCtx(programContext);
			var errors = WellFormednessRule.runAllProgramChecks(program, RunChecks.makeChecks(program));
			if (errors.isPresent()) {
				System.err.println(errors.get());
				System.exit(1);
			}

			System.out.println("Done!");
		} catch (ParseCancellationException e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(1);
		}
	}
}
