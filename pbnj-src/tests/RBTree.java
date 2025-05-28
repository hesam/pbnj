import polyglot.ext.pbnj.primitives.*;
import polyglot.ext.pbnj.tologic.*;
import java.util.HashSet;
import java.util.Random;

enum Color {
    RED (  ),
    
    BLACK (  ),
    
    ;
    
    
    
    
    private Color() {
        
    }
    
    public static LogExpr RED_get_log(LogProblem fallback_problem,
                                      LogExpr fallback_target,
                                      String fallback_targetTypeArgsStr,
                                      String[] fallback_targetTypeArgs,
                                      boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(Color.RED);
    }
    
    public static LogExpr BLACK_get_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean isOld) {
        return fallback_problem.objToSingletonRelation_log(Color.BLACK);
    }
}

class RBNode implements PBJInternObject {
    public int nodeValue;
    
    public Color nodeColor;
    
    public RBNode leftNode;
    
    public RBNode rightNode;
    
    public RBNode parentNode;
    
    public RBNode(int nodeValue,
                  RBNode leftNode,
                  RBNode rightNode) {
        this(nodeValue,
             Color.BLACK,
             leftNode,
             rightNode);
    }
    
    public RBNode(int nodeValue,
                  Color nodeColor,
                  RBNode leftNode,
                  RBNode rightNode) {
        super();
        this.nodeValue =
          nodeValue;
        this.nodeColor =
          nodeColor;
        this.leftNode =
          leftNode;
        this.rightNode =
          rightNode;
        if (leftNode !=
              null)
            leftNode.parentNode =
              this;
        if (rightNode !=
              null)
            rightNode.parentNode =
              this;
        this.parentNode =
          null;
        this.addInstance();
    }
    
    public void nodeValue(int v) {
        this.nodeValue =
          v;
    }
    
    public void nodeColor(Color c) {
        this.nodeColor =
          c;
    }
    
    public void leftNode(RBNode l) {
        this.leftNode =
          l;
    }
    
    public void rightNode(RBNode r) {
        this.rightNode =
          r;
    }
    
    public void parentNode(RBNode p) {
        this.parentNode =
          p;
    }
    
    public PBJInternSet<RBNode> children() {
        return this ==
                 null ? new PBJInternSet<RBNode>() : this.multiFields_RBNode("leftNode",
                                                                             "rightNode");
    }
    
    public PBJInternSet<RBNode> descendants() {
        return this ==
                 null ? new PBJInternSet<RBNode>() : this.fieldsClosure_RBNode(this,
                                                                               false,
                                                                               "leftNode",
                                                                               "rightNode");
    }
    
    public PBJInternSet<RBNode> leftNodeSubtree() {
        return this.leftNode ==
                 null ? new PBJInternSet<RBNode>() : this.leftNode.fieldsClosure_RBNode(this.leftNode,
                                                                                        true,
                                                                                        "leftNode",
                                                                                        "rightNode");
    }
    
    public PBJInternSet<RBNode> rightNodeSubtree() {
        return this.rightNode ==
                 null ? new PBJInternSet<RBNode>() : this.rightNode.fieldsClosure_RBNode(this.rightNode,
                                                                                         true,
                                                                                         "leftNode",
                                                                                         "rightNode");
    }
    
    public PBJInternSet<RBNode> ancestors() {
        return this ==
                 null ? new PBJInternSet<RBNode>() : this.fieldsClosure_RBNode(this,
                                                                               false,
                                                                               "parentNode");
    }
    
    public PBJInternSet<RBNode> thisAndAncestors() {
        return this ==
                 null ? new PBJInternSet<RBNode>() : this.fieldsClosure_RBNode(this,
                                                                               true,
                                                                               "parentNode");
    }
    
    public PBJInternSet<RBNode> blackAncestors() {
        return blackAncestors_setComprehension_0();
    }
    
    public RBNode grandparentNode() {
        assert parentNode !=
          null;
        assert parentNode.parentNode !=
          null;
        return parentNode.parentNode;
    }
    
    public RBNode sibling() {
        assert parentNode !=
          null;
        if (this ==
              parentNode.leftNode)
            return parentNode.rightNode;
        else
            return parentNode.leftNode;
    }
    
    public RBNode uncle() {
        assert parentNode !=
          null;
        assert parentNode.parentNode !=
          null;
        return parentNode.sibling();
    }
    
    public boolean equals(Object n) {
        return n instanceof RBNode &&
          nodeValue ==
            ((RBNode)
               n).nodeValue;
    }
    
    public int hashCode() {
        return nodeValue;
    }
    
    public String toString() {
        return (nodeColor ==
                  Color.RED ? "[R]" : "") +
               "Node(" +
               nodeValue +
        ")";
    }
    
    public RBNode old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public RBNode(LogExpr dontcare) {
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
        LogMap.addInstance(RBNode.class,
                           this);
    }
    
