package polyglot.ext.pbnj.tologic;

import polyglot.ext.pbnj.primitives.*;

import java.util.AbstractCollection;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;

import java.io.CharArrayWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import kodkod.ast.Node;
import kodkod.ast.Variable;
import kodkod.ast.Formula;
import kodkod.ast.operator.FormulaOperator;
import kodkod.ast.Decls;
import kodkod.ast.Expression;
import kodkod.ast.IntExpression;
import kodkod.ast.Relation;
import kodkod.ast.IntConstant;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Tuple;
import kodkod.instance.Bounds;
import kodkod.instance.Universe;
import kodkod.instance.Instance;
import kodkod.engine.Solver;
import kodkod.engine.Solution;
import kodkod.engine.Proof;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.config.Options;
import kodkod.engine.fol2sat.TranslationRecord;

public class LogExpr {

    static LogProblem problem;
    Expression expr;
    IntExpression intExpr;
    Formula formula;

    public LogExpr(LogProblem problem, Expression expr) {
	this(problem, expr, null, null);
    }
    public LogExpr(LogProblem problem, IntExpression intExpr) {
	this(problem, null, intExpr, null);
    }
    public LogExpr(LogProblem problem, Formula formula) {
	this(problem, null, null, formula);
    }
    public LogExpr(LogProblem problem, Expression expr, IntExpression intExpr, Formula formula) {
	this.problem = problem;
	this.expr = expr;
	this.intExpr = intExpr;
	this.formula = formula;
    }

    public String toString() { return "expr=" + expr + " intExpr=" + intExpr + " formulaExpr=" + formula; }
   
    public Expression expr() { 
	return expr == null ?
	    intExpr.toExpression() : expr; 
    }

    public Formula formula() { 
	return formula == null ? (this.eq(problem.true_log())).formula() : formula; 
    }

    public IntExpression intExpr() { 
	return intExpr == null ? 
	    expr.sum() : 
	    intExpr;	    
    }

    public int arity() { return expr.arity(); }

    public IntExpression sum() { return expr.sum(); }

    public LogExpr eq(LogExpr e) {
	return new LogExpr(problem, 
	    expr == null ?
	    intExpr().eq(e.intExpr())
	    : expr().eq(e.expr())
	    );
    }

    public LogExpr gt(LogExpr e) {
	return new LogExpr(problem, 
	    intExpr().gt(e.intExpr())
	    );
    }

    public LogExpr gte(LogExpr e) {
	return new LogExpr(problem, 
	    intExpr().gte(e.intExpr())
	    );
    }

    public LogExpr lt(LogExpr e) {
	return new LogExpr(problem, 
	    intExpr().lt(e.intExpr())
	    );
    }

    public LogExpr lte(LogExpr e) {
	return new LogExpr(problem, 
	    intExpr().lte(e.intExpr())
	    );
    }

    public LogExpr some() {
	return new LogExpr(problem, expr.some());
    }

    public LogExpr no() {
	return new LogExpr(problem, expr.no());
    }

    public LogExpr one() {
	return new LogExpr(problem, expr.one());
    }

    public LogExpr not() {
	return new LogExpr(problem, formula().not());
    }

    public LogExpr and(LogExpr e) {
	return new LogExpr(problem, formula().and(e.formula()));
    }

    public LogExpr or(LogExpr e) {
	return new LogExpr(problem, formula().or(e.formula()));
    }

    public LogExpr implies(LogExpr e) {
	return new LogExpr(problem, formula().implies(e.formula()));
    }

    public LogExpr iff(LogExpr e) {
	return new LogExpr(problem, formula().iff(e.formula()));
    }

    public LogExpr thenElse(LogExpr t, LogExpr e) {
	if (t.expr() == null)
	    return new LogExpr(problem, formula().thenElse(t.intExpr(), e.intExpr()));
	else
	    return new LogExpr(problem, formula().thenElse(t.expr(), e.expr()));
    }

