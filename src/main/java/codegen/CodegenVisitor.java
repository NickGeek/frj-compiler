package codegen;

import parser.DotExpression;
import parser.Expression;
import parser.Program;
import parser.ProgramNode;
import visitors.CollectorVisitor;
import visitors.Visitable;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CodegenVisitor extends CollectorVisitor {
	private static final Set<String> INTRINSIC_CLASSES = Set.of(
			"Std",
			"Literal",
			"Bool",
			"True",
			"False",
			"ProducerN",
			"Number",
			"Int",
			"Float",
			"String"
	);
	private static final Map<String, String> REPLACEMENT_TYPES = Map.of(
			"Int", "Long",
			"Float", "Double",
			"Number", "Number",
			"String", "String",
			"toString", "toString",
			"this", "this"
	);

	private static String mangle(String name) {
		if (REPLACEMENT_TYPES.containsKey(name)) return REPLACEMENT_TYPES.get(name);

		return "FRJ_" + name;
	}

	private static String convertTypeName(ProgramNode.Type type) {
		if (type instanceof ProgramNode.LiftedType) {
			return String.format("SignalBox<%s>", convertTypeName(((ProgramNode.LiftedType) type).innerType));
		}

		return mangle(type.name);
	}

	private final StringBuilder output = new StringBuilder();
	private final String name;
	private final Program program;

	public CodegenVisitor(String name, Program program) {
		this.name = name;
		this.program = program;
	}

	public String generate() {
		return this.generateHeader() + this.output.toString() + this.generateFooter();
	}

	public String getCode() {
		return this.output.toString();
	}

	public void visitMain(Visitable visitable) {
		this.output.append("public static void main(String[] args) {\nvar out = ");
		visitable.accept(this);
		this.output.append(";\n}");
	}

	@Override
	public void visitNew(Expression.InstantiationExpr expr) {
		this.output
				.append("new ")
				.append(mangle(expr.name))
				.append('(');

		this.output.append(Arrays.stream(expr.args)
				.map(arg -> {
					var visitor = new CodegenVisitor(this.name, this.program);
					arg.accept(visitor);
					return visitor.getCode();
				})
				.collect(Collectors.joining(",")));

		this.output.append(')');
	}

	@Override
	public void visitNewSignal(Expression.SignalConstructionExpr expr) {
		this.output.append("SignalBox.explicit(() -> ");
		expr.head.accept(this);
		this.output.append(", () -> ");
		expr.tail.accept(this);
		this.output.append(')');
	}

	@Override
	public void visitEmptySignal(Expression.EmptySignalExpr expr) {
		this.output.append("new SignalBox<>()");
	}

	@Override
	public void visitLookup(Expression.LookupExpr expr) {
		var lookup = expr.lookup == Expression.LookupExpr.Lookup.HEAD ? "head" : "tail";
		this.output
				.append("SignalBox.")
				.append(lookup)
				.append('(');
		expr.signalExpr.accept(this);
		this.output.append(')');
	}

	@Override
	public void visitLet(Expression.LetExpr expr) {
		this.output
				.append("switch (0) { default -> { ")
				.append(convertTypeName(expr.type))
				.append(' ')
				.append(mangle(expr.name))
				.append(" = ");
		expr.value.accept(this);
		this.output.append("; yield ");
		expr.boundTo.accept(this);
		this.output.append("; } }");
	}

	@Override
	public void visitIdentifier(Expression.IdentifierExpr expr) {
		output.append(mangle(expr.name));
	}

	@Override
	public void visitLiteral(Expression.LiteralExpr<?> expr) {
		String cast = switch (expr.type) {
			case INTEGER -> "long";
			case FLOAT -> "double";
			case STRING -> "String";

			default -> throw new IllegalStateException("Can't codegen " + expr.type.name());
		};

		this.output.append('(').append(cast).append(')').append(expr.toString());
	}

	@Override
	public void visitCall(DotExpression.CallExpr expr) {
		expr.receiver().accept(this);
		this.output.append('.').append(mangle(expr.methodName)).append('(');
		this.output.append(Arrays.stream(expr.args)
				.skip(1)
				.map(arg -> {
					var visitor = new CodegenVisitor(this.name, this.program);
					arg.accept(visitor);
					return visitor.getCode();
				})
				.collect(Collectors.joining(",")));
		this.output.append(')');
	}

	@Override
	public void visitLiftedCall(DotExpression.CallExpr expr) {
		var args = Arrays.stream(expr.args)
				.skip(1)
				.map(arg -> {
					var visitor = new CodegenVisitor(this.name, this.program);
					arg.accept(visitor);
					return visitor.getCode();
				})
				.collect(Collectors.joining(","));

		this.output.append("SignalBox.lift(");
		expr.receiver().accept(this);
		this.output
				.append(", \"")
				.append(mangle(expr.methodName))
				.append("\"");
		if (args.length() > 0) this.output.append(',').append(args);
		this.output.append(')');
	}

	@Override
	public void visitFieldAccess(DotExpression.FieldAccessExpr expr) {
		expr.receiver.accept(this);
		this.output.append('.').append(mangle(expr.fieldName));
	}

	@Override
	public void visitFieldUpdate(DotExpression.FieldUpdateExpr expr) {
		this.output.append("switch (0) { default -> { var newValue = ");
		expr.value.accept(this);
		this.output.append("; ");

		expr.receiver.accept(this);
		this.output
				.append('.')
				.append(mangle(expr.fieldName))
				.append(" = ")
				.append("newValue; yield newValue; } }");
	}

	@Override
	public void visitClassDeclaration(ProgramNode.ClassDeclaration classDec) {
		if (INTRINSIC_CLASSES.contains(classDec.name)) return;
		var name = mangle(classDec.name);

		this.output.append(String.format("private static class %s extends FRJObj ", name));
		if (classDec.impl.length > 0) {
			this.output.append("implements ")
					.append(String.join(", ", (Iterable<String>) Arrays.stream(classDec.impl).map(CodegenVisitor::mangle)::iterator))
					.append(' ');
		}
		this.output.append("{\n");

		classDec.fields.values().forEach(field -> {
			this.output.append("public ");
			field.accept(this);
			this.output.append(";\n");
		});

		this.output.append(this.generateConstructor(classDec));

		classDec.methods.values().forEach(method -> method.accept(this));
		this.output.append("\n}\n");
	}

	@Override
	public void visitInterfaceDeclaration(ProgramNode.ClassDeclaration classDec) {
		if (INTRINSIC_CLASSES.contains(classDec.name)) return;
		var name = mangle(classDec.name);

		this.output.append(String.format("interface %s ", name));
		if (classDec.extend.length > 0) {
			this.output.append("extends ")
					.append(String.join(", ", (Iterable<String>) Arrays.stream(classDec.extend).map(CodegenVisitor::mangle)::iterator))
					.append(' ');
		}
		this.output.append("{\n");

		classDec.methods.values().forEach(method -> method.accept(this));
		this.output.append("\n}\n");
	}

	@Override
	public void visitMethod(ProgramNode.Method method) {
		String args = Arrays.stream(method.args)
				.skip(1)
				.map(arg -> {
					var visitor = new CodegenVisitor(this.name, this.program);
					arg.accept(visitor);
					return visitor.getCode();
				})
				.collect(Collectors.joining(","));

		if (method.expression().isEmpty()) {
			// Interface method header
			this.output.append(String.format("%s %s(%s);\n", convertTypeName(method.returnType), mangle(method.name), args));
		} else {
			// Class method impl
			this.output.append(String.format("public %s %s(%s) {\nreturn ", convertTypeName(method.returnType), mangle(method.name), args));
			method.expression().get().accept(this);
			this.output.append(";\n}\n");
		}
	}

	@Override
	public void visitBindingDeclaration(ProgramNode.BindingDeclaration bindingDeclaration) {
		this.output.append(convertTypeName(bindingDeclaration.type))
				.append(' ')
				.append(mangle(bindingDeclaration.name));
	}

	private String generateHeader() {
		return "public class " + this.name + " {\n";
	}

	private String generateFooter() {
		return "\n}\n";
	}

	private String generateConstructor(ProgramNode.ClassDeclaration classDec) {
		String args = classDec.fields
				.values()
				.stream()
				.map(arg -> {
					var visitor = new CodegenVisitor(this.name, this.program);
					arg.accept(visitor);
					return visitor.getCode();
				})
				.collect(Collectors.joining(","));

		String assignment = classDec.fields
				.values()
				.stream()
				.map(arg -> String.format("this.%s = %s;", mangle(arg.name), mangle(arg.name)))
				.collect(Collectors.joining(" "));

		return String.format(
				"public %s(%s) { %s }\n",
				mangle(classDec.name),
				args,
				assignment
		);
	}
}
