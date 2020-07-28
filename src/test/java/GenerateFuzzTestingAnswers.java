import parser.Parser;
import parser.Program;
import wellFormedness.MalformedException;
import wellFormedness.NoDuplicateNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class GenerateFuzzTestingAnswers {
	public static final Path expectations = Paths.get("src/test/resources/fuzzTestExpectations.txt");

	public static void main(String[] args) throws IOException {
		var testCases = new File("src/test/resources/fuzzTestCases").listFiles();
		if (testCases == null) {
			throw new FileNotFoundException("Error reading test cases");
		}

		var results = Arrays.stream(testCases)
				.filter(File::isFile)
				.map(file -> {
					try {
						var programContext = Parser.fromPath(file.toPath());

						// The test case will be skipped if this well formedness check fails
						try {
							new NoDuplicateNames().visit(programContext);
							return Program.fromCtx(programContext).toString();
						} catch (MalformedException e) {
							return "Skipped test";
						}

					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				});

		// Write the results of the parse to a file.
		// The results will need to be checked manually to validate they're correct.
		Files.write(expectations, (Iterable<String>) results::iterator);
	}
}
