package parser;

import antlrGenerated.FRJSimpleParser;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public interface Expression {
	static Expression ctxToExpression(FRJSimpleParser.ExprContext ctx) {
		if (ctx.callExpr() != null) {
			return new Expression.CallExpr(
					ctxToExpression(ctx.expr()),
					ctx.callExpr().Identifier().getText(),
					ctx.callExpr()
							.argumentList()
							.expr()
							.stream()
							.map(Expression::ctxToExpression)
							.collect(Collectors.toList())
			);
		}
		if (ctx.instantiationExpr() != null) {
			return new Expression.InstantiationExpr(
					ctx.instantiationExpr().Identifier().getText(),
					ctx.instantiationExpr()
							.argumentList()
							.expr()
							.stream()
							.map(Expression::ctxToExpression)
							.collect(Collectors.toList())
			);
		}
		if (ctx.fieldAccessExpr() != null) {
			return new Expression.FieldAccessExpr(ctxToExpression(ctx.expr()), ctx.fieldAccessExpr().Identifier().getText());
		}
		if (ctx.THIS() != null) {
			return new Expression.ThisExpr();
		}

		throw new IllegalStateException(String.format("Unexpected expression: %s", ctx.getText()));
	}

	@ToString
	class InstantiationExpr implements Expression {
		String name;
		List<Expression> args;

		public InstantiationExpr(String name, List<Expression> args) {
			this.name = name;
			this.args = args;
		}
	}

	@ToString
	class CallExpr implements Expression {
		public Expression receiver;
		public String methodName;
		public List<Expression> arguments;

		public CallExpr(Expression receiver, String methodName, List<Expression> arguments) {
			this.receiver = receiver;
			this.methodName = methodName;
			this.arguments = arguments;
		}
	}

	@ToString
	@AllArgsConstructor
	class FieldAccessExpr implements Expression {
		public Expression receiver;
		public String fieldName;
	}

	class ThisExpr implements Expression {
		@Override
		public String toString() {
			return "this";
		}
	}
}
