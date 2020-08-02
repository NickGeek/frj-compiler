package typing;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import parser.ProgramNode;

import java.util.List;
import java.util.stream.Collectors;

public class TypeError extends ParseCancellationException {
	public TypeError(ProgramNode.Position pos, String msg) {
		super(String.format(
				"Type error at: %s\n\t%s",
				pos.line >= 0 ? String.format("Line %d, col %d", pos.line, pos.col) : "???",
				msg
		));
	}

	public TypeError(List<TypeError> exceptions) {
		super(exceptions.stream()
				.map(Throwable::getLocalizedMessage)
				.collect(Collectors.joining("\n")));
	}
}
