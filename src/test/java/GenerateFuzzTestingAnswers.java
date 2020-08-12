import org.antlr.v4.runtime.misc.ParseCancellationException;
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
	public static final Path expectations = Paths.get("src/test/resources/fuzzTestExpectations");

	public static void main(String[] args) throws IOException {
		var testCases = new File("src/test/resources/fuzzTestCases").listFiles();
		if (testCases == null) {
			throw new FileNotFoundException("Error reading test cases");
		}

		Arrays.stream(testCases)
				.parallel()
				.filter(File::isFile)
				.forEach(file -> {
					try {
						var programContext = Parser.fromPath(file.toPath());
						var outputPath = expectations.resolve(file.getName());
						String expectation;

						// The test case will be skipped if this well formedness check fails
						try {
							new NoDuplicateNames().visit(programContext);
							expectation = Program.fromCtx(programContext).toString();
						} catch (MalformedException e) {
							System.out.println("Skipping test: " + file);
							Files.write(outputPath, e.getLocalizedMessage().getBytes());
							return;
						}

						validateExpectation(file.getName(), expectation);
						Files.write(outputPath, expectation.getBytes());

					} catch (ParseCancellationException e) {
						System.err.println(String.format("Error parsing %s", file));
						throw e;
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				});
	}

	private static void validateExpectation(String name, String expectation) throws MalformedException {
		try {
			Program.fromCtx(Parser.fromString(expectation));
		} catch (ParseCancellationException e) {
			System.err.println("On " + name);
			System.err.println(e.getLocalizedMessage());
//			System.exit(1);
		}
	}
}
