package pbnj.examples.primitives;

import java.util.HashMap;

public final class PBJString implements java.io.Serializable, polyglot.ext.pbnj.primitives.PBJInternObject {
    private final String value;
    
    private int length;
    
    public String value() {
        return value;
    }
    
    public int length() {
        return this.length;
    }
    
    private static HashMap<Integer, PBJString> instances =
      new HashMap<Integer, PBJString>();
    
    public static PBJString get(String original) {
        int h =
          original.hashCode();
        if (instances.containsKey(h))
            return instances.get(h);
        return new PBJString(original);
    }
    
    public PBJString() {
        super();
        this.value =
          null;
        this.addInstance();
    }
    
    public static PBJString[] getAll(String[] originals) {
        int s =
          originals.length;
        PBJString[] res =
          new PBJString[s];
        for (int i =
               0;
             i <
               s;
             i++)
            res[i] =
              PBJString.get(originals[i]);
        return res;
    }
    
    public PBJString(String original) {
        super();
        this.value =
          original;
        this.length =
          original.length();
        int h =
          original.hashCode();
        if (!instances.containsKey(h))
            instances.put(h,
                          this);
        this.addInstance();
    }
    
    public int hashCode() {
        return value.hashCode();
    }
    
    public String toString() {
        return value.toString();
    }
    
    public PBJString old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public PBJString(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
        super();
        this.value =
          null;
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PBJString.class,
                                                     this);
    }
    
    public void addInstanceForProblem(PBJString toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             PBJString.class,
                                             "pbnj.examples.primitives.PBJString",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public PBJString old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public PBJString fallback_setTypeArgs(String[] args) {
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
        return PBJString.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return PBJString.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return PBJString.classClonerStep ==
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
            PBJString.fallback_classAtomize(fallback_problem,
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
            PBJString.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
            PBJString.length_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.length);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            PBJString.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            PBJString.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public PBJString fallback_clone() {
        if (isCloned())
            return old;
        PBJString res =
          null;
        PBJString.fallback_classClone();
        try {
            res =
              this;
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
            res.length =
              this.length;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr length_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.examples.primitives.PBJString",
                                                             fallback_targetTypeArgsStr,
                                                             "length",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation length_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                           String fallback_targetTypeArgsStr,
                                                                           String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.examples.primitives.PBJString",
                                                                fallback_targetTypeArgsStr,
                                                                "length");
    }
    
    public int fallback_updateField_length(Integer newVal) {
        return this.length =
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
    
    public static polyglot.ext.pbnj.primitives.PBJInternSet<Integer> setMap_length(polyglot.ext.pbnj.primitives.PBJInternSet<PBJString> objs,
                                                                                   java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJInternSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJInternSet<Integer>();
        java.util.Iterator<PBJString> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().length);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(PBJString.class,
                                                               true);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel("length",
                                                              PBJString.class,
                                                              "pbnj.examples.primitives.PBJString",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr length_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                               polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs,
                                                               boolean fallback_target_isOld) {
        return PBJString.length_get_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        fallback_target_isOld);
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
