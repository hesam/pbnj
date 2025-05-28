package at.ac.testing.brooklyn.policy.mocks;

import at.ac.testing.mocks.*;
import polyglot.ext.pbnj.tologic.LogMap;

public class ThesholdBasedPolicy implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int lowerBound;
    
    int upperBound;
    
    int value;
    
    boolean valid() {
        return true &&
                 this.lowerBound >=
                   0 &&
          this.upperBound >=
            this.lowerBound;
    }
    
    public ThesholdBasedPolicy(int lowerBound,
                               int upperBound) {
        super();
        this.lowerBound =
          lowerBound;
        this.upperBound =
          upperBound;
        this.addInstance();
    }
    
    public String toString() {
        return "Policy: \n" +
               "Lower Bound " +
               this.lowerBound +
               "\n" +
               "Upper Bound " +
               this.upperBound +
        "\n";
    }
    
    public SensorReading resize_orig() {
        return null;
    }
    
    public boolean scalesDown(SensorReading sensorReading) {
        return true &&
          sensorReading.value <
            this.lowerBound;
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          8;
        ThesholdBasedPolicy t =
          new ThesholdBasedPolicy(10,
                                  11);
        System.out.println(t.resize());
    }
    
    public ThesholdBasedPolicy old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public ThesholdBasedPolicy(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(ThesholdBasedPolicy.class,
                           this);
    }
    
    public void addInstanceForProblem(ThesholdBasedPolicy toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             ThesholdBasedPolicy.class,
                                             "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public ThesholdBasedPolicy old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public ThesholdBasedPolicy fallback_setTypeArgs(String[] args) {
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
        return ThesholdBasedPolicy.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return ThesholdBasedPolicy.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return ThesholdBasedPolicy.classClonerStep ==
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
    
    public boolean resize_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.resize_checkFieldsInvariants() &&
                 (this.fallback_field_result ==
                    null ||
                    ((SensorReading)
                       this.fallback_field_result).fallback_checkInvariants()) &&
          ((SensorReading)
             this.fallback_field_result !=
             null &&
             scalesDown((SensorReading)
                          this.fallback_field_result));
    }
    
    public void resize_assertContract() {
        assert resize_checkContract();
    }
    
    public void resize_commitModel(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem resize_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": resize" +
                                         ") initiated plan b...")))));
        SensorReading.fallback_initClassDefs();
        SensorReading.fallback_initClassDefs();
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("at.ac.testing.mocks.SensorReading",
                                           1);
        fallback_problem.setFreshInstances("at.ac.testing.mocks.SensorReading",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        SensorReading.fallback_classClone();
        SensorReading.fallback_classClone();
        SensorReading.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        SensorReading.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        SensorReading.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        SensorReading.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          ThesholdBasedPolicy.resize_checkContract_log(fallback_problem,
                                                       fallback_target,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs,
                                                       fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("resize",
                                 this,
                                 fallback_formula.formula(),
                                 null,
                                 true,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public SensorReading resize() {
        return resize_ensured();
    }
    
    public SensorReading resize_ensured() {
        SensorReading fallback_result;
        initEnsuredMethod();
        try {
            fallback_result =
              resize_orig();
            this.fallback_field_result =
              fallback_result;
            resize_assertContract();
            return fallback_result;
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  resize_planb();
                resize_commitModel(fallback_problem);
                return (SensorReading)
                         this.fallback_field_result;
            }
        }
    }
    
    public boolean resize_checkFieldsInvariants() {
        return true;
    }
    
    SensorReading fallback_field_result_resize;
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            ThesholdBasedPolicy.fallback_classAtomize(fallback_problem,
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
            ThesholdBasedPolicy.fallback_classRelationizeOld(fallback_problem,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs);
            ThesholdBasedPolicy.lowerBound_old_get_log(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                        this,
                                                                                        this.lowerBound);
            ThesholdBasedPolicy.upperBound_old_get_log(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                        this,
                                                                                        this.upperBound);
            ThesholdBasedPolicy.value_old_get_log(fallback_problem,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                                   this,
                                                                                   this.value);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            ThesholdBasedPolicy.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            ThesholdBasedPolicy.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public ThesholdBasedPolicy fallback_clone() {
        if (isCloned())
            return old;
        ThesholdBasedPolicy res =
          null;
        ThesholdBasedPolicy.fallback_classClone();
        try {
            res =
              (ThesholdBasedPolicy)
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
            res.lowerBound =
              this.lowerBound;
            res.upperBound =
              this.upperBound;
            res.value =
              this.value;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr lowerBound_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "lowerBound",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation lowerBound_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                               String fallback_targetTypeArgsStr,
                                                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "lowerBound");
    }
    
    public int fallback_updateField_lowerBound(Integer newVal) {
        return this.lowerBound =
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr upperBound_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "upperBound",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation upperBound_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                               String fallback_targetTypeArgsStr,
                                                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "upperBound");
    }
    
    public int fallback_updateField_upperBound(Integer newVal) {
        return this.upperBound =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr value_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                   fallback_targetTypeArgsStr,
                                   "value",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation value_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                      fallback_targetTypeArgsStr,
                                      "value");
    }
    
    public int fallback_updateField_value(Integer newVal) {
        return this.value =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_field_result_resize_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                         polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                         String fallback_targetTypeArgsStr,
                                                                                         String[] fallback_targetTypeArgs,
                                                                                         boolean isOld) {
        return LogMap.resultGet_log(fallback_problem,
                                    fallback_target,
                                    "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                    fallback_targetTypeArgsStr,
                                    "fallback_field_result_resize");
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_lowerBound(polyglot.ext.pbnj.primitives.PBJInternSet<ThesholdBasedPolicy> objs,
                                                                                       java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<ThesholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().lowerBound);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_upperBound(polyglot.ext.pbnj.primitives.PBJInternSet<ThesholdBasedPolicy> objs,
                                                                                       java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<ThesholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().upperBound);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_value(polyglot.ext.pbnj.primitives.PBJInternSet<ThesholdBasedPolicy> objs,
                                                                                  java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<ThesholdBasedPolicy> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().value);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(ThesholdBasedPolicy.class,
                                     true);
               LogMap.newInstVarRel("lowerBound",
                                    ThesholdBasedPolicy.class,
                                    "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
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
               LogMap.newInstVarRel("upperBound",
                                    ThesholdBasedPolicy.class,
                                    "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
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
               LogMap.newInstVarRel("value",
                                    ThesholdBasedPolicy.class,
                                    "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
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
               LogMap.newInstVarRel("fallback_field_result_resize",
                                    ThesholdBasedPolicy.class,
                                    "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                    SensorReading.class,
                                    "at.ac.testing.mocks.SensorReading",
                                    null,
                                    null,
                                    false,
                                    false,
                                    0,
                                    true,
                                    true,
                                    true,
                                    false,
                                    false);
           }
    
    static polyglot.ext.pbnj.tologic.LogExpr valid_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(ThesholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                         fallback_target,
                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                         fallback_targetTypeArgs,
                                                                                                                         fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)))).and(ThesholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                           fallback_target_isOld).gte(ThesholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr scalesDown_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean fallback_target_isOld,
                                                                   polyglot.ext.pbnj.tologic.LogExpr sensorReading,
                                                                   boolean sensorReading_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(SensorReading.value_get_log(fallback_problem,
                                                                                                              sensorReading,
                                                                                                              "",
                                                                                                              null,
                                                                                                              sensorReading_isOld).lt(ThesholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                             fallback_target,
                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                             fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return ThesholdBasedPolicy.valid_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr resize_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                             polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                             String fallback_targetTypeArgsStr,
                                                                             String[] fallback_targetTypeArgs,
                                                                             boolean fallback_target_isOld) {
        return ThesholdBasedPolicy.fallback_checkInvariants_log(fallback_problem,
                                                                fallback_target,
                                                                fallback_targetTypeArgsStr,
                                                                fallback_targetTypeArgs,
                                                                fallback_target_isOld).and(ThesholdBasedPolicy.resize_checkFieldsInvariants_log(fallback_problem,
                                                                                                                                                fallback_target,
                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                fallback_target_isOld)).and(ThesholdBasedPolicy.fallback_field_result_resize_get_log(fallback_problem,
                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                     fallback_target_isOld).eq(fallback_problem.null_log()).or(SensorReading.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                          ThesholdBasedPolicy.fallback_field_result_resize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                          "",
                                                                                                                                                                                                                                                                                                                                          null,
                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld))).and(ThesholdBasedPolicy.fallback_field_result_resize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld).eq(fallback_problem.null_log()).not().and(ThesholdBasedPolicy.scalesDown_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ThesholdBasedPolicy.fallback_field_result_resize_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr resize_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                     polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                     String fallback_targetTypeArgsStr,
                                                                                     String[] fallback_targetTypeArgs,
                                                                                     boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE);
    }
}
