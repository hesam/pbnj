import polyglot.ext.pbnj.tologic.*;

public class Test2 implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int x;
    
    public String toString() {
        return "x=" +
        x;
    }
    
    public void m1_orig() {
        
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          6;
        Test2 t1 =
          new Test2();
        System.out.println(t1);
        t1.m1();
        System.out.println(t1);
    }
    
    public Test2 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test2() {
        super();
        this.addInstance();
    }
    
    public Test2(LogExpr dontcare) {
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
        LogMap.addInstance(Test2.class,
                           this);
    }
    
    public void addInstanceForProblem(Test2 toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test2.class,
                                             "Test2",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test2 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test2 fallback_setTypeArgs(String[] args) {
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
        return Test2.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Test2.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test2.classClonerStep ==
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
    
    public boolean m1_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.m1_checkFieldsInvariants() &&
          this.x ==
            this.old.x +
              1;
    }
    
    public void m1_assertContract() {
        assert m1_checkContract();
    }
    
    public void m1_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem m1_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m1" +
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
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          Test2.m1_checkContract_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m1",
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
    
    public void m1() {
        m1_ensured();
    }
    
    public void m1_ensured() {
        initEnsuredMethod();
        try {
            m1_orig();
            m1_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  m1_planb();
                m1_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean m1_checkFieldsInvariants() {
        return true &&
          (this.old ==
             null ||
             this.old.fallback_checkInvariants());
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test2.fallback_classAtomize(fallback_problem,
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
            Test2.fallback_classRelationizeOld(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs);
            Test2.x_old_get_log(fallback_problem,
                                fallback_targetTypeArgsStr,
                                fallback_targetTypeArgs).put_log(fallback_problem,
                                                                 this,
                                                                 this.x);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test2.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test2.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test2 fallback_clone() {
        if (isCloned())
            return old;
        Test2 res =
          null;
        Test2.fallback_classClone();
        try {
            res =
              (Test2)
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
            res.x =
              this.x;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr x_get_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "Test2",
                                   fallback_targetTypeArgsStr,
                                   "x",
                                   isOld);
    }
    
    public static LogRelation x_old_get_log(LogProblem fallback_problem,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test2",
                                      fallback_targetTypeArgsStr,
                                      "x");
    }
    
    public int fallback_updateField_x(Integer newVal) {
        return this.x =
          newVal;
    }
    
    public polyglot.ext.pbnj.primitives.PBJInternSet<Integer> fieldsClosure_Integer(Object fallback_target,
                                                                                    boolean isReflexive,
                                                                                    java.lang.String ... fieldNs) {
        Class c =
          int.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
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
    
    polyglot.ext.pbnj.primitives.PBJInternSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
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
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_x(polyglot.ext.pbnj.primitives.PBJInternSet<Test2> objs,
                                                                              java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<Test2> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().x);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test2.class,
                                     true);
               LogMap.newInstVarRel("x",
                                    Test2.class,
                                    "Test2",
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
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
    
    public static LogExpr m1_checkContract_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean fallback_target_isOld) {
        return Test2.fallback_checkInvariants_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).and(Test2.m1_checkFieldsInvariants_log(fallback_problem,
                                                                                                                fallback_target,
                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                fallback_targetTypeArgs,
                                                                                                                fallback_target_isOld)).and(Test2.x_get_log(fallback_problem,
                                                                                                                                                            fallback_target,
                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                            fallback_target_isOld).eq(Test2.x_get_log(fallback_problem,
                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                      true).plus(new LogExpr(fallback_problem,
                                                                                                                                                                                                                             kodkod.ast.IntConstant.constant(1)))));
    }
    
    public static LogExpr m1_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(fallback_target.eq(fallback_problem.null_log()).or(Test2.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                              fallback_target,
                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                              true)));
    }
}
