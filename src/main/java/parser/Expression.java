package parser;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

public interface Expression {
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
