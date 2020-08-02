package wellFormedness;

import parser.Expression;
import parser.Modifier;
import parser.ProgramNode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Capsules passed in by argument must be used 0 or one times in a method body.
 */
public class CapsuleUsage implements WellFormednessRule<ProgramNode.Method> {
	@Override
	public void check(ProgramNode.Method method) throws MalformedException {
		Arrays.stream(method.args)
				.filter(arg -> arg.type.mdf == Modifier.CAPSULE)
				.forEach(arg -> {
					var count = new AtomicInteger();

					method.expression()
							.ifPresent(methodExpr -> methodExpr.walk(expr -> {
								if (expr instanceof Expression.IdentifierExpr) {
									var identifier = (Expression.IdentifierExpr) expr;
									if (identifier.name.equals(arg.name) && count.incrementAndGet() > 1) {
										var pos = identifier.pos();
										throw new MalformedException(
												pos.line,
												pos.col,
												String.format("Capsule '%s' used more than once here.", arg.name)
										);
									}
								}
							}));
				});
	}
}
