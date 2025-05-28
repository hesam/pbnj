import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.*;
import java.util.HashSet;
import java.util.Random;

class BSNode implements PBJInternObject {
    public int nodeValue;
    
    public BSNode leftNode;
    
    public BSNode rightNode;
    
    public BSNode(int nodeValue,
                  BSNode leftNode,
                  BSNode rightNode) {
        super();
        this.nodeValue =
          nodeValue;
        this.leftNode =
          leftNode;
        this.rightNode =
          rightNode;
        this.addInstance();
    }
    
    public void nodeValue(int v) {
        this.nodeValue =
          v;
    }
    
    public void leftNode(BSNode l) {
        this.leftNode =
          l;
    }
    
    public void rightNode(BSNode r) {
        this.rightNode =
          r;
    }
    
    public PBJInternSet<BSNode> children() {
        return this ==
                 null ? new PBJInternSet<BSNode>() : this.multiFields_BSNode("leftNode",
                                                                             "rightNode");
    }
    
    public PBJInternSet<BSNode> descendants() {
        return this ==
                 null ? new PBJInternSet<BSNode>() : this.fieldsClosure_BSNode(this,
                                                                               false,
                                                                               "leftNode",
                                                                               "rightNode");
    }
    
    public PBJInternSet<BSNode> leftNodeSubtree() {
        return this.leftNode ==
                 null ? new PBJInternSet<BSNode>() : this.leftNode.fieldsClosure_BSNode(this.leftNode,
                                                                                        true,
                                                                                        "leftNode",
                                                                                        "rightNode");
    }
    
    public PBJInternSet<BSNode> rightNodeSubtree() {
        return this.rightNode ==
                 null ? new PBJInternSet<BSNode>() : this.rightNode.fieldsClosure_BSNode(this.rightNode,
                                                                                         true,
                                                                                         "leftNode",
                                                                                         "rightNode");
    }
    
    public boolean equals(Object n) {
        return n instanceof BSNode &&
          nodeValue ==
            ((BSNode)
               n).nodeValue;
    }
    
    public int hashCode() {
        return nodeValue;
    }
    
    public String toString() {
        return "Node(" +
               nodeValue +
        ")";
    }
    
    public BSNode old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public BSNode(LogExpr dontcare) {
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
        LogMap.addInstance(BSNode.class,
                           this);
    }
    
    public void addInstanceForProblem(BSNode toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             BSNode.class,
                                             "BSNode",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public BSNode old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public BSNode fallback_setTypeArgs(String[] args) {
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
        return BSNode.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return BSNode.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return BSNode.classClonerStep ==
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
            BSNode.fallback_classAtomize(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.leftNode !=
                  null)
                this.leftNode.fallback_atomize(fallback_problem,
                                               "",
                                               null);
            if (this.rightNode !=
                  null)
                this.rightNode.fallback_atomize(fallback_problem,
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
            BSNode.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.leftNode !=
                  null)
                this.leftNode.fallback_relationizeOld(fallback_problem,
                                                      "",
                                                      null);
            if (this.rightNode !=
                  null)
                this.rightNode.fallback_relationizeOld(fallback_problem,
                                                       "",
                                                       null);
            BSNode.nodeValue_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.nodeValue);
            BSNode.leftNode_old_get_log(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                         this,
                                                                         this.leftNode);
            BSNode.rightNode_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.rightNode);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            BSNode.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            BSNode.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public BSNode fallback_clone() {
        if (isCloned())
            return old;
        BSNode res =
          null;
        BSNode.fallback_classClone();
        try {
            res =
              (BSNode)
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
            res.nodeValue =
              this.nodeValue;
            if (this.leftNode !=
                  null)
                res.leftNode =
                  this.leftNode.fallback_clone();
            if (this.rightNode !=
                  null)
                res.rightNode =
                  this.rightNode.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr nodeValue_get_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "BSNode",
                                   fallback_targetTypeArgsStr,
                                   "nodeValue",
                                   isOld);
    }
    
