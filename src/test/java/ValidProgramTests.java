import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class ValidProgramTests {
	@Parameterized.Parameters(name="Source code: {0}")
	public static Iterable<Path> data() throws IOException {
		var testCases = new File("src/test/resources/validPrograms").listFiles();
		if (testCases == null) {
			throw new FileNotFoundException("Error reading test cases");
		}

		return Arrays.stream(testCases).filter(File::isFile).map(File::toPath)::iterator;
	}

	private final Path source;

	public ValidProgramTests(Path source) {
		this.source = source;
	}

	@Test
	public void isValid() throws Exception {
		Compiler.compile(Parser.fromPath(this.source));
	}
}
