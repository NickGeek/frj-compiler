package visitors;

import parser.DotExpression;
import parser.Expression;
import parser.ProgramNode;

public class CollectorVisitor {
	public void visitNew(Expression.InstantiationExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitNewSignal(Expression.SignalConstructionExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitEmptySignal(Expression.EmptySignalExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitLookup(Expression.LookupExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitLet(Expression.LetExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitIdentifier(Expression.IdentifierExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitLiteral(Expression.LiteralExpr<?> expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitCall(DotExpression.CallExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitLiftedCall(DotExpression.CallExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitFieldAccess(DotExpression.FieldAccessExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitFieldUpdate(DotExpression.FieldUpdateExpr expr) {
		expr.children().forEach(child -> child.accept(this));
	}

	public void visitClassDeclaration(ProgramNode.ClassDeclaration classDec) {
		classDec.children().forEach(child -> child.accept(this));
	}

	public void visitInterfaceDeclaration(ProgramNode.ClassDeclaration classDec) {
		classDec.children().forEach(child -> child.accept(this));
	}

	public void visitMethod(ProgramNode.Method method) {
		method.children().forEach(child -> child.accept(this));
	}

	public void visitBindingDeclaration(ProgramNode.BindingDeclaration bindingDeclaration) {
		bindingDeclaration.children().forEach(child -> child.accept(this));
	}

	public void visitType(ProgramNode.Type type) {
		type.children().forEach(child -> child.accept(this));
	}

	public void visitLiftedType(ProgramNode.LiftedType liftedType) {
		liftedType.children().forEach(child -> child.accept(this));
	}
}
