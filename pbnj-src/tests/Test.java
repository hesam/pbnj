import polyglot.ext.pbnj.primitives.*;

public class Test implements PBJInternObject {
    int multiplier;
    
    public void resize1(int currentSize,
                        int targetSize) {
        System.out.println(" validMultipliers " +
                           validMultipliers(currentSize,
                                            targetSize));
        updateMultiplierH(currentSize,
                          targetSize);
    }
    
    public void resize2(int currentSize,
                        int targetSize) {
        System.out.println(" validMultipliers " +
                           validMultipliers(currentSize,
                                            targetSize));
        this.multiplier =
          getBiggestValidMultiplier(currentSize,
                                    targetSize);
    }
    
    PBJInternSet<Integer> validMultipliers(int currentSize,
                                           int targetSize) {
        return validMultipliers_setComprehension_0(currentSize,
                                                   targetSize);
    }
    
    int getBiggestValidMultiplier(int currentSize,
                                  int targetSize) {
        PBJInternSet<Integer> valids =
          validMultipliers(currentSize,
                           targetSize);
        return getBiggestValidMultiplier_setComprehension_2(currentSize,
                                                            targetSize,
                                                            valids).get();
    }
    
    void updateMultiplierH_int_int_orig(int currentSize,
                                        int targetSize) {
        
    }
    
    public String toString() {
        return "multiplier: " +
        this.multiplier;
    }
    
    public static void main(String[] args) {
        Test t =
          new Test();
        System.out.println(t);
        t.resize1(7,
                  8);
        System.out.println(t);
    }
    
    public Test old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test() {
        super();
        this.addInstance();
    }
    
    public Test(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(Test.class,
                                                     this);
    }
    
    public void addInstanceForProblem(Test toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
          polyglot.ext.pbnj.tologic.LogMap.clonerStep();
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
        return Test.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return Test.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test.classClonerStep ==
          polyglot.ext.pbnj.tologic.LogMap.clonerStep();
    }
    
