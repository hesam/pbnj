package at.ac.testing.mocks;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubClass extends SuperClass implements PBJInternObject {
    public SubClass old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) { this.fallback_field_result = r; }
    
    public SubClass() { super();
                        this.addInstance(); }
    
    public SubClass(LogExpr dontcare) { super(dontcare);
                                        this.addInstance(); }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) { this.fallback_field_resultArray = r; }
    
    public boolean fallback_checkInvariants() { return true; }
    
    public void addInstance() { LogMap.addInstance(SubClass.class, this);
                                super.addInstance(); }
    
    public void addInstanceForProblem(SubClass toAdd, LogProblem fallback_problem, String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd, SubClass.class, "at.ac.testing.mocks.SubClass",
                                             fallback_targetTypeArgsStr);
        super.addInstanceForProblem(toAdd, fallback_problem, fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public SubClass old() { return this.old; }
    
    String[] fallback_typeArgs;
    
    public SubClass fallback_setTypeArgs(String[] args) { this.fallback_typeArgs = args;
                                                          return this; }
    
    int clonerStep = 0;
    
    int atomizerStep = 0;
    
    boolean isCloned() { return this.clonerStep == LogMap.clonerStep(); }
    
    boolean isAtomized(LogProblem fallback_problem) { return this.atomizerStep == fallback_problem.relationizerStep(); }
    
    int relationizerStep = 0;
    
    boolean isRelationized(LogProblem fallback_problem) {
        return this.relationizerStep == fallback_problem.relationizerStep(); }
    
    public static int classRelationizerStep = 0;
    
    public static boolean isClassRelationized(LogProblem fallback_problem) {
        return SubClass.classRelationizerStep == fallback_problem.relationizerStep(); }
    
    public static int classAtomizerStep = 0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return SubClass.classAtomizerStep == fallback_problem.relationizerStep(); }
    
    public static int classClonerStep = 0;
    
    public static boolean isClassCloned() { return SubClass.classClonerStep == LogMap.clonerStep(); }
    
    void initEnsuredMethod() { this.startMethodTime = System.currentTimeMillis();
                               LogMap.incrClonerStep();
                               fallback_clone(); }
    
    public void fallback_updateField(java.lang.reflect.Method updaterMtd, Object[] args) {
        try { updaterMtd.invoke(this, args); }
        catch (Exception rte) { rte.printStackTrace(); } }
    
    public Object fallback_newInstance(java.lang.reflect.Constructor cons, Object[] args, String[] typeParamNames) {
        try { return ((PBJInternObject) cons.newInstance(args)).fallback_setTypeArgs(typeParamNames); }
        catch (Exception rte) { rte.printStackTrace();
                                return null; } }
    
    public void fallback_atomize(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            super.fallback_atomize(fallback_problem, fallback_targetTypeArgsStr, fallback_targetTypeArgs);
            this.atomizerStep = fallback_problem.relationizerStep();
            SubClass.fallback_classAtomize(fallback_problem, fallback_targetTypeArgsStr, fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old, fallback_problem, fallback_targetTypeArgsStr); }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            super.fallback_relationizeOld(fallback_problem, fallback_targetTypeArgsStr, fallback_targetTypeArgs);
            this.relationizerStep = fallback_problem.relationizerStep();
            SubClass.fallback_classRelationizeOld(fallback_problem, fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            SuperClass.fallback_classAtomize(fallback_problem, fallback_targetTypeArgsStr, fallback_targetTypeArgs);
            SubClass.classAtomizerStep = fallback_problem.relationizerStep(); }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem, String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            SuperClass.fallback_classRelationizeOld(fallback_problem, fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs);
            SubClass.classRelationizerStep = fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() { if (isClassCloned()) return; }
    
    public SubClass fallback_clone() { if (isCloned()) return old;
                                       SubClass res = null;
                                       SubClass.fallback_classClone();
                                       try { res = (SubClass) super.fallback_clone();
                                             res.isOld = true;
                                             this.old = res;
                                             res.old = this;
                                             this.fallback_consistencyLock = new Object();
                                             this.clonerStep = LogMap.clonerStep(); }
                                       catch (Exception rte) { rte.printStackTrace();
                                                               System.exit(1); }
                                       return res; }
    
    public static void fallback_initClassDefs() {  }
    
    static { LogMap.newClassForLog(SubClass.class, true); }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem, LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem, kodkod.ast.Formula.TRUE);
    }
}
