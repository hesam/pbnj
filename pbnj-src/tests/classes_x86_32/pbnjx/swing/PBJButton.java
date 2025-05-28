package pbnjx.swing;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.Action;

public class PBJButton extends JButton implements polyglot.ext.pbnj.primitives.PBJObject {
    static int SPEC_GRID;
    
    protected int xp;
    
    protected int yp;
    
    protected int wp;
    
    protected int hp;
    
    protected int gw;
    
    protected int gh;
    
    protected int ey;
    
    protected int ew;
    
    protected int eh;
    
    protected int ewp;
    
    protected int gx;
    
    protected int gy;
    
    protected int iright;
    
    protected int itop;
    
    protected int centerAnchor;
    
    public static void setSpecGrid(int specGrid) {
        SPEC_GRID =
          specGrid;
    }
    
    public Integer xp() {
        return this.xp;
    }
    
    public Integer yp() {
        return this.yp;
    }
    
    public Integer wp() {
        return this.wp;
    }
    
    public Integer hp() {
        return this.hp;
    }
    
    public Integer ey() {
        return this.ey;
    }
    
    public Integer ew() {
        return this.ew;
    }
    
    public Integer eh() {
        return this.eh;
    }
    
    public Integer ewp() {
        return this.ewp;
    }
    
    public Integer gx() {
        return this.gx;
    }
    
    public Integer gy() {
        return this.gy;
    }
    
    public Integer gw() {
        return this.gw;
    }
    
    public Integer gh() {
        return this.gh;
    }
    
    public Integer iright() {
        return this.iright;
    }
    
    public Integer itop() {
        return this.itop;
    }
    
    public Integer centerAnchor() {
        return this.centerAnchor;
    }
    
    public void xpSet(int xp) {
        this.xp =
          xp;
    }
    
    public void ypSet(int yp) {
        this.yp =
          yp;
    }
    
    public void wpSet(int wp) {
        this.wp =
          wp;
    }
    
    public void hpSet(int hp) {
        this.hp =
          hp;
    }
    
    public void xp(int xp) {
        this.xp =
          xp;
        setBounds(xp *
                    SPEC_GRID,
                  getY(),
                  getWidth(),
                  getHeight());
    }
    
    public void yp(int yp) {
        this.yp =
          yp;
        setBounds(getX(),
                  yp *
                    SPEC_GRID,
                  getWidth(),
                  getHeight());
    }
    
    public void wp(int wp) {
        this.wp =
          wp;
        setBounds(getX(),
                  getY(),
                  wp *
                    SPEC_GRID,
                  getHeight());
    }
    
    public void hp(int hp) {
        this.hp =
          hp;
        setBounds(getX(),
                  getY(),
                  getWidth(),
                  hp *
                    SPEC_GRID);
    }
    
    public void ey(int y) {
        this.ey =
          y;
    }
    
    public void ew(int w) {
        this.ew =
          w;
        this.wp =
          w;
    }
    
    public void eh(int h) {
        this.eh =
          h;
        this.hp =
          h;
    }
    
    public void ewp(int w) {
        this.ewp =
          w;
        this.wp =
          w;
    }
    
    public void gx(int x) {
        this.gx =
          x;
    }
    
    public void gy(int y) {
        this.gy =
          y;
    }
    
    public void gw(int w) {
        this.gw =
          w;
    }
    
    public void gh(int h) {
        this.gh =
          h;
    }
    
    public void iright(int x) {
        this.iright =
          x;
    }
    
    public void itop(int y) {
        this.itop =
          y;
    }
    
    public void centerAnchor(int a) {
        this.centerAnchor =
          a;
    }
    
    public void xpSet(Integer xp) {
        this.xp =
          xp;
    }
    
    public void ypSet(Integer yp) {
        this.yp =
          yp;
    }
    
    public void wpSet(Integer wp) {
        this.wp =
          wp;
    }
    
    public void hpSet(Integer hp) {
        this.hp =
          hp;
    }
    
