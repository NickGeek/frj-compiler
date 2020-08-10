package std;

import parser.ProgramNode;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Literals {
	public static final Map<String, ProgramNode.ClassDeclaration> classes = Map.of(
			"Int", makeClassDec("Int"),
			"Float", makeClassDec("Float"),
			"String", makeClassDec("String"),
			"Bool", makeClassDec("Bool")
	);

	private static final ProgramNode.Position pos = new ProgramNode.Position(-1, -1);

	private static ProgramNode.ClassDeclaration makeClassDec(String name) {
		return new ProgramNode.ClassDeclaration(
				pos,
				false,
				false,
				name,
				new String[0],
				new String[0],
				new LinkedHashMap<>(),
				Collections.emptyMap()
		);
	}
}
