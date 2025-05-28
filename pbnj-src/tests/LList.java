import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.*;
import java.util.Random;
import java.util.Iterator;

class LLNode implements PBJInternObject {
    public int value;
    
    public LLNode next;
    
    public LLNode(int value) {
        this(value,
             null);
    }
    
    public LLNode(int value,
                  LLNode next) {
        super();
        this.value =
          value;
        this.next =
          next;
        this.addInstance();
    }
    
    public PBJInternSet<LLNode> tail() {
        return this ==
                 null ? new PBJInternSet<LLNode>() : this.fieldsClosure_LLNode(this,
                                                                               false,
                                                                               "next");
    }
    
    public String toString() {
        return "N" +
        Integer.toString(value);
    }
    
    public LLNode old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public LLNode(LogExpr dontcare) {
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
        LogMap.addInstance(LLNode.class,
                           this);
    }
    
    public void addInstanceForProblem(LLNode toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             LLNode.class,
                                             "LLNode",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public LLNode old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public LLNode fallback_setTypeArgs(String[] args) {
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
        return LLNode.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return LLNode.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return LLNode.classClonerStep ==
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
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            LLNode.fallback_classAtomize(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.next !=
                  null)
                this.next.fallback_atomize(fallback_problem,
                                           "",
                                           null);
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            LLNode.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.next !=
                  null)
                this.next.fallback_relationizeOld(fallback_problem,
                                                  "",
                                                  null);
            LLNode.value_old_get_log(fallback_problem,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs).put_log(fallback_problem,
                                                                      this,
                                                                      this.value);
            LLNode.next_old_get_log(fallback_problem,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs).put_log(fallback_problem,
                                                                     this,
                                                                     this.next);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            LLNode.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            LLNode.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public LLNode fallback_clone() {
        if (isCloned())
            return old;
        LLNode res =
          null;
        LLNode.fallback_classClone();
        try {
            res =
              (LLNode)
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
            res.value =
              this.value;
            if (this.next !=
                  null)
                res.next =
                  this.next.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr value_get_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "LLNode",
                                   fallback_targetTypeArgsStr,
                                   "value",
                                   isOld);
    }
    
    public static LogRelation value_old_get_log(LogProblem fallback_problem,
                                                String fallback_targetTypeArgsStr,
                                                String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "LLNode",
                                      fallback_targetTypeArgsStr,
                                      "value");
    }
    
    public int fallback_updateField_value(Integer newVal) {
        return this.value =
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
    
    public static LogExpr next_get_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "LLNode",
                                   fallback_targetTypeArgsStr,
                                   "next",
                                   isOld);
    }
    
    public static LogRelation next_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "LLNode",
                                      fallback_targetTypeArgsStr,
                                      "next");
    }
    
    public LLNode fallback_updateField_next(LLNode newVal) {
        return this.next =
          newVal;
    }
    
    public PBJInternSet<LLNode> fieldsClosure_LLNode(Object fallback_target,
                                                     boolean isReflexive,
                                                     java.lang.String ... fieldNs) {
        Class c =
          LLNode.class;
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        java.util.ArrayList<LLNode> workList =
          new java.util.ArrayList<LLNode>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                LLNode childN =
                  (LLNode)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            LLNode n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    LLNode childN =
                      (LLNode)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((LLNode)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<LLNode> multiFields_LLNode(java.lang.String ... fieldNs) {
        Class c =
          LLNode.class;
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                LLNode n =
                  (LLNode)
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
    
    public static PBJInternSet<Integer> setMap_value(PBJInternSet<LLNode> objs,
                                                     java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        Iterator<LLNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().value);
        }
        return res;
    }
    
    public static PBJInternSet<LLNode> setMap_next(PBJInternSet<LLNode> objs,
                                                   java.lang.String ... fieldNs) {
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        Iterator<LLNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().next);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(LLNode.class,
                                     true);
               LogMap.newInstVarRel("value",
                                    LLNode.class,
                                    "LLNode",
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
               LogMap.newInstVarRel("next",
                                    LLNode.class,
                                    "LLNode",
                                    LLNode.class,
                                    "LLNode",
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
    
    public static LogExpr tail_log(LogProblem fallback_problem,
                                   LogExpr fallback_target,
                                   String fallback_targetTypeArgsStr,
                                   String[] fallback_targetTypeArgs,
                                   boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          fallback_target,
                                          "LLNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          false,
                                          "next");
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE);
    }
}

public class LList implements PBJInternObject {
    static final int SIZE =
      20;
    
    public LLNode head;
    
    public void head(LLNode h) {
        this.head =
          h;
    }
    
    public LList() {
        super();
        this.addInstance();
    }
    
