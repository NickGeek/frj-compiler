import com.google.common.collect.Streams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parser.Parser;
import parser.Program;
import wellFormedness.MalformedException;
import wellFormedness.NoDuplicateNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeNoException;

@RunWith(Parameterized.class)
public class ParserFuzzTests {
	@Parameterized.Parameters(name="Fuzz test case {0}")
	public static Iterable<Object[]> data() throws IOException {
		var testCases = new File("src/test/resources/fuzzTestCases").listFiles();
		if (testCases == null) {
			throw new FileNotFoundException("Error reading test cases");
		}

		var testFiles = Arrays.stream(testCases).filter(File::isFile);

		var expectations = Files.lines(Paths.get("src/test/resources/fuzzTestExpectations.txt"));

		return Streams.zip(
				testFiles,
				expectations,
				(testFile, expectation) -> new Object[] { testFile, expectation }).collect(Collectors.toList());
	}

	private final File testCase;
	private final String expected;

	public ParserFuzzTests(File testCase, String expected) {
		this.testCase = testCase;
		this.expected = expected;
	}

	@Test
	public void isValidSyntax() throws Exception {
		Parser.fromPath(this.testCase.toPath());
	}

	@Test
	public void generatesValidProgram() throws Exception {
		var programContext = Parser.fromPath(this.testCase.toPath());

		// Only run this if the code passes the duplicate well-formedness check
		try {
			new NoDuplicateNames().visit(programContext);
		} catch (MalformedException e) {
			assumeNoException(e);
		}

		var program = Program.fromCtx(programContext);
		assertEquals(program.toString(), this.expected);
	}
}
