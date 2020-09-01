import antlrGenerated.FRJSimpleParser;
import codegen.CodegenVisitor;
import codegen.Bundler;
import codegen.JavaCode;
import parser.Program;
import parser.ProgramNode;
import typing.TypeCheckVisitor;
import wellFormedness.NoDuplicateNames;
import wellFormedness.RunChecks;
import wellFormedness.WellFormednessRule;

import java.io.IOException;
import java.nio.file.Paths;

public class Compiler {
	public static void compile(FRJSimpleParser.ProgramContext programContext) {
		// Compute high level program object from the tree (duplicate names need to be removed because we use a Map data structure)
		new NoDuplicateNames().check(programContext);
		var program = Program.fromCtx(programContext);

		// Ensure the program is well-formed
		WellFormednessRule.runAllProgramChecks(
				RunChecks.makeChecks(program),
				program
		);

		// Type check CDs
		program.classDeclarations
				.values()
				.forEach(cd -> cd.accept(new TypeCheckVisitor(program, ProgramNode.Type.ANY)));

		// Type check the main expression
		var typeCheckVisitor = new TypeCheckVisitor(program, ProgramNode.Type.ANY);
		typeCheckVisitor.cap = true;
		program.main.accept(typeCheckVisitor);

		// Generate Java source code
		var name = "Program" + System.currentTimeMillis();
		var codegenVisitor = new CodegenVisitor(name, program);
		program.classDeclarations.values().forEach(cd -> cd.accept(codegenVisitor));
		codegenVisitor.visitMain(program.main);

		// Compile the source code
		var workingDir = Paths.get(System.getProperty("java.io.tmpdir"), name);
		if (!workingDir.toFile().mkdir()) {
			throw new RuntimeException("Could not create a working directory for building the program in: " + System.getProperty("java.io.tmpdir"));
		}

		var javaCode = new JavaCode(name, codegenVisitor.generate());
		javaCode.compile(workingDir);

		// Bundle into a jar file
		try {
			new Bundler(name).makeJar(workingDir);
		} catch (IOException e) {
			throw new RuntimeException("I/O Exception encountered whilst building JAR.\n" + e);
		}
	}
}
