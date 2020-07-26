package parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Singleton class that handles errors and throws a catchable exception with a better error
 * message than ANTLR's default.
 */
public class ErrorHandler extends BaseErrorListener {
	public static final ErrorHandler INSTANCE = new ErrorHandler();

	private ErrorHandler() {
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		throw new ParseCancellationException(String.format(
				"Parser Error at: Line %d, col %d\n\t%s",
				line,
				charPositionInLine,
				msg
		));
	}
}
