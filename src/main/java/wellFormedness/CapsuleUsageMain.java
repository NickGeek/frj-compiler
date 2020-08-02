package wellFormedness;

import parser.Expression;
import parser.Modifier;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CapsuleUsageMain implements WellFormednessRule<Expression> {
	@Override
	public void check(Expression expr) throws MalformedException {
		var counters = new HashMap<String, AtomicInteger>();
		expr.walk(walkable -> {
			if (walkable instanceof Expression.LetExpr) {
				Expression.LetExpr letExpr = (Expression.LetExpr) walkable;
				if (letExpr.type.mdf == Modifier.CAPSULE) {
					counters.put(letExpr.name, new AtomicInteger(0));
				}
			} else if (walkable instanceof Expression.IdentifierExpr) {
				Expression.IdentifierExpr identifier = (Expression.IdentifierExpr) walkable;
				if (!counters.containsKey(identifier.name)) return;

				if (counters.get(identifier.name).incrementAndGet() > 1) {
					var pos = identifier.pos();
					throw new MalformedException(
							pos.line,
							pos.col,
							String.format("Capsule '%s' used more than once here.", identifier.name)
					);
				}
			}
		});
	}
}
