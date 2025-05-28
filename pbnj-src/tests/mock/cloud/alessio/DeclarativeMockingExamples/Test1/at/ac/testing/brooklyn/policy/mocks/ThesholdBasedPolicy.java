package at.ac.testing.brooklyn.policy.mocks;

import at.ac.testing.mocks.RequestsCount;

public class ThesholdBasedPolicy implements polyglot.ext.pbnj.primitives.PBJInternObject {
    int lowerBound;
    
    int upperBound;
    
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
        return "" +
               "Lower Bound " +
               this.lowerBound +
               "\n" +
               "Upper Bound " +
               this.upperBound +
        "\n";
    }
    
    public boolean validRequestsCountForTargetConfiguration(RequestsCount requestsCount,
                                                            int currentSize,
                                                            int targetSize) {
        return true &&
                 requestsCount.requests >=
                   targetSize *
                     lowerBound &&
          requestsCount.requests <=
            targetSize *
              upperBound;
    }
    
    public boolean scalesUp(RequestsCount requestsCount,
                            int currentSize,
                            int targetSize) {
        return true &&
                 requestsCount.requests >
                   currentSize *
                     upperBound &&
          requestsCount.requests >
            (targetSize -
               1) *
              upperBound;
    }
    
    public boolean scalesDown(RequestsCount requestsCount,
                              int currentSize,
                              int targetSize) {
        return true &&
                 requestsCount.requests <
                   currentSize *
                     lowerBound &&
          requestsCount.requests <
            (targetSize +
               1) *
              lowerBound;
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(ThesholdBasedPolicy.class,
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
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            res.lowerBound =
              this.lowerBound;
            res.upperBound =
              this.upperBound;
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
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                                             fallback_targetTypeArgsStr,
                                                             "lowerBound",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation lowerBound_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                               String fallback_targetTypeArgsStr,
                                                                               String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
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
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                                             fallback_targetTypeArgsStr,
                                                             "upperBound",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation upperBound_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                               String fallback_targetTypeArgsStr,
                                                                               String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "at.ac.testing.brooklyn.policy.mocks.ThesholdBasedPolicy",
                                                                fallback_targetTypeArgsStr,
                                                                "upperBound");
    }
    
    public int fallback_updateField_upperBound(Integer newVal) {
        return this.upperBound =
          newVal;
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
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(ThesholdBasedPolicy.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("lowerBound",
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
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("upperBound",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr validRequestsCountForTargetConfiguration_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                                 String fallback_targetTypeArgsStr,
                                                                                                 String[] fallback_targetTypeArgs,
                                                                                                 boolean fallback_target_isOld,
                                                                                                 polyglot.ext.pbnj.tologic.LogExpr requestsCount,
                                                                                                 boolean requestsCount_isOld,
                                                                                                 polyglot.ext.pbnj.tologic.LogExpr currentSize,
                                                                                                 boolean currentSize_isOld,
                                                                                                 polyglot.ext.pbnj.tologic.LogExpr targetSize,
                                                                                                 boolean targetSize_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(RequestsCount.requests_get_log(fallback_problem,
                                                                                                                 requestsCount,
                                                                                                                 "",
                                                                                                                 null,
                                                                                                                 requestsCount_isOld).gte(targetSize.multiply(ThesholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                     fallback_target_isOld)))).and(RequestsCount.requests_get_log(fallback_problem,
                                                                                                                                                                                                                                                                  requestsCount,
                                                                                                                                                                                                                                                                  "",
                                                                                                                                                                                                                                                                  null,
                                                                                                                                                                                                                                                                  requestsCount_isOld).lte(targetSize.multiply(ThesholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr scalesUp_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr requestsCount,
                                                                 boolean requestsCount_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr currentSize,
                                                                 boolean currentSize_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr targetSize,
                                                                 boolean targetSize_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(RequestsCount.requests_get_log(fallback_problem,
                                                                                                                 requestsCount,
                                                                                                                 "",
                                                                                                                 null,
                                                                                                                 requestsCount_isOld).gt(currentSize.multiply(ThesholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                     fallback_target_isOld)))).and(RequestsCount.requests_get_log(fallback_problem,
                                                                                                                                                                                                                                                                  requestsCount,
                                                                                                                                                                                                                                                                  "",
                                                                                                                                                                                                                                                                  null,
                                                                                                                                                                                                                                                                  requestsCount_isOld).gt(targetSize.minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))).multiply(ThesholdBasedPolicy.upperBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr scalesDown_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean fallback_target_isOld,
                                                                   polyglot.ext.pbnj.tologic.LogExpr requestsCount,
                                                                   boolean requestsCount_isOld,
                                                                   polyglot.ext.pbnj.tologic.LogExpr currentSize,
                                                                   boolean currentSize_isOld,
                                                                   polyglot.ext.pbnj.tologic.LogExpr targetSize,
                                                                   boolean targetSize_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(RequestsCount.requests_get_log(fallback_problem,
                                                                                                                 requestsCount,
                                                                                                                 "",
                                                                                                                 null,
                                                                                                                 requestsCount_isOld).lt(currentSize.multiply(ThesholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                     fallback_target_isOld)))).and(RequestsCount.requests_get_log(fallback_problem,
                                                                                                                                                                                                                                                                  requestsCount,
                                                                                                                                                                                                                                                                  "",
                                                                                                                                                                                                                                                                  null,
                                                                                                                                                                                                                                                                  requestsCount_isOld).lt(targetSize.plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))).multiply(ThesholdBasedPolicy.lowerBound_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld))));
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
}
