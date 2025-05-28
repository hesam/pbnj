package pbnj.examples.primitives;

import polyglot.ext.pbnj.primitives.PBJInternSet;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class PBJSet<E>  implements polyglot.ext.pbnj.primitives.PBJInternObject {
    static final Random rand =
      new Random();
    
    static final int MAX_LENGTH =
      10;
    
    E[] values;
    
    int size;
    
    public int size() {
        return size;
    }
    
    public E get_spec(int i) {
        return values[i];
    }
    
    public PBJSet() {
        super();
        this.values =
          (E[])
            (new Object[MAX_LENGTH]);
        this.size =
          0;
    }
    
    public boolean valid() {
        return this.values !=
                 null &&
                 this.size >=
                   0 &&
          this.size <=
            this.values.length;
    }
    
    public PBJInternSet<E> values_spec() {
        return values_spec_setComprehension_1();
    }
    
    public boolean contains(E val) {
        return contains_existQuantify_2(val);
    }
    
    public boolean contains_spec(Object val) {
        return contains_spec_existQuantify_3(val);
    }
    
    private boolean unchanged() {
        return unchanged_univQuantify_4();
    }
    
    private boolean unchangedExcept(E val) {
        return !contains(val) &&
          unchangedExcept_univQuantify_5(val);
    }
    
    public boolean add_spec(E val) {
        return unchanged() &&
                 (!old.contains_spec(val) ||
                    size ==
                      old.size) &&
          (!(!old.contains_spec(val)) ||
             size ==
               1 +
                 old.size &&
               contains(val));
    }
    
    public void add(E val) {
        System.out.println("adding " +
                           val);
        if (!contains(val))
            insert(val);
    }
    
    public boolean removeSpec(E val) {
        return (!(!old.contains_spec(val)) ||
                  size ==
                    old.size &&
                    unchanged()) &&
          (!old.contains_spec(val) ||
             size ==
               old.size -
                 1 &&
               unchangedExcept(val));
    }
    
    public void remove(E val) {
        System.out.println("removing " +
                           val);
        if (contains(val))
            delete(val);
    }
    
    public void insert(E val) {
        values[size++] =
          val;
    }
    
    public void delete(E val) {
        int idx =
          0;
        while (values[idx] !=
                 val)
            idx++;
        for (;
             idx <
               size -
                 1;
             idx++)
            values[idx] =
              values[idx +
                       1];
        size--;
    }
    
    public Set<E> getValues() {
        Set<E> res =
          new HashSet<E>();
        for (int i =
               0;
             i <
               size;
             i++)
            res.add(values[i]);
        return res;
    }
    
    public String toString() {
        String res =
          "{ ";
        for (int i =
               0;
             i <
               size;
             i++)
            res +=
              values[i] +
              " ";
        res +=
          "}";
        return res;
    }
    
    public static void main(String[] args) {
        int SIZE =
          2;
        final PBJSet<Integer> c =
          new PBJSet<Integer>();
        System.out.println(c);
        for (int i =
               0;
             i <
               SIZE;
             i++) {
            int v =
              rand.nextInt(10);
            c.add(i);
            System.out.println(c);
        }
        c.remove(c.values[0]);
        System.out.println(c);
    }
    
    public PBJSet<E> old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public PBJSet(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PBJSet.class,
                                                     this);
    }
    
    public void addInstanceForProblem(PBJSet toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             PBJSet.class,
                                             "pbnj.examples.primitives.PBJSet",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public PBJSet<E> old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public PBJSet<E> fallback_setTypeArgs(String[] args) {
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
        return PBJSet.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return PBJSet.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return PBJSet.classClonerStep ==
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
            PBJSet.fallback_classAtomize(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.values !=
                  null)
                for (int i0_values =
                       0;
                     i0_values <
                       this.values.length;
                     i0_values++)
                    if (this.values[i0_values] !=
                          null &&
                          this.values[i0_values] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.values[i0_values]).fallback_atomize(fallback_problem,
                                                                    "",
                                                                    null);
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            PBJSet.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.values !=
                  null)
                for (int i0_values =
                       0;
                     i0_values <
                       this.values.length;
                     i0_values++)
                    if (this.values[i0_values] !=
                          null &&
                          this.values[i0_values] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.values[i0_values]).fallback_relationizeOld(fallback_problem,
                                                                           "",
                                                                           null);
            PBJSet.values_old_get_log(fallback_problem,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                             this,
                                                                             this.values);
            PBJSet.size_old_get_log(fallback_problem,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs).put_log(fallback_problem,
                                                                     this,
                                                                     this.size);
        }
    }
    
    public static void fallback_classAtomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            PBJSet.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            PBJSet.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public PBJSet<E> fallback_clone() {
        if (isCloned())
            return old;
        PBJSet<E> res =
          null;
        PBJSet.fallback_classClone();
        try {
            res =
              (PBJSet<E>)
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
            if (this.values !=
                  null) {
                res.values =
                  (E[])
                    this.values.clone();
                for (int i0_values =
                       0;
                     i0_values <
                       this.values.length;
                     i0_values++)
                    if (this.values[i0_values] !=
                          null &&
                          this.values[i0_values] instanceof polyglot.ext.pbnj.primitives.PBJInternObject) {
                        res.values[i0_values] =
                          (E)
                            ((polyglot.ext.pbnj.primitives.PBJInternObject)
                               this.values[i0_values]).fallback_clone();
                    }
            }
            res.size =
              this.size;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr values_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.examples.primitives.PBJSet",
                                                             fallback_targetTypeArgsStr,
                                                             "values",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation values_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                           String fallback_targetTypeArgsStr,
                                                                           String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.examples.primitives.PBJSet",
                                                                fallback_targetTypeArgsStr,
                                                                "values");
    }
    
    public E fallback_updateArrayField_values(int index,
                                              E newVal) {
        this.values[index] =
          newVal;
        return newVal;
    }
    
    public E[] fallback_updateField_values(java.util.ArrayList<E> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.values ==
              null ||
              this.values.length !=
                s)
            this.values =
              (E[])
                (new Object[s]);
        while (i <
                 s) {
            this.values[i] =
              newVal.get(i);
            i++;
        }
        return this.values;
    }
    
    public E[] fallback_updateField_values(E[] newVal) {
        return this.values =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.examples.primitives.PBJSet",
                                                             fallback_targetTypeArgsStr,
                                                             "size",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation size_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.examples.primitives.PBJSet",
                                                                fallback_targetTypeArgsStr,
                                                                "size");
    }
    
    public int fallback_updateField_size(Integer newVal) {
        return this.size =
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
    
    public PBJInternSet<E> values_spec_setComprehension_1() {
        PBJInternSet<E> res =
          new PBJInternSet<E>();
        for (E i : (java.util.ArrayList<E>)
                     polyglot.ext.pbnj.tologic.LogMap.allInstances(polyglot.ext.pbnj.tologic.LogMap.getGenericParamActualArg(PBJSet.class,
                                                                                                                             "E",
                                                                                                                             fallback_typeArgs))) {
            if (values_spec_existQuantify_0(i))
                res.add(i);
        }
        return res;
    }
    
    public boolean values_spec_existQuantify_0(E i) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (values[j] ==
                  i)
                return true;
        }
        return false;
    }
    
    public boolean contains_existQuantify_2(E val) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (values[i] ==
                  val)
                return true;
        }
        return false;
    }
    
    public boolean contains_spec_existQuantify_3(Object val) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (values[i] ==
                  val)
                return true;
        }
        return false;
    }
    
    private boolean unchanged_univQuantify_4() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         old.size -
                                                                           1)) {
            if (!contains_spec(old.values[i]))
                return false;
        }
        return true;
    }
    
    private boolean unchangedExcept_univQuantify_5(E val) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         old.size -
                                                                           1)) {
            if (!(!(old.values[i] !=
                      val) ||
                    contains_spec(old.values[i])))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<PBJSet> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<PBJSet> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(PBJSet.class,
                                                               true,
                                                               "E");
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("values",
                                                                     PBJSet.class,
                                                                     "pbnj.examples.primitives.PBJSet",
                                                                     Object.class,
                                                                     "E",
                                                                     null,
                                                                     null,
                                                                     true,
                                                                     false,
                                                                     1,
                                                                     true,
                                                                     false,
                                                                     false,
                                                                     false,
                                                                     false);
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("size",
                                                                     PBJSet.class,
                                                                     "pbnj.examples.primitives.PBJSet",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                             polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                             String fallback_targetTypeArgsStr,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld) {
        return PBJSet.size_get_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr get_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr i,
                                                                 boolean i_isOld) {
        return PBJSet.values_get_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld).get_log(fallback_problem,
                                                                    i,
                                                                    false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr valid_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return PBJSet.values_get_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld).no().not().and(PBJSet.size_get_log(fallback_problem,
                                                                                               fallback_target,
                                                                                               fallback_targetTypeArgsStr,
                                                                                               fallback_targetTypeArgs,
                                                                                               fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                kodkod.ast.IntConstant.constant(0)))).and(PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                              fallback_target_isOld).lte(PBJSet.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                               fallback_target_isOld).length_get_log(fallback_problem)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr values_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("i"));
        boolean j_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_j =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("j"));
        polyglot.ext.pbnj.tologic.LogExpr j =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                quantVar_j.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_j =
          quantVar_j;
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(fallback_problem.allInstances_log(fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(PBJSet.class,
                                                                                                                                                                                    "E")],
                                                                                                      false),
                                                                    i,
                                                                    polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                 polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                         fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                         "",
                                                                                                                                                                                                         null,
                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                         new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                         PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                             fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                         fallback_target_isOld),
                                                                                                                                                 "<java.lang.Integer>",
                                                                                                                                                 new String[] { "java.lang.Integer" },
                                                                                                                                                 fallback_target_isOld),
                                                                                                                 false,
                                                                                                                 "some",
                                                                                                                 fallback_var_j,
                                                                                                                 PBJSet.values_get_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                      j,
                                                                                                                                                                      false).eq(i)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr contains_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr val,
                                                                 boolean val_isOld) {
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                            polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                    fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                    "",
                                                                                                                                                    null,
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                        fallback_target,
                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                        fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                    fallback_target_isOld),
                                                                                            "<java.lang.Integer>",
                                                                                            new String[] { "java.lang.Integer" },
                                                                                            fallback_target_isOld),
                                                            false,
                                                            "some",
                                                            fallback_var_i,
                                                            PBJSet.values_get_log(fallback_problem,
                                                                                  fallback_target,
                                                                                  fallback_targetTypeArgsStr,
                                                                                  fallback_targetTypeArgs,
                                                                                  fallback_target_isOld).get_log(fallback_problem,
                                                                                                                 i,
                                                                                                                 false).eq(val));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr contains_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld,
                                                                      polyglot.ext.pbnj.tologic.LogExpr val,
                                                                      boolean val_isOld) {
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                            polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                    fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                    "",
                                                                                                                                                    null,
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                        fallback_target,
                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                        fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                    fallback_target_isOld),
                                                                                            "<java.lang.Integer>",
                                                                                            new String[] { "java.lang.Integer" },
                                                                                            fallback_target_isOld),
                                                            false,
                                                            "some",
                                                            fallback_var_i,
                                                            PBJSet.values_get_log(fallback_problem,
                                                                                  fallback_target,
                                                                                  fallback_targetTypeArgsStr,
                                                                                  fallback_targetTypeArgs,
                                                                                  fallback_target_isOld).get_log(fallback_problem,
                                                                                                                 i,
                                                                                                                 false).eq(val));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr unchanged_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean fallback_target_isOld) {
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                            polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                    fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                    "",
                                                                                                                                                    null,
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                        fallback_target,
                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                        true).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                          kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                    fallback_target_isOld),
                                                                                            "<java.lang.Integer>",
                                                                                            new String[] { "java.lang.Integer" },
                                                                                            fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            PBJSet.contains_spec_log(fallback_problem,
                                                                                     fallback_target,
                                                                                     fallback_targetTypeArgsStr,
                                                                                     fallback_targetTypeArgs,
                                                                                     fallback_target_isOld,
                                                                                     PBJSet.values_get_log(fallback_problem,
                                                                                                           fallback_target,
                                                                                                           fallback_targetTypeArgsStr,
                                                                                                           fallback_targetTypeArgs,
                                                                                                           true).get_log(fallback_problem,
                                                                                                                         i,
                                                                                                                         false),
                                                                                     fallback_target_isOld));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr unchangedExcept_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs,
                                                                         boolean fallback_target_isOld,
                                                                         polyglot.ext.pbnj.tologic.LogExpr val,
                                                                         boolean val_isOld) {
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
        return PBJSet.contains_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld,
                                   val,
                                   val_isOld).not().and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                     polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                             fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                             "",
                                                                                                                                                                                             null,
                                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                                             new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                                             PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                 true).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                             fallback_target_isOld),
                                                                                                                                     "<java.lang.Integer>",
                                                                                                                                     new String[] { "java.lang.Integer" },
                                                                                                                                     fallback_target_isOld),
                                                                                                     false,
                                                                                                     "all",
                                                                                                     fallback_var_i,
                                                                                                     PBJSet.values_get_log(fallback_problem,
                                                                                                                           fallback_target,
                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                           fallback_targetTypeArgs,
                                                                                                                           true).get_log(fallback_problem,
                                                                                                                                         i,
                                                                                                                                         false).eq(val).not().implies(PBJSet.contains_spec_log(fallback_problem,
                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                               PBJSet.values_get_log(fallback_problem,
                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                     true).get_log(fallback_problem,
                                                                                                                                                                                                                                   i,
                                                                                                                                                                                                                                   false),
                                                                                                                                                                                               fallback_target_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr add_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr val,
                                                                 boolean val_isOld) {
        return PBJSet.unchanged_log(fallback_problem,
                                    fallback_target,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs,
                                    fallback_target_isOld).and(PBJSet.contains_spec_log(fallback_problem,
                                                                                        fallback_target,
                                                                                        fallback_targetTypeArgsStr,
                                                                                        fallback_targetTypeArgs,
                                                                                        true,
                                                                                        val,
                                                                                        val_isOld).implies(PBJSet.size_get_log(fallback_problem,
                                                                                                                               fallback_target,
                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                               fallback_targetTypeArgs,
                                                                                                                               fallback_target_isOld).eq(PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                             fallback_target,
                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                             true)))).and(PBJSet.contains_spec_log(fallback_problem,
                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                   true,
                                                                                                                                                                                                                   val,
                                                                                                                                                                                                                   val_isOld).not().implies(PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                fallback_target_isOld).eq(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1)).plus(PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                             true))).and(PBJSet.contains_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                             val,
                                                                                                                                                                                                                                                                                                                                                                                                                             val_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr removeSpec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean fallback_target_isOld,
                                                                   polyglot.ext.pbnj.tologic.LogExpr val,
                                                                   boolean val_isOld) {
        return PBJSet.contains_spec_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        true,
                                        val,
                                        val_isOld).not().implies(PBJSet.size_get_log(fallback_problem,
                                                                                     fallback_target,
                                                                                     fallback_targetTypeArgsStr,
                                                                                     fallback_targetTypeArgs,
                                                                                     fallback_target_isOld).eq(PBJSet.size_get_log(fallback_problem,
                                                                                                                                   fallback_target,
                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                   true)).and(PBJSet.unchanged_log(fallback_problem,
                                                                                                                                                                   fallback_target,
                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                   fallback_target_isOld))).and(PBJSet.contains_spec_log(fallback_problem,
                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                         true,
                                                                                                                                                                                                                         val,
                                                                                                                                                                                                                         val_isOld).implies(PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                fallback_target_isOld).eq(PBJSet.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                              true).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1)))).and(PBJSet.unchangedExcept_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                                     val,
                                                                                                                                                                                                                                                                                                                                                                                                                                     val_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return PBJSet.valid_log(fallback_problem,
                                fallback_target,
                                fallback_targetTypeArgsStr,
                                fallback_targetTypeArgs,
                                fallback_target_isOld);
    }
}
