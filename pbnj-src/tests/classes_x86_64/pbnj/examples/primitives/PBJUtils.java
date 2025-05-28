package pbnj.examples.primitives;

import polyglot.ext.pbnj.primitives.PBJInternSet;
import polyglot.ext.pbnj.tologic.LogMap;

public class PBJUtils<E>  implements polyglot.ext.pbnj.primitives.PBJInternObject {
    public static int Max(int a,
                          int b) {
        return a >=
                 b ? a : b;
    }
    
    public static int Min(int a,
                          int b) {
        return a <=
                 b ? a : b;
    }
    
    public static int Abs(int a) {
        return a >=
                 0 ? a : -a;
    }
    
    public int indexOf(E[] array,
                       E o) {
        return indexOf_setComprehension_0(array,
                                          o).get();
    }
    
    public PBJUtils<E> old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public PBJUtils() {
        super();
    }
    
    public PBJUtils(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(PBJUtils.class,
                           this);
    }
    
    public void addInstanceForProblem(PBJUtils toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             PBJUtils.class,
                                             "pbnj.examples.primitives.PBJUtils",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public PBJUtils<E> old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public PBJUtils<E> fallback_setTypeArgs(String[] args) {
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
        return PBJUtils.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return PBJUtils.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return PBJUtils.classClonerStep ==
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
            PBJUtils.fallback_classAtomize(fallback_problem,
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
            PBJUtils.fallback_classRelationizeOld(fallback_problem,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            PBJUtils.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            PBJUtils.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public PBJUtils<E> fallback_clone() {
        if (isCloned())
            return old;
        PBJUtils<E> res =
          null;
        PBJUtils.fallback_classClone();
        try {
            res =
              (PBJUtils<E>)
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
    
    public PBJInternSet<Integer> indexOf_setComprehension_0(E[] array,
                                                            E o) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         array.length -
                                                                           1)) {
            if (array[i] ==
                  o)
                res.add(i);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(PBJUtils.class,
                                     true,
                                     "E");
           }
    
    public static polyglot.ext.pbnj.tologic.LogExpr Max_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr a,
                                                            boolean a_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr b,
                                                            boolean b_isOld) {
        return a.gte(b).thenElse(a,
                                 b);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr Min_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr a,
                                                            boolean a_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr b,
                                                            boolean b_isOld) {
        return a.lte(b).thenElse(a,
                                 b);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr Abs_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld,
                                                            polyglot.ext.pbnj.tologic.LogExpr a,
                                                            boolean a_isOld) {
        return a.gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                           kodkod.ast.IntConstant.constant(0))).thenElse(a,
                                                                                                         a.negate());
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr indexOf_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs,
                                                                boolean fallback_target_isOld,
                                                                polyglot.ext.pbnj.tologic.LogExpr array,
                                                                boolean array_isOld,
                                                                polyglot.ext.pbnj.tologic.LogExpr o,
                                                                boolean o_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                    polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                            fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                            "",
                                                                                                                                                            null,
                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                            new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                            fallback_target_isOld,
                                                                                                                                                            array.length_get_log(fallback_problem).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                            fallback_target_isOld),
                                                                                                    "<java.lang.Integer>",
                                                                                                    new String[] { "java.lang.Integer" },
                                                                                                    fallback_target_isOld),
                                                                    fallback_var_i,
                                                                    array.get_log(fallback_problem,
                                                                                  i,
                                                                                  false).eq(o)).get_log(fallback_problem);
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
