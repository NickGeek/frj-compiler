package wellFormedness;

import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.List;
import java.util.stream.Collectors;

public class MalformedException extends ParseCancellationException {
	public MalformedException(int line, int col, String msg) {
		super(String.format(
				"Well-Formedness error at: Line %d, col %d\n\t%s",
				line,
				col,
				msg
		));
	}

	public MalformedException(List<MalformedException> exceptions) {
		super(exceptions.stream()
				.map(Throwable::getLocalizedMessage)
				.collect(Collectors.joining("\n")));
	}
}
