import polyglot.ext.pbnj.tologic.*;
import polyglot.ext.pbnj.primitives.*;
import pbnj.util.ArrayList;
import java.util.Arrays;

public class Test implements PBJInternObject {
    int maxThreshold;
    
    CurrentContext currentContext;
    
    CurrentConfiguration currentConfiguration;
    
    public Test() {
        super();
        this.maxThreshold =
          10;
        this.currentContext =
          new CurrentContext();
        this.currentConfiguration =
          new CurrentConfiguration();
        this.addInstance();
    }
    
    boolean needsScaleUpAtIndex(int i) {
        return currentContext.requestSumAtIndex(i) /
                 currentConfiguration.numRunningServers >
          maxThreshold;
    }
    
    boolean needsScaleDownAtIndex(int i) {
        return !needsScaleUpAtIndex(i);
    }
    
    void testTriggerScaleMain_orig() {
        
    }
    
    void testTriggerScaleInit() {
        currentConfiguration.numRunningServers =
          4;
        for (int i =
               0;
             i <=
               1;
             i++)
            currentContext.requestCounts.add(new RequestCounts());
    }
    
    void testTriggerScale() {
        testTriggerScaleInit();
        System.out.println("Before:\n" +
                           this);
        testTriggerScaleMain();
        System.out.println("After:\n" +
                           this);
    }
    
    public String toString() {
        return "A Test (currentContext = " +
               currentContext +
               ", currentConfiguration = " +
               currentConfiguration +
               ", maxThreshold = " +
               maxThreshold +
        ")";
    }
    
    public static void main(String[] args) {
        Test t =
          new Test();
        t.testTriggerScale();
    }
    
    public Test old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test(LogExpr dontcare) {
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
        LogMap.addInstance(Test.class,
                           this);
    }
    
