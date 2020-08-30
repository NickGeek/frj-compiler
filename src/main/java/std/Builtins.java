package std;

import parser.Parser;
import parser.ProgramNode;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

public class Builtins {
	private Builtins() {}

	public static Map<String, ProgramNode.ClassDeclaration> parseBuiltIns() {
		try {
			return Parser.fromInputStream(Builtins.class.getResourceAsStream("/std.frj"))
					.classDeclaration()
					.stream()
					.map(ProgramNode.ClassDeclaration::ctxToClassDeclaration)
					.collect(Collectors.toMap(cd -> cd.name, cd -> cd));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