    public PBJInternSet<LLNode> nodes() {
        return head ==
                 null ? new PBJInternSet<LLNode>() : head.fieldsClosure_LLNode(head,
                                                                               true,
                                                                               "next");
    }
    
    public PBJInternSet<Integer> nodeValues() {
        return this.nodes() ==
                 null ? new PBJInternSet<Integer>() : LLNode.setMap_value(this.nodes(),
                                                                          "value");
    }
    
    public PBJInternSet<LLNode> nodesWithValue(int i) {
        return nodesWithValue_setComprehension_0(i);
    }
    
    public boolean isAcyclic() {
        return isAcyclic_univQuantify_1();
    }
    
    public int occurrencesOf(int i) {
        return this.nodesWithValue(i).size();
    }
    
    public boolean isSorted() {
        return isSorted_univQuantify_2();
    }
    
    public boolean isPermutedSublistOf(LList lst) {
        return isPermutedSublistOf_univQuantify_3(lst);
    }
    
    public boolean isPermutationOf(LList lst) {
        return this.isPermutedSublistOf(lst) &&
          lst.isPermutedSublistOf(this);
    }
    
    public void bubbleSort_orig() {
        int z;
        if (nodes().size() ==
              SIZE) {
            head =
              null;
            head =
              head.next;
        }
        LLNode curr;
        LLNode tmp;
        LLNode prev =
          null;
        LLNode last =
          null;
        while (last !=
                 head) {
            curr =
              head;
            while (curr.next !=
                     last) {
                if (curr.value >
                      curr.next.value) {
                    if (curr ==
                          head)
                        head =
                          curr.next;
                    else
                        prev.next =
                          curr.next;
                    prev =
                      curr.next;
                    tmp =
                      curr.next.next;
                    curr.next.next =
                      curr;
                    curr.next =
                      tmp;
                } else {
                    prev =
                      curr;
                    curr =
                      curr.next;
                }
            }
            last =
              curr;
        }
        System.out.println(this);
    }
    
    public void add(int v) {
        LLNode res =
          new LLNode(v);
        add(res);
    }
    
    public void add(LLNode n) {
        if (head ==
              null) {
            head =
              n;
        } else {
            LLNode c =
              head;
            while (c.next !=
                     null)
                c =
                  c.next;
            c.next =
              n;
        }
    }
    
    public String toString() {
        String res =
          "[ ";
        LLNode n =
          head;
        while (n !=
                 null) {
            res +=
              n.value +
              " ";
            n =
              n.next;
        }
        res +=
          "]";
        return res;
    }
    
    public static void main(String[] args) {
        boolean useAltSolver =
          args.length >
          0;
        if (useAltSolver)
            LogMap.SolverOpt_SolverNum(Integer.parseInt(args[0]));
        LList tb =
          new LList();
        Random rand =
          new Random(1111L);
        int[] a =
          new int[SIZE];
        for (int i =
               0;
             i <
               SIZE;
             ++i)
            a[i] =
              i;
        for (int i =
               SIZE;
             i >
               0;
             --i) {
            int n =
              rand.nextInt(SIZE);
            int temp =
              a[n];
            a[n] =
              a[i -
                  1];
            tb.add(temp);
        }
        System.out.print("B=");
        System.out.println(tb);
        System.out.println("sorting B...");
        tb.bubbleSort();
        System.out.print("B=");
        System.out.println(tb);
    }
    
    public LList old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public LList(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return isAcyclic();
    }
    
    public void addInstance() {
        LogMap.addInstance(LList.class,
                           this);
    }
    