    public static LogRelation nodeValue_old_get_log(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "BSNode",
                                      fallback_targetTypeArgsStr,
                                      "nodeValue");
    }
    
    public int fallback_updateField_nodeValue(Integer newVal) {
        return this.nodeValue =
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
    
    public static LogExpr leftNode_get_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "BSNode",
                                   fallback_targetTypeArgsStr,
                                   "leftNode",
                                   isOld);
    }
    
    public static LogRelation leftNode_old_get_log(LogProblem fallback_problem,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "BSNode",
                                      fallback_targetTypeArgsStr,
                                      "leftNode");
    }
    
    public BSNode fallback_updateField_leftNode(BSNode newVal) {
        return this.leftNode =
          newVal;
    }
    
    public PBJInternSet<BSNode> fieldsClosure_BSNode(Object fallback_target,
                                                     boolean isReflexive,
                                                     java.lang.String ... fieldNs) {
        Class c =
          BSNode.class;
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        java.util.ArrayList<BSNode> workList =
          new java.util.ArrayList<BSNode>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                BSNode childN =
                  (BSNode)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            BSNode n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    BSNode childN =
                      (BSNode)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((BSNode)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<BSNode> multiFields_BSNode(java.lang.String ... fieldNs) {
        Class c =
          BSNode.class;
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                BSNode n =
                  (BSNode)
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
    
    public static LogExpr rightNode_get_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "BSNode",
                                   fallback_targetTypeArgsStr,
                                   "rightNode",
                                   isOld);
    }
    
    public static LogRelation rightNode_old_get_log(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "BSNode",
                                      fallback_targetTypeArgsStr,
                                      "rightNode");
    }
    
    public BSNode fallback_updateField_rightNode(BSNode newVal) {
        return this.rightNode =
          newVal;
    }
    
    public static PBJInternSet<Integer> setMap_nodeValue(PBJInternSet<BSNode> objs,
                                                         java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<BSNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().nodeValue);
        }
        return res;
    }
    
    public static PBJInternSet<BSNode> setMap_leftNode(PBJInternSet<BSNode> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        java.util.Iterator<BSNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().leftNode);
        }
        return res;
    }
    
    public static PBJInternSet<BSNode> setMap_rightNode(PBJInternSet<BSNode> objs,
                                                        java.lang.String ... fieldNs) {
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        java.util.Iterator<BSNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().rightNode);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(BSNode.class,
                                     true);
               LogMap.newInstVarRel("nodeValue",
                                    BSNode.class,
                                    "BSNode",
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
               LogMap.newInstVarRel("leftNode",
                                    BSNode.class,
                                    "BSNode",
                                    BSNode.class,
                                    "BSNode",
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
               LogMap.newInstVarRel("rightNode",
                                    BSNode.class,
                                    "BSNode",
                                    BSNode.class,
                                    "BSNode",
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
    
    public static LogExpr children_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          fallback_target,
                                          "BSNode",
                                          "",
                                          fallback_target_isOld,
                                          true,
                                          false,
                                          "leftNode",
                                          "rightNode");
    }
    
    public static LogExpr descendants_log(LogProblem fallback_problem,
                                          LogExpr fallback_target,
                                          String fallback_targetTypeArgsStr,
                                          String[] fallback_targetTypeArgs,
                                          boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          fallback_target,
                                          "BSNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          false,
                                          "leftNode",
                                          "rightNode");
    }
    
    public static LogExpr leftNodeSubtree_log(LogProblem fallback_problem,
                                              LogExpr fallback_target,
                                              String fallback_targetTypeArgsStr,
                                              String[] fallback_targetTypeArgs,
                                              boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          BSNode.leftNode_get_log(fallback_problem,
                                                                  fallback_target,
                                                                  fallback_targetTypeArgsStr,
                                                                  fallback_targetTypeArgs,
                                                                  fallback_target_isOld),
                                          "BSNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "leftNode",
                                          "rightNode");
    }
    
    public static LogExpr rightNodeSubtree_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          BSNode.rightNode_get_log(fallback_problem,
                                                                   fallback_target,
                                                                   fallback_targetTypeArgsStr,
                                                                   fallback_targetTypeArgs,
                                                                   fallback_target_isOld),
                                          "BSNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "leftNode",
                                          "rightNode");
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

