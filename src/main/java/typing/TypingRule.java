package typing;

import parser.Expression;
import parser.Program;

import java.util.*;
import java.util.stream.Collectors;

public interface TypingRule<T extends Expression> {
//	static Map<Expression, TypedExpression<?>> type(Program program) {
//		var rules = new TypingRules(program, new HashMap<>());
//		program.visit(visitable -> {
//			if (visitable instanceof Expression) {
//				rules.type((Expression) visitable);
//			}
//		});
//
//		return null; // TODO: All of this
//	}

	static Optional<String> getErrors(Program program) {
		var errors = new ArrayList<TypeError>();
		var rules = new TypingRules(program);

		// Is main okay?
		var foo = rules.type(program.main);

		// (class) rule
		// TODO

		// (interface) rule
		// TODO

		// (method) rule
		// TODO

//		program.visit(visitable -> {
//			if (visitable instanceof Expression) {
//				rules.type((Expression) visitable);
//			}
//		});

		return !errors.isEmpty() ? Optional.of(errors.stream().map(TypeError::toString).collect(Collectors.joining("\n"))) : Optional.empty();
	}

	TypedExpression<T> type(T expr);

	default List<TypeError> check(T toCheck) {
		return Collections.emptyList();
	}
}
