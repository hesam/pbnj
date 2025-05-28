package at.ac.testing.mocks;

import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrooklynSchedule extends NewSchedule implements PBJInternObject {
    int stabilityPeriodUp;
    
    int stabilityPeriodDown;
    
    int controlPeriod;
    
    int actuationDelay;
    
    public BrooklynSchedule(int stabilityPeriodUp,
                            int stabilityPeriodDown,
                            int controlPeriod,
                            int actuationDelay) {
        super();
        this.stabilityPeriodUp =
          stabilityPeriodUp;
        this.stabilityPeriodDown =
          stabilityPeriodDown;
        this.controlPeriod =
          controlPeriod;
        this.actuationDelay =
          actuationDelay;
        this.addInstance();
    }
    
    public boolean classInvariant() {
        return true &&
                 super.classInvariant() &&
                 stabilityPeriodUp >=
                   0 &&
                 stabilityPeriodDown >=
                   0 &&
                 controlPeriod >=
                   0 &&
          actuationDelay >=
            0;
    }
    
    public int getNextControlInterval(int time) {
        if (controlPeriod ==
              0)
            return time +
              1;
        else
            if (time /
                  controlPeriod *
                  controlPeriod <=
                  time)
                return time /
                         controlPeriod *
                         controlPeriod +
                  controlPeriod;
            else
                return time /
                         controlPeriod *
                  controlPeriod;
    }
    
    int getMax(int a,
               int b) {
        return a >
                 b ? a : b;
    }
    
    boolean avoidConcurrentActions() {
        return avoidConcurrentActions_univQuantify_1();
    }
    
    public void withDuration(int duration) {
        super.withDuration(duration);
    }
    
    public void withoutConcurrentActions() {
        avoidConcurrentActionsH();
    }
    
    void avoidConcurrentActionsH_orig() {
        
    }
    
    public String toString() {
        return "Schedule:\n" +
               Arrays.toString(actions) +
               "\n" +
               "Configuration:\n\tSup: " +
               stabilityPeriodUp +
               "\n\tSdown: " +
               stabilityPeriodDown +
               "\n\tControl: " +
               controlPeriod +
        "\n";
    }
    
    public BrooklynSchedule old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public BrooklynSchedule(LogExpr dontcare) {
        super(dontcare);
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return classInvariant();
    }
    
    public void addInstance() {
        LogMap.addInstance(BrooklynSchedule.class,
                           this);
        super.addInstance();
    }
    
    public void addInstanceForProblem(BrooklynSchedule toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             BrooklynSchedule.class,
                                             "at.ac.testing.mocks.BrooklynSchedule",
                                             fallback_targetTypeArgsStr);
        super.addInstanceForProblem(toAdd,
                                    fallback_problem,
                                    fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public BrooklynSchedule old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public BrooklynSchedule fallback_setTypeArgs(String[] args) {
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
        return BrooklynSchedule.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return BrooklynSchedule.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return BrooklynSchedule.classClonerStep ==
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
    
    public boolean avoidConcurrentActionsH_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.avoidConcurrentActionsH_checkFieldsInvariants() &&
          avoidConcurrentActions();
    }
    
    public void avoidConcurrentActionsH_assertContract() {
        assert avoidConcurrentActionsH_checkContract();
    }
    
    public void avoidConcurrentActionsH_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem avoidConcurrentActionsH_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": avoidConcurrentActionsH" +
                                         ") initiated plan b...")))));
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("at.ac.testing.mocks.TimedAction.time");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          BrooklynSchedule.avoidConcurrentActionsH_checkContract_log(fallback_problem,
                                                                     fallback_target,
                                                                     fallback_targetTypeArgsStr,
                                                                     fallback_targetTypeArgs,
                                                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("avoidConcurrentActionsH",
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
    
    void avoidConcurrentActionsH() {
        avoidConcurrentActionsH_ensured();
    }
    
    void avoidConcurrentActionsH_ensured() {
        initEnsuredMethod();
        try {
            avoidConcurrentActionsH_orig();
            avoidConcurrentActionsH_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  avoidConcurrentActionsH_planb();
                avoidConcurrentActionsH_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean avoidConcurrentActionsH_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            super.fallback_atomize(fallback_problem,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs);
            this.atomizerStep =
              fallback_problem.relationizerStep();
            BrooklynSchedule.fallback_classAtomize(fallback_problem,
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
            super.fallback_relationizeOld(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs);
            this.relationizerStep =
              fallback_problem.relationizerStep();
            BrooklynSchedule.fallback_classRelationizeOld(fallback_problem,
                                                          fallback_targetTypeArgsStr,
                                                          fallback_targetTypeArgs);
            BrooklynSchedule.stabilityPeriodUp_old_get_log(fallback_problem,
                                                           fallback_targetTypeArgsStr,
                                                           fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                            this,
                                                                                            this.stabilityPeriodUp);
            BrooklynSchedule.stabilityPeriodDown_old_get_log(fallback_problem,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                              this,
                                                                                              this.stabilityPeriodDown);
            BrooklynSchedule.controlPeriod_old_get_log(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                        this,
                                                                                        this.controlPeriod);
            BrooklynSchedule.actuationDelay_old_get_log(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                         this,
                                                                                         this.actuationDelay);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            NewSchedule.fallback_classAtomize(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs);
            BrooklynSchedule.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            NewSchedule.fallback_classRelationizeOld(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs);
            BrooklynSchedule.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public BrooklynSchedule fallback_clone() {
        if (isCloned())
            return old;
        BrooklynSchedule res =
          null;
        BrooklynSchedule.fallback_classClone();
        try {
            res =
              (BrooklynSchedule)
                super.fallback_clone();
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
            res.stabilityPeriodUp =
              this.stabilityPeriodUp;
            res.stabilityPeriodDown =
              this.stabilityPeriodDown;
            res.controlPeriod =
              this.controlPeriod;
            res.actuationDelay =
              this.actuationDelay;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr stabilityPeriodUp_get_log(LogProblem fallback_problem,
                                                    LogExpr fallback_target,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs,
                                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.BrooklynSchedule",
                                   fallback_targetTypeArgsStr,
                                   "stabilityPeriodUp",
                                   isOld);
    }
    
    public static LogRelation stabilityPeriodUp_old_get_log(LogProblem fallback_problem,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.BrooklynSchedule",
                                      fallback_targetTypeArgsStr,
                                      "stabilityPeriodUp");
    }
    
    public int fallback_updateField_stabilityPeriodUp(Integer newVal) {
        return this.stabilityPeriodUp =
          newVal;
    }
    
    public PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target,
                                                       boolean isReflexive,
                                                       java.lang.String ... fieldNs) {
        Class c =
          int.class;
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.ArrayList<Integer> workList =
          new java.util.ArrayList<Integer>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                Integer childN =
                  (Integer)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            Integer n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    Integer childN =
                      (Integer)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((Integer)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                Integer n =
                  (Integer)
                    f.get(this);
                if (n !=
                      null)
                    res.add(n);
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    public static LogExpr stabilityPeriodDown_get_log(LogProblem fallback_problem,
                                                      LogExpr fallback_target,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs,
                                                      boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.BrooklynSchedule",
                                   fallback_targetTypeArgsStr,
                                   "stabilityPeriodDown",
                                   isOld);
    }
    
    public static LogRelation stabilityPeriodDown_old_get_log(LogProblem fallback_problem,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.BrooklynSchedule",
                                      fallback_targetTypeArgsStr,
                                      "stabilityPeriodDown");
    }
    
    public int fallback_updateField_stabilityPeriodDown(Integer newVal) {
        return this.stabilityPeriodDown =
          newVal;
    }
    
    public static LogExpr controlPeriod_get_log(LogProblem fallback_problem,
                                                LogExpr fallback_target,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs,
                                                boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.BrooklynSchedule",
                                   fallback_targetTypeArgsStr,
                                   "controlPeriod",
                                   isOld);
    }
    
    public static LogRelation controlPeriod_old_get_log(LogProblem fallback_problem,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.BrooklynSchedule",
                                      fallback_targetTypeArgsStr,
                                      "controlPeriod");
    }
    
    public int fallback_updateField_controlPeriod(Integer newVal) {
        return this.controlPeriod =
          newVal;
    }
    
    public static LogExpr actuationDelay_get_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.mocks.BrooklynSchedule",
                                   fallback_targetTypeArgsStr,
                                   "actuationDelay",
                                   isOld);
    }
    
    public static LogRelation actuationDelay_old_get_log(LogProblem fallback_problem,
                                                         String fallback_targetTypeArgsStr,
                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.mocks.BrooklynSchedule",
                                      fallback_targetTypeArgsStr,
                                      "actuationDelay");
    }
    
    public int fallback_updateField_actuationDelay(Integer newVal) {
        return this.actuationDelay =
          newVal;
    }
    
    boolean avoidConcurrentActions_univQuantify_1() {
        for (int i : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!avoidConcurrentActions_univQuantify_0(i))
                return false;
        }
        return true;
    }
    
    boolean avoidConcurrentActions_univQuantify_0(int i) {
        for (int j : PBJInternInteger.range(0,
                                            size -
                                              1)) {
            if (!(i <
                    j ==
                    getNextControlInterval(actions[i].time) <=
                      actions[j].time))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_stabilityPeriodUp(PBJInternSet<BrooklynSchedule> objs,
                                                                 java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<BrooklynSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().stabilityPeriodUp);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_stabilityPeriodDown(PBJInternSet<BrooklynSchedule> objs,
                                                                   java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<BrooklynSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().stabilityPeriodDown);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_controlPeriod(PBJInternSet<BrooklynSchedule> objs,
                                                             java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<BrooklynSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().controlPeriod);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_actuationDelay(PBJInternSet<BrooklynSchedule> objs,
                                                              java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<BrooklynSchedule> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().actuationDelay);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(BrooklynSchedule.class,
                                     true);
               LogMap.newInstVarRel("stabilityPeriodUp",
                                    BrooklynSchedule.class,
                                    "at.ac.testing.mocks.BrooklynSchedule",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel("stabilityPeriodDown",
                                    BrooklynSchedule.class,
                                    "at.ac.testing.mocks.BrooklynSchedule",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel("controlPeriod",
                                    BrooklynSchedule.class,
                                    "at.ac.testing.mocks.BrooklynSchedule",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newInstVarRel("actuationDelay",
                                    BrooklynSchedule.class,
                                    "at.ac.testing.mocks.BrooklynSchedule",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
           }
    
    public static LogExpr classInvariant_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(NewSchedule.classInvariant_log(fallback_problem,
                                                                                       fallback_target,
                                                                                       "",
                                                                                       null,
                                                                                       fallback_target_isOld)).and(BrooklynSchedule.stabilityPeriodUp_get_log(fallback_problem,
                                                                                                                                                              fallback_target,
                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                              fallback_target_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0)))).and(BrooklynSchedule.stabilityPeriodDown_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                            fallback_target_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)))).and(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(0)))).and(BrooklynSchedule.actuationDelay_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld).gte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    kodkod.ast.IntConstant.constant(0))));
    }
    
    public static LogExpr getNextControlInterval_log(LogProblem fallback_problem,
                                                     LogExpr fallback_target,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs,
                                                     boolean fallback_target_isOld,
                                                     LogExpr time,
                                                     boolean time_isOld) {
        return BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld).eq(new LogExpr(fallback_problem,
                                                                                            kodkod.ast.IntConstant.constant(0))).thenElse(time.plus(new LogExpr(fallback_problem,
                                                                                                                                                                kodkod.ast.IntConstant.constant(1))),
                                                                                                                                          time.divide(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                             fallback_target_isOld)).multiply(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                     fallback_target_isOld)).lte(time).thenElse(time.divide(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld)).multiply(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld)).plus(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld)),
                                                                                                                                                                                                                                                                                                                time.divide(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld)).multiply(BrooklynSchedule.controlPeriod_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld))));
    }
    
    static LogExpr getMax_log(LogProblem fallback_problem,
                              LogExpr fallback_target,
                              String fallback_targetTypeArgsStr,
                              String[] fallback_targetTypeArgs,
                              boolean fallback_target_isOld,
                              LogExpr a,
                              boolean a_isOld,
                              LogExpr b,
                              boolean b_isOld) {
        return a.gt(b).thenElse(a,
                                b);
    }
    
    static LogExpr avoidConcurrentActions_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean fallback_target_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        boolean j_isOld =
          false;
        LogExpr quantVar_j =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("j"));
        LogExpr j =
          new LogExpr(fallback_problem,
                      quantVar_j.expr());
        LogExpr fallback_var_j =
          quantVar_j;
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  PBJInternInteger.range_log(fallback_problem,
                                                                                             fallback_problem.class_log(PBJInternInteger.class),
                                                                                             "",
                                                                                             null,
                                                                                             fallback_target_isOld,
                                                                                             new LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0)),
                                                                                             fallback_target_isOld,
                                                                                             BrooklynSchedule.size_get_log(fallback_problem,
                                                                                                                           fallback_target,
                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                           fallback_targetTypeArgs,
                                                                                                                           fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                    kodkod.ast.IntConstant.constant(1))),
                                                                                             fallback_target_isOld),
                                                                  "<java.lang.Integer>",
                                                                  new String[] { "java.lang.Integer" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  fallback_var_i,
                                  LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                     PBJInternInteger.range_log(fallback_problem,
                                                                                                                fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                "",
                                                                                                                null,
                                                                                                                fallback_target_isOld,
                                                                                                                new LogExpr(fallback_problem,
                                                                                                                            kodkod.ast.IntConstant.constant(0)),
                                                                                                                fallback_target_isOld,
                                                                                                                BrooklynSchedule.size_get_log(fallback_problem,
                                                                                                                                              fallback_target,
                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                              fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                       kodkod.ast.IntConstant.constant(1))),
                                                                                                                fallback_target_isOld),
                                                                                     "<java.lang.Integer>",
                                                                                     new String[] { "java.lang.Integer" },
                                                                                     fallback_target_isOld),
                                                     false,
                                                     "all",
                                                     fallback_var_j,
                                                     i.lt(j).iff(BrooklynSchedule.getNextControlInterval_log(fallback_problem,
                                                                                                             fallback_target,
                                                                                                             fallback_targetTypeArgsStr,
                                                                                                             fallback_targetTypeArgs,
                                                                                                             fallback_target_isOld,
                                                                                                             TimedAction.time_get_log(fallback_problem,
                                                                                                                                      BrooklynSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                       fallback_target,
                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                       fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                      i,
                                                                                                                                                                                                      false),
                                                                                                                                      "",
                                                                                                                                      null,
                                                                                                                                      fallback_target_isOld),
                                                                                                             fallback_target_isOld).lte(TimedAction.time_get_log(fallback_problem,
                                                                                                                                                                 BrooklynSchedule.actions_get_log(fallback_problem,
                                                                                                                                                                                                  fallback_target,
                                                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                                                  fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                 j,
                                                                                                                                                                                                                                 false),
                                                                                                                                                                 "",
                                                                                                                                                                 null,
                                                                                                                                                                 fallback_target_isOld)))));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return BrooklynSchedule.classInvariant_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld);
    }
    
    public static LogExpr avoidConcurrentActionsH_checkContract_log(LogProblem fallback_problem,
                                                                    LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        return BrooklynSchedule.fallback_checkInvariants_log(fallback_problem,
                                                             fallback_target,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs,
                                                             fallback_target_isOld).and(BrooklynSchedule.avoidConcurrentActionsH_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                           fallback_target,
                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                           fallback_target_isOld)).and(BrooklynSchedule.avoidConcurrentActions_log(fallback_problem,
                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                   fallback_target_isOld));
    }
    
    public static LogExpr avoidConcurrentActionsH_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                            LogExpr fallback_target,
                                                                            String fallback_targetTypeArgsStr,
                                                                            String[] fallback_targetTypeArgs,
                                                                            boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