    public void addInstanceForProblem(Test toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test.class,
                                             "Test",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test fallback_setTypeArgs(String[] args) {
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
        return Test.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Test.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test.classClonerStep ==
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
    
    public boolean testTriggerScaleMain_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.testTriggerScaleMain_checkFieldsInvariants() &&
          (needsScaleUpAtIndex(0) &&
             needsScaleDownAtIndex(1));
    }
    
    public void testTriggerScaleMain_assertContract() {
        assert testTriggerScaleMain_checkContract();
    }
    
    public void testTriggerScaleMain_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem testTriggerScaleMain_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": testTriggerScaleMain" +
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
        fallback_problem.setModifiableField("RequestCounts.counts");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          Test.testTriggerScaleMain_checkContract_log(fallback_problem,
                                                      fallback_target,
                                                      fallback_targetTypeArgsStr,
                                                      fallback_targetTypeArgs,
                                                      fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("testTriggerScaleMain",
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
    
    void testTriggerScaleMain() {
        testTriggerScaleMain_ensured();
    }
    
    void testTriggerScaleMain_ensured() {
        initEnsuredMethod();
        try {
            testTriggerScaleMain_orig();
            testTriggerScaleMain_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  testTriggerScaleMain_planb();
                testTriggerScaleMain_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean testTriggerScaleMain_checkFieldsInvariants() {
        return true &&
                 (currentContext ==
                    null ||
                    currentContext.fallback_checkInvariants()) &&
          (currentConfiguration ==
             null ||
             currentConfiguration.fallback_checkInvariants());
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test.fallback_classAtomize(fallback_problem,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.currentContext !=
                  null)
                this.currentContext.fallback_atomize(fallback_problem,
                                                     "",
                                                     null);
            if (this.currentConfiguration !=
                  null)
                this.currentConfiguration.fallback_atomize(fallback_problem,
                                                           "",
                                                           null);
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Test.fallback_classRelationizeOld(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs);
            if (this.currentContext !=
                  null)
                this.currentContext.fallback_relationizeOld(fallback_problem,
                                                            "",
                                                            null);
            if (this.currentConfiguration !=
                  null)
                this.currentConfiguration.fallback_relationizeOld(fallback_problem,
                                                                  "",
                                                                  null);
            Test.maxThreshold_old_get_log(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs).put_log(fallback_problem,
                                                                           this,
                                                                           this.maxThreshold);
            Test.currentContext_old_get_log(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs).put_log(fallback_problem,
                                                                             this,
                                                                             this.currentContext);
            Test.currentConfiguration_old_get_log(fallback_problem,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                   this,
                                                                                   this.currentConfiguration);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test fallback_clone() {
        if (isCloned())
            return old;
        Test res =
          null;
        Test.fallback_classClone();
        try {
            res =
              (Test)
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
            res.maxThreshold =
              this.maxThreshold;
            if (this.currentContext !=
                  null)
                res.currentContext =
                  this.currentContext.fallback_clone();
            if (this.currentConfiguration !=
                  null)
                res.currentConfiguration =
                  this.currentConfiguration.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr maxThreshold_get_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test",
                                   fallback_targetTypeArgsStr,
                                   "maxThreshold",
                                   isOld);
    }
    
    public static LogRelation maxThreshold_old_get_log(LogProblem fallback_problem,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test",
                                      fallback_targetTypeArgsStr,
                                      "maxThreshold");
    }
    
    public int fallback_updateField_maxThreshold(Integer newVal) {
        return this.maxThreshold =
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
    
    public static LogExpr currentContext_get_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test",
                                   fallback_targetTypeArgsStr,
                                   "currentContext",
                                   isOld);
    }
    
    public static LogRelation currentContext_old_get_log(LogProblem fallback_problem,
                                                         String fallback_targetTypeArgsStr,
                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test",
                                      fallback_targetTypeArgsStr,
                                      "currentContext");
    }
    
    public CurrentContext fallback_updateField_currentContext(CurrentContext newVal) {
        return this.currentContext =
          newVal;
    }
    
    public PBJInternSet<CurrentContext> fieldsClosure_CurrentContext(Object fallback_target,
                                                                     boolean isReflexive,
                                                                     java.lang.String ... fieldNs) {
        Class c =
          CurrentContext.class;
        PBJInternSet<CurrentContext> res =
          new PBJInternSet<CurrentContext>();
        java.util.ArrayList<CurrentContext> workList =
          new java.util.ArrayList<CurrentContext>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                CurrentContext childN =
                  (CurrentContext)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            CurrentContext n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    CurrentContext childN =
                      (CurrentContext)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((CurrentContext)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<CurrentContext> multiFields_CurrentContext(java.lang.String ... fieldNs) {
        Class c =
          CurrentContext.class;
        PBJInternSet<CurrentContext> res =
          new PBJInternSet<CurrentContext>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                CurrentContext n =
                  (CurrentContext)
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
    
    public static LogExpr currentConfiguration_get_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test",
                                   fallback_targetTypeArgsStr,
                                   "currentConfiguration",
                                   isOld);
    }
    
    public static LogRelation currentConfiguration_old_get_log(LogProblem fallback_problem,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test",
                                      fallback_targetTypeArgsStr,
                                      "currentConfiguration");
    }
    
    public CurrentConfiguration fallback_updateField_currentConfiguration(CurrentConfiguration newVal) {
        return this.currentConfiguration =
          newVal;
    }
    
    public PBJInternSet<CurrentConfiguration> fieldsClosure_CurrentConfiguration(Object fallback_target,
                                                                                 boolean isReflexive,
                                                                                 java.lang.String ... fieldNs) {
        Class c =
          CurrentConfiguration.class;
        PBJInternSet<CurrentConfiguration> res =
          new PBJInternSet<CurrentConfiguration>();
        java.util.ArrayList<CurrentConfiguration> workList =
          new java.util.ArrayList<CurrentConfiguration>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                CurrentConfiguration childN =
                  (CurrentConfiguration)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            CurrentConfiguration n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    CurrentConfiguration childN =
                      (CurrentConfiguration)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((CurrentConfiguration)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<CurrentConfiguration> multiFields_CurrentConfiguration(java.lang.String ... fieldNs) {
        Class c =
          CurrentConfiguration.class;
        PBJInternSet<CurrentConfiguration> res =
          new PBJInternSet<CurrentConfiguration>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                CurrentConfiguration n =
                  (CurrentConfiguration)
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
    
    public static PBJInternSet<Integer> setMap_maxThreshold(PBJInternSet<Test> objs,
                                                            java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Test> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().maxThreshold);
        }
        return res;
    }
    
    public static PBJInternSet<CurrentContext> setMap_currentContext(PBJInternSet<Test> objs,
                                                                     java.lang.String ... fieldNs) {
        PBJInternSet<CurrentContext> res =
          new PBJInternSet<CurrentContext>();
        java.util.Iterator<Test> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().currentContext);
        }
        return res;
    }
    
    public static PBJInternSet<CurrentConfiguration> setMap_currentConfiguration(PBJInternSet<Test> objs,
                                                                                 java.lang.String ... fieldNs) {
        PBJInternSet<CurrentConfiguration> res =
          new PBJInternSet<CurrentConfiguration>();
        java.util.Iterator<Test> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().currentConfiguration);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test.class,
                                     true);
               LogMap.newInstVarRel("maxThreshold",
                                    Test.class,
                                    "Test",
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
               LogMap.newInstVarRel("currentContext",
                                    Test.class,
                                    "Test",
                                    CurrentContext.class,
                                    "CurrentContext",
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
               LogMap.newInstVarRel("currentConfiguration",
                                    Test.class,
                                    "Test",
                                    CurrentConfiguration.class,
                                    "CurrentConfiguration",
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
    
    static LogExpr needsScaleUpAtIndex_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean fallback_target_isOld,
                                           LogExpr i,
                                           boolean i_isOld) {
        return CurrentContext.requestSumAtIndex_log(fallback_problem,
                                                    Test.currentContext_get_log(fallback_problem,
                                                                                fallback_target,
                                                                                fallback_targetTypeArgsStr,
                                                                                fallback_targetTypeArgs,
                                                                                fallback_target_isOld),
                                                    "",
                                                    null,
                                                    fallback_target_isOld,
                                                    i,
                                                    i_isOld).divide(CurrentConfiguration.numRunningServers_get_log(fallback_problem,
                                                                                                                   Test.currentConfiguration_get_log(fallback_problem,
                                                                                                                                                     fallback_target,
                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                     fallback_target_isOld),
                                                                                                                   "",
                                                                                                                   null,
                                                                                                                   fallback_target_isOld)).gt(Test.maxThreshold_get_log(fallback_problem,
                                                                                                                                                                        fallback_target,
                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                        fallback_target_isOld));
    }
    
    static LogExpr needsScaleDownAtIndex_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld,
                                             LogExpr i,
                                             boolean i_isOld) {
        return Test.needsScaleUpAtIndex_log(fallback_problem,
                                            fallback_target,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs,
                                            fallback_target_isOld,
                                            i,
                                            i_isOld).not();
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr testTriggerScaleMain_checkContract_log(LogProblem fallback_problem,
                                                                 LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld) {
        return Test.fallback_checkInvariants_log(fallback_problem,
                                                 fallback_target,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs,
                                                 fallback_target_isOld).and(Test.testTriggerScaleMain_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                fallback_target,
                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                fallback_target_isOld)).and(Test.needsScaleUpAtIndex_log(fallback_problem,
                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                         new LogExpr(fallback_problem,
                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                         fallback_target_isOld).and(Test.needsScaleDownAtIndex_log(fallback_problem,
                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                   fallback_target_isOld,
                                                                                                                                                                                                                                                   new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(1)),
                                                                                                                                                                                                                                                   fallback_target_isOld)));
    }
    
    public static LogExpr testTriggerScaleMain_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                                         LogExpr fallback_target,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs,
                                                                         boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(Test.currentContext_get_log(fallback_problem,
                                                                                    fallback_target,
                                                                                    fallback_targetTypeArgsStr,
                                                                                    fallback_targetTypeArgs,
                                                                                    fallback_target_isOld).eq(fallback_problem.null_log()).or(CurrentContext.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                          Test.currentContext_get_log(fallback_problem,
                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                      fallback_target_isOld),
                                                                                                                                                                                          "",
                                                                                                                                                                                          null,
                                                                                                                                                                                          fallback_target_isOld))).and(Test.currentConfiguration_get_log(fallback_problem,
                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                         fallback_target_isOld).eq(fallback_problem.null_log()).or(CurrentConfiguration.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                     Test.currentConfiguration_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                     "",
                                                                                                                                                                                                                                                                                                                                                                     null,
                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld)));
    }
}

