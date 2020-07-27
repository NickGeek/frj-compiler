import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Parser;
import parser.Program;
import wellFormedness.NoDuplicateNames;

public class Main {
	public static void main(String[] args) {
		var source = "interface Hello {\n" +
				"\tmethod String name();\n" +
				"}\n" +
				"\n" +
				"class Foo implements Hello {\n" +
				"\tmut String name;\n" +
				"\tmethod String name() = this.name;\n" +
				"}\n" +
				"\n" +
				"main = new Foo().name();";

		try {
			var programContext = Parser.fromString(source);
			new NoDuplicateNames().visit(programContext);
			var program = Program.fromCtx(programContext);
			System.out.println(program);
			System.out.println("Done!");
		} catch (ParseCancellationException e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(1);
		}
	}
}