    public void xp(Integer xp) {
        this.xp =
          xp;
        setBounds(xp *
                    SPEC_GRID,
                  getY(),
                  getWidth(),
                  getHeight());
    }
    
    public void yp(Integer yp) {
        this.yp =
          yp;
        setBounds(getX(),
                  yp *
                    SPEC_GRID,
                  getWidth(),
                  getHeight());
    }
    
    public void wp(Integer wp) {
        this.wp =
          wp;
        setBounds(getX(),
                  getY(),
                  wp *
                    SPEC_GRID,
                  getHeight());
    }
    
    public void hp(Integer hp) {
        this.hp =
          hp;
        setBounds(getX(),
                  getY(),
                  getWidth(),
                  hp *
                    SPEC_GRID);
    }
    
    public void ey(Integer y) {
        this.ey =
          y;
    }
    
    public void ew(Integer w) {
        this.ew =
          w;
        this.wp =
          w;
    }
    
    public void eh(Integer h) {
        this.eh =
          h;
        this.hp =
          h;
    }
    
    public void ewp(Integer w) {
        this.ewp =
          w;
        this.wp =
          w;
    }
    
    public void gx(Integer x) {
        this.gx =
          x;
    }
    
    public void gy(Integer y) {
        this.gy =
          y;
    }
    
    public void gw(Integer w) {
        this.gw =
          w;
    }
    
    public void gh(Integer h) {
        this.gh =
          h;
    }
    
    public void iright(Integer x) {
        this.iright =
          x;
    }
    
    public void itop(Integer y) {
        this.itop =
          y;
    }
    
    public void centerAnchor(Integer a) {
        this.centerAnchor =
          a;
    }
    
    public PBJButton() {
        this(null,
             null);
    }
    
    public PBJButton(Icon icon) {
        this(null,
             icon);
    }
    
    public PBJButton(String text) {
        this(text,
             null);
    }
    
    public PBJButton(Action a) {
        this();
        setAction(a);
    }
    
    public void setBounds(int x,
                          int y,
                          int width,
                          int height) {
        reshape(x,
                y,
                width,
                height);
        this.xp =
          x /
            SPEC_GRID;
        this.yp =
          y /
            SPEC_GRID;
        this.wp =
          width /
            SPEC_GRID;
        this.hp =
          height /
            SPEC_GRID;
    }
    
    public PBJButton(String text,
                     Icon icon) {
        super(text,
              icon);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(PBJButton.class,
                                                     this);
    }
    
