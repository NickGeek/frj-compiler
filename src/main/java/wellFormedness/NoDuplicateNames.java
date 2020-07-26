package wellFormedness;

import antlrGenerated.FRJSimpleParser;
import antlrGenerated.FRJSimpleParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class NoDuplicateNames extends FRJSimpleParserBaseVisitor<Void> {
	private final Set<String> classAndInterfaceNames = new HashSet<>();

	@Override
	public Void visitClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx) {
		var name = ctx.Identifier().getText();

		if (this.classAndInterfaceNames.contains(name)) {
			throw new MalformedException(
					ctx.start.getLine(),
					ctx.start.getCharPositionInLine(),
					"Class and interface names must be unique."
			);
		}

		this.classAndInterfaceNames.add(name);
		new NoDuplicateMethodFieldNames().visit(ctx);

		return null;
	}

	private static class NoDuplicateMethodFieldNames extends FRJSimpleParserBaseVisitor<Void> {
		private final Set<String> methodNames = new HashSet<>();
		private final Set<String> fieldNames = new HashSet<>();

		@Override
		public Void visitMethodHeader(FRJSimpleParser.MethodHeaderContext ctx) {
			var name = ctx.Identifier().getText();

			if (this.methodNames.contains(name)) {
				throw new MalformedException(
						ctx.start.getLine(),
						ctx.start.getCharPositionInLine(),
						"Method names must be unique within a class."
				);
			}

			this.methodNames.add(name);
			return super.visitMethodHeader(ctx);
		}

		@Override
		public Void visitFieldDeclaration(FRJSimpleParser.FieldDeclarationContext ctx) {
			var name = ctx.Identifier().getText();

			if (this.fieldNames.contains(name)) {
				throw new MalformedException(
						ctx.start.getLine(),
						ctx.start.getCharPositionInLine(),
						"Field names must be unique within a class."
				);
			}

			this.fieldNames.add(name);
			return super.visitFieldDeclaration(ctx);
		}
	}
}
