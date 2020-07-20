import org.antlr.v4.runtime.*;

public class Foo {
	public static void main(String[] args) {
		var testProgram = "class Foo {}\nmain = new Foo();";
		var lexer = new FRJLexer(CharStreams.fromString(testProgram));
		var parser = new FRJParser(new CommonTokenStream(lexer));

//		parser.main().enterRule(new MainWalker());
//		new MainWalker().enterMain(parser.main());

		System.out.println("hi");
	}
}

class MainWalker extends FRJParserBaseListener {
	@Override
	public void enterMain(FRJParser.MainContext ctx) {
		super.enterMain(ctx);
	}

	@Override
	public void enterExpr(FRJParser.ExprContext ctx) {
		super.enterExpr(ctx);
	}
}
