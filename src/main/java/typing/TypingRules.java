package typing;

import parser.Expression;
import parser.Modifier;
import parser.Program;
import parser.ProgramNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TypingRules {
	private final Program program;
	private final Map<Expression.IdentifierExpr, TypedExpression<?>> gamma;

	public TypingRules(Program program) {
		this.program = program;
		this.gamma = new HashMap<>();
	}

	public TypedExpression<?> type(Expression expression) {
		return null;
	}

	/**
	 * Rule (x) types variables (identifiers) as the type they point to in the Gamma typing environment.
	 */
	private TypedExpression<Expression.IdentifierExpr> typeVariable(Expression.IdentifierExpr expr) {
		var lookup = gamma.get(expr);

		return new TypedExpression<>(
				expr,
				lookup.type
		);
	}

	/**
	 * This rule isn't from the formalism, but literals have been added for convenience.
	 */
	private TypedExpression<Expression.LiteralExpr<?>> typeLiteral(Expression.LiteralExpr<?> expr) {
		return switch (expr.type) {
			case INTEGER -> new TypedExpression<>(
					expr,
					new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Int")
			);

			case FLOAT -> new TypedExpression<>(
					expr,
					new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Float")
			);

			case STRING -> new TypedExpression<>(
					expr,
					new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Str")
			);

			case BOOLEAN -> new TypedExpression<>(
					expr,
					new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Bool")
			);
		};
	}
}