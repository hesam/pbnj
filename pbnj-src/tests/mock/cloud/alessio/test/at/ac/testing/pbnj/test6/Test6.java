package at.ac.testing.pbnj.test6;

import polyglot.ext.pbnj.tologic.LogMap;
import at.ac.testing.pbnj.test6.NewPeriodicSchedule;
import at.ac.testing.pbnj.test6.TimedAction;

public class Test6 implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int stabilityPeriodUp =
      4;
    
    int stabilityPeriodDown =
      4;
    
    int controlPeriod =
      3;
    
    int monitoringPeriod =
      1;
    
    int actuationDelay =
      0;
    
    NewPeriodicSchedule schedule;
    
    public static void setupSolver() {
        LogMap.SolverOpt_IntBitWidth =
          8;
    }
    
    public void printSummaryTest() {
        monitoringPeriod =
          1;
        controlPeriod =
          1;
        stabilityPeriodUp =
          4;
        stabilityPeriodDown =
          5;
        schedule =
          new NewPeriodicSchedule(monitoringPeriod,
                                  stabilityPeriodUp,
                                  stabilityPeriodDown,
                                  controlPeriod,
                                  actuationDelay);
        TimedAction[] targetStates =
          new TimedAction[] { new TimedAction(1,
                                              11,
                                              9), new TimedAction(2,
                                                                  120,
                                                                  9), new TimedAction(3,
                                                                                      6,
                                                                                      9), new TimedAction(4,
                                                                                                          6,
                                                                                                          6), new TimedAction(5,
                                                                                                                              6,
                                                                                                                              120), new TimedAction(6,
                                                                                                                                                    120,
                                                                                                                                                    120), new TimedAction(7,
                                                                                                                                                                          6,
                                                                                                                                                                          10), new TimedAction(8,
                                                                                                                                                                                               6,
                                                                                                                                                                                               12), new TimedAction(9,
                                                                                                                                                                                                                    6,
                                                                                                                                                                                                                    13), new TimedAction(10,
                                                                                                                                                                                                                                         6,
                                                                                                                                                                                                                                         16), new TimedAction(11,
                                                                                                                                                                                                                                                              6,
                                                                                                                                                                                                                                                              17), new TimedAction(12,
                                                                                                                                                                                                                                                                                   6,
                                                                                                                                                                                                                                                                                   18) };
        schedule.inputActions =
          targetStates;
        schedule.updateTypes();
        schedule.actions =
          schedule.inputActions;
        schedule.printTriggerActions();
        System.out.println("SUMMARY : " +
                           schedule);
    }
    
    public static void main(String[] args) {
        Test6 test =
          new Test6();
        test.printSummaryTest();
    }
    
    public Test6 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test6() {
        super();
        this.addInstance();
    }
    
    public Test6(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(Test6.class,
                           this);
    }
    
    public void addInstanceForProblem(Test6 toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test6.class,
                                             "at.ac.testing.pbnj.test6.Test6",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test6 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test6 fallback_setTypeArgs(String[] args) {
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
    
    boolean isAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return this.atomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return this.relationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classRelationizerStep =
      0;
    
    public static boolean isClassRelationized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Test6.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Test6.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test6.classClonerStep ==
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
            return ((polyglot.ext.pbnj.primitives.PBJInternObject)
                      cons.newInstance(args)).fallback_setTypeArgs(typeParamNames);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test6.fallback_classAtomize(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Test6.fallback_classRelationizeOld(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test6.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test6.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test6 fallback_clone() {
        if (isCloned())
            return old;
        Test6 res =
          null;
        Test6.fallback_classClone();
        try {
            res =
              (Test6)
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
               LogMap.newClassForLog(Test6.class,
                                     true);
           }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
