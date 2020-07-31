package typing;

import parser.Expression;
import parser.Modifier;
import parser.Program;
import parser.ProgramNode;

import java.util.HashMap;
import java.util.Map;

public class TypingRules {
	private final Program program;
	private final Map<Expression.IdentifierExpr, ProgramNode.Type> gamma;

	public TypingRules(Program program) {
		this.program = program;
		this.gamma = new HashMap<>();
	}

	public ProgramNode.Type type(Expression expr) {
		if (expr instanceof Expression.IdentifierExpr) {
			return this.typeVariable((Expression.IdentifierExpr) expr);
		} else if (expr instanceof Expression.LiteralExpr<?>) {
			return this.typeLiteral((Expression.LiteralExpr<?>) expr);
		}

//		throw new IllegalArgumentException("No type rules cover: " + expr);
		return null; // TODO: Tmp to just test out without throwing the exception
	}

	/**
	 * Rule (x) types variables (identifiers) as the type they point to in the Gamma typing environment.
	 */
	private ProgramNode.Type typeVariable(Expression.IdentifierExpr expr) {
		var type = this.gamma.get(expr);
		return new ProgramNode.Type(expr.pos(), type.mdf, type.isLifted, type.name);
	}

	/**
	 * This rule isn't from the formalism, but literals have been added for convenience.
	 */
	private ProgramNode.Type typeLiteral(Expression.LiteralExpr<?> expr) {
		return switch (expr.type) {
			case INTEGER -> new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Int");
			case FLOAT -> new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Float");
			case STRING -> new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "String");
			case BOOLEAN -> new ProgramNode.Type(expr.pos(), Modifier.IMM, false, "Bool");
		};
	}
}