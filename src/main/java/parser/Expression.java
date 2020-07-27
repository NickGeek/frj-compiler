package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public interface Expression {
	static Expression ctxToExpression(FRJSimpleParser.ExprContext ctx) {
		if (DotExpression.isBiExpression(ctx)) {
			return DotExpression.ctxToBiExpression(ctx);
		}
		if (ctx.instantiationExpr() != null) {
			return new InstantiationExpr(
					ctx.instantiationExpr().Identifier().getText(),
					argListCtxToList(ctx.instantiationExpr().argumentList())
			);
		}
		if (ctx.letExpr() != null) {
			return new LetExpr(
					Program.mdfTerminalToModifier(ctx.letExpr().typeName().MDF()),
					ctx.letExpr().typeName().Identifier().getText(),
					Expression.ctxToExpression(ctx.letExpr().expr(0)),
					Expression.ctxToExpression(ctx.letExpr().expr(1))
			);
		}
		if (ctx.THIS() != null) {
			return new ThisExpr();
		}
		if (ctx.Identifier() != null) {
			return new Identifier(ctx.Identifier().getText());
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	static List<Expression> argListCtxToList(FRJSimpleParser.ArgumentListContext ctx) {
		return ctx.expr()
				.stream()
				.map(Expression::ctxToExpression)
				.collect(Collectors.toList());
	}

	@ToString
	class InstantiationExpr implements Expression {
		public final String name;
		public final List<Expression> args;

		public InstantiationExpr(String name, List<Expression> args) {
			this.name = name;
			this.args = args;
		}
	}

	@ToString
	@AllArgsConstructor
	class LetExpr implements Expression {
		public final Program.Modifier mdf;
		public final String name;
		public final Expression value;
		public final Expression boundTo;
	}

	class ThisExpr implements Expression {
		@Override
		public String toString() {
			return "this";
		}
	}

	@AllArgsConstructor
	@EqualsAndHashCode
	class Identifier implements Expression {
		public final String name;

		@Override
		public String toString() {
			return this.name;
		}
	}
}