    public void addInstanceForProblem(RBNode toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             RBNode.class,
                                             "RBNode",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public RBNode old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public RBNode fallback_setTypeArgs(String[] args) {
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
        return RBNode.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return RBNode.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return RBNode.classClonerStep ==
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
            RBNode.fallback_classAtomize(fallback_problem,
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
            if (this.parentNode !=
                  null)
                this.parentNode.fallback_atomize(fallback_problem,
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
            RBNode.fallback_classRelationizeOld(fallback_problem,
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
            if (this.parentNode !=
                  null)
                this.parentNode.fallback_relationizeOld(fallback_problem,
                                                        "",
                                                        null);
            RBNode.nodeValue_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.nodeValue);
            RBNode.nodeColor_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.nodeColor);
            RBNode.leftNode_old_get_log(fallback_problem,
                                        fallback_targetTypeArgsStr,
                                        fallback_targetTypeArgs).put_log(fallback_problem,
                                                                         this,
                                                                         this.leftNode);
            RBNode.rightNode_old_get_log(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs).put_log(fallback_problem,
                                                                          this,
                                                                          this.rightNode);
            RBNode.parentNode_old_get_log(fallback_problem,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs).put_log(fallback_problem,
                                                                           this,
                                                                           this.parentNode);
        }
    }
    
    public static void fallback_classAtomize(LogProblem fallback_problem,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs) {
        if (!isClassAtomized(fallback_problem)) {
            RBNode.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            RBNode.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public RBNode fallback_clone() {
        if (isCloned())
            return old;
        RBNode res =
          null;
        RBNode.fallback_classClone();
        try {
            res =
              (RBNode)
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
            res.nodeColor =
              this.nodeColor;
            if (this.leftNode !=
                  null)
                res.leftNode =
                  this.leftNode.fallback_clone();
            if (this.rightNode !=
                  null)
                res.rightNode =
                  this.rightNode.fallback_clone();
            if (this.parentNode !=
                  null)
                res.parentNode =
                  this.parentNode.fallback_clone();
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
                                   "RBNode",
                                   fallback_targetTypeArgsStr,
                                   "nodeValue",
                                   isOld);
    }
    
    public static LogRelation nodeValue_old_get_log(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RBNode",
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
    
    public static LogExpr nodeColor_get_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "RBNode",
                                   fallback_targetTypeArgsStr,
                                   "nodeColor",
                                   isOld);
    }
    
    public static LogRelation nodeColor_old_get_log(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RBNode",
                                      fallback_targetTypeArgsStr,
                                      "nodeColor");
    }
    
    public Color fallback_updateField_nodeColor(Color newVal) {
        return this.nodeColor =
          newVal;
    }
    
    public PBJInternSet<Color> fieldsClosure_Color(Object fallback_target,
                                                   boolean isReflexive,
                                                   java.lang.String ... fieldNs) {
        Class c =
          Color.class;
        PBJInternSet<Color> res =
          new PBJInternSet<Color>();
        java.util.ArrayList<Color> workList =
          new java.util.ArrayList<Color>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                Color childN =
                  (Color)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            Color n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    Color childN =
                      (Color)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((Color)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<Color> multiFields_Color(java.lang.String ... fieldNs) {
        Class c =
          Color.class;
        PBJInternSet<Color> res =
          new PBJInternSet<Color>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                Color n =
                  (Color)
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
                                   "RBNode",
                                   fallback_targetTypeArgsStr,
                                   "leftNode",
                                   isOld);
    }
    
    public static LogRelation leftNode_old_get_log(LogProblem fallback_problem,
                                                   String fallback_targetTypeArgsStr,
                                                   String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RBNode",
                                      fallback_targetTypeArgsStr,
                                      "leftNode");
    }
    
    public RBNode fallback_updateField_leftNode(RBNode newVal) {
        return this.leftNode =
          newVal;
    }
    
    public PBJInternSet<RBNode> fieldsClosure_RBNode(Object fallback_target,
                                                     boolean isReflexive,
                                                     java.lang.String ... fieldNs) {
        Class c =
          RBNode.class;
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        java.util.ArrayList<RBNode> workList =
          new java.util.ArrayList<RBNode>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                RBNode childN =
                  (RBNode)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            RBNode n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    RBNode childN =
                      (RBNode)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((RBNode)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<RBNode> multiFields_RBNode(java.lang.String ... fieldNs) {
        Class c =
          RBNode.class;
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                RBNode n =
                  (RBNode)
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
                                   "RBNode",
                                   fallback_targetTypeArgsStr,
                                   "rightNode",
                                   isOld);
    }
    
    public static LogRelation rightNode_old_get_log(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RBNode",
                                      fallback_targetTypeArgsStr,
                                      "rightNode");
    }
    
    public RBNode fallback_updateField_rightNode(RBNode newVal) {
        return this.rightNode =
          newVal;
    }
    
    public static LogExpr parentNode_get_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "RBNode",
                                   fallback_targetTypeArgsStr,
                                   "parentNode",
                                   isOld);
    }
    
    public static LogRelation parentNode_old_get_log(LogProblem fallback_problem,
                                                     String fallback_targetTypeArgsStr,
                                                     String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RBNode",
                                      fallback_targetTypeArgsStr,
                                      "parentNode");
    }
    
    public RBNode fallback_updateField_parentNode(RBNode newVal) {
        return this.parentNode =
          newVal;
    }
    
    public PBJInternSet<RBNode> blackAncestors_setComprehension_0() {
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        for (RBNode n : thisAndAncestors()) {
            if (n.nodeColor ==
                  Color.BLACK)
                res.add(n);
        }
        return res;
    }
    
    public static PBJInternSet<Integer> setMap_nodeValue(PBJInternSet<RBNode> objs,
                                                         java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<RBNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().nodeValue);
        }
        return res;
    }
    
    public static PBJInternSet<Color> setMap_nodeColor(PBJInternSet<RBNode> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<Color> res =
          new PBJInternSet<Color>();
        java.util.Iterator<RBNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().nodeColor);
        }
        return res;
    }
    
    public static PBJInternSet<RBNode> setMap_leftNode(PBJInternSet<RBNode> objs,
                                                       java.lang.String ... fieldNs) {
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        java.util.Iterator<RBNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().leftNode);
        }
        return res;
    }
    
    public static PBJInternSet<RBNode> setMap_rightNode(PBJInternSet<RBNode> objs,
                                                        java.lang.String ... fieldNs) {
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        java.util.Iterator<RBNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().rightNode);
        }
        return res;
    }
    
    public static PBJInternSet<RBNode> setMap_parentNode(PBJInternSet<RBNode> objs,
                                                         java.lang.String ... fieldNs) {
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        java.util.Iterator<RBNode> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().parentNode);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(RBNode.class,
                                     true);
               LogMap.newInstVarRel("nodeValue",
                                    RBNode.class,
                                    "RBNode",
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
               LogMap.newInstVarRel("nodeColor",
                                    RBNode.class,
                                    "RBNode",
                                    Color.class,
                                    "Color",
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
                                    RBNode.class,
                                    "RBNode",
                                    RBNode.class,
                                    "RBNode",
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
                                    RBNode.class,
                                    "RBNode",
                                    RBNode.class,
                                    "RBNode",
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
               LogMap.newInstVarRel("parentNode",
                                    RBNode.class,
                                    "RBNode",
                                    RBNode.class,
                                    "RBNode",
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
                                          "RBNode",
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
                                          "RBNode",
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
                                          RBNode.leftNode_get_log(fallback_problem,
                                                                  fallback_target,
                                                                  fallback_targetTypeArgsStr,
                                                                  fallback_targetTypeArgs,
                                                                  fallback_target_isOld),
                                          "RBNode",
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
                                          RBNode.rightNode_get_log(fallback_problem,
                                                                   fallback_target,
                                                                   fallback_targetTypeArgsStr,
                                                                   fallback_targetTypeArgs,
                                                                   fallback_target_isOld),
                                          "RBNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "leftNode",
                                          "rightNode");
    }
    
    public static LogExpr ancestors_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          fallback_target,
                                          "RBNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          false,
                                          "parentNode");
    }
    
    public static LogExpr thisAndAncestors_log(LogProblem fallback_problem,
                                               LogExpr fallback_target,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs,
                                               boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          fallback_target,
                                          "RBNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "parentNode");
    }
    
    public static LogExpr blackAncestors_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          RBNode.thisAndAncestors_log(fallback_problem,
                                                                                                      fallback_target,
                                                                                                      fallback_targetTypeArgsStr,
                                                                                                      fallback_targetTypeArgs,
                                                                                                      fallback_target_isOld),
                                                                          "<RBNode>",
                                                                          new String[] { "RBNode" },
                                                                          fallback_target_isOld),
                                          n,
                                          RBNode.nodeColor_get_log(fallback_problem,
                                                                   n,
                                                                   fallback_targetTypeArgsStr,
                                                                   fallback_targetTypeArgs,
                                                                   n_isOld).eq(Color.BLACK_get_log(fallback_problem,
                                                                                                   fallback_problem.class_log(Color.class),
                                                                                                   "",
                                                                                                   null,
                                                                                                   fallback_target_isOld)));
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

