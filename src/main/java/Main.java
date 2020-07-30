import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Parser;
import parser.Program;
import wellFormedness.NoDuplicateNames;
import wellFormedness.RunChecks;
import wellFormedness.WellFormednessRule;

public class Main {
	public static void main(String[] cliArgs) {
		var source = "interface H2 extends Hello { method Int foo2(); } interface Hello {\n" +
				"\tmethod String name();\n" +
				"}\n" +
				"\n" +
				"class Foo implements Hello {\n" +
				"\t@String name;\n" +
				"\tmethod String name(Int hey, capsule Int hey2) = Int hey3 = 5, Int hey4 = hey, this.name;\n" +
				"\tmethod String foo(capsule Int trouble) = this.name(12, trouble);\n" +
				"}\n" +
				"\n" +
				"main = new Foo().name();";

		try {
			var programContext = Parser.fromString(source);
			new NoDuplicateNames().check(programContext);

			var program = Program.fromCtx(programContext);
			var errors = WellFormednessRule.runAllProgramChecks(program, RunChecks.makeChecks(program));

//			var idk = program.classDeclarations.values().stream().filter(cd -> cd.isInterface).map(Interface::new).map(i -> i.methods(program).collect(Collectors.toList())).collect(Collectors.toList());

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
