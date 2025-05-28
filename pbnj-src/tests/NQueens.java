import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.*;

public class NQueens implements PBJInternObject {
    int n;
    
    boolean[][] cells;
    
    public NQueens(int n) {
        super();
        this.n =
          n;
        this.cells =
          (new boolean[n][n]);
        this.addInstance();
    }
    
    public String toString() {
        String res =
          "";
        for (int c =
               0;
             c <
               n;
             c++) {
            for (int r =
                   0;
                 r <
                   n;
                 r++)
                res +=
                  (cells[c][r] ? "Q" : "-") +
                  " ";
            res +=
              "\n";
        }
        return res;
    }
    
    int abs(int i) {
        return i >
                 0 ? i : -1 *
                           i;
    }
    
    boolean invariants() {
        return cells !=
                 null &&
                 cells.length ==
                   n &&
          invariants_univQuantify_0();
    }
    
    PBJInternSet<Integer> queenCount() {
        return queenCount_setComprehension_2();
    }
    
    boolean noAttacksOn(int c1,
                        int r1) {
        return noAttacksOn_univQuantify_4(c1,
                                          r1);
    }
    
    boolean noAttacks() {
        return noAttacks_univQuantify_6();
    }
    
    public void nqueens_orig() {
        
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_IntBitWidth =
          5;
        NQueens t =
          new NQueens(8);
        System.out.println(t);
        t.nqueens();
        System.out.println(t);
    }
    
    public NQueens old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public NQueens(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return invariants();
    }
    
    public void addInstance() {
        LogMap.addInstance(NQueens.class,
                           this);
    }
    
