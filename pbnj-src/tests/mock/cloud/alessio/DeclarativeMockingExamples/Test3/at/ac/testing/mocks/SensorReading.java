package at.ac.testing.mocks;

public class SensorReading implements polyglot.ext.pbnj.primitives.PBJInternObject {
    public int value;
    
    public boolean valid() {
        return value >=
                 0 &&
          value <
            10;
    }
    
    public String toString() {
        return "Sensor Value: " +
        value;
    }
    
    public static void main(String[] args) {
        System.out.println(" Sample " +
                           new SensorReading());
    }
    
    public SensorReading old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public SensorReading() {
        super();
        this.addInstance();
    }
    
    public SensorReading(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(SensorReading.class,
                                                     this);
    }
    
    public void addInstanceForProblem(SensorReading toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             SensorReading.class,
                                             "at.ac.testing.mocks.SensorReading",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public SensorReading old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public SensorReading fallback_setTypeArgs(String[] args) {
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
        return SensorReading.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return SensorReading.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return SensorReading.classClonerStep ==
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
            SensorReading.fallback_classAtomize(fallback_problem,
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
            SensorReading.fallback_classRelationizeOld(fallback_problem,
                                                       fallback_targetTypeArgsStr,
                                                       fallback_targetTypeArgs);
            SensorReading.value_old_get_log(fallback_problem,
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
            SensorReading.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            SensorReading.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public SensorReading fallback_clone() {
        if (isCloned())
            return old;
        SensorReading res =
          null;
        SensorReading.fallback_classClone();
        try {
            res =
              (SensorReading)
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
            res.value =
              this.value;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr value_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                  String fallback_targetTypeArgsStr,
                                                                  String[] fallback_targetTypeArgs,
                                                                  boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.mocks.SensorReading",
                                                             fallback_targetTypeArgsStr,
                                                             "value",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation value_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                          String fallback_targetTypeArgsStr,
                                                                          String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "at.ac.testing.mocks.SensorReading",
                                                                fallback_targetTypeArgsStr,
                                                                "value");
    }
    
    public int fallback_updateField_value(Integer newVal) {
        return this.value =
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
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_value(polyglot.ext.pbnj.primitives.PBJInternSet<SensorReading> objs,
                                                                                  java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<SensorReading> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().value);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(SensorReading.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("value",
                                                              SensorReading.class,
                                                              "at.ac.testing.mocks.SensorReading",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr valid_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return SensorReading.value_get_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                            kodkod.ast.IntConstant.constant(0))).and(SensorReading.value_get_log(fallback_problem,
                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                 fallback_target_isOld).lt(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(10))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return SensorReading.valid_log(fallback_problem,
                                       fallback_target,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs,
                                       fallback_target_isOld);
    }
}
