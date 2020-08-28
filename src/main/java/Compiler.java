import antlrGenerated.FRJSimpleParser;
import parser.Program;
import parser.ProgramNode;
import typing.TypeCheckVisitor;
import wellFormedness.NoDuplicateNames;
import wellFormedness.RunChecks;
import wellFormedness.WellFormednessRule;

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
		var visitor = new TypeCheckVisitor(program, ProgramNode.Type.ANY);
		visitor.cap = true;
		program.main.accept(visitor);

//		System.out.println(program);
	}
}