    public void addInstanceForProblem(NQueens toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             NQueens.class,
                                             "NQueens",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public NQueens old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public NQueens fallback_setTypeArgs(String[] args) {
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
        return NQueens.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return NQueens.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return NQueens.classClonerStep ==
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
    
    public boolean nqueens_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.nqueens_checkFieldsInvariants() &&
          (queenCount().size() ==
             this.n &&
             noAttacks());
    }
    
    public void nqueens_assertContract() {
        assert nqueens_checkContract();
    }
    
    public void nqueens_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem nqueens_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": nqueens" +
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
        fallback_problem.setModifiableField("NQueens.cells");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          NQueens.nqueens_checkContract_log(fallback_problem,
                                            fallback_target,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs,
                                            fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("nqueens",
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
    
    public void nqueens() {
        nqueens_ensured();
    }
    
    public void nqueens_ensured() {
        initEnsuredMethod();
        try {
            nqueens_orig();
            nqueens_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  nqueens_planb();
                nqueens_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean nqueens_checkFieldsInvariants() {
        return true;
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            NQueens.fallback_classAtomize(fallback_problem,
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
            NQueens.fallback_classRelationizeOld(fallback_problem,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs);
            NQueens.n_old_get_log(fallback_problem,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs).put_log(fallback_problem,
                                                                   this,
                                                                   this.n);
            NQueens.cells_old_get_log(fallback_problem,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs).boolean2_array_put_log(fallback_problem,
                                                                                      this,
                                                                                      this.cells);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            NQueens.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            NQueens.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public NQueens fallback_clone() {
        if (isCloned())
            return old;
        NQueens res =
          null;
        NQueens.fallback_classClone();
        try {
            res =
              (NQueens)
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
            res.n =
              this.n;
            if (this.cells !=
                  null) {
                res.cells =
                  (boolean[][])
                    this.cells.clone();
            }
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr n_get_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "NQueens",
                                   fallback_targetTypeArgsStr,
                                   "n",
                                   isOld);
    }
    
    public static LogRelation n_old_get_log(LogProblem fallback_problem,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "NQueens",
                                      fallback_targetTypeArgsStr,
                                      "n");
    }
    
    public int fallback_updateField_n(Integer newVal) {
        return this.n =
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
    
    public static LogExpr cells_get_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "NQueens",
                                   fallback_targetTypeArgsStr,
                                   "cells",
                                   isOld);
    }
    
    public static LogRelation cells_old_get_log(LogProblem fallback_problem,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "NQueens",
                                      fallback_targetTypeArgsStr,
                                      "cells");
    }
    
    public boolean[] fallback_updateArrayField_cells(int index,
                                                     boolean[] newVal) {
        this.cells[index] =
          newVal;
        return newVal;
    }
    
    public boolean[][] fallback_updateField_cells(java.util.ArrayList<java.util.ArrayList<Boolean>> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.cells ==
              null ||
              this.cells.length !=
                s)
            this.cells =
              (new boolean[s][]);
        while (i <
                 s) {
            java.util.ArrayList<Boolean> fallback_l =
              newVal.get(i);
            int fallback_ls =
              fallback_l.size();
            this.cells[i] =
              (new boolean[fallback_ls]);
            for (int j_fallback =
                   0;
                 j_fallback <
                   fallback_ls;
                 j_fallback++)
                this.cells[i][j_fallback] =
                  fallback_l.get(j_fallback);
            i++;
        }
        return this.cells;
    }
    
    public boolean[][] fallback_updateField_cells(boolean[][] newVal) {
        return this.cells =
          newVal;
    }
    
    boolean invariants_univQuantify_0() {
        for (int c : PBJInternInteger.range(0,
                                            n -
                                              1)) {
            if (!(cells[c] !=
                    null &&
                    cells[c].length ==
                      n))
                return false;
        }
        return true;
    }
    
    PBJInternSet<Integer> queenCount_setComprehension_2() {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int column : PBJInternInteger.range(0,
                                                 n -
                                                   1)) {
            if (queenCount_existQuantify_1(column))
                res.add(column);
        }
        return res;
    }
    
    boolean queenCount_existQuantify_1(int column) {
        for (int row : PBJInternInteger.range(0,
                                              n -
                                                1)) {
            if (cells[column][row])
                return true;
        }
        return false;
    }
    
    boolean noAttacksOn_univQuantify_4(int c1,
                                       int r1) {
        for (int c2 : PBJInternInteger.range(0,
                                             n -
                                               1)) {
            if (!noAttacksOn_univQuantify_3(c1,
                                            r1,
                                            c2))
                return false;
        }
        return true;
    }
    
    boolean noAttacksOn_univQuantify_3(int c1,
                                       int r1,
                                       int c2) {
        for (int r2 : PBJInternInteger.range(0,
                                             n -
                                               1)) {
            if (!(!(!(c1 ==
                        c2 &&
                        r1 ==
                          r2)) ||
                    (!(c1 ==
                         c2 ||
                         r1 ==
                           r2 ||
                         abs(c1 -
                               c2) ==
                           abs(r1 -
                                 r2)) ||
                       !(cells[c1][r1] &&
                           cells[c2][r2]))))
                return false;
        }
        return true;
    }
    
    boolean noAttacks_univQuantify_6() {
        for (int c1 : PBJInternInteger.range(0,
                                             n -
                                               1)) {
            if (!noAttacks_univQuantify_5(c1))
                return false;
        }
        return true;
    }
    
    boolean noAttacks_univQuantify_5(int c1) {
        for (int r1 : PBJInternInteger.range(0,
                                             n -
                                               1)) {
            if (!noAttacksOn(c1,
                             r1))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_n(PBJInternSet<NQueens> objs,
                                                 java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<NQueens> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().n);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(NQueens.class,
                                     true);
               LogMap.newInstVarRel("n",
                                    NQueens.class,
                                    "NQueens",
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
               LogMap.newInstVarRel("cells",
                                    NQueens.class,
                                    "NQueens",
                                    Boolean.class,
                                    "boolean",
                                    null,
                                    null,
                                    false,
                                    false,
                                    2,
                                    true,
                                    false,
                                    false,
                                    false,
                                    false);
           }
    
    static LogExpr abs_log(LogProblem fallback_problem,
                           LogExpr fallback_target,
                           String fallback_targetTypeArgsStr,
                           String[] fallback_targetTypeArgs,
                           boolean fallback_target_isOld,
                           LogExpr i,
                           boolean i_isOld) {
        return i.gt(new LogExpr(fallback_problem,
                                kodkod.ast.IntConstant.constant(0))).thenElse(i,
                                                                              new LogExpr(fallback_problem,
                                                                                          kodkod.ast.IntConstant.constant(1)).negate().multiply(i));
    }
    
    static LogExpr invariants_log(LogProblem fallback_problem,
                                  LogExpr fallback_target,
                                  String fallback_targetTypeArgsStr,
                                  String[] fallback_targetTypeArgs,
                                  boolean fallback_target_isOld) {
        boolean c_isOld =
          false;
        LogExpr quantVar_c =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("c"));
        LogExpr c =
          new LogExpr(fallback_problem,
                      quantVar_c.expr());
        LogExpr fallback_var_c =
          quantVar_c;
        return NQueens.cells_get_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld).no().not().and(NQueens.cells_get_log(fallback_problem,
                                                                                                 fallback_target,
                                                                                                 fallback_targetTypeArgsStr,
                                                                                                 fallback_targetTypeArgs,
                                                                                                 fallback_target_isOld).length_get_log(fallback_problem).eq(NQueens.n_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                                                         NQueens.n_get_log(fallback_problem,
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
                                                                                                                                                                                                                              fallback_var_c,
                                                                                                                                                                                                                              NQueens.cells_get_log(fallback_problem,
                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                    fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                   c,
                                                                                                                                                                                                                                                                                   false).no().not().and(NQueens.cells_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                               fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                              c,
                                                                                                                                                                                                                                                                                                                                                              false).length_get_log(fallback_problem).eq(NQueens.n_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld)))));
    }
    
    static LogExpr queenCount_log(LogProblem fallback_problem,
                                  LogExpr fallback_target,
                                  String fallback_targetTypeArgsStr,
                                  String[] fallback_targetTypeArgs,
                                  boolean fallback_target_isOld) {
        boolean column_isOld =
          false;
        LogExpr quantVar_column =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("column"));
        LogExpr column =
          new LogExpr(fallback_problem,
                      quantVar_column.expr());
        LogExpr fallback_var_column =
          quantVar_column;
        boolean row_isOld =
          false;
        LogExpr quantVar_row =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("row"));
        LogExpr row =
          new LogExpr(fallback_problem,
                      quantVar_row.expr());
        LogExpr fallback_var_row =
          quantVar_row;
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          PBJInternInteger.range_log(fallback_problem,
                                                                                                     fallback_problem.class_log(PBJInternInteger.class),
                                                                                                     "",
                                                                                                     null,
                                                                                                     fallback_target_isOld,
                                                                                                     new LogExpr(fallback_problem,
                                                                                                                 kodkod.ast.IntConstant.constant(0)),
                                                                                                     fallback_target_isOld,
                                                                                                     NQueens.n_get_log(fallback_problem,
                                                                                                                       fallback_target,
                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                       fallback_targetTypeArgs,
                                                                                                                       fallback_target_isOld).minus(new LogExpr(fallback_problem,
                                                                                                                                                                kodkod.ast.IntConstant.constant(1))),
                                                                                                     fallback_target_isOld),
                                                                          "<java.lang.Integer>",
                                                                          new String[] { "java.lang.Integer" },
                                                                          fallback_target_isOld),
                                          fallback_var_column,
                                          LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                             PBJInternInteger.range_log(fallback_problem,
                                                                                                                        fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                        "",
                                                                                                                        null,
                                                                                                                        fallback_target_isOld,
                                                                                                                        new LogExpr(fallback_problem,
                                                                                                                                    kodkod.ast.IntConstant.constant(0)),
                                                                                                                        fallback_target_isOld,
                                                                                                                        NQueens.n_get_log(fallback_problem,
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
                                                             "some",
                                                             fallback_var_row,
                                                             NQueens.cells_get_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld).get_log(fallback_problem,
                                                                                                                  column,
                                                                                                                  false).get_log(fallback_problem,
                                                                                                                                 row,
                                                                                                                                 false)));
    }
    
    static LogExpr noAttacksOn_log(LogProblem fallback_problem,
                                   LogExpr fallback_target,
                                   String fallback_targetTypeArgsStr,
                                   String[] fallback_targetTypeArgs,
                                   boolean fallback_target_isOld,
                                   LogExpr c1,
                                   boolean c1_isOld,
                                   LogExpr r1,
                                   boolean r1_isOld) {
        boolean c2_isOld =
          false;
        LogExpr quantVar_c2 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("c2"));
        LogExpr c2 =
          new LogExpr(fallback_problem,
                      quantVar_c2.expr());
        LogExpr fallback_var_c2 =
          quantVar_c2;
        boolean r2_isOld =
          false;
        LogExpr quantVar_r2 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("r2"));
        LogExpr r2 =
          new LogExpr(fallback_problem,
                      quantVar_r2.expr());
        LogExpr fallback_var_r2 =
          quantVar_r2;
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  PBJInternInteger.range_log(fallback_problem,
                                                                                             fallback_problem.class_log(PBJInternInteger.class),
                                                                                             "",
                                                                                             null,
                                                                                             fallback_target_isOld,
                                                                                             new LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0)),
                                                                                             fallback_target_isOld,
                                                                                             NQueens.n_get_log(fallback_problem,
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
                                  fallback_var_c2,
                                  LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                     PBJInternInteger.range_log(fallback_problem,
                                                                                                                fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                "",
                                                                                                                null,
                                                                                                                fallback_target_isOld,
                                                                                                                new LogExpr(fallback_problem,
                                                                                                                            kodkod.ast.IntConstant.constant(0)),
                                                                                                                fallback_target_isOld,
                                                                                                                NQueens.n_get_log(fallback_problem,
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
                                                     fallback_var_r2,
                                                     c1.eq(c2).and(r1.eq(r2)).not().implies(c1.eq(c2).or(r1.eq(r2)).or(NQueens.abs_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld,
                                                                                                                                       c1.minus(c2),
                                                                                                                                       fallback_target_isOld).eq(NQueens.abs_log(fallback_problem,
                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                 r1.minus(r2),
                                                                                                                                                                                 fallback_target_isOld))).implies(NQueens.cells_get_log(fallback_problem,
                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                        fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                       c1,
                                                                                                                                                                                                                                                                       false).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                      r1,
                                                                                                                                                                                                                                                                                      false).and(NQueens.cells_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                       fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                      c2,
                                                                                                                                                                                                                                                                                                                                                      false).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                     r2,
                                                                                                                                                                                                                                                                                                                                                                     false)).not()))));
    }
    
    static LogExpr noAttacks_log(LogProblem fallback_problem,
                                 LogExpr fallback_target,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs,
                                 boolean fallback_target_isOld) {
        boolean c1_isOld =
          false;
        LogExpr quantVar_c1 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("c1"));
        LogExpr c1 =
          new LogExpr(fallback_problem,
                      quantVar_c1.expr());
        LogExpr fallback_var_c1 =
          quantVar_c1;
        boolean r1_isOld =
          false;
        LogExpr quantVar_r1 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("r1"));
        LogExpr r1 =
          new LogExpr(fallback_problem,
                      quantVar_r1.expr());
        LogExpr fallback_var_r1 =
          quantVar_r1;
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  PBJInternInteger.range_log(fallback_problem,
                                                                                             fallback_problem.class_log(PBJInternInteger.class),
                                                                                             "",
                                                                                             null,
                                                                                             fallback_target_isOld,
                                                                                             new LogExpr(fallback_problem,
                                                                                                         kodkod.ast.IntConstant.constant(0)),
                                                                                             fallback_target_isOld,
                                                                                             NQueens.n_get_log(fallback_problem,
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
                                  fallback_var_c1,
                                  LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                     PBJInternInteger.range_log(fallback_problem,
                                                                                                                fallback_problem.class_log(PBJInternInteger.class),
                                                                                                                "",
                                                                                                                null,
                                                                                                                fallback_target_isOld,
                                                                                                                new LogExpr(fallback_problem,
                                                                                                                            kodkod.ast.IntConstant.constant(0)),
                                                                                                                fallback_target_isOld,
                                                                                                                NQueens.n_get_log(fallback_problem,
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
                                                     fallback_var_r1,
                                                     NQueens.noAttacksOn_log(fallback_problem,
                                                                             fallback_target,
                                                                             fallback_targetTypeArgsStr,
                                                                             fallback_targetTypeArgs,
                                                                             fallback_target_isOld,
                                                                             c1,
                                                                             c1_isOld,
                                                                             r1,
                                                                             r1_isOld)));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return NQueens.invariants_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld);
    }
    
    public static LogExpr nqueens_checkContract_log(LogProblem fallback_problem,
                                                    LogExpr fallback_target,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs,
                                                    boolean fallback_target_isOld) {
        return NQueens.fallback_checkInvariants_log(fallback_problem,
                                                    fallback_target,
                                                    fallback_targetTypeArgsStr,
                                                    fallback_targetTypeArgs,
                                                    fallback_target_isOld).and(NQueens.nqueens_checkFieldsInvariants_log(fallback_problem,
                                                                                                                         fallback_target,
                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                         fallback_targetTypeArgs,
                                                                                                                         fallback_target_isOld)).and(NQueens.queenCount_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            fallback_target_isOld).size_log(fallback_problem).eq(NQueens.n_get_log(fallback_problem,
                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                   fallback_target_isOld)).and(NQueens.noAttacks_log(fallback_problem,
                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                     fallback_target_isOld)));
    }
    
    public static LogExpr nqueens_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                            LogExpr fallback_target,
                                                            String fallback_targetTypeArgsStr,
                                                            String[] fallback_targetTypeArgs,
                                                            boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}