class RequestCounts implements PBJInternObject {
    int numRequests;
    
    int[] counts;
    
    public RequestCounts() {
        super();
        this.numRequests =
          5;
        this.counts =
          (new int[5]);
        this.addInstance();
    }
    
    boolean valid() {
        return counts !=
                 null &&
                 counts.length ==
                   numRequests &&
          valid_univQuantify_0();
    }
    
    int requestSum() {
        return counts[0] +
                 counts[1] +
                 counts[2] +
                 counts[3] +
          counts[4];
    }
    
    public String toString() {
        return Arrays.toString(counts);
    }
    
    public RequestCounts old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public RequestCounts(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return valid();
    }
    
    public void addInstance() {
        LogMap.addInstance(RequestCounts.class,
                           this);
    }
    
    public void addInstanceForProblem(RequestCounts toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             RequestCounts.class,
                                             "RequestCounts",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public RequestCounts old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public RequestCounts fallback_setTypeArgs(String[] args) {
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
        return RequestCounts.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return RequestCounts.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return RequestCounts.classClonerStep ==
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
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            RequestCounts.fallback_classAtomize(fallback_problem,
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
            RequestCounts.fallback_classRelationizeOld(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs);
            RequestCounts.numRequests_old_get_log(fallback_problem,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                   this,
                                                                                   this.numRequests);
            RequestCounts.counts_old_get_log(fallback_problem,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs).int1_array_put_log(fallback_problem,
                                                                                         this,
                                                                                         this.counts);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            RequestCounts.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            RequestCounts.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public RequestCounts fallback_clone() {
        if (isCloned())
            return old;
        RequestCounts res =
          null;
        RequestCounts.fallback_classClone();
        try {
            res =
              (RequestCounts)
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
            res.numRequests =
              this.numRequests;
            if (this.counts !=
                  null) {
                res.counts =
                  (int[])
                    this.counts.clone();
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr numRequests_get_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "RequestCounts",
                                   fallback_targetTypeArgsStr,
                                   "numRequests",
                                   isOld);
    }
    
    public static LogRelation numRequests_old_get_log(LogProblem fallback_problem,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RequestCounts",
                                      fallback_targetTypeArgsStr,
                                      "numRequests");
    }
    
    public int fallback_updateField_numRequests(Integer newVal) {
        return this.numRequests =
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
    
    public static LogExpr counts_get_log(LogProblem fallback_problem,
                                         LogExpr fallback_target,
                                         String fallback_targetTypeArgsStr,
                                         String[] fallback_targetTypeArgs,
                                         boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "RequestCounts",
                                   fallback_targetTypeArgsStr,
                                   "counts",
                                   isOld);
    }
    
    public static LogRelation counts_old_get_log(LogProblem fallback_problem,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RequestCounts",
                                      fallback_targetTypeArgsStr,
                                      "counts");
    }
    
    public int fallback_updateArrayField_counts(int index,
                                                int newVal) {
        this.counts[index] =
          newVal;
        return newVal;
    }
    
    public int[] fallback_updateField_counts(java.util.ArrayList<Integer> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.counts ==
              null ||
              this.counts.length !=
                s)
            this.counts =
              (new int[s]);
        while (i <
                 s) {
            this.counts[i] =
              newVal.get(i);
            i++;
        }
        return this.counts;
    }
    
    public int[] fallback_updateField_counts(int[] newVal) {
        return this.counts =
          newVal;
    }
    
    boolean valid_univQuantify_0() {
        for (int i : PBJInternInteger.range(0,
                                            numRequests -
                                              1)) {
            if (!(counts[i] >=
                    0 &&
                    counts[i] <=
                      20))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_numRequests(PBJInternSet<RequestCounts> objs,
                                                           java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<RequestCounts> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().numRequests);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(RequestCounts.class,
                                     true);
               LogMap.newInstVarRel("numRequests",
                                    RequestCounts.class,
                                    "RequestCounts",
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
               LogMap.newInstVarRel("counts",
                                    RequestCounts.class,
                                    "RequestCounts",
                                    Integer.class,
                                    "int",
                                    null,
                                    null,
                                    false,
                                    false,
                                    1,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
           }
    
    static LogExpr valid_log(LogProblem fallback_problem,
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
        return RequestCounts.counts_get_log(fallback_problem,
                                            fallback_target,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs,
                                            fallback_target_isOld).no().not().and(RequestCounts.counts_get_log(fallback_problem,
                                                                                                               fallback_target,
                                                                                                               fallback_targetTypeArgsStr,
                                                                                                               fallback_targetTypeArgs,
                                                                                                               fallback_target_isOld).length_get_log(fallback_problem).eq(RequestCounts.numRequests_get_log(fallback_problem,
                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                            fallback_target_isOld))).and(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                            PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                       fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                       "",
                                                                                                                                                                                                                                                                                                                       null,
                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                       new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                       RequestCounts.numRequests_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                            RequestCounts.counts_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                         fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                        i,
                                                                                                                                                                                                                                                                                                                        false).gte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(0))).and(RequestCounts.counts_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                    false).lte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(20))))));
    }
    
    static LogExpr requestSum_log(LogProblem fallback_problem,
                                  LogExpr fallback_target,
                                  String fallback_targetTypeArgsStr,
                                  String[] fallback_targetTypeArgs,
                                  boolean fallback_target_isOld) {
        return RequestCounts.counts_get_log(fallback_problem,
                                            fallback_target,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs,
                                            fallback_target_isOld).get_log(fallback_problem,
                                                                           new LogExpr(fallback_problem,
                                                                                       kodkod.ast.IntConstant.constant(0)),
                                                                           false).plus(RequestCounts.counts_get_log(fallback_problem,
                                                                                                                    fallback_target,
                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                    fallback_targetTypeArgs,
                                                                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                   new LogExpr(fallback_problem,
                                                                                                                                                               kodkod.ast.IntConstant.constant(1)),
                                                                                                                                                   false)).plus(RequestCounts.counts_get_log(fallback_problem,
                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                            new LogExpr(fallback_problem,
                                                                                                                                                                                                                                        kodkod.ast.IntConstant.constant(2)),
                                                                                                                                                                                                                            false)).plus(RequestCounts.counts_get_log(fallback_problem,
                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                      fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                     new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(3)),
                                                                                                                                                                                                                                                                                                     false)).plus(RequestCounts.counts_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                              new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(4)),
                                                                                                                                                                                                                                                                                                                                                                              false));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return RequestCounts.valid_log(fallback_problem,
                                       fallback_target,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs,
                                       fallback_target_isOld);
    }
}

