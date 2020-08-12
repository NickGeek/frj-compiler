import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.Parser;
import parser.Program;
import parser.ProgramNode;
import typing.TypeCheckVisitor;
import wellFormedness.NoDuplicateNames;
import wellFormedness.RunChecks;
import wellFormedness.WellFormednessRule;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
	public static void main(String[] cliArgs) {
		try {
			// Build parse tree
			var programContext = Parser.fromPath(Path.of(cliArgs[0]));
			Compiler.compile(programContext);
		} catch (ParseCancellationException | IOException e) {
			printErrorsAndQuit(e.getLocalizedMessage());
		}
	}

	public static void printErrorsAndQuit(String errors) {
		System.err.println(errors);
		System.exit(1);
	}
}
