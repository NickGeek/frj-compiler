import org.antlr.v4.runtime.*;

public class Foo {
	public static void main(String[] args) {
		var testProgram = "class Foo {}\nclass Bar<T> {}\nmain = new Foo();";
		var lexer = new FRJLexer(CharStreams.fromString(testProgram));
		var parser = new FRJParser(new CommonTokenStream(lexer));

//		parser.main().enterRule(new MainWalker());
//		new MainWalker().enterMain(parser.main());
		var idk = new FRJClassDeclarationVisitor().visit(parser.program());

		/*
		 * Steps for doing this:
		 * 1. Parse into AST (I think ANTLR does this for me??)
		 * 2. Create a class table (CDs)
		    * a. Make concrete classes for generics
		 * 3. Check the CDs for well-formedness and type check them
		 * 4. Walk through the main expression and well-formedness check as we go?
		 * 5. Walk through the main expression and type check
		 * 6. Apply the reduction rules we can do at compile time
		 * 7. Codegen Java source code
		 */

		System.out.println("hi");
	}
}

class FRJClassDeclarationVisitor extends FRJParserBaseVisitor<FRJParser.ClassDeclarationContext> {
	@Override
	public FRJParser.ClassDeclarationContext visitClassDeclaration(FRJParser.ClassDeclarationContext ctx) {
		return super.visitClassDeclaration(ctx);
	}
}
