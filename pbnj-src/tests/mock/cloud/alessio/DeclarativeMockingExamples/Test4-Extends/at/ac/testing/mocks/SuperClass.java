package at.ac.testing.mocks;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuperClass implements PBJInternObject {
    public void init() {
        initH();
    }
    
    void initH_orig() {
        
    }
    
    public SuperClass old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public SuperClass() {
        super();
        this.addInstance();
    }
    
    public SuperClass(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return true;
    }
    
    public void addInstance() {
        LogMap.addInstance(SuperClass.class,
                           this);
    }
    
    public void addInstanceForProblem(SuperClass toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             SuperClass.class,
                                             "at.ac.testing.mocks.SuperClass",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public SuperClass old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public SuperClass fallback_setTypeArgs(String[] args) {
        this.fallback_typeArgs =
          args;
        return this;
    }
    
    int clonerStep =
      0;
    
    int atomizerStep =
      0;
    
    boolean isCloned() {
        return this.clonerStep ==
          LogMap.clonerStep();
    }
    
    boolean isAtomized(LogProblem fallback_problem) {
        return this.atomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized(LogProblem fallback_problem) {
        return this.relationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classRelationizerStep =
      0;
    
    public static boolean isClassRelationized(LogProblem fallback_problem) {
        return SuperClass.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return SuperClass.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return SuperClass.classClonerStep ==
          LogMap.clonerStep();
    }
    
    void initEnsuredMethod() {
        this.startMethodTime =
          System.currentTimeMillis();
        LogMap.incrClonerStep();
        fallback_clone();
    }
    
    public void fallback_updateField(java.lang.reflect.Method updaterMtd,
                                     Object[] args) {
        try {
            updaterMtd.invoke(this,
                              args);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
    }
    
    public Object fallback_newInstance(java.lang.reflect.Constructor cons,
                                       Object[] args,
                                       String[] typeParamNames) {
        try {
            return ((PBJInternObject)
                      cons.newInstance(args)).fallback_setTypeArgs(typeParamNames);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public boolean initH_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.initH_checkFieldsInvariants() &&
          false;
    }
    
    public void initH_assertContract() {
        assert initH_checkContract();
    }
    
    public void initH_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem initH_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": initH" +
                                         ") initiated plan b...")))));
        TimedAction.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.mocks.TimedAction",
                                           2);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        TimedAction.fallback_classClone();
        TimedAction.fallback_classAtomize(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        TimedAction.fallback_classRelationizeOld(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.mocks.NewSchedule.actions");
        fallback_problem.setModifiableField("at.ac.testing.mocks.NewSchedule.duration");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          SuperClass.initH_checkContract_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("initH",
                                 this,
                                 fallback_formula.formula(),
                                 null,
                                 false,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    void initH() {
        initH_ensured();
    }
    
    void initH_ensured() {
        initEnsuredMethod();
        try {
            initH_orig();
            initH_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  initH_planb();
                initH_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean initH_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            SuperClass.fallback_classAtomize(fallback_problem,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            SuperClass.fallback_classRelationizeOld(fallback_problem,
                                                    fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            SuperClass.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            SuperClass.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public SuperClass fallback_clone() {
        if (isCloned())
            return old;
        SuperClass res =
          null;
        SuperClass.fallback_classClone();
        try {
            res =
              (SuperClass)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            this.fallback_consistencyLock =
              new Object();
            this.clonerStep =
              LogMap.clonerStep();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(SuperClass.class,
                                     true);
           }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr initH_checkContract_log(LogProblem fallback_problem,
                                                  LogExpr fallback_target,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs,
                                                  boolean fallback_target_isOld) {
        return SuperClass.fallback_checkInvariants_log(fallback_problem,
                                                       fallback_target,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs,
                                                       fallback_target_isOld).and(SuperClass.initH_checkFieldsInvariants_log(fallback_problem,
                                                                                                                             fallback_target,
                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                             fallback_targetTypeArgs,
                                                                                                                             fallback_target_isOld)).and(new LogExpr(fallback_problem,
                                                                                                                                                                     kodkod.ast.Formula.FALSE));
    }
    
    public static LogExpr initH_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                          LogExpr fallback_target,
                                                          String fallback_targetTypeArgsStr,
                                                          String[] fallback_targetTypeArgs,
                                                          boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
