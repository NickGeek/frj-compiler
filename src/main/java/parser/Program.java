package parser;

import antlrGenerated.FRJSimpleParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
	public static Program fromCtx(FRJSimpleParser.ProgramContext ctx) {
		var classDecs = ctx.classDeclaration()
				.stream()
				.map(Program::ctxToClassDeclaration)
				.collect(Collectors.toMap(cd -> cd.name, cd -> cd));

		var mainExprCtx = ctx.main().expr();

		return new Program(classDecs, null);
	}

	private static Program.ClassDeclaration ctxToClassDeclaration(FRJSimpleParser.ClassDeclarationContext ctx) {
		var implNode = ctx.implementsDeclaration();
		List<String> impl = Collections.emptyList();
		if (implNode != null) {
			impl = ctx.implementsDeclaration().Identifier().stream()
					.map(ParseTree::getText)
					.collect(Collectors.toList());
		}

		var extendsNode = ctx.extendsDeclaration();
		List<String> extend = Collections.emptyList();
		if (extendsNode != null) {
			extend = ctx.extendsDeclaration().Identifier().stream()
					.map(ParseTree::getText)
					.collect(Collectors.toList());
		}

		var fields = ctx.fieldDeclaration().stream()
				.map(fieldCtx -> new Field(typeNameCtxToType(fieldCtx.typeName()), fieldCtx.Identifier().getText()))
				.collect(Collectors.toMap(f -> f.name, f -> f));

		var methods = ctx.methodDeclaration().stream()
				.map(methodCtx -> {
					var header = methodCtx.methodHeader();
					return new Method(
							mdfTerminalToModifier(header.MDF()),
							typeNameCtxToType(header.typeName()),
							header.Identifier().getText(),
							new HashMap<>(),
							null
					);
				})
				.collect(Collectors.toMap(meth -> meth.name, meth -> meth));

		return new Program.ClassDeclaration(
				ctx.CAP() != null,
				ctx.INTERFACE() != null,
				ctx.Identifier().getText(),
				impl,
				extend,
				fields,
				methods
		);
	}

	private static Program.Type typeNameCtxToType(FRJSimpleParser.TypeNameContext ctx) {
		var mdf = mdfTerminalToModifier(ctx.MDF());
		return new Type(mdf, ctx.Identifier().getText());
	}

	private static Program.Modifier mdfTerminalToModifier(TerminalNode mdf) {
		return mdf != null ? Modifier.fromLiteral(mdf.getText()) : Modifier.IMM;
	}

	final Map<String, ClassDeclaration> classDeclarations;
	final Expression main;

	public Program(Map<String, ClassDeclaration> classDeclarations, Expression main) {
		this.classDeclarations = classDeclarations;
		this.main = main;
	}

	enum Modifier {
		MUT,
		IMM,
		CAPSULE,
		READ;

		public static Modifier fromLiteral(String literal) {
			return Modifier.valueOf(literal.toUpperCase());
		}
	}

	static class ClassDeclaration {
		public final boolean isCapability;
		public final boolean isInterface;
		public final String name;
		public final List<String> impl;
		public final List<String> extend;
		public final Map<String, Field> fields;
		public final Map<String, Method> methods;

		ClassDeclaration(boolean isCapability, boolean isInterface, String name, List<String> impl, List<String> extend, Map<String, Field> fields, Map<String, Method> methods) {
			this.isCapability = isCapability;
			this.isInterface = isInterface;
			this.name = name;
			this.impl = impl;
			this.extend = extend;
			this.fields = fields;
			this.methods = methods;
		}
	}

	static class Field {
		public final Type type;
		public final String name;

		public Field(Type type, String name) {
			this.type = type;
			this.name = name;
		}
	}

	static class Method {
		public final Modifier mdf;
		public final Type returnType;
		public final String name;
		public final HashMap<String, Expression> bindings;
		public final Expression expression;

		Method(Modifier mdf, Type returnType, String name, HashMap<String, Expression> bindings, Expression expression) {
			this.mdf = mdf;
			this.returnType = returnType;
			this.name = name;
			this.bindings = bindings;
			this.expression = expression;
		}
	}

	static class Type {
		public final Modifier mdf;
		public final String name;

		Type(Modifier mdf, String name) {
			this.mdf = mdf;
			this.name = name;
		}
	}

	interface Expression {

	}
}
