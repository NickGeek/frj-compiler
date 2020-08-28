import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Parser;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
	public static void main(String[] cliArgs) {
		if (cliArgs.length < 1) {
			printErrorsAndQuit("Please provide a FRJ file to compile.");
		}

		try {
			// Build parse tree
			var programContext = Parser.fromPath(Path.of(cliArgs[0]));
			Compiler.compile(programContext);
		} catch (ParseCancellationException | IOException e) {
			printErrorsAndQuit(e.getLocalizedMessage());
		}
	}

	private static void printErrorsAndQuit(String errors) {
		System.err.println(errors);
		System.exit(1);
	}
}