    PBJButton old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public PBJButton(polyglot.ext.pbnj.tologic.LogObjSet dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean verifyInvariants() {
        return true;
    }
    
    long startMethodTime;
    
    public PBJButton old() {
        return this.old;
    }
    
    boolean isOld;
    
    public boolean isOld() {
        return this.isOld;
    }
    
    int atomizerStep =
      0;
    
    boolean isAtomized() {
        return this.atomizerStep ==
          polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
    }
    
    int relationizerStep =
      0;
    
    boolean isRelationized() {
        return this.relationizerStep ==
          polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
    }
    
    int clonerStep =
      0;
    
    public boolean isCloned() {
        return this.clonerStep ==
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
                                       Object[] args) {
        try {
            return cons.newInstance(args);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public void fallback_atomize() {
        if (!isAtomized()) {
            this.atomizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            polyglot.ext.pbnj.tologic.LogMap.addToClassInstances(this.old,
                                                                 PBJButton.class);
        }
    }
    
    public void fallback_relationizeOld() {
        if (!isRelationized()) {
            this.relationizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "xp_old").put_log(this,
                                                                               this.xp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "yp_old").put_log(this,
                                                                               this.yp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "wp_old").put_log(this,
                                                                               this.wp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "hp_old").put_log(this,
                                                                               this.hp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gw_old").put_log(this,
                                                                               this.gw);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gh_old").put_log(this,
                                                                               this.gh);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "ey_old").put_log(this,
                                                                               this.ey);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "ew_old").put_log(this,
                                                                               this.ew);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "eh_old").put_log(this,
                                                                               this.eh);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "ewp_old").put_log(this,
                                                                                this.ewp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gx_old").put_log(this,
                                                                               this.gx);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gy_old").put_log(this,
                                                                               this.gy);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "iright_old").put_log(this,
                                                                                   this.iright);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "itop_old").put_log(this,
                                                                                 this.itop);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "centerAnchor_old").put_log(this,
                                                                                         this.centerAnchor);
        }
    }
    
    public void fallback_relationize() {
        if (!old.isRelationized()) {
            old.relationizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "xp").put_log(old,
                                                                           old.xp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "yp").put_log(old,
                                                                           old.yp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "wp").put_log(old,
                                                                           old.wp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "hp").put_log(old,
                                                                           old.hp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gw").put_log(old,
                                                                           old.gw);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gh").put_log(old,
                                                                           old.gh);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "ey").put_log(old,
                                                                           old.ey);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "ew").put_log(old,
                                                                           old.ew);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "eh").put_log(old,
                                                                           old.eh);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "ewp").put_log(old,
                                                                            old.ewp);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gx").put_log(old,
                                                                           old.gx);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "gy").put_log(old,
                                                                           old.gy);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "iright").put_log(old,
                                                                               old.iright);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "itop").put_log(old,
                                                                             old.itop);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "centerAnchor").put_log(old,
                                                                                     old.centerAnchor);
        }
    }
    
    public PBJButton fallback_clone() {
        if (isCloned())
            return this.old;
        PBJButton res =
          null;
        try {
            this.clonerStep =
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            res =
              (PBJButton)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            res.xp =
              this.xp;
            res.yp =
              this.yp;
            res.wp =
              this.wp;
            res.hp =
              this.hp;
            res.gw =
              this.gw;
            res.gh =
              this.gh;
            res.ey =
              this.ey;
            res.ew =
              this.ew;
            res.eh =
              this.eh;
            res.ewp =
              this.ewp;
            res.gx =
              this.gx;
            res.gy =
              this.gy;
            res.iright =
              this.iright;
            res.itop =
              this.itop;
            res.centerAnchor =
              this.centerAnchor;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public void fallback_updateField_xp(Integer newVal) {
        this.xp =
          newVal;
    }
    
    public polyglot.ext.pbnj.primitives.PBJSet<Integer> fieldsClosure_Integer(Object target,
                                                                              boolean isReflexive,
                                                                              java.lang.String ... fieldNs) {
        Class c =
          int.class;
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
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
                    f.get(target);
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
                          target);
        }
        catch (Exception rte) {
            rte.printStackTrace();
        }
        return res;
    }
    
    polyglot.ext.pbnj.primitives.PBJSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
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
    
    public void fallback_updateField_yp(Integer newVal) {
        this.yp =
          newVal;
    }
    
    public void fallback_updateField_wp(Integer newVal) {
        this.wp =
          newVal;
    }
    
    public void fallback_updateField_hp(Integer newVal) {
        this.hp =
          newVal;
    }
    
    public void fallback_updateField_gw(Integer newVal) {
        this.gw =
          newVal;
    }
    
    public void fallback_updateField_gh(Integer newVal) {
        this.gh =
          newVal;
    }
    
    public void fallback_updateField_ey(Integer newVal) {
        this.ey =
          newVal;
    }
    
    public void fallback_updateField_ew(Integer newVal) {
        this.ew =
          newVal;
    }
    
    public void fallback_updateField_eh(Integer newVal) {
        this.eh =
          newVal;
    }
    
    public void fallback_updateField_ewp(Integer newVal) {
        this.ewp =
          newVal;
    }
    
    public void fallback_updateField_gx(Integer newVal) {
        this.gx =
          newVal;
    }
    
    public void fallback_updateField_gy(Integer newVal) {
        this.gy =
          newVal;
    }
    
    public void fallback_updateField_iright(Integer newVal) {
        this.iright =
          newVal;
    }
    
    public void fallback_updateField_itop(Integer newVal) {
        this.itop =
          newVal;
    }
    
    public void fallback_updateField_centerAnchor(Integer newVal) {
        this.centerAnchor =
          newVal;
    }
    
    public static kodkod.ast.IntExpression xp_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "xp_old" : "xp",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_xp(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().xp);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression yp_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "yp_old" : "yp",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_yp(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().yp);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression wp_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "wp_old" : "wp",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_wp(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().wp);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression hp_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "hp_old" : "hp",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_hp(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().hp);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression gw_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "gw_old" : "gw",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_gw(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().gw);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression gh_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "gh_old" : "gh",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_gh(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().gh);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression ey_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "ey_old" : "ey",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_ey(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().ey);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression ew_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "ew_old" : "ew",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_ew(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().ew);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression eh_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "eh_old" : "eh",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_eh(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().eh);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression ewp_get_log(kodkod.ast.Expression target,
                                                       boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "ewp_old" : "ewp",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_ewp(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                          java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().ewp);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression gx_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "gx_old" : "gx",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_gx(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().gx);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression gy_get_log(kodkod.ast.Expression target,
                                                      boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "gy_old" : "gy",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_gy(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                         java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().gy);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression iright_get_log(kodkod.ast.Expression target,
                                                          boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "iright_old" : "iright",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_iright(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                             java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().iright);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression itop_get_log(kodkod.ast.Expression target,
                                                        boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "itop_old" : "itop",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_itop(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                           java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().itop);
        }
        return res;
    }
    
    public static kodkod.ast.IntExpression centerAnchor_get_log(kodkod.ast.Expression target,
                                                                boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "centerAnchor_old" : "centerAnchor",
                                                             PBJButton.class).sum();
    }
    
    public static polyglot.ext.pbnj.primitives.PBJSet<Integer> setMap_centerAnchor(polyglot.ext.pbnj.primitives.PBJSet<PBJButton> objs,
                                                                                   java.lang.String ... fieldNs) {
        polyglot.ext.pbnj.primitives.PBJSet<Integer> res =
          new polyglot.ext.pbnj.primitives.PBJSet<Integer>();
        java.util.Iterator<PBJButton> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().centerAnchor);
        }
        return res;
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(PBJButton.class);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "xp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "xp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "yp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "yp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "wp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "wp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "hp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "hp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gw",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gw",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gh",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gh",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "ey",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "ey",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "ew",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "ew",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "eh",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "eh",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "ewp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "ewp",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gx",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gx",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gy",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "gy",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "iright",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "iright",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "itop",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "itop",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "centerAnchor",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(PBJButton.class,
                                                              "centerAnchor",
                                                              PBJButton.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
           }
    
    public static kodkod.ast.IntExpression xp_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.xp_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression yp_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.yp_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression wp_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.wp_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression hp_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.hp_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression ey_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.ey_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression ew_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.ew_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression eh_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.eh_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression ewp_log(kodkod.ast.Expression target,
                                                   boolean target_isOld) {
        return PBJButton.ewp_get_log(target,
                                     target_isOld);
    }
    
    public static kodkod.ast.IntExpression gx_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.gx_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression gy_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.gy_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression gw_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.gw_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression gh_log(kodkod.ast.Expression target,
                                                  boolean target_isOld) {
        return PBJButton.gh_get_log(target,
                                    target_isOld);
    }
    
    public static kodkod.ast.IntExpression iright_log(kodkod.ast.Expression target,
                                                      boolean target_isOld) {
        return PBJButton.iright_get_log(target,
                                        target_isOld);
    }
    
    public static kodkod.ast.IntExpression itop_log(kodkod.ast.Expression target,
                                                    boolean target_isOld) {
        return PBJButton.itop_get_log(target,
                                      target_isOld);
    }
    
    public static kodkod.ast.IntExpression centerAnchor_log(kodkod.ast.Expression target,
                                                            boolean target_isOld) {
        return PBJButton.centerAnchor_get_log(target,
                                              target_isOld);
    }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target,
                                                          boolean target_isOld) {
        return kodkod.ast.Formula.TRUE;
    }
}