public class BSTree implements PBJInternObject {
    private static final int INDENT_STEP =
      4;
    
    private static final int SIZE =
      10;
    
    private static final boolean TEST_INSERT =
      true;
    
    private static final boolean TEST_DELETE =
      false;
    
    private static final boolean TEST_BALANCE =
      false;
    
    public BSNode root;
    
    public BSTree() {
        super();
        root =
          null;
        this.addInstance();
    }
    
    public void root(BSNode r) {
        this.root =
          r;
    }
    
    public PBJInternSet<BSNode> nodes() {
        return root ==
                 null ? new PBJInternSet<BSNode>() : root.fieldsClosure_BSNode(root,
                                                                               true,
                                                                               "leftNode",
                                                                               "rightNode");
    }
    
    public PBJInternSet<Integer> nodeValues() {
        return this.nodes() ==
                 null ? new PBJInternSet<Integer>() : BSNode.setMap_nodeValue(this.nodes(),
                                                                              "nodeValue");
    }
    
    public boolean isAcyclic() {
        return isAcyclic_univQuantify_0();
    }
    
    public boolean isValidBinarySearch() {
        return isValidBinarySearch_univQuantify_3();
    }
    
    public boolean isBinarySearchTree() {
        return isAcyclic() &&
          isValidBinarySearch();
    }
    
    public int abs(int i) {
        return i <
                 0 ? -i : i;
    }
    
    public boolean isBalanced() {
        return isBalanced_univQuantify_4();
    }
    
    public void rebalance_orig() {
        
    }
    
    public void insert_int_orig(int nodeValue) {
        System.out.println("adding " +
                           nodeValue);
        if (TEST_INSERT)
            assert nodes().size() !=
              SIZE -
                1;
        BSNode node =
          new BSNode(nodeValue,
                     null,
                     null);
        if (root ==
              null) {
            root =
              node;
        } else {
            BSNode n =
              setChildAndGetParentNode(node);
        }
    }
    
    public void delete_int_orig(int nodeValue) {
        
    }
    
    public HashSet<Object> getNewNodeParentNodeToBe(int nodeValue) {
        HashSet<Object> res =
          new HashSet<Object>();
        if (root ==
              null) {
            res.add(this);
            return res;
        }
        BSNode n =
          root;
        while (true) {
            int compResult =
              compareTo(nodeValue,
                        n.nodeValue);
            if (compResult ==
                  0) {
                break;
            } else
                if (compResult <
                      0) {
                    if (n.leftNode ==
                          null) {
                        break;
                    } else {
                        n =
                          n.leftNode;
                    }
                } else {
                    assert compResult >
                      0;
                    if (n.rightNode ==
                          null) {
                        break;
                    } else {
                        n =
                          n.rightNode;
                    }
                }
        }
        res.add(n);
        return res;
    }
    
    public HashSet<Object> getParentNodeAndChildren(int nodeValue) {
        HashSet<Object> res =
          new HashSet<Object>();
        BSNode node =
          lookupNode(nodeValue);
        res.add(node);
        if (root ==
              node)
            res.add(this);
        else {
            
        }
        if (node.leftNode !=
              null)
            res.add(node.leftNode);
        if (node.rightNode !=
              null)
            res.add(node.rightNode);
        return res;
    }
    
    private BSNode lookupNode(int nodeValue) {
        BSNode n =
          root;
        while (n !=
                 null) {
            int compResult =
              compareTo(nodeValue,
                        n.nodeValue);
            if (compResult ==
                  0) {
                return n;
            } else
                if (compResult <
                      0) {
                    n =
                      n.leftNode;
                } else {
                    n =
                      n.rightNode;
                }
        }
        return n;
    }
    
