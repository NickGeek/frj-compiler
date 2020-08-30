package codegen;

import std.Builtins;

import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class JavaCode extends SimpleJavaFileObject {
	private final String name;
	private final String code;

	public JavaCode(String name, String code) {
		super(URI.create("string:///" + name + Kind.SOURCE.extension), Kind.SOURCE);
		this.name = name;
		this.code = code;
	}

	public void compile(Path workingDir) {
		var compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			throw new RuntimeException("No Java compiler could be found. Please install a JDK >= 10.");
		}

		var tempRuntimeFile = workingDir.resolve("runtime.jar").toFile();
		try {
			var tempRuntimeFileOs = new FileOutputStream(tempRuntimeFile);
			Builtins.class.getResourceAsStream("/runtime.jar").transferTo(tempRuntimeFileOs);
			tempRuntimeFileOs.close();
		} catch (IOException e) {
			throw new RuntimeException("Error: Could not write to " + tempRuntimeFile.toString());
		}

		var options = List.of(
				"-classpath",
				tempRuntimeFile.getAbsolutePath(),
				"-d",
				workingDir.toString()
		);

		boolean success = compiler.getTask(
				null,
				null,
				null,
				options,
				null,
				Collections.singleton(this)
		).call();

		if (!success) {
			throw new RuntimeException("Internal Compiler Error: Could not generate bytecode.");
		}
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return this.code;
	}
}
