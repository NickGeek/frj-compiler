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
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParserFuzzTests {
	@Parameterized.Parameters(name="Fuzz test case {0}")
	public static Iterable<Object[]> data() throws IOException {
		var testCases = new File("src/test/resources/fuzzTestCases").listFiles();
		if (testCases == null) {
			throw new FileNotFoundException("Error reading test cases");
		}

		Arrays.sort(testCases);

		var testFiles = Arrays.stream(testCases).filter(File::isFile);

		var expectationsDir = GenerateFuzzTestingAnswers.expectations.toFile().listFiles();
		if (expectationsDir == null) {
			throw new FileNotFoundException("Error reading expectation directory cases");
		}

		var expectations = Arrays.stream(expectationsDir)
				.filter(File::isFile)
				.sorted()
				.map(file -> {
					try {
						return Files.readString(file.toPath());
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				});

		return Streams.zip(
				testFiles,
				expectations,
				(testFile, expectation) -> new Object[] { testFile, expectation }).collect(Collectors.toList());
	}

	private final File testCase;
	private final String expected;
	private final String standardLib;

	public ParserFuzzTests(File testCase, String expected) throws IOException {
		this.testCase = testCase;
		this.expected = expected;

		this.standardLib = Program.fromCtx(Parser.fromPath(Path.of("src", "main", "frj", "std.frj"))).toString();
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
			assertEquals(e.getLocalizedMessage(), this.expected);
			return;
		}

		var program = Program.fromCtx(programContext);
		assertEquals(program.toString(), this.expected);
	}
}
