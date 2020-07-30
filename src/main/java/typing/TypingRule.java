package typing;

import parser.Expression;
import parser.Program;

import java.util.*;
import java.util.stream.Collectors;

public interface TypingRule<T extends Expression> {
	static Map<Expression.IdentifierExpr, TypedExpression<?>> type(Program program) {
		var rules = new TypingRules(program);
		program.visit(visitable -> {
			if (visitable instanceof Expression) {
				rules.type((Expression) visitable);
			}
		});

		return null; // TODO: All of this
	}

	static Optional<String> getErrors(Program program) {
		var errors = new ArrayList<TypeError>();
		var rules = new TypingRules(program);

		return !errors.isEmpty() ? Optional.of(errors.stream().map(TypeError::toString).collect(Collectors.joining("\n"))) : Optional.empty();
	}

	TypedExpression<T> type(T expr);

	default List<TypeError> check(T toCheck) {
		return Collections.emptyList();
	}
}