class CurrentContext implements PBJInternObject {
    ArrayList<RequestCounts> requestCounts;
    
    public CurrentContext() {
        super();
        this.requestCounts =
          new ArrayList<RequestCounts>().fallback_setTypeArgs(new String[] { "RequestCounts" });
        this.addInstance();
    }
    
    boolean valid() {
        return requestCounts !=
                 null &&
                 requestCounts.valid() &&
          valid_univQuantify_1();
    }
    
    int requestSumAtIndex(int i) {
        return requestCounts.get_spec(i).requestSum();
    }
    
    public String toString() {
        return "A CurrentConext (requestCounts = " +
               requestCounts +
        ")";
    }
    
    public CurrentContext old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public CurrentContext(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return valid();
    }
    
    public void addInstance() {
        LogMap.addInstance(CurrentContext.class,
                           this);
    }
    
    public void addInstanceForProblem(CurrentContext toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             CurrentContext.class,
                                             "CurrentContext",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public CurrentContext old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public CurrentContext fallback_setTypeArgs(String[] args) {
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
        return CurrentContext.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return CurrentContext.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return CurrentContext.classClonerStep ==
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
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            CurrentContext.fallback_classAtomize(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.requestCounts !=
                  null)
                this.requestCounts.fallback_atomize(fallback_problem,
                                                    "<RequestCounts>",
                                                    new String[] { "RequestCounts" });
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            CurrentContext.fallback_classRelationizeOld(fallback_problem,
                                                        fallback_targetTypeArgsStr,
                                                        fallback_targetTypeArgs);
            if (this.requestCounts !=
                  null)
                this.requestCounts.fallback_relationizeOld(fallback_problem,
                                                           "<RequestCounts>",
                                                           new String[] { "RequestCounts" });
            CurrentContext.requestCounts_old_get_log(fallback_problem,
                                                     fallback_targetTypeArgsStr,
                                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                      this,
                                                                                      this.requestCounts);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            CurrentContext.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            CurrentContext.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public CurrentContext fallback_clone() {
        if (isCloned())
            return old;
        CurrentContext res =
          null;
        CurrentContext.fallback_classClone();
        try {
            res =
              (CurrentContext)
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
            if (this.requestCounts !=
                  null)
                res.requestCounts =
                  this.requestCounts.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr requestCounts_get_log(LogProblem fallback_problem,
                                                LogExpr fallback_target,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs,
                                                boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "CurrentContext",
                                   fallback_targetTypeArgsStr,
                                   "requestCounts",
                                   isOld);
    }
    
    public static LogRelation requestCounts_old_get_log(LogProblem fallback_problem,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "CurrentContext",
                                      fallback_targetTypeArgsStr,
                                      "requestCounts");
    }
    
    public ArrayList<RequestCounts> fallback_updateField_requestCounts(ArrayList<RequestCounts> newVal) {
        return this.requestCounts =
          newVal;
    }
    
    boolean valid_univQuantify_1() {
        for (int i : PBJInternInteger.range(0,
                                            requestCounts.size() -
                                              1)) {
            if (!(requestCounts.get_spec(i) !=
                    null &&
                    requestCounts.get_spec(i).valid()))
                return false;
        }
        return true;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(CurrentContext.class,
                                     true);
               LogMap.newInstVarRel("requestCounts",
                                    CurrentContext.class,
                                    "CurrentContext",
                                    ArrayList.class,
                                    "pbnj.util.ArrayList<RequestCounts>",
                                    new Class[] { RequestCounts.class },
                                    new String[] { "RequestCounts" },
                                    false,
                                    false,
                                    0,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
               LogMap.newParameterizedGenericClass(ArrayList.class,
                                                   "pbnj.util.ArrayList<RequestCounts>",
                                                   new Class[] { RequestCounts.class },
                                                   new String[] { "RequestCounts" });
           }
    
    static LogExpr valid_log(LogProblem fallback_problem,
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
        return CurrentContext.requestCounts_get_log(fallback_problem,
                                                    fallback_target,
                                                    fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs,
                                                    fallback_target_isOld).eq(fallback_problem.null_log()).not().and(ArrayList.valid_log(fallback_problem,
                                                                                                                                         CurrentContext.requestCounts_get_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                         "<RequestCounts>",
                                                                                                                                         new String[] { "RequestCounts" },
                                                                                                                                         fallback_target_isOld)).and(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                        PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                   fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                                                                                                                                                   "",
                                                                                                                                                                                                                                                   null,
                                                                                                                                                                                                                                                   fallback_target_isOld,
                                                                                                                                                                                                                                                   new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                                   fallback_target_isOld,
                                                                                                                                                                                                                                                   ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                                                      CurrentContext.requestCounts_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                           fallback_target_isOld),
                                                                                                                                                                                                                                                                      "<RequestCounts>",
                                                                                                                                                                                                                                                                      new String[] { "RequestCounts" },
                                                                                                                                                                                                                                                                      fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                   fallback_target_isOld),
                                                                                                                                                                                                                        "<java.lang.Integer>",
                                                                                                                                                                                                                        new String[] { "java.lang.Integer" },
                                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                                        false,
                                                                                                                                                                                        "all",
                                                                                                                                                                                        fallback_var_i,
                                                                                                                                                                                        ArrayList.get_spec_log(fallback_problem,
                                                                                                                                                                                                               CurrentContext.requestCounts_get_log(fallback_problem,
                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                                                               "<RequestCounts>",
                                                                                                                                                                                                               new String[] { "RequestCounts" },
                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                               i,
                                                                                                                                                                                                               i_isOld).eq(fallback_problem.null_log()).not().and(RequestCounts.valid_log(fallback_problem,
                                                                                                                                                                                                                                                                                          ArrayList.get_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                 CurrentContext.requestCounts_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                 "<RequestCounts>",
                                                                                                                                                                                                                                                                                                                 new String[] { "RequestCounts" },
                                                                                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                 i,
                                                                                                                                                                                                                                                                                                                 i_isOld),
                                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                                          fallback_target_isOld))));
    }
    
