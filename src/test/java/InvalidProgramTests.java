import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class InvalidProgramTests {
	@Parameterized.Parameters(name="Source code: {0}")
	public static Iterable<Path> data() throws IOException {
		var testCases = new File("src/test/resources/invalidPrograms").listFiles();
		if (testCases == null) {
			throw new FileNotFoundException("Error reading test cases");
		}

		return Arrays.stream(testCases).filter(File::isFile).map(File::toPath)::iterator;
	}

	private final Path source;

	public InvalidProgramTests(Path source) {
		this.source = source;
	}

	@Test
	public void isInvalid() throws Exception {
		try {
			Compiler.compile(Parser.fromPath(this.source), false);
			fail();
		} catch (ParseCancellationException e) {
			e.printStackTrace();
		}
	}
}
