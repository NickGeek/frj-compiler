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
				"\tmethod String name(Int hey, capsule Int hey2) = Int hey3 = 5, Int hey4 = 6, this.name;\n" +
				"\tmethod String foo(capsule Int trouble) = this.name(12, trouble);\n" +
				"}\n" +
				"\n" +
				"main = new Foo().name();";

		System.out.println(source);

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
			System.out.println(program.toString());
		} catch (ParseCancellationException e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(1);
		}
	}
}