    static LogExpr requestSumAtIndex_log(LogProblem fallback_problem,
                                         LogExpr fallback_target,
                                         String fallback_targetTypeArgsStr,
                                         String[] fallback_targetTypeArgs,
                                         boolean fallback_target_isOld,
                                         LogExpr i,
                                         boolean i_isOld) {
        return RequestCounts.requestSum_log(fallback_problem,
                                            ArrayList.get_spec_log(fallback_problem,
                                                                   CurrentContext.requestCounts_get_log(fallback_problem,
                                                                                                        fallback_target,
                                                                                                        fallback_targetTypeArgsStr,
                                                                                                        fallback_targetTypeArgs,
                                                                                                        fallback_target_isOld),
                                                                   "<RequestCounts>",
                                                                   new String[] { "RequestCounts" },
                                                                   fallback_target_isOld,
                                                                   i,
                                                                   i_isOld),
                                            "",
                                            null,
                                            fallback_target_isOld);
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return CurrentContext.valid_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        fallback_target_isOld);
    }
}

class CurrentConfiguration implements PBJInternObject {
    int numRunningServers;
    
    boolean valid() {
        return true;
    }
    
    public String toString() {
        return "A CurrentConfiguration (numRunningServers = " +
               numRunningServers +
        ")";
    }
    
