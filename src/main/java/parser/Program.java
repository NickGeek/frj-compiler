package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program implements Visitable {
	public static Program fromCtx(FRJSimpleParser.ProgramContext ctx) {
		var classDecs = ctx.classDeclaration()
				.stream()
				.map(ProgramNode.ClassDeclaration::ctxToClassDeclaration)
				.collect(Collectors.toMap(cd -> cd.name, cd -> cd));

		var mainExpr = Expression.ctxToExpression(ctx.main().expr());

		return new Program(classDecs, mainExpr);
	}

	public final Map<String, ProgramNode.ClassDeclaration> classDeclarations;
	public final Expression main;

	public Program(Map<String, ProgramNode.ClassDeclaration> classDeclarations, Expression main) {
		this.classDeclarations = classDeclarations;
		this.main = main;
	}

	@Override
	public List<Expression> children() {
		var classDecChildren = this.classDeclarations.values()
				.stream()
				.map(ProgramNode.ClassDeclaration::children)
				.flatMap(List::stream);

		return Stream.concat(Stream.of(this.main), classDecChildren).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		var source = new StringBuilder();
		source.append("main = ").append(this.main.toString()).append(";").append("\n\n");

		for (var cd : this.classDeclarations.values()) {
			source.append(cd.toString()).append("\n\n");
		}

		return source.toString();
	}
}