    void initEnsuredMethod() {
        this.startMethodTime =
          System.currentTimeMillis();
        polyglot.ext.pbnj.tologic.LogMap.incrClonerStep();
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
    
    public boolean updateMultiplierH_int_int_checkContract(int currentSize,
                                                           int targetSize) {
        return this.fallback_checkInvariants() &&
                 this.updateMultiplierH_int_int_checkFieldsInvariants() &&
          getBiggestValidMultiplier(currentSize,
                                    targetSize) ==
            this.multiplier;
    }
    
    public void updateMultiplierH_int_int_assertContract(int currentSize,
                                                         int targetSize) {
        assert updateMultiplierH_int_int_checkContract(currentSize,
                                                       targetSize);
    }
    
    public void updateMultiplierH_int_int_commitModel(int currentSize,
                                                      int targetSize,
                                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem updateMultiplierH_int_int_planb(int currentSize,
                                                                         int targetSize) {
        boolean currentSize_isOld =
          false;
        boolean targetSize_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": updateMultiplierH" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          polyglot.ext.pbnj.tologic.LogMap.initRelationize();
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
        fallback_problem.setModifiableField("Test.multiplier");
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          Test.updateMultiplierH_int_int_checkContract_log(fallback_problem,
                                                           fallback_target,
                                                           fallback_targetTypeArgsStr,
                                                           fallback_targetTypeArgs,
                                                           fallback_target_isOld,
                                                           fallback_problem.intToSingletonRelation_log(currentSize),
                                                           currentSize_isOld,
                                                           fallback_problem.intToSingletonRelation_log(targetSize),
                                                           targetSize_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("updateMultiplierH_int_int",
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
    
    void updateMultiplierH(int currentSize,
                           int targetSize) {
        updateMultiplierH_int_int_ensured(currentSize,
                                          targetSize);
    }
    
    void updateMultiplierH_int_int_ensured(int currentSize,
                                           int targetSize) {
        initEnsuredMethod();
        try {
            updateMultiplierH_int_int_orig(currentSize,
                                           targetSize);
            updateMultiplierH_int_int_assertContract(currentSize,
                                                     targetSize);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  updateMultiplierH_int_int_planb(currentSize,
                                                  targetSize);
                updateMultiplierH_int_int_commitModel(currentSize,
                                                      targetSize,
                                                      fallback_problem);
            }
        }
    }
    
    public boolean updateMultiplierH_int_int_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            Test.fallback_classRelationizeOld(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs);
            Test.multiplier_old_get_log(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                         this,
                                                                         this.multiplier);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            Test.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            res.multiplier =
              this.multiplier;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr multiplier_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "Test",
                                                             fallback_targetTypeArgsStr,
                                                             "multiplier",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation multiplier_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                               String fallback_targetTypeArgsStr,
                                                                               String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "Test",
                                                                fallback_targetTypeArgsStr,
                                                                "multiplier");
    }
    
    public int fallback_updateField_multiplier(Integer newVal) {
        return this.multiplier =
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
    
    PBJInternSet<Integer> validMultipliers_setComprehension_0(int currentSize,
                                                              int targetSize) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int value : PBJInternInteger.range(0,
                                                100)) {
            if (value <
                  20)
                res.add(value);
        }
        return res;
    }
    
    PBJInternSet<Integer> getBiggestValidMultiplier_setComprehension_2(int currentSize,
                                                                       int targetSize,
                                                                       PBJInternSet<Integer> valids) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int m : valids) {
            if (getBiggestValidMultiplier_univQuantify_1(currentSize,
                                                         targetSize,
                                                         m,
                                                         valids))
                res.add(m);
        }
        return res;
    }
    
    boolean getBiggestValidMultiplier_univQuantify_1(int currentSize,
                                                     int targetSize,
                                                     int m,
                                                     PBJInternSet<Integer> valids) {
        for (int mm : valids) {
            if (!(!(m !=
                      mm &&
                      mm >
                        m)))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_multiplier(PBJInternSet<Test> objs,
                                                          java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<Test> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().multiplier);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(Test.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("multiplier",
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
           }
    
    static polyglot.ext.pbnj.tologic.LogExpr validMultipliers_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean fallback_target_isOld,
                                                                  polyglot.ext.pbnj.tologic.LogExpr currentSize,
                                                                  boolean currentSize_isOld,
                                                                  polyglot.ext.pbnj.tologic.LogExpr targetSize,
                                                                  boolean targetSize_isOld) {
        boolean value_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_value =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("value"));
        polyglot.ext.pbnj.tologic.LogExpr value =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_value.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_value =
          quantVar_value;
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                    PBJInternInteger.range_log(fallback_problem,
                                                                                                                               fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                               "",
                                                                                                                               null,
                                                                                                                               fallback_target_isOld,
                                                                                                                               new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                     kodkod.ast.IntConstant.constant(0)),
                                                                                                                               fallback_target_isOld,
                                                                                                                               new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                     kodkod.ast.IntConstant.constant(100)),
                                                                                                                               fallback_target_isOld),
                                                                                                    "<java.lang.Integer>",
                                                                                                    new String[] { "java.lang.Integer" },
                                                                                                    fallback_target_isOld),
                                                                    fallback_var_value,
                                                                    value.lt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                   kodkod.ast.IntConstant.constant(20))));
    }
    
    static polyglot.ext.pbnj.tologic.LogExpr getBiggestValidMultiplier_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                           polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                           String fallback_targetTypeArgsStr,
                                                                           String[] fallback_targetTypeArgs,
                                                                           boolean fallback_target_isOld,
                                                                           polyglot.ext.pbnj.tologic.LogExpr currentSize,
                                                                           boolean currentSize_isOld,
                                                                           polyglot.ext.pbnj.tologic.LogExpr targetSize,
                                                                           boolean targetSize_isOld) {
        boolean m_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_m =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("m"));
        polyglot.ext.pbnj.tologic.LogExpr m =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_m.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_m =
          quantVar_m;
        boolean mm_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_mm =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("mm"));
        polyglot.ext.pbnj.tologic.LogExpr mm =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_mm.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_mm =
          quantVar_mm;
        polyglot.ext.pbnj.tologic.LogExpr valids =
          Test.validMultipliers_log(fallback_problem,
                                    fallback_target,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs,
                                    fallback_target_isOld,
                                    currentSize,
                                    currentSize_isOld,
                                    targetSize,
                                    targetSize_isOld);
        boolean valids_isOld =
          false;
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                    valids,
                                                                                                    "<java.lang.Integer>",
                                                                                                    new String[] { "java.lang.Integer" },
                                                                                                    fallback_target_isOld),
                                                                    fallback_var_m,
                                                                    polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                 valids,
                                                                                                                                                 "<java.lang.Integer>",
                                                                                                                                                 new String[] { "java.lang.Integer" },
                                                                                                                                                 fallback_target_isOld),
                                                                                                                 false,
                                                                                                                 "all",
                                                                                                                 fallback_var_mm,
                                                                                                                 m.eq(mm).not().and(mm.gt(m)).not())).get_log(fallback_problem);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr updateMultiplierH_int_int_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                                polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                                String fallback_targetTypeArgsStr,
                                                                                                String[] fallback_targetTypeArgs,
                                                                                                boolean fallback_target_isOld,
                                                                                                polyglot.ext.pbnj.tologic.LogExpr currentSize,
                                                                                                boolean currentSize_isOld,
                                                                                                polyglot.ext.pbnj.tologic.LogExpr targetSize,
                                                                                                boolean targetSize_isOld) {
        return Test.fallback_checkInvariants_log(fallback_problem,
                                                 fallback_target,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs,
                                                 fallback_target_isOld).and(Test.updateMultiplierH_int_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                     fallback_target,
                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                     fallback_target_isOld)).and(Test.getBiggestValidMultiplier_log(fallback_problem,
                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                    currentSize,
                                                                                                                                                                                                    currentSize_isOld,
                                                                                                                                                                                                    targetSize,
                                                                                                                                                                                                    targetSize_isOld).eq(Test.multiplier_get_log(fallback_problem,
                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                 fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr updateMultiplierH_int_int_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                                        String fallback_targetTypeArgsStr,
                                                                                                        String[] fallback_targetTypeArgs,
                                                                                                        boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