    public LogExpr plus(LogExpr e) {
	return new LogExpr(problem, intExpr().plus(e.intExpr()));
    }

    public LogExpr minus(LogExpr e) {
	return new LogExpr(problem, intExpr().minus(e.intExpr()));
    }

    public LogExpr divide(LogExpr e) {
	return new LogExpr(problem, intExpr().divide(e.intExpr()));
    }

    public LogExpr multiply(LogExpr e) {
	return new LogExpr(problem, intExpr().multiply(e.intExpr()));
    }

    public LogExpr intersection(LogExpr e) { 
	return new LogExpr(problem, expr().intersection(e.expr()));
    }

    public LogExpr union(LogExpr e) { 
	return new LogExpr(problem, expr().union(e.expr()));
    }

    public LogExpr join(LogExpr e) { 
	return new LogExpr(problem, expr().join(e.expr()));
    }

    public LogExpr negate() { 
	return new LogExpr(problem, intExpr().negate());
    }

    public LogExpr count() { return new LogExpr(problem, expr().count()); }

    public LogExpr length_get_log(LogProblem p) {
	return //count();
	    new LogExpr(problem, expr().project(IntConstant.constant(0)).count());
	    
    }

    public LogExpr project(IntExpression p) { return new LogExpr(problem, expr().project(p)); }

    public LogExpr equals_log(LogProblem p, LogExpr o, boolean isOld) {
	return new LogExpr(problem, expr().eq(o.expr()));
    }

    public LogExpr plus_log(LogProblem p, LogExpr o, boolean isOld) {
	return new LogExpr(problem, expr().union(o.expr()));
    }

    public LogExpr minus_log(LogProblem p, LogExpr o, boolean isOld) {
	return new LogExpr(problem, expr().difference(o.expr()));
    }

    public LogExpr contains_log(LogProblem p, LogExpr itm, boolean isOld) {
	return new LogExpr(problem, intersection(itm).some().formula());
    }

    public LogExpr size_log(LogProblem p) {
	return count();
    }

    public LogExpr isEmpty_log(LogProblem p) {
	return new LogExpr(problem, expr().no());
    }

    public LogExpr get_log(LogProblem p, LogExpr o, boolean isOld) {
	return o.join(this);
    }                              

    public LogExpr get_log(LogProblem p) {
//         Variable quantVar1 = Variable.unary("i");
// 	Decls varDecl1 = quantVar1.oneOf(expr());
//         Variable quantVar2 = Variable.unary("j");
// 	Decls varDecl2 = quantVar2.oneOf(expr());
// 	Formula form = quantVar1.sum().lte(quantVar2.sum()).forAll(varDecl2);	
// 	return new LogExpr(problem, form.comprehension(varDecl1).sum());
	return this;
    }                              

    public static LogExpr quantifyOp(LogExpr quantSetExpr, boolean quantKindIsaOneOrLone, String quantKind, LogExpr quantVar, LogExpr quantClause) {
	Variable v = (Variable) quantVar.expr();
	Formula f = quantClause.formula();
	if (quantSetExpr.arity() > 1)
	    quantSetExpr = quantSetExpr.project(IntConstant.constant(1));
	Decls varDecl = v.oneOf(quantSetExpr.expr());
	return new LogExpr(problem, quantKind.equals("all") ? f.forAll(varDecl) : f.forSome(varDecl));
    }

    public static LogExpr setComprehensionOp(LogExpr quantSet, LogExpr quantVar, LogExpr quantClause) {
	LogExpr quantSetExpr = quantSet;
	if (quantSetExpr.arity() > 1)
	    quantSetExpr = quantSetExpr.project(IntConstant.constant(1));
	Variable v = (Variable) quantVar.expr();
	Expression r = quantClause.formula().comprehension(v.oneOf(quantSetExpr.expr()));
	return new LogExpr(problem, r);
    }

}

