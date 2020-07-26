import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Program;
import parser.Parser;

public class Main {
	public static void main(String[] args) {
		var program = "interface Hello {\n" +
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
			// TODO: I need to do the duplicate naming check before making the AST
			var ast = Program.fromCtx(Parser.fromString(program));
			System.out.println("Done!");
		} catch (ParseCancellationException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}
