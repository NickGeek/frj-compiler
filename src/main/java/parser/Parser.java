package parser;

import antlrGenerated.FRJLexer;
import antlrGenerated.FRJSimpleParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.nio.file.Path;

public class Parser {
	/**
	 * Lexes and generates a parse tree for the given source code.
	 * @param source The source code of the program.
	 * @return The context for the program node containing the whole program tree (CDs and a main expression).
	 * @throws ParseCancellationException Throws if the syntax is invalid or it cannot parse the source code.
	 */
	public static FRJSimpleParser.ProgramContext fromString(String source) throws ParseCancellationException {
		var lexer = new FRJLexer(CharStreams.fromString(source));
		return makeParser(lexer);
	}

	public static FRJSimpleParser.ProgramContext fromPath(Path source) throws ParseCancellationException, IOException {
		var lexer = new FRJLexer(CharStreams.fromPath(source));
		return makeParser(lexer);
	}

	private static FRJSimpleParser.ProgramContext makeParser(FRJLexer lexer) {
		replaceErrorListeners(lexer);

		var parser = new FRJSimpleParser(new CommonTokenStream(lexer));
		replaceErrorListeners(parser);
		return parser.program();
	}

	private static void replaceErrorListeners(Recognizer<?, ?> recognizer) {
		recognizer.removeErrorListeners();
		recognizer.addErrorListener(ErrorHandler.INSTANCE);
	}
}
