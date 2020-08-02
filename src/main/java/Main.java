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

			// Compute high level program object from the tree (duplicate names need to be removed because we use a Map data structure)
			new NoDuplicateNames().check(programContext);
			var program = Program.fromCtx(programContext);

			WellFormednessRule.runAllProgramChecks(
					RunChecks.makeChecks(program),
					program
			).ifPresent(Main::printErrorsAndQuit);

//			TypingRule.getErrors(program).ifPresent(Main::printErrorsAndQuit);
			var visitor = new TypeCheckVisitor(program, ProgramNode.Type.ANY);
			visitor.cap = true;
			program.main.accept(visitor);
			visitor.cap = false;

//			var idk = program.classDeclarations.values().stream().filter(cd -> cd.isInterface).map(typing.Interface::new).map(i -> i.methods(program).collect(java.util.stream.Collectors.toList())).collect(java.util.stream.Collectors.toList());

			System.out.println("Done!");
		} catch (ParseCancellationException | IOException e) {
			printErrorsAndQuit(e.getLocalizedMessage());
		}
	}

	private static void printErrorsAndQuit(String errors) {
		System.err.println(errors);
		System.exit(1);
	}
}
