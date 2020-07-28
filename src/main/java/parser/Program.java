package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ToString
public class Program {
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
}