public class RBTree implements PBJInternObject {
    private static final int INDENT_STEP =
      4;
    
    private static final int SIZE =
      10;
    
    private static final boolean TEST_INSERT =
      true;
    
    private static final boolean TEST_DELETE =
      false;
    
    public RBNode root;
    
    public RBTree() {
        super();
        root =
          null;
        this.addInstance();
    }
    
    public void root(RBNode r) {
        this.root =
          r;
    }
    
    public PBJInternSet<RBNode> nodes() {
        return root ==
                 null ? new PBJInternSet<RBNode>() : root.fieldsClosure_RBNode(root,
                                                                               true,
                                                                               "leftNode",
                                                                               "rightNode");
    }
    
    public PBJInternSet<RBNode> leaves() {
        return leaves_setComprehension_1();
    }
    
    public PBJInternSet<Integer> nodeNodeValues() {
        return this.nodes() ==
                 null ? new PBJInternSet<Integer>() : RBNode.setMap_nodeValue(this.nodes(),
                                                                              "nodeValue");
    }
    
    public boolean isRBTree() {
        return redsChildren() &&
                 eqBlacks() &&
                 rootBlack() &&
          isBinarySearchTree();
    }
    
    public boolean isBinarySearchTree() {
        return isValidBinarySearch() &&
                 parentNodeDef() &&
          isAcyclic();
    }
    
    public boolean rootBlack() {
        return this.root ==
                 null ||
          this.root.nodeColor ==
            Color.BLACK;
    }
    
    public boolean redsChildren() {
        return redsChildren_univQuantify_3();
    }
    
    public boolean eqBlacks() {
        return eqBlacks_univQuantify_5();
    }
    
    public boolean isAcyclic() {
        return isAcyclic_univQuantify_6();
    }
    
    public boolean parentNodeDef() {
        return parentNodeDef_univQuantify_8();
    }
    
    public boolean isValidBinarySearch() {
        return isValidBinarySearch_univQuantify_11();
    }
    
    public void insert_int_orig(int nodeValue) {
        System.out.println("adding " +
                           nodeValue);
        if (TEST_INSERT)
            assert nodes().size() !=
              SIZE -
                1;
        RBNode insertedNode =
          new RBNode(nodeValue,
                     Color.RED,
                     null,
                     null);
        if (root ==
              null) {
            root =
              insertedNode;
        } else {
            RBNode n =
              getNewNodeParentNode(insertedNode);
            insertedNode.parentNode =
              n;
        }
        insertCase1(insertedNode);
    }
    
    public void delete_int_orig(int nodeValue) {
        System.out.println("deleting: " +
                           nodeValue);
    }
    
    private static Color nodeColor(RBNode n) {
        return n ==
                 null ? Color.BLACK : n.nodeColor;
    }
    
    private HashSet<Object> getAffectedNodesOnInsert(int nodeValue) {
        HashSet<Object> res =
          new HashSet<Object>();
        if (root !=
              null) {
            RBNode node =
              new RBNode(nodeValue,
                         Color.RED,
                         null,
                         null);
            RBNode n =
              getNewNodeParentNodeToBe(nodeValue);
            node.parentNode =
              n;
            res.add(n);
            getAffectedNodesOnInsert1(node,
                                      res);
        } else {
            res.add(this);
        }
        return res;
    }
    
    private HashSet<Object> getAffectedNodesOnDelete(int nodeValue) {
        HashSet<Object> res =
          new HashSet<Object>();
        RBNode node =
          lookupNode(nodeValue);
        res.add(node);
        if (node.parentNode !=
              null)
            res.add(node.parentNode);
        if (node.leftNode !=
              null &&
              node.rightNode !=
                null) {
            RBNode pred =
              maximumNode(node.leftNode);
            node.nodeValue =
              pred.nodeValue;
            node =
              pred;
            res.add(pred);
        }
        assert node.leftNode ==
                 null ||
          node.rightNode ==
            null;
        RBNode child =
          node.rightNode ==
            null ? node.leftNode : node.rightNode;
        if (nodeColor(node) ==
              Color.BLACK) {
            node.nodeColor =
              nodeColor(child);
            getAffectedNodesOnDelete1(node,
                                      res);
        }
        return res;
    }
    