    public CurrentConfiguration old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public CurrentConfiguration() {
        super();
        this.addInstance();
    }
    
    public CurrentConfiguration(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return valid();
    }
    
    public void addInstance() {
        LogMap.addInstance(CurrentConfiguration.class,
                           this);
    }
    
    public void addInstanceForProblem(CurrentConfiguration toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             CurrentConfiguration.class,
                                             "CurrentConfiguration",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public CurrentConfiguration old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public CurrentConfiguration fallback_setTypeArgs(String[] args) {
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
        return CurrentConfiguration.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return CurrentConfiguration.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return CurrentConfiguration.classClonerStep ==
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
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            CurrentConfiguration.fallback_classAtomize(fallback_problem,
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
            CurrentConfiguration.fallback_classRelationizeOld(fallback_problem,
                                                              fallback_targetTypeArgsStr,
                                                              fallback_targetTypeArgs);
            CurrentConfiguration.numRunningServers_old_get_log(fallback_problem,
                                                               fallback_targetTypeArgsStr,
                                                               fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                                this,
                                                                                                this.numRunningServers);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            CurrentConfiguration.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            CurrentConfiguration.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public CurrentConfiguration fallback_clone() {
        if (isCloned())
            return old;
        CurrentConfiguration res =
          null;
        CurrentConfiguration.fallback_classClone();
        try {
            res =
              (CurrentConfiguration)
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
            res.numRunningServers =
              this.numRunningServers;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr numRunningServers_get_log(LogProblem fallback_problem,
                                                    LogExpr fallback_target,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs,
                                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "CurrentConfiguration",
                                   fallback_targetTypeArgsStr,
                                   "numRunningServers",
                                   isOld);
    }
    
    public static LogRelation numRunningServers_old_get_log(LogProblem fallback_problem,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "CurrentConfiguration",
                                      fallback_targetTypeArgsStr,
                                      "numRunningServers");
    }
    
    public int fallback_updateField_numRunningServers(Integer newVal) {
        return this.numRunningServers =
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
    
    public static PBJInternSet<Integer> setMap_numRunningServers(PBJInternSet<CurrentConfiguration> objs,
                                                                 java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<CurrentConfiguration> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().numRunningServers);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(CurrentConfiguration.class,
                                     true);
               LogMap.newInstVarRel("numRunningServers",
                                    CurrentConfiguration.class,
                                    "CurrentConfiguration",
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
    
    static LogExpr valid_log(LogProblem fallback_problem,
                             LogExpr fallback_target,
                             String fallback_targetTypeArgsStr,
                             String[] fallback_targetTypeArgs,
                             boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return CurrentConfiguration.valid_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld);
    }
}