    public BSNode setChildAndGetParentNode(BSNode insertedNode) {
        BSNode n =
          root;
        int nodeValue =
          insertedNode.nodeValue;
        while (true) {
            int compResult =
              compareTo(nodeValue,
                        n.nodeValue);
            if (compResult ==
                  0) {
                if (insertedNode !=
                      null) {
                    n.nodeValue =
                      nodeValue;
                }
                return n;
            } else
                if (compResult <
                      0) {
                    if (n.leftNode ==
                          null) {
                        if (insertedNode !=
                              null) {
                            n.leftNode =
                              insertedNode;
                        }
                        break;
                    } else {
                        n =
                          n.leftNode;
                    }
                } else {
                    assert compResult >
                      0;
                    if (n.rightNode ==
                          null) {
                        if (insertedNode !=
                              null) {
                            n.rightNode =
                              insertedNode;
                        }
                        break;
                    } else {
                        n =
                          n.rightNode;
                    }
                }
        }
        return n;
    }
    
    public void print() {
        printHelper(root,
                    0);
        System.out.println("---------------------------------------" +
                           (root ==
                              null ? 0 : nodes().size()) +
                           " nodes");
    }
    
    private static void printHelper(BSNode n,
                                    int indent) {
        if (n ==
              null) {
            System.out.println("<empty tree>");
            return;
        }
        if (n.rightNode !=
              null) {
            printHelper(n.rightNode,
                        indent +
                          INDENT_STEP);
        }
        for (int i =
               0;
             i <
               indent;
             i++)
            System.out.print(" ");
        System.out.println(n.nodeValue);
        if (n.leftNode !=
              null) {
            printHelper(n.leftNode,
                        indent +
                          INDENT_STEP);
        }
    }
    
    public static int compareTo(int a,
                                int b) {
        return a >
                 b ? 1 : (a <
                            b ? -1 : 0);
    }
    