    private RBNode lookupNode(int nodeValue) {
        RBNode n =
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
    
    public String toString() {
        String res =
          "";
        res +=
          printHelper(root,
                      0);
        res +=
          "---------------------------------------" +
          (root ==
             null ? 0 : nodes().size()) +
          " nodes";
        return res +
        "\n";
    }
    
    private String printHelper(RBNode n,
                               int indent) {
        String res =
          "";
        if (n ==
              null) {
            res +=
              "<empty tree>\n";
            return res;
        }
        if (n.rightNode !=
              null) {
            res +=
              printHelper(n.rightNode,
                          indent +
                            INDENT_STEP);
        }
        for (int i =
               0;
             i <
               indent;
             i++)
            res +=
              " ";
        if (n.nodeColor ==
              Color.BLACK)
            res +=
              n.nodeValue +
              "\n";
        else
            res +=
              "R" +
              n.nodeValue +
              "\n";
        if (n.leftNode !=
              null) {
            res +=
              printHelper(n.leftNode,
                          indent +
                            INDENT_STEP);
        }
        return res;
    }
    
    public RBNode getNewNodeParentNode(RBNode insertedNode) {
        RBNode n =
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
    
    public RBNode getNewNodeParentNodeToBe(int nodeValue) {
        RBNode n =
          root;
        while (true) {
            int compResult =
              compareTo(nodeValue,
                        n.nodeValue);
            if (compResult ==
                  0) {
                return n;
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
        return n;
    }
    
    private void insertCase1(RBNode n) {
        if (n.parentNode ==
              null)
            n.nodeColor =
              Color.BLACK;
        else
            insertCase2(n);
    }
    
    private void insertCase2(RBNode n) {
        if (nodeColor(n.parentNode) ==
              Color.BLACK)
            return;
        else
            insertCase3(n);
    }
    
    void insertCase3(RBNode n) {
        if (nodeColor(n.uncle()) ==
              Color.RED) {
            n.parentNode.nodeColor =
              Color.BLACK;
            n.uncle().nodeColor =
              Color.BLACK;
            n.grandparentNode().nodeColor =
              Color.RED;
            insertCase1(n.grandparentNode());
        } else {
            insertCase4(n);
        }
    }
    
    void insertCase4(RBNode n) {
        if (n ==
              n.parentNode.rightNode &&
              n.parentNode ==
                n.grandparentNode().leftNode) {
            rotateLeftNode(n.parentNode);
            n =
              n.leftNode;
        } else
            if (n ==
                  n.parentNode.leftNode &&
                  n.parentNode ==
                    n.grandparentNode().rightNode) {
                rotateRightNode(n.parentNode);
                n =
                  n.rightNode;
            }
        insertCase5(n);
    }
    
    void insertCase5(RBNode n) {
        n.parentNode.nodeColor =
          Color.BLACK;
        n.grandparentNode().nodeColor =
          Color.RED;
        if (n ==
              n.parentNode.leftNode &&
              n.parentNode ==
                n.grandparentNode().leftNode) {
            rotateRightNode(n.grandparentNode());
        } else {
            assert n ==
                     n.parentNode.rightNode &&
              n.parentNode ==
                n.grandparentNode().rightNode;
            rotateLeftNode(n.grandparentNode());
        }
    }
    
    private void rotateLeftNode(RBNode n) {
        RBNode r =
          n.rightNode;
        replaceNode(n,
                    r);
        n.rightNode =
          r.leftNode;
        if (r.leftNode !=
              null) {
            r.leftNode.parentNode =
              n;
        }
        r.leftNode =
          n;
        n.parentNode =
          r;
    }
    
    private void rotateRightNode(RBNode n) {
        RBNode l =
          n.leftNode;
        replaceNode(n,
                    l);
        n.leftNode =
          l.rightNode;
        if (l.rightNode !=
              null) {
            l.rightNode.parentNode =
              n;
        }
        l.rightNode =
          n;
        n.parentNode =
          l;
    }
    
    private void replaceNode(RBNode oldn,
                             RBNode newn) {
        if (oldn.parentNode ==
              null) {
            root =
              newn;
        } else {
            if (oldn ==
                  oldn.parentNode.leftNode)
                oldn.parentNode.leftNode =
                  newn;
            else
                oldn.parentNode.rightNode =
                  newn;
        }
        if (newn !=
              null) {
            newn.parentNode =
              oldn.parentNode;
        }
    }
    
    private static RBNode maximumNode(RBNode n) {
        assert n !=
          null;
        while (n.rightNode !=
                 null) {
            n =
              n.rightNode;
        }
        return n;
    }
    
    private void getAffectedNodesOnInsert1(RBNode n,
                                           HashSet<Object> res) {
        if (n !=
              root)
            getAffectedNodesOnInsert2(n,
                                      res);
    }
    
    private void getAffectedNodesOnInsert2(RBNode n,
                                           HashSet<Object> res) {
        if (nodeColor(n.parentNode) ==
              Color.BLACK)
            return;
        else
            getAffectedNodesOnInsert3(n,
                                      res);
    }
    
    void getAffectedNodesOnInsert3(RBNode n,
                                   HashSet<Object> res) {
        if (nodeColor(n.uncle()) ==
              Color.RED) {
            res.add(n.parentNode);
            res.add(n.uncle());
            res.add(n.grandparentNode());
            getAffectedNodesOnInsert1(n.grandparentNode(),
                                      res);
        } else {
            getAffectedNodesOnInsert4(n,
                                      res);
        }
    }
    
    void getAffectedNodesOnInsert4(RBNode n,
                                   HashSet<Object> res) {
        if (n.parentNode !=
              null)
            res.add(n.parentNode);
        if (n.grandparentNode() !=
              null)
            res.add(n.grandparentNode());
        if (n.parentNode.grandparentNode() !=
              null)
            res.add(n.parentNode.grandparentNode());
        if (n ==
              n.parentNode.rightNode &&
              n.parentNode ==
                n.grandparentNode().leftNode) {
            res.add(n.parentNode.leftNode);
            if (n.leftNode !=
                  null)
                res.add(n.leftNode);
            if (n.rightNode !=
                  null)
                res.add(n.rightNode);
        } else
            if (n ==
                  n.parentNode.leftNode &&
                  n.parentNode ==
                    n.grandparentNode().rightNode) {
                res.add(n.parentNode.rightNode);
                if (n.leftNode !=
                      null)
                    res.add(n.leftNode);
                if (n.rightNode !=
                      null)
                    res.add(n.rightNode);
            }
    }
    
    private void getAffectedNodesOnDelete1(RBNode n,
                                           HashSet<Object> res) {
        if (n.parentNode ==
              null)
            return;
        else
            getAffectedNodesOnDelete2(n,
                                      res);
    }
    
    private void getAffectedNodesOnDelete2(RBNode n,
                                           HashSet<Object> res) {
        if (nodeColor(n.sibling()) ==
              Color.RED) {
            res.add(n.parentNode);
            res.add(n.sibling());
            n.parentNode.nodeColor =
              Color.RED;
            n.sibling().nodeColor =
              Color.BLACK;
            res.add(n.leftNode);
            res.add(n.rightNode);
            if (n ==
                  n.parentNode.leftNode)
                res.add(n.parentNode.leftNode);
            else
                res.add(n.parentNode.rightNode);
        }
        getAffectedNodesOnDelete3(n,
                                  res);
    }
    
    private void getAffectedNodesOnDelete3(RBNode n,
                                           HashSet<Object> res) {
        if (nodeColor(n.parentNode) ==
              Color.BLACK &&
              nodeColor(n.sibling()) ==
                Color.BLACK &&
              nodeColor(n.sibling().leftNode) ==
                Color.BLACK &&
              nodeColor(n.sibling().rightNode) ==
                Color.BLACK) {
            res.add(n.sibling());
            getAffectedNodesOnDelete1(n.parentNode,
                                      res);
        } else
            getAffectedNodesOnDelete4(n,
                                      res);
    }
    
    private void getAffectedNodesOnDelete4(RBNode n,
                                           HashSet<Object> res) {
        if (nodeColor(n.parentNode) ==
              Color.RED &&
              nodeColor(n.sibling()) ==
                Color.BLACK &&
              nodeColor(n.sibling().leftNode) ==
                Color.BLACK &&
              nodeColor(n.sibling().rightNode) ==
                Color.BLACK) {
            res.add(n.sibling());
            res.add(n.parentNode);
        } else
            getAffectedNodesOnDelete5(n,
                                      res);
    }
    
    private void getAffectedNodesOnDelete5(RBNode n,
                                           HashSet<Object> res) {
        if (n ==
              n.parentNode.leftNode &&
              nodeColor(n.sibling()) ==
                Color.BLACK &&
              nodeColor(n.sibling().leftNode) ==
                Color.RED &&
              nodeColor(n.sibling().rightNode) ==
                Color.BLACK) {
            res.add(n.sibling());
            res.add(n.sibling().leftNode);
            res.add(n.sibling().rightNode);
            res.add(n.sibling().parentNode.rightNode);
        } else
            if (n ==
                  n.parentNode.rightNode &&
                  nodeColor(n.sibling()) ==
                    Color.BLACK &&
                  nodeColor(n.sibling().rightNode) ==
                    Color.RED &&
                  nodeColor(n.sibling().leftNode) ==
                    Color.BLACK) {
                res.add(n.sibling());
                res.add(n.sibling().leftNode);
                res.add(n.sibling().rightNode);
                res.add(n.sibling().parentNode.leftNode);
            }
        getAffectedNodesOnDelete6(n,
                                  res);
    }
    
    private void getAffectedNodesOnDelete6(RBNode n,
                                           HashSet<Object> res) {
        res.add(n.sibling());
        res.add(n.parentNode);
        if (n ==
              n.parentNode.leftNode) {
            assert nodeColor(n.sibling().rightNode) ==
              Color.RED;
            res.add(n.sibling().rightNode);
            res.add(n.parentNode.leftNode);
            res.add(n.parentNode.rightNode);
            res.add(n.parentNode.parentNode.leftNode);
        } else {
            assert nodeColor(n.sibling().leftNode) ==
              Color.RED;
            res.add(n.sibling().leftNode);
            res.add(n.parentNode.leftNode);
            res.add(n.parentNode.rightNode);
            res.add(n.parentNode.parentNode);
            res.add(n.parentNode.parentNode.rightNode);
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
        RBTree t =
          new RBTree();
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
                System.out.println(t);
        }
        if (TEST_DELETE) {
            for (int i =
                   SIZE -
                   1;
                 i >=
                   0;
                 --i) {
                t.delete(i);
                System.out.println(t);
                i =
                  0;
            }
        }
    }
    
    public RBTree old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public RBTree(LogExpr dontcare) {
        super();
        this.addInstance();
    }
    
    Object[] fallback_field_resultArray;
    
    public void fallback_field_resultArray(Object[] r) {
        this.fallback_field_resultArray =
          r;
    }
    
    public boolean fallback_checkInvariants() {
        return isRBTree();
    }
    
    public void addInstance() {
        LogMap.addInstance(RBTree.class,
                           this);
    }
    
    public void addInstanceForProblem(RBTree toAdd,
                                      LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             RBTree.class,
                                             "RBTree",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public RBTree old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public RBTree fallback_setTypeArgs(String[] args) {
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
        return RBTree.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(LogProblem fallback_problem) {
        return RBTree.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return RBTree.classClonerStep ==
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
    
    public boolean insert_int_checkContract(int nodeValue) {
        return this.fallback_checkInvariants() &&
                 this.insert_int_checkFieldsInvariants() &&
          this.nodeNodeValues().equals(this.old.nodeNodeValues().plus(nodeValue));
    }
    
    public void insert_int_assertContract(int nodeValue) {
        assert insert_int_checkContract(nodeValue);
    }
    
    public void insert_int_commitModel(int nodeValue,
                                       LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem insert_int_planb(int nodeValue,
                                java.util.Collection modifiableObjects) {
        boolean nodeValue_isOld =
          false;
        boolean modifiableObjects_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": insert" +
                                         ") initiated plan b...")))));
        RBNode.fallback_initClassDefs();
        LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        fallback_problem.newFreshInstances();
        fallback_problem.setFreshInstances("RBNode",
                                           1);
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        RBNode.fallback_classClone();
        RBNode.fallback_classAtomize(fallback_problem,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        RBNode.fallback_classRelationizeOld(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
        fallback_problem.initRelations();
        fallback_problem.newModifiableFields();
        fallback_problem.setModifiableField("RBTree.root");
        fallback_problem.setModifiableField("RBNode.nodeColor");
        fallback_problem.setModifiableField("RBNode.leftNode");
        fallback_problem.setModifiableField("RBNode.rightNode");
        fallback_problem.setModifiableField("RBNode.parentNode");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          RBTree.insert_int_checkContract_log(fallback_problem,
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
                                 modifiableObjects,
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
                  insert_int_planb(nodeValue,
                                   this.old.getAffectedNodesOnInsert(nodeValue));
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
          this.nodeNodeValues().equals(this.old.nodeNodeValues().minus(nodeValue));
    }
    
    public void delete_int_assertContract(int nodeValue) {
        assert delete_int_checkContract(nodeValue);
    }
    
    public void delete_int_commitModel(int nodeValue,
                                       LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    LogProblem delete_int_planb(int nodeValue) {
        boolean nodeValue_isOld =
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
        fallback_problem.setModifiableField("RBTree.root");
        fallback_problem.setModifiableField("RBNode.nodeColor");
        fallback_problem.setModifiableField("RBNode.leftNode");
        fallback_problem.setModifiableField("RBNode.rightNode");
        fallback_problem.setModifiableField("RBNode.parentNode");
        LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        LogExpr fallback_formula =
          RBTree.delete_int_checkContract_log(fallback_problem,
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
                                 null,
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
                  delete_int_planb(nodeValue);
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
            RBTree.fallback_classAtomize(fallback_problem,
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
            RBTree.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.root !=
                  null)
                this.root.fallback_relationizeOld(fallback_problem,
                                                  "",
                                                  null);
            RBTree.root_old_get_log(fallback_problem,
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
            RBTree.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            RBTree.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public RBTree fallback_clone() {
        if (isCloned())
            return old;
        RBTree res =
          null;
        RBTree.fallback_classClone();
        try {
            res =
              (RBTree)
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
                                   "RBTree",
                                   fallback_targetTypeArgsStr,
                                   "root",
                                   isOld);
    }
    
    public static LogRelation root_old_get_log(LogProblem fallback_problem,
                                               String fallback_targetTypeArgsStr,
                                               String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "RBTree",
                                      fallback_targetTypeArgsStr,
                                      "root");
    }
    
    public RBNode fallback_updateField_root(RBNode newVal) {
        return this.root =
          newVal;
    }
    
    public PBJInternSet<RBNode> fieldsClosure_RBNode(Object fallback_target,
                                                     boolean isReflexive,
                                                     java.lang.String ... fieldNs) {
        Class c =
          RBNode.class;
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        java.util.ArrayList<RBNode> workList =
          new java.util.ArrayList<RBNode>();
        try {
            java.util.ArrayList<java.lang.reflect.Field> fields =
              new java.util.ArrayList<java.lang.reflect.Field>();
            for (String fN : fieldNs) {
                fields.add(c.getField(fN));
            }
            for (java.lang.reflect.Field f : fields) {
                RBNode childN =
                  (RBNode)
                    f.get(fallback_target);
                if (!(childN ==
                        null ||
                        res.containsPtrEqCmp(childN)))
                    workList.add(childN);
            }
            RBNode n;
            while (workList.size() >
                     0) {
                n =
                  workList.get(0);
                res.add(n);
                for (java.lang.reflect.Field f : fields) {
                    RBNode childN =
                      (RBNode)
                        f.get(n);
                    if (!(childN ==
                            null ||
                            res.containsPtrEqCmp(childN)))
                        workList.add(childN);
                }
                workList.remove(n);
            }
            if (isReflexive)
                res.add((RBNode)
                          fallback_target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    PBJInternSet<RBNode> multiFields_RBNode(java.lang.String ... fieldNs) {
        Class c =
          RBNode.class;
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        try {
            for (String fN : fieldNs) {
                java.lang.reflect.Field f =
                  c.getField(fN);
                RBNode n =
                  (RBNode)
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
    
    public PBJInternSet<RBNode> leaves_setComprehension_1() {
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        for (RBNode n : nodes()) {
            if (n.leftNode ==
                  null ||
                  n.rightNode ==
                    null)
                res.add(n);
        }
        return res;
    }
    
    public boolean redsChildren_univQuantify_3() {
        for (RBNode n : nodes()) {
            if (!(n.nodeColor ==
                    Color.BLACK ||
                    redsChildren_univQuantify_2(n)))
                return false;
        }
        return true;
    }
    
    public boolean redsChildren_univQuantify_2(RBNode n) {
        for (RBNode c : n.children()) {
            if (!(c.nodeColor ==
                    Color.BLACK))
                return false;
        }
        return true;
    }
    
    public boolean eqBlacks_univQuantify_5() {
        for (RBNode l1 : leaves()) {
            if (!eqBlacks_univQuantify_4(l1))
                return false;
        }
        return true;
    }
    
    public boolean eqBlacks_univQuantify_4(RBNode l1) {
        for (RBNode l2 : leaves()) {
            if (!(l1 ==
                    l2 ||
                    l1.blackAncestors().size() ==
                      l2.blackAncestors().size()))
                return false;
        }
        return true;
    }
    
    public boolean isAcyclic_univQuantify_6() {
        for (RBNode n : nodes()) {
            if (!(!n.descendants().contains(n)))
                return false;
        }
        return true;
    }
    
    public boolean parentNodeDef_univQuantify_8() {
        for (RBNode n : nodes()) {
            if (!parentNodeDef_univQuantify_7(n))
                return false;
        }
        return true;
    }
    
    public boolean parentNodeDef_univQuantify_7(RBNode n) {
        for (RBNode p : nodes()) {
            if (!((!p.children().contains(n) ||
                     n.parentNode ==
                       p) &&
                    (n.parentNode !=
                       p ||
                       p.children().contains(n))))
                return false;
        }
        return true;
    }
    
    public boolean isValidBinarySearch_univQuantify_11() {
        for (RBNode n : nodes()) {
            if (!((n.leftNode ==
                     null ||
                     isValidBinarySearch_univQuantify_9(n)) &&
                    (n.rightNode ==
                       null ||
                       isValidBinarySearch_univQuantify_10(n))))
                return false;
        }
        return true;
    }
    
    public boolean isValidBinarySearch_univQuantify_9(RBNode n) {
        for (RBNode lc : n.leftNodeSubtree()) {
            if (!(lc.nodeValue <
                    n.nodeValue))
                return false;
        }
        return true;
    }
    
    public boolean isValidBinarySearch_univQuantify_10(RBNode n) {
        for (RBNode rc : n.rightNodeSubtree()) {
            if (!(rc.nodeValue >
                    n.nodeValue))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<RBNode> setMap_root(PBJInternSet<RBTree> objs,
                                                   java.lang.String ... fieldNs) {
        PBJInternSet<RBNode> res =
          new PBJInternSet<RBNode>();
        java.util.Iterator<RBTree> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().root);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(RBTree.class,
                                     true);
               LogMap.newInstVarRel("root",
                                    RBTree.class,
                                    "RBTree",
                                    RBNode.class,
                                    "RBNode",
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
                                          RBTree.root_get_log(fallback_problem,
                                                              fallback_target,
                                                              fallback_targetTypeArgsStr,
                                                              fallback_targetTypeArgs,
                                                              fallback_target_isOld),
                                          "RBNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          true,
                                          "leftNode",
                                          "rightNode");
    }
    
    public static LogExpr leaves_log(LogProblem fallback_problem,
                                     LogExpr fallback_target,
                                     String fallback_targetTypeArgsStr,
                                     String[] fallback_targetTypeArgs,
                                     boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        return LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                          RBTree.nodes_log(fallback_problem,
                                                                                           fallback_target,
                                                                                           fallback_targetTypeArgsStr,
                                                                                           fallback_targetTypeArgs,
                                                                                           fallback_target_isOld),
                                                                          "<RBNode>",
                                                                          new String[] { "RBNode" },
                                                                          fallback_target_isOld),
                                          n,
                                          RBNode.leftNode_get_log(fallback_problem,
                                                                  n,
                                                                  "",
                                                                  null,
                                                                  n_isOld).eq(fallback_problem.null_log()).or(RBNode.rightNode_get_log(fallback_problem,
                                                                                                                                       n,
                                                                                                                                       "",
                                                                                                                                       null,
                                                                                                                                       n_isOld).eq(fallback_problem.null_log())));
    }
    
    public static LogExpr nodeNodeValues_log(LogProblem fallback_problem,
                                             LogExpr fallback_target,
                                             String fallback_targetTypeArgsStr,
                                             String[] fallback_targetTypeArgs,
                                             boolean fallback_target_isOld) {
        return LogMap.fieldGetClosure_log(fallback_problem,
                                          RBTree.nodes_log(fallback_problem,
                                                           fallback_target,
                                                           fallback_targetTypeArgsStr,
                                                           fallback_targetTypeArgs,
                                                           fallback_target_isOld),
                                          "RBNode",
                                          "",
                                          fallback_target_isOld,
                                          false,
                                          false,
                                          "nodeValue");
    }
    
    public static LogExpr isRBTree_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean fallback_target_isOld) {
        return RBTree.redsChildren_log(fallback_problem,
                                       fallback_target,
                                       fallback_targetTypeArgsStr,
                                       fallback_targetTypeArgs,
                                       fallback_target_isOld).and(RBTree.eqBlacks_log(fallback_problem,
                                                                                      fallback_target,
                                                                                      fallback_targetTypeArgsStr,
                                                                                      fallback_targetTypeArgs,
                                                                                      fallback_target_isOld)).and(RBTree.rootBlack_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld)).and(RBTree.isBinarySearchTree_log(fallback_problem,
                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                 fallback_target_isOld));
    }
    
    public static LogExpr isBinarySearchTree_log(LogProblem fallback_problem,
                                                 LogExpr fallback_target,
                                                 String fallback_targetTypeArgsStr,
                                                 String[] fallback_targetTypeArgs,
                                                 boolean fallback_target_isOld) {
        return RBTree.isValidBinarySearch_log(fallback_problem,
                                              fallback_target,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs,
                                              fallback_target_isOld).and(RBTree.parentNodeDef_log(fallback_problem,
                                                                                                  fallback_target,
                                                                                                  fallback_targetTypeArgsStr,
                                                                                                  fallback_targetTypeArgs,
                                                                                                  fallback_target_isOld)).and(RBTree.isAcyclic_log(fallback_problem,
                                                                                                                                                   fallback_target,
                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                   fallback_target_isOld));
    }
    
    public static LogExpr rootBlack_log(LogProblem fallback_problem,
                                        LogExpr fallback_target,
                                        String fallback_targetTypeArgsStr,
                                        String[] fallback_targetTypeArgs,
                                        boolean fallback_target_isOld) {
        return RBTree.root_get_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld).eq(fallback_problem.null_log()).or(RBNode.nodeColor_get_log(fallback_problem,
                                                                                                                      RBTree.root_get_log(fallback_problem,
                                                                                                                                          fallback_target,
                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                          fallback_target_isOld),
                                                                                                                      "",
                                                                                                                      null,
                                                                                                                      fallback_target_isOld).eq(Color.BLACK_get_log(fallback_problem,
                                                                                                                                                                    fallback_problem.class_log(Color.class),
                                                                                                                                                                    "",
                                                                                                                                                                    null,
                                                                                                                                                                    fallback_target_isOld)));
    }
    
    public static LogExpr redsChildren_log(LogProblem fallback_problem,
                                           LogExpr fallback_target,
                                           String fallback_targetTypeArgsStr,
                                           String[] fallback_targetTypeArgs,
                                           boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        boolean c_isOld =
          false;
        LogExpr c =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("c"));
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  RBTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<RBNode>",
                                                                  new String[] { "RBNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  RBNode.nodeColor_get_log(fallback_problem,
                                                           n,
                                                           "",
                                                           null,
                                                           n_isOld).eq(Color.BLACK_get_log(fallback_problem,
                                                                                           fallback_problem.class_log(Color.class),
                                                                                           "",
                                                                                           null,
                                                                                           fallback_target_isOld)).or(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                         RBNode.children_log(fallback_problem,
                                                                                                                                                                                             n,
                                                                                                                                                                                             "",
                                                                                                                                                                                             null,
                                                                                                                                                                                             n_isOld),
                                                                                                                                                                         "<RBNode>",
                                                                                                                                                                         new String[] { "RBNode" },
                                                                                                                                                                         fallback_target_isOld),
                                                                                                                                         false,
                                                                                                                                         "all",
                                                                                                                                         c,
                                                                                                                                         RBNode.nodeColor_get_log(fallback_problem,
                                                                                                                                                                  c,
                                                                                                                                                                  "",
                                                                                                                                                                  null,
                                                                                                                                                                  c_isOld).eq(Color.BLACK_get_log(fallback_problem,
                                                                                                                                                                                                  fallback_problem.class_log(Color.class),
                                                                                                                                                                                                  "",
                                                                                                                                                                                                  null,
                                                                                                                                                                                                  fallback_target_isOld)))));
    }
    
    public static LogExpr eqBlacks_log(LogProblem fallback_problem,
                                       LogExpr fallback_target,
                                       String fallback_targetTypeArgsStr,
                                       String[] fallback_targetTypeArgs,
                                       boolean fallback_target_isOld) {
        boolean l1_isOld =
          false;
        LogExpr l1 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("l1"));
        boolean l2_isOld =
          false;
        LogExpr l2 =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("l2"));
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  RBTree.leaves_log(fallback_problem,
                                                                                    fallback_target,
                                                                                    fallback_targetTypeArgsStr,
                                                                                    fallback_targetTypeArgs,
                                                                                    fallback_target_isOld),
                                                                  "<RBNode>",
                                                                  new String[] { "RBNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  l1,
                                  LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                     RBTree.leaves_log(fallback_problem,
                                                                                                       fallback_target,
                                                                                                       fallback_targetTypeArgsStr,
                                                                                                       fallback_targetTypeArgs,
                                                                                                       fallback_target_isOld),
                                                                                     "<RBNode>",
                                                                                     new String[] { "RBNode" },
                                                                                     fallback_target_isOld),
                                                     false,
                                                     "all",
                                                     l2,
                                                     l1.eq(l2).or(RBNode.blackAncestors_log(fallback_problem,
                                                                                            l1,
                                                                                            "",
                                                                                            null,
                                                                                            l1_isOld).size_log(fallback_problem).eq(RBNode.blackAncestors_log(fallback_problem,
                                                                                                                                                              l2,
                                                                                                                                                              "",
                                                                                                                                                              null,
                                                                                                                                                              l2_isOld).size_log(fallback_problem)))));
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
                                                                  RBTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<RBNode>",
                                                                  new String[] { "RBNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  RBNode.descendants_log(fallback_problem,
                                                         n,
                                                         "",
                                                         null,
                                                         n_isOld).contains_log(fallback_problem,
                                                                               n,
                                                                               n_isOld).not());
    }
    
    public static LogExpr parentNodeDef_log(LogProblem fallback_problem,
                                            LogExpr fallback_target,
                                            String fallback_targetTypeArgsStr,
                                            String[] fallback_targetTypeArgs,
                                            boolean fallback_target_isOld) {
        boolean n_isOld =
          false;
        LogExpr n =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("n"));
        boolean p_isOld =
          false;
        LogExpr p =
          new LogExpr(fallback_problem,
                      kodkod.ast.Variable.unary("p"));
        return LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                  RBTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<RBNode>",
                                                                  new String[] { "RBNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                     RBTree.nodes_log(fallback_problem,
                                                                                                      fallback_target,
                                                                                                      fallback_targetTypeArgsStr,
                                                                                                      fallback_targetTypeArgs,
                                                                                                      fallback_target_isOld),
                                                                                     "<RBNode>",
                                                                                     new String[] { "RBNode" },
                                                                                     fallback_target_isOld),
                                                     false,
                                                     "all",
                                                     p,
                                                     RBNode.children_log(fallback_problem,
                                                                         p,
                                                                         "",
                                                                         null,
                                                                         p_isOld).contains_log(fallback_problem,
                                                                                               n,
                                                                                               n_isOld).not().or(RBNode.parentNode_get_log(fallback_problem,
                                                                                                                                           n,
                                                                                                                                           "",
                                                                                                                                           null,
                                                                                                                                           n_isOld).eq(p)).and(RBNode.parentNode_get_log(fallback_problem,
                                                                                                                                                                                         n,
                                                                                                                                                                                         "",
                                                                                                                                                                                         null,
                                                                                                                                                                                         n_isOld).eq(p).not().or(RBNode.children_log(fallback_problem,
                                                                                                                                                                                                                                     p,
                                                                                                                                                                                                                                     "",
                                                                                                                                                                                                                                     null,
                                                                                                                                                                                                                                     p_isOld).contains_log(fallback_problem,
                                                                                                                                                                                                                                                           n,
                                                                                                                                                                                                                                                           n_isOld)))));
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
                                                                  RBTree.nodes_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld),
                                                                  "<RBNode>",
                                                                  new String[] { "RBNode" },
                                                                  fallback_target_isOld),
                                  false,
                                  "all",
                                  n,
                                  RBNode.leftNode_get_log(fallback_problem,
                                                          n,
                                                          "",
                                                          null,
                                                          n_isOld).eq(fallback_problem.null_log()).or(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                         RBNode.leftNodeSubtree_log(fallback_problem,
                                                                                                                                                                                    n,
                                                                                                                                                                                    "",
                                                                                                                                                                                    null,
                                                                                                                                                                                    n_isOld),
                                                                                                                                                         "<RBNode>",
                                                                                                                                                         new String[] { "RBNode" },
                                                                                                                                                         fallback_target_isOld),
                                                                                                                         false,
                                                                                                                         "all",
                                                                                                                         lc,
                                                                                                                         RBNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                  lc,
                                                                                                                                                  "",
                                                                                                                                                  null,
                                                                                                                                                  lc_isOld).lt(RBNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                                                        n,
                                                                                                                                                                                        "",
                                                                                                                                                                                        null,
                                                                                                                                                                                        n_isOld)))).and(RBNode.rightNode_get_log(fallback_problem,
                                                                                                                                                                                                                                 n,
                                                                                                                                                                                                                                 "",
                                                                                                                                                                                                                                 null,
                                                                                                                                                                                                                                 n_isOld).eq(fallback_problem.null_log()).or(LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                RBNode.rightNodeSubtree_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                            n,
                                                                                                                                                                                                                                                                                                                                                            "",
                                                                                                                                                                                                                                                                                                                                                            null,
                                                                                                                                                                                                                                                                                                                                                            n_isOld),
                                                                                                                                                                                                                                                                                                                                "<RBNode>",
                                                                                                                                                                                                                                                                                                                                new String[] { "RBNode" },
                                                                                                                                                                                                                                                                                                                                fallback_target_isOld),
                                                                                                                                                                                                                                                                                                false,
                                                                                                                                                                                                                                                                                                "all",
                                                                                                                                                                                                                                                                                                rc,
                                                                                                                                                                                                                                                                                                RBNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                         rc,
                                                                                                                                                                                                                                                                                                                         "",
                                                                                                                                                                                                                                                                                                                         null,
                                                                                                                                                                                                                                                                                                                         rc_isOld).gt(RBNode.nodeValue_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                               n,
                                                                                                                                                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                                                                                                                                                               n_isOld))))));
    }
    
    public static LogExpr fallback_checkInvariants_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld) {
        return RBTree.isRBTree_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld);
    }
    
    public static LogExpr insert_int_checkContract_log(LogProblem fallback_problem,
                                                       LogExpr fallback_target,
                                                       String fallback_targetTypeArgsStr,
                                                       String[] fallback_targetTypeArgs,
                                                       boolean fallback_target_isOld,
                                                       LogExpr nodeValue,
                                                       boolean nodeValue_isOld) {
        return RBTree.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(RBTree.insert_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                          fallback_target,
                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                          fallback_targetTypeArgs,
                                                                                                                          fallback_target_isOld)).and(RBTree.nodeNodeValues_log(fallback_problem,
                                                                                                                                                                                fallback_target,
                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                fallback_target_isOld).equals_log(fallback_problem,
                                                                                                                                                                                                                  RBTree.nodeNodeValues_log(fallback_problem,
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
                           kodkod.ast.Formula.TRUE).and(RBTree.root_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).eq(fallback_problem.null_log()).or(RBNode.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                          RBTree.root_get_log(fallback_problem,
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
        return RBTree.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(RBTree.delete_int_checkFieldsInvariants_log(fallback_problem,
                                                                                                                          fallback_target,
                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                          fallback_targetTypeArgs,
                                                                                                                          fallback_target_isOld)).and(RBTree.nodeNodeValues_log(fallback_problem,
                                                                                                                                                                                fallback_target,
                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                fallback_target_isOld).equals_log(fallback_problem,
                                                                                                                                                                                                                  RBTree.nodeNodeValues_log(fallback_problem,
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
                           kodkod.ast.Formula.TRUE).and(RBTree.root_get_log(fallback_problem,
                                                                            fallback_target,
                                                                            fallback_targetTypeArgsStr,
                                                                            fallback_targetTypeArgs,
                                                                            fallback_target_isOld).eq(fallback_problem.null_log()).or(RBNode.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                          RBTree.root_get_log(fallback_problem,
                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                                                          "",
                                                                                                                                                                          null,
                                                                                                                                                                          fallback_target_isOld)));
    }
}
