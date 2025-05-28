import polyglot.ext.pbnj.tologic.*;
import java.util.Arrays;

public class Test33 implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int x;
    
    public Test33() {
        super();
        this.x =
          0;
        this.addInstance();
    }
    
    public String toString() {
        return " x=" +
        x;
    }
    
    public void m32_orig() {
        
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          5;
        Test33 t1 =
          new Test33();
        int r =
          3;
        while (r-- >=
                 0) {
            System.out.println(t1);
            t1.m32();
            System.out.println(t1);
            t1.x =
              0;
        }
    }
    
    public Test33 old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public Test33(LogExpr dontcare) {
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
        LogMap.addInstance(Test33.class,
                           this);
    }
    
    public void addInstanceForProblem(Test33 toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             Test33.class,
                                             "Test33",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public Test33 old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public Test33 fallback_setTypeArgs(String[] args) {
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
        return Test33.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return Test33.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return Test33.classClonerStep ==
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
    
    public boolean m32_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.m32_checkFieldsInvariants() &&
          (this.x >
             0 &&
             this.x <=
               3);
    }
    
    public void m32_assertContract() {
        assert m32_checkContract();
    }
    
    public void m32_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem m32_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": m32" +
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
          Test33.m32_checkContract_log(fallback_problem,
                                       fallback_target,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs,
                                       fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("m32",
                                 this,
                                 fallback_formula.formula(),
                                 null,
                                 false,
                                 true,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public void m32() {
        m32_ensured();
    }
    
    public void m32_ensured() {
        initEnsuredMethod();
        try {
            m32_orig();
            m32_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  m32_planb();
                m32_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean m32_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            Test33.fallback_classAtomize(fallback_problem,
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
            Test33.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            Test33.x_old_get_log(fallback_problem,
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
            Test33.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            Test33.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public Test33 fallback_clone() {
        if (isCloned())
            return old;
        Test33 res =
          null;
        Test33.fallback_classClone();
        try {
            res =
              (Test33)
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
                                   "Test33",
                                   fallback_targetTypeArgsStr,
                                   "x",
                                   isOld);
    }
    
    public static LogRelation x_old_get_log(LogProblem fallback_problem,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "Test33",
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
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_x(polyglot.ext.pbnj.primitives.PBJInternSet<Test33> objs,
                                                                              java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<Test33> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().x);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(Test33.class,
                                     true);
               LogMap.newInstVarRel("x",
                                    Test33.class,
                                    "Test33",
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
    
    public static LogExpr m32_checkContract_log(LogProblem fallback_problem,
                                                LogExpr fallback_target,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs,
                                                boolean fallback_target_isOld) {
        return Test33.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(Test33.m32_checkFieldsInvariants_log(fallback_problem,
                                                                                                                   fallback_target,
                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                   fallback_targetTypeArgs,
                                                                                                                   fallback_target_isOld)).and(Test33.x_get_log(fallback_problem,
                                                                                                                                                                fallback_target,
                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                fallback_target_isOld).gt(new LogExpr(fallback_problem,
                                                                                                                                                                                                      kodkod.ast.IntConstant.constant(0))).and(Test33.x_get_log(fallback_problem,
                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                fallback_target_isOld).lte(new LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(3)))));
    }
    
    public static LogExpr m32_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                        LogExpr fallback_target,
                                                        String fallback_targetTypeArgsStr,
                                                        String[] fallback_targetTypeArgs,
                                                        boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