    public void addInstanceForProblem(LList toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             LList.class,
                                             "LList",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public LList old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public LList fallback_setTypeArgs(String[] args) {
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
        return LList.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return LList.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return LList.classClonerStep ==
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
    
    public boolean bubbleSort_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.bubbleSort_checkFieldsInvariants() &&
          (isPermutationOf(this.old) &&
             isSorted());
    }
    
    public void bubbleSort_assertContract() {
        assert bubbleSort_checkContract();
    }
    
    public void bubbleSort_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem bubbleSort_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": bubbleSort" +
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
        fallback_problem.setModifiableField("LList.head");
        fallback_problem.setModifiableField("LLNode.next");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          LList.bubbleSort_checkContract_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("bubbleSort",
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
    
    public void bubbleSort() {
        bubbleSort_ensured();
    }
    
    public void bubbleSort_ensured() {
        initEnsuredMethod();
        try {
            bubbleSort_orig();
            bubbleSort_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  bubbleSort_planb();
                bubbleSort_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean bubbleSort_checkFieldsInvariants() {
        return true &&
          (head ==
             null ||
             head.fallback_checkInvariants());
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            LList.fallback_classAtomize(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.head !=
                  null)
                this.head.fallback_atomize(fallback_problem,
                                           "",
                                           null);
        }
    }
    
    public void fallback_relationizeOld(LogProblem fallback_problem,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            LList.fallback_classRelationizeOld(fallback_problem,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs);
            if (this.head !=
                  null)
                this.head.fallback_relationizeOld(fallback_problem,
                                                  "",
                                                  null);
            LList.head_old_get_log(fallback_problem,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs).put_log(fallback_problem,
                                                                    this,
                                                                    this.head);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            LList.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            LList.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public LList fallback_clone() {
        if (isCloned())
            return old;
        LList res =
          null;
        LList.fallback_classClone();
        try {
            res =
              (LList)
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
            if (this.head !=
                  null)
                res.head =
                  this.head.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr head_get_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "LList",
                                   fallback_targetTypeArgsStr,
                                   "head",
                                   isOld);
    }
    
    public static LogRelation head_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "LList",
                                      fallback_targetTypeArgsStr,
                                      "head");
    }
    
    public LLNode fallback_updateField_head(LLNode newVal) {
        return this.head =
          newVal;
    }
    
    public PBJInternSet<LLNode> fieldsClosure_LLNode(Object fallback_target,
                                                     boolean isReflexive,
                                                     java.lang.String ... fieldNs) {
        Class c =
          LLNode.class;
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        java.util.ArrayList<LLNode> workList =
          new java.util.ArrayList<LLNode>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                LLNode childN =
                  (LLNode)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            LLNode n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    LLNode childN =
                      (LLNode)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((LLNode)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<LLNode> multiFields_LLNode(java.lang.String ... fieldNs) {
        Class c =
          LLNode.class;
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                LLNode n =
                  (LLNode)
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
    
    public PBJInternSet<LLNode> nodesWithValue_setComprehension_0(int i) {
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        for (LLNode n : nodes()) {
            if (n.value ==
                  i)
                res.add(n);
        }
        return res;
    }
    
    public boolean isAcyclic_univQuantify_1() {
        for (LLNode n : (java.util.ArrayList<LLNode>)
                          LogMap.allInstances("LLNode")) {
            if (!(!n.tail().contains(n)))
                return false;
        }
        return true;
    }
    
    public boolean isSorted_univQuantify_2() {
        for (LLNode n : nodes()) {
            if (!(n.next ==
                    null ||
                    n.value <=
                      n.next.value))
                return false;
        }
        return true;
    }
    
    public boolean isPermutedSublistOf_univQuantify_3(LList lst) {
        for (int i : nodeValues()) {
            if (!(occurrencesOf(i) <=
                    lst.occurrencesOf(i)))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<LLNode> setMap_head(PBJInternSet<LList> objs,
                                                   java.lang.String ... fieldNs) {
        PBJInternSet<LLNode> res =
          new PBJInternSet<LLNode>();
        Iterator<LList> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().head);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(LList.class,
                                     true);
               LogMap.newInstVarRel("head",
                                    LList.class,
                                    "LList",
                                    LLNode.class,
                                    "LLNode",
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
    
    public static LogExpr nodes_log(LogProblem fallback_problem,
                                    LogExpr fallback_target,
                                    String fallback_targetTypeArgsStr,
                                    String[] fallback_targetTypeArgs,
                                    boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          LList.head_get_log(fallback_problem,
                                                             fallback_target,
                                                             fallback_targetTypeArgsStr,
                                                             fallback_targetTypeArgs,
                                                             fallback_target_isOld),
                                          "LLNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "next");
    }
    
    public static LogExpr nodeValues_log(LogProblem fallback_problem,
                                         LogExpr fallback_target,
                                         String fallback_targetTypeArgsStr,
                                         String[] fallback_targetTypeArgs,
                                         boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          LList.nodes_log(fallback_problem,
                                                          fallback_target,
                                                          fallback_targetTypeArgsStr,
                                                          fallback_targetTypeArgs,
                                                          fallback_target_isOld),
                                          "LLNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          false,
                                          "value");
    }
    
    public static LogExpr nodesWithValue_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld,
                                             LogExpr i,
                                             boolean i_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          LList.nodes_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetTypeArgsStr,
                                                                                          fallback_targetTypeArgs,
                                                                                          fallback_target_isOld),
                                                                          "<LLNode>",
                                                                          new String[] { "LLNode" },
                                                                          fallback_target_isOld),
                                          n,
                                          LLNode.value_get_log(fallback_problem,
                                                               n,
                                                               "",
                                                               null,
                                                               n_isOld).eq(i));
    }
    
    public static LogExpr isAcyclic_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        return LogExpr.quantifyOp(fallback_problem.allInstances_log("LLNode",
                                                                    false),
                                  false,
                                  "all",
                                  n,
                                  LLNode.tail_log(fallback_problem,
                                                  n,
                                                  "",
                                                  null,
                                                  n_isOld).contains_log(fallback_problem,
                                                                        n,
                                                                        n_isOld).not());
    }
    
    public static LogExpr occurrencesOf_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean fallback_target_isOld,
                                            LogExpr i,
                                            boolean i_isOld) {
        return LList.nodesWithValue_log(fallback_problem,
                                        fallback_target,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs,
                                        fallback_target_isOld,
                                        i,
                                        i_isOld).size_log(fallback_problem);
    }
    
    public static LogExpr isSorted_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  LList.nodes_log(fallback_problem,
                                                                                  fallback_target,
                                                                                  fallback_targetTypeArgsStr,
                                                                                  fallback_targetTypeArgs,
                                                                                  fallback_target_isOld),
                                                                  "<LLNode>",
                                                                  new String[] { "LLNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  LLNode.next_get_log(fallback_problem,
                                                      n,
                                                      "",
                                                      null,
                                                      n_isOld).eq(fallback_problem.null_log()).or(LLNode.value_get_log(fallback_problem,
                                                                                                                       n,
                                                                                                                       "",
                                                                                                                       null,
                                                                                                                       n_isOld).lte(LLNode.value_get_log(fallback_problem,
                                                                                                                                                         LLNode.next_get_log(fallback_problem,
                                                                                                                                                                             n,
                                                                                                                                                                             "",
                                                                                                                                                                             null,
                                                                                                                                                                             n_isOld),
                                                                                                                                                         "",
                                                                                                                                                         null,
                                                                                                                                                         fallback_target_isOld))));
    }
    
    public static LogExpr isPermutedSublistOf_log(LogProblem fallback_problem,
                                                  LogExpr fallback_target,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs,
                                                  boolean fallback_target_isOld,
                                                  LogExpr lst,
                                                  boolean lst_isOld) {
        boolean i_isOld =
          false;
        LogExpr quantVar_i =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("i"));
        LogExpr i =
          new LogExpr(fallback_problem,
                      quantVar_i.expr());
        LogExpr fallback_var_i =
          quantVar_i;
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  LList.nodeValues_log(fallback_problem,
                                                                                       fallback_target,
                                                                                       fallback_targetTypeArgsStr,
                                                                                       fallback_targetTypeArgs,
                                                                                       fallback_target_isOld),
                                                                  "<java.lang.Integer>",
                                                                  new String[] { "java.lang.Integer" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  fallback_var_i,
                                  LList.occurrencesOf_log(fallback_problem,
                                                          fallback_target,
                                                          fallback_targetTypeArgsStr,
                                                          fallback_targetTypeArgs,
                                                          fallback_target_isOld,
                                                          i,
                                                          i_isOld).lte(LList.occurrencesOf_log(fallback_problem,
                                                                                               lst,
                                                                                               fallback_targetTypeArgsStr,
                                                                                               fallback_targetTypeArgs,
                                                                                               lst_isOld,
                                                                                               i,
                                                                                               i_isOld)));
    }
    
    public static LogExpr isPermutationOf_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean fallback_target_isOld,
                                              LogExpr lst,
                                              boolean lst_isOld) {
        return LList.isPermutedSublistOf_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld,
                                             lst,
                                             lst_isOld).and(LList.isPermutedSublistOf_log(fallback_problem,
                                                                                          lst,
                                                                                          fallback_targetTypeArgsStr,
                                                                                          fallback_targetTypeArgs,
                                                                                          lst_isOld,
                                                                                          fallback_target,
                                                                                          fallback_target_isOld));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return LList.isAcyclic_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld);
    }
    
    public static LogExpr bubbleSort_checkContract_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return LList.fallback_checkInvariants_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetTypeArgsStr,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).and(LList.bubbleSort_checkFieldsInvariants_log(fallback_problem,
                                                                                                                        fallback_target,
                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                        fallback_targetTypeArgs,
                                                                                                                        fallback_target_isOld)).and(LList.isPermutationOf_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              true).and(LList.isSorted_log(fallback_problem,
                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                           fallback_target_isOld)));
    }
    
    public static LogExpr bubbleSort_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                               LogExpr fallback_target,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs,
                                                               boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(LList.head_get_log(fallback_problem,
                                                                           fallback_target,
                                                                           fallback_targetTypeArgsStr,
                                                                           fallback_targetTypeArgs,
                                                                           fallback_target_isOld).eq(fallback_problem.null_log()).or(LLNode.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                         LList.head_get_log(fallback_problem,
                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                            fallback_target_isOld),
                                                                                                                                                                         "",
                                                                                                                                                                         null,
                                                                                                                                                                         fallback_target_isOld)));
    }
}
