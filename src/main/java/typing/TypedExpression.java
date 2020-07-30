package typing;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import parser.Expression;
import parser.ProgramNode;

@AllArgsConstructor
@EqualsAndHashCode
public class TypedExpression<T extends Expression> {
	public final T expression;
	public final ProgramNode.Type type;

	@Override
	public String toString() {
		return "cap;\uD835\uDF68;\uD835\uDF58; ⊢ " + this.expression + " " + this.type;
	}
}