    public static void main(String[] args) {
        boolean useAltSolver =
          args.length >
          0;
        if (useAltSolver)
            LogMap.SolverOpt_SolverNum(Integer.parseInt(args[0]));
        Random rand =
          new Random(1111L);
        BSTree t =
          new BSTree();
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
              rand.nextInt(i);
            int temp =
              a[n];
            a[n] =
              a[i -
                  1];
            t.insert(temp);
            if (i <
                  3)
                t.print();
        }
        if (TEST_DELETE) {
            for (int i =
                   SIZE -
                   1;
                 i >=
                   0;
                 --i) {
                t.delete(i);
                t.print();
                i =
                  0;
            }
        } else
            if (TEST_BALANCE) {
                t.rebalance();
                t.print();
            }
    }
    
    public BSTree old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public BSTree(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return isBinarySearchTree();
    }
    
    public void addInstance() {
        LogMap.addInstance(BSTree.class,
                           this);
    }
    
    public void addInstanceForProblem(BSTree toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             BSTree.class,
                                             "BSTree",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public BSTree old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public BSTree fallback_setTypeArgs(String[] args) {
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
        return BSTree.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return BSTree.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return BSTree.classClonerStep ==
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
    
    public boolean rebalance_checkContract() {
        return this.fallback_checkInvariants() &&
                 this.rebalance_checkFieldsInvariants() &&
          (this.nodes().equals(this.old.nodes()) &&
             isBalanced());
    }
    
    public void rebalance_assertContract() {
        assert rebalance_checkContract();
    }
    
    public void rebalance_commitModel(LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem rebalance_planb() {
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": rebalance" +
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
        fallback_problem.setModifiableField("BSTree.root");
        fallback_problem.setModifiableField("BSNode.leftNode");
        fallback_problem.setModifiableField("BSNode.rightNode");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          BSTree.rebalance_checkContract_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("rebalance",
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
    
    public void rebalance() {
        rebalance_ensured();
    }
    
    public void rebalance_ensured() {
        initEnsuredMethod();
        try {
            rebalance_orig();
            rebalance_assertContract();
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  rebalance_planb();
                rebalance_commitModel(fallback_problem);
            }
        }
    }
    
    public boolean rebalance_checkFieldsInvariants() {
        return true &&
          (root ==
             null ||
             root.fallback_checkInvariants());
    }
    
    public boolean insert_int_checkContract(int nodeValue) {
        return this.fallback_checkInvariants() &&
                 this.insert_int_checkFieldsInvariants() &&
          nodeValues().equals(this.old.nodeValues().plus(nodeValue));
    }
    
    public void insert_int_assertContract(int nodeValue) {
        assert insert_int_checkContract(nodeValue);
    }
    
    public void insert_int_commitModel(int nodeValue,
                                       LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem insert_int_planb(int nodeValue) {
        boolean nodeValue_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": insert" +
                                         ") initiated plan b...")))));
        BSNode.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("BSNode",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        BSNode.fallback_classClone();
        BSNode.fallback_classAtomize(fallback_problem,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        BSNode.fallback_classRelationizeOld(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("BSTree.root");
        fallback_problem.setModifiableField("BSNode.leftNode");
        fallback_problem.setModifiableField("BSNode.rightNode");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          BSTree.insert_int_checkContract_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld,
                                              fallback_problem.intToSingletonRelation_log(nodeValue),
                                              nodeValue_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("insert_int",
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
    
    public void insert(int nodeValue) {
        insert_int_ensured(nodeValue);
    }
    
    public void insert_int_ensured(int nodeValue) {
        initEnsuredMethod();
        try {
            insert_int_orig(nodeValue);
            insert_int_assertContract(nodeValue);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  insert_int_planb(nodeValue);
                insert_int_commitModel(nodeValue,
                                       fallback_problem);
            }
        }
    }
    
    public boolean insert_int_checkFieldsInvariants() {
        return true &&
          (root ==
             null ||
             root.fallback_checkInvariants());
    }
    
    public boolean delete_int_checkContract(int nodeValue) {
        return this.fallback_checkInvariants() &&
                 this.delete_int_checkFieldsInvariants() &&
          this.nodeValues().equals(this.old.nodeValues().minus(nodeValue));
    }
    
    public void delete_int_assertContract(int nodeValue) {
        assert delete_int_checkContract(nodeValue);
    }
    
    public void delete_int_commitModel(int nodeValue,
                                       LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem delete_int_planb(int nodeValue,
                                java.util.Collection modifiableObjects) {
        boolean nodeValue_isOld =
          false;
        boolean modifiableObjects_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": delete" +
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
        fallback_problem.setModifiableField("BSTree.root");
        fallback_problem.setModifiableField("BSNode.leftNode");
        fallback_problem.setModifiableField("BSNode.rightNode");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          BSTree.delete_int_checkContract_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld,
                                              fallback_problem.intToSingletonRelation_log(nodeValue),
                                              nodeValue_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("delete_int",
                                 this,
                                 fallback_formula.formula(),
                                 modifiableObjects,
                                 false,
                                 false,
                                 this.startMethodTime,
                                 false);
        assert isSatisfiable: "Formula UNSAT! Recovery failed...";
        return fallback_problem;
    }
    
    public void delete(int nodeValue) {
        delete_int_ensured(nodeValue);
    }
    
    public void delete_int_ensured(int nodeValue) {
        initEnsuredMethod();
        try {
            delete_int_orig(nodeValue);
            delete_int_assertContract(nodeValue);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                LogProblem fallback_problem =
                  delete_int_planb(nodeValue,
                                   this.old.getParentNodeAndChildren(nodeValue));
                delete_int_commitModel(nodeValue,
                                       fallback_problem);
            }
        }
    }
    
    public boolean delete_int_checkFieldsInvariants() {
        return true &&
          (root ==
             null ||
             root.fallback_checkInvariants());
    }
    
    public void fallback_atomize(LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            BSTree.fallback_classAtomize(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.root !=
                  null)
                this.root.fallback_atomize(fallback_problem,
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
            BSTree.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.root !=
                  null)
                this.root.fallback_relationizeOld(fallback_problem,
                                                  "",
                                                  null);
            BSTree.root_old_get_log(fallback_problem,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs).put_log(fallback_problem,
                                                                     this,
                                                                     this.root);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            BSTree.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            BSTree.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public BSTree fallback_clone() {
        if (isCloned())
            return old;
        BSTree res =
          null;
        BSTree.fallback_classClone();
        try {
            res =
              (BSTree)
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
            if (this.root !=
                  null)
                res.root =
                  this.root.fallback_clone();
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public static LogExpr root_get_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "BSTree",
                                   fallback_targetTypeArgsStr,
                                   "root",
                                   isOld);
    }
    
    public static LogRelation root_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "BSTree",
                                      fallback_targetTypeArgsStr,
                                      "root");
    }
    
    public BSNode fallback_updateField_root(BSNode newVal) {
        return this.root =
          newVal;
    }
    
    public PBJInternSet<BSNode> fieldsClosure_BSNode(Object fallback_target,
                                                     boolean isReflexive,
                                                     java.lang.String ... fieldNs) {
        Class c =
          BSNode.class;
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        java.util.ArrayList<BSNode> workList =
          new java.util.ArrayList<BSNode>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                BSNode childN =
                  (BSNode)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            BSNode n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    BSNode childN =
                      (BSNode)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((BSNode)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<BSNode> multiFields_BSNode(java.lang.String ... fieldNs) {
        Class c =
          BSNode.class;
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                BSNode n =
                  (BSNode)
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
    
    public boolean isAcyclic_univQuantify_0() {
        for (BSNode n : nodes()) {
            if (!(!n.descendants().contains(n)))
                return false;
        }
        return true;
    }
    
    public boolean isValidBinarySearch_univQuantify_3() {
        for (BSNode n : nodes()) {
            if (!((n.leftNode ==
                     null ||
                     isValidBinarySearch_univQuantify_1(n)) &&
                    (n.rightNode ==
                       null ||
                       isValidBinarySearch_univQuantify_2(n))))
                return false;
        }
        return true;
    }
    
    public boolean isValidBinarySearch_univQuantify_1(BSNode n) {
        for (BSNode lc : n.leftNodeSubtree()) {
            if (!(lc.nodeValue <
                    n.nodeValue))
                return false;
        }
        return true;
    }
    
    public boolean isValidBinarySearch_univQuantify_2(BSNode n) {
        for (BSNode rc : n.rightNodeSubtree()) {
            if (!(rc.nodeValue >
                    n.nodeValue))
                return false;
        }
        return true;
    }
    
    public boolean isBalanced_univQuantify_4() {
        for (BSNode n : nodes()) {
            if (!(abs(n.leftNodeSubtree().size() -
                        n.rightNodeSubtree().size()) <=
                    1))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<BSNode> setMap_root(PBJInternSet<BSTree> objs,
                                                   java.lang.String ... fieldNs) {
        PBJInternSet<BSNode> res =
          new PBJInternSet<BSNode>();
        java.util.Iterator<BSTree> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().root);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(BSTree.class,
                                     true);
               LogMap.newInstVarRel("root",
                                    BSTree.class,
                                    "BSTree",
                                    BSNode.class,
                                    "BSNode",
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
                                          BSTree.root_get_log(fallback_problem,
                                                              fallback_target,
                                                              fallback_targetTypeArgsStr,
                                                              fallback_targetTypeArgs,
                                                              fallback_target_isOld),
                                          "BSNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "leftNode",
                                          "rightNode");
    }
    
    public static LogExpr nodeValues_log(LogProblem fallback_problem,
                                         LogExpr fallback_target,
                                         String fallback_targetTypeArgsStr,
                                         String[] fallback_targetTypeArgs,
                                         boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          BSTree.nodes_log(fallback_problem,
                                                           fallback_target,
                                                           fallback_targetTypeArgsStr,
                                                           fallback_targetTypeArgs,
                                                           fallback_target_isOld),
                                          "BSNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          false,
                                          "nodeValue");
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
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  BSTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<BSNode>",
                                                                  new String[] { "BSNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  BSNode.descendants_log(fallback_problem,
                                                         n,
                                                         "",
                                                         null,
                                                         n_isOld).contains_log(fallback_problem,
                                                                               n,
                                                                               n_isOld).not());
    }
    
    public static LogExpr isValidBinarySearch_log(LogProblem fallback_problem,
                                                  LogExpr fallback_target,
                                                  String fallback_targetTypeArgsStr,
                                                  String[] fallback_targetTypeArgs,
                                                  boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        boolean lc_isOld =
          false;
        LogExpr lc =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("lc"));
        boolean rc_isOld =
          false;
        LogExpr rc =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("rc"));
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  BSTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<BSNode>",
                                                                  new String[] { "BSNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  BSNode.leftNode_get_log(fallback_problem,
                                                          n,
                                                          "",
                                                          null,
                                                          n_isOld).eq(fallback_problem.null_log()).or(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                         BSNode.leftNodeSubtree_log(fallback_problem,
                                                                                                                                                                                    n,
                                                                                                                                                                                    "",
                                                                                                                                                                                    null,
                                                                                                                                                                                    n_isOld),
                                                                                                                                                         "<BSNode>",
                                                                                                                                                         new String[] { "BSNode" },
                                                                                                                                                         fallback_target_isOld),
                                                                                                                         false,
                                                                                                                         "all",
                                                                                                                         lc,
                                                                                                                         BSNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                  lc,
                                                                                                                                                  "",
                                                                                                                                                  null,
                                                                                                                                                  lc_isOld).lt(BSNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                                                        n,
                                                                                                                                                                                        "",
                                                                                                                                                                                        null,
                                                                                                                                                                                        n_isOld)))).and(BSNode.rightNode_get_log(fallback_problem,
                                                                                                                                                                                                                                 n,
                                                                                                                                                                                                                                 "",
                                                                                                                                                                                                                                 null,
                                                                                                                                                                                                                                 n_isOld).eq(fallback_problem.null_log()).or(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                BSNode.rightNodeSubtree_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                            n,
                                                                                                                                                                                                                                                                                                                                                            "",
                                                                                                                                                                                                                                                                                                                                                            null,
                                                                                                                                                                                                                                                                                                                                                            n_isOld),
                                                                                                                                                                                                                                                                                                                                "<BSNode>",
                                                                                                                                                                                                                                                                                                                                new String[] { "BSNode" },
                                                                                                                                                                                                                                                                                                                                fallback_target_isOld),
                                                                                                                                                                                                                                                                                                false,
                                                                                                                                                                                                                                                                                                "all",
                                                                                                                                                                                                                                                                                                rc,
                                                                                                                                                                                                                                                                                                BSNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                         rc,
                                                                                                                                                                                                                                                                                                                         "",
                                                                                                                                                                                                                                                                                                                         null,
                                                                                                                                                                                                                                                                                                                         rc_isOld).gt(BSNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                               n,
                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                               n_isOld))))));
    }
    
    public static LogExpr isBinarySearchTree_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean fallback_target_isOld) {
        return BSTree.isAcyclic_log(fallback_problem,
                                    fallback_target,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs,
                                    fallback_target_isOld).and(BSTree.isValidBinarySearch_log(fallback_problem,
                                                                                              fallback_target,
                                                                                              fallback_targetTypeArgsStr,
                                                                                              fallback_targetTypeArgs,
                                                                                              fallback_target_isOld));
    }
    
    public static LogExpr abs_log(LogProblem fallback_problem,
                                  LogExpr fallback_target,
                                  String fallback_targetTypeArgsStr,
                                  String[] fallback_targetTypeArgs,
                                  boolean fallback_target_isOld,
                                  LogExpr i,
                                  boolean i_isOld) {
        return i.lt(new LogExpr(fallback_problem,
                                kodkod.ast.IntConstant.constant(0))).thenElse(i.negate(),
                                                                              i);
    }
    
    public static LogExpr isBalanced_log(LogProblem fallback_problem,
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
                                                                  BSTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<BSNode>",
                                                                  new String[] { "BSNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  BSTree.abs_log(fallback_problem,
                                                 fallback_target,
                                                 fallback_targetTypeArgsStr,
                                                 fallback_targetTypeArgs,
                                                 fallback_target_isOld,
                                                 BSNode.leftNodeSubtree_log(fallback_problem,
                                                                            n,
                                                                            "",
                                                                            null,
                                                                            n_isOld).size_log(fallback_problem).minus(BSNode.rightNodeSubtree_log(fallback_problem,
                                                                                                                                                  n,
                                                                                                                                                  "",
                                                                                                                                                  null,
                                                                                                                                                  n_isOld).size_log(fallback_problem)),
                                                 fallback_target_isOld).lte(new LogExpr(fallback_problem,
                                                                                        kodkod.ast.IntConstant.constant(1))));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return BSTree.isBinarySearchTree_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld);
    }
    
    public static LogExpr rebalance_checkContract_log(LogProblem fallback_problem,
                                                      LogExpr fallback_target,
                                                      String fallback_targetTypeArgsStr,
                                                      String[] fallback_targetTypeArgs,
                                                      boolean fallback_target_isOld) {
        return BSTree.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(BSTree.rebalance_checkFieldsInvariants_log(fallback_problem,
                                                                                                                         fallback_target,
                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                         fallback_targetTypeArgs,
                                                                                                                         fallback_target_isOld)).and(BSTree.nodes_log(fallback_problem,
                                                                                                                                                                      fallback_target,
                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                      fallback_target_isOld).equals_log(fallback_problem,
                                                                                                                                                                                                        BSTree.nodes_log(fallback_problem,
                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                         true),
                                                                                                                                                                                                        true).and(BSTree.isBalanced_log(fallback_problem,
                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                        fallback_target_isOld)));
    }
    
    public static LogExpr rebalance_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                              LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(BSTree.root_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).eq(fallback_problem.null_log()).or(BSNode.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                          BSTree.root_get_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                                          "",
                                                                                                                                                                          null,
                                                                                                                                                                          fallback_target_isOld)));
    }
    
    public static LogExpr insert_int_checkContract_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld,
                                                       LogExpr nodeValue,
                                                       boolean nodeValue_isOld) {
        return BSTree.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(BSTree.insert_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                          fallback_target,
                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                          fallback_targetTypeArgs,
                                                                                                                          fallback_target_isOld)).and(BSTree.nodeValues_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            fallback_target_isOld).equals_log(fallback_problem,
                                                                                                                                                                                                              BSTree.nodeValues_log(fallback_problem,
                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                    true).plus_log(fallback_problem,
                                                                                                                                                                                                                                                   nodeValue,
                                                                                                                                                                                                                                                   nodeValue_isOld),
                                                                                                                                                                                                              true));
    }
    
    public static LogExpr insert_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                               LogExpr fallback_target,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs,
                                                               boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(BSTree.root_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).eq(fallback_problem.null_log()).or(BSNode.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                          BSTree.root_get_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                                          "",
                                                                                                                                                                          null,
                                                                                                                                                                          fallback_target_isOld)));
    }
    
    public static LogExpr delete_int_checkContract_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld,
                                                       LogExpr nodeValue,
                                                       boolean nodeValue_isOld) {
        return BSTree.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(BSTree.delete_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                          fallback_target,
                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                          fallback_targetTypeArgs,
                                                                                                                          fallback_target_isOld)).and(BSTree.nodeValues_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            fallback_target_isOld).equals_log(fallback_problem,
                                                                                                                                                                                                              BSTree.nodeValues_log(fallback_problem,
                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                    true).minus_log(fallback_problem,
                                                                                                                                                                                                                                                    nodeValue,
                                                                                                                                                                                                                                                    nodeValue_isOld),
                                                                                                                                                                                                              true));
    }
    
    public static LogExpr delete_int_checkFieldsInvariants_log(LogProblem fallback_problem,
                                                               LogExpr fallback_target,
                                                               String fallback_targetTypeArgsStr,
                                                               String[] fallback_targetTypeArgs,
                                                               boolean fallback_target_isOld) {
        return new LogExpr(fallback_problem,
                           kodkod.ast.Formula.TRUE).and(BSTree.root_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).eq(fallback_problem.null_log()).or(BSNode.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                          BSTree.root_get_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                                          "",
                                                                                                                                                                          null,
                                                                                                                                                                          fallback_target_isOld)));
    }
}
