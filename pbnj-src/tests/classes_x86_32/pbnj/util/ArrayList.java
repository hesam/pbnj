package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJSet;

public class ArrayList<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable, polyglot.ext.pbnj.primitives.PBJObject {
    private static final long serialVersionUID =
      8683452581122892189L;
    
    transient E[] elementData;
    
    private int size;
    
    public ArrayList(int initialCapacity) {
        super();
        if (initialCapacity <
              0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                                               initialCapacity);
        this.elementData =
          (E[])
            (new Object[initialCapacity]);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(ArrayList.class,
                                                     this);
    }
    
    public ArrayList() {
        this(10);
    }
    
    public ArrayList(Collection<? extends E> c) {
        super();
        size =
          c.size();
        elementData =
          (E[])
            (new Object[(int)
                          Math.min(size *
                                     110L /
                                     100,
                                   Integer.MAX_VALUE)]);
        c.toArray(elementData);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(ArrayList.class,
                                                     this);
    }
    
    public void trimToSize() {
        modCount++;
        int oldCapacity =
          elementData.length;
        if (size <
              oldCapacity) {
            Object[] oldData =
              elementData;
            elementData =
              (E[])
                (new Object[size]);
            System.arraycopy(oldData,
                             0,
                             elementData,
                             0,
                             size);
        }
    }
    
    public void ensureCapacity(int minCapacity) {
        modCount++;
        int oldCapacity =
          elementData.length;
        if (minCapacity >
              oldCapacity) {
            Object[] oldData =
              elementData;
            int newCapacity =
              oldCapacity *
                3 /
                2 +
              1;
            if (newCapacity <
                  minCapacity)
                newCapacity =
                  minCapacity;
            elementData =
              (E[])
                (new Object[newCapacity]);
            System.arraycopy(oldData,
                             0,
                             elementData,
                             0,
                             size);
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size ==
          0;
    }
    
    public boolean contains(Object elem) {
        return indexOf(elem) >=
          0;
    }
    
    public int indexOf(Object elem) {
        if (elem ==
              null) {
            for (int i =
                   0;
                 i <
                   size;
                 i++)
                if (elementData[i] ==
                      null)
                    return i;
        } else {
            for (int i =
                   0;
                 i <
                   size;
                 i++)
                if (elem.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    public int lastIndexOf(Object elem) {
        if (elem ==
              null) {
            for (int i =
                   size -
                   1;
                 i >=
                   0;
                 i--)
                if (elementData[i] ==
                      null)
                    return i;
        } else {
            for (int i =
                   size -
                   1;
                 i >=
                   0;
                 i--)
                if (elem.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    public Object clone() {
        try {
            ArrayList<E> v =
              (ArrayList<E>)
                super.clone();
            v.elementData =
              (E[])
                (new Object[size]);
            System.arraycopy(elementData,
                             0,
                             v.elementData,
                             0,
                             size);
            v.modCount =
              0;
            return v;
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
    
    public Object[] toArray() {
        Object[] result =
          new Object[size];
        System.arraycopy(elementData,
                         0,
                         result,
                         0,
                         size);
        return result;
    }
    
    public <T> T[] toArray(T[] a) {
        if (a.length <
              size)
            a =
              (T[])
                java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),
                                                    size);
        System.arraycopy(elementData,
                         0,
                         a,
                         0,
                         size);
        if (a.length >
              size)
            a[size] =
              null;
        return a;
    }
    
    public E get(int index) {
        RangeCheck(index);
        return elementData[index];
    }
    
    public E get_spec(int index) {
        return elementData[index];
    }
    
    public PBJSet<E> toPBJSet() {
        return toPBJSet_setComprehension_1();
    }
    
    public E set(int index,
                 E element) {
        RangeCheck(index);
        E oldValue =
          elementData[index];
        elementData[index] =
          element;
        return oldValue;
    }
    
    public boolean add(E o) {
        ensureCapacity(size +
                         1);
        elementData[size++] =
          o;
        return true;
    }
    
    public void add(int index,
                    E element) {
        if (index >
              size ||
              index <
                0)
            throw new IndexOutOfBoundsException("Index: " +
                                                index +
                                                ", Size: " +
                                                size);
        ensureCapacity(size +
                         1);
        System.arraycopy(elementData,
                         index,
                         elementData,
                         index +
                           1,
                         size -
                           index);
        elementData[index] =
          element;
        size++;
    }
    
    public E remove(int index) {
        RangeCheck(index);
        modCount++;
        E oldValue =
          elementData[index];
        int numMoved =
          size -
            index -
          1;
        if (numMoved >
              0)
            System.arraycopy(elementData,
                             index +
                               1,
                             elementData,
                             index,
                             numMoved);
        elementData[--size] =
          null;
        return oldValue;
    }
    
    public boolean remove(Object o) {
        if (o ==
              null) {
            for (int index =
                   0;
                 index <
                   size;
                 index++)
                if (elementData[index] ==
                      null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index =
                   0;
                 index <
                   size;
                 index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
    
    private void fastRemove(int index) {
        modCount++;
        int numMoved =
          size -
            index -
          1;
        if (numMoved >
              0)
            System.arraycopy(elementData,
                             index +
                               1,
                             elementData,
                             index,
                             numMoved);
        elementData[--size] =
          null;
    }
    
    public void clear() {
        modCount++;
        for (int i =
               0;
             i <
               size;
             i++)
            elementData[i] =
              null;
        size =
          0;
    }
    
    public boolean addAll(Collection<? extends E> c) {
        Object[] a =
          c.toArray();
        int numNew =
          a.length;
        ensureCapacity(size +
                         numNew);
        System.arraycopy(a,
                         0,
                         elementData,
                         size,
                         numNew);
        size +=
          numNew;
        return numNew !=
          0;
    }
    
    public boolean addAll(int index,
                          Collection<? extends E> c) {
        if (index >
              size ||
              index <
                0)
            throw new IndexOutOfBoundsException("Index: " +
                                                index +
                                                ", Size: " +
                                                size);
        Object[] a =
          c.toArray();
        int numNew =
          a.length;
        ensureCapacity(size +
                         numNew);
        int numMoved =
          size -
          index;
        if (numMoved >
              0)
            System.arraycopy(elementData,
                             index,
                             elementData,
                             index +
                               numNew,
                             numMoved);
        System.arraycopy(a,
                         0,
                         elementData,
                         index,
                         numNew);
        size +=
          numNew;
        return numNew !=
          0;
    }
    
    protected void removeRange(int fromIndex,
                               int toIndex) {
        modCount++;
        int numMoved =
          size -
          toIndex;
        System.arraycopy(elementData,
                         toIndex,
                         elementData,
                         fromIndex,
                         numMoved);
        int newSize =
          size -
          (toIndex -
             fromIndex);
        while (size !=
                 newSize)
            elementData[--size] =
              null;
    }
    
    private void RangeCheck(int index) {
        if (index >=
              size)
            throw new IndexOutOfBoundsException("Index: " +
                                                index +
                                                ", Size: " +
                                                size);
    }
    
    private void writeObject(java.io.ObjectOutputStream s)
          throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(elementData.length);
        for (int i =
               0;
             i <
               size;
             i++)
            s.writeObject(elementData[i]);
    }
    
    private void readObject(java.io.ObjectInputStream s)
          throws java.io.IOException,
        ClassNotFoundException {
        s.defaultReadObject();
        int arrayLength =
          s.readInt();
        Object[] a =
          elementData =
          (E[])
            (new Object[arrayLength]);
        for (int i =
               0;
             i <
               size;
             i++)
            a[i] =
              s.readObject();
    }
    
    ArrayList old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public ArrayList(polyglot.ext.pbnj.tologic.LogObjSet dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean verifyInvariants() {
        return toPBJSet().size() ==
          this.size;
    }
    
    long startMethodTime;
    
    public ArrayList old() {
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
                                                                 ArrayList.class);
            if (this.elementData !=
                  null)
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.elementData[i_elementData]).fallback_atomize();
        }
    }
    
    public void fallback_relationizeOld() {
        if (!isRelationized()) {
            this.relationizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            if (this.elementData !=
                  null)
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.elementData[i_elementData]).fallback_relationizeOld();
            for (E e : this)
                if (e !=
                      null)
                    ((polyglot.ext.pbnj.primitives.PBJObject)
                       e).fallback_relationizeOld();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "elementData_old").array_put_log(this,
                                                                                              this.elementData);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "size_old").put_log(this,
                                                                                 this.size);
        }
    }
    
    public void fallback_relationize() {
        if (!old.isRelationized()) {
            old.relationizerStep =
              polyglot.ext.pbnj.tologic.LogMap.relationizerStep();
            if (this.elementData !=
                  null)
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.elementData[i_elementData]).fallback_relationize();
            for (E e : this)
                if (e !=
                      null)
                    ((polyglot.ext.pbnj.primitives.PBJObject)
                       e).fallback_relationize();
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "elementData").array_put_log(old,
                                                                                          old.elementData);
            polyglot.ext.pbnj.tologic.LogMap.instVarRel_log0(this,
                                                             "size").put_log(old,
                                                                             old.size);
        }
    }
    
    public ArrayList<E> fallback_clone() {
        if (isCloned())
            return this.old;
        ArrayList<E> res =
          null;
        try {
            this.clonerStep =
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            res =
              (ArrayList<E>)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            if (this.elementData !=
                  null) {
                res.elementData =
                  (E[])
                    this.elementData.clone();
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null)
                        res.elementData[i_elementData] =
                          (E)
                            ((polyglot.ext.pbnj.primitives.PBJObject)
                               this.elementData[i_elementData]).fallback_clone();
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
    
    public void fallback_updateField_elementData(java.util.ArrayList<E> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.elementData ==
              null)
            this.elementData =
              (E[])
                (new Object[s]);
        while (i <
                 s) {
            this.elementData[i] =
              newVal.get(i);
            i++;
        }
    }
    
    public void fallback_updateField_size(Integer newVal) {
        this.size =
          newVal;
    }
    
    public PBJSet<Integer> fieldsClosure_Integer(Object target,
                                                 boolean isReflexive,
                                                 java.lang.String ... fieldNs) {
        Class c =
          int.class;
        PBJSet<Integer> res =
          new PBJSet<Integer>();
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
    
    PBJSet<Integer> multiFields_Integer(java.lang.String ... fieldNs) {
        Class c =
          Integer.class;
        PBJSet<Integer> res =
          new PBJSet<Integer>();
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
    
    public PBJSet<E> toPBJSet_setComprehension_1() {
        PBJSet<E> res =
          new PBJSet<E>();
        for (E e : this.elementData) {
            if (toPBJSet_existQuantify_0(e))
                res.add(e);
        }
        return res;
    }
    
    public boolean toPBJSet_existQuantify_0(E e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   this.size() -
                                                                     1)) {
            if (this.elementData[i] ==
                  e)
                return true;
        }
        return false;
    }
    
    public static polyglot.ext.pbnj.tologic.LogObjSet elementData_get_log(kodkod.ast.Expression target,
                                                                          boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_obj_set_log(target,
                                                                     isOld ? "elementData_old" : "elementData",
                                                                     ArrayList.class);
    }
    
    public static kodkod.ast.IntExpression size_get_log(kodkod.ast.Expression target,
                                                        boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "size_old" : "size",
                                                             ArrayList.class).sum();
    }
    
    public static PBJSet<Integer> setMap_size(PBJSet<ArrayList> objs,
                                              java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<ArrayList> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(ArrayList.class);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(ArrayList.class,
                                                              "elementData",
                                                              ArrayList.class,
                                                              Object.class,
                                                              Object.class,
                                                              false,
                                                              true,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(ArrayList.class,
                                                              "elementData",
                                                              ArrayList.class,
                                                              Object.class,
                                                              Object.class,
                                                              false,
                                                              true,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(ArrayList.class,
                                                              "size",
                                                              ArrayList.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(ArrayList.class,
                                                              "size",
                                                              ArrayList.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
           }
    
    public static kodkod.ast.IntExpression size_log(kodkod.ast.Expression target,
                                                    boolean target_isOld) {
        return ArrayList.size_get_log(target,
                                      target_isOld);
    }
    
    public static kodkod.ast.Expression get_spec_log(kodkod.ast.Expression target,
                                                     boolean target_isOld,
                                                     kodkod.ast.IntExpression index,
                                                     boolean index_isOld) {
        return ArrayList.elementData_get_log(target,
                                             target_isOld).get_log(index,
                                                                   false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogObjSet toPBJSet_log(kodkod.ast.Expression target,
                                                                   boolean target_isOld) {
        boolean e_isOld =
          false;
        kodkod.ast.Expression e =
          kodkod.ast.Variable.unary("e");
        boolean i_isOld =
          false;
        kodkod.ast.Variable quantVar_i =
          kodkod.ast.Variable.unary("i");
        kodkod.ast.IntExpression i =
          quantVar_i.sum();
        kodkod.ast.Expression fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogObjSet.setComprehensionOp(ArrayList.elementData_get_log(target,
                                                                                                    target_isOld),
                                                                      e,
                                                                      polyglot.ext.pbnj.tologic.LogObjSet.quantifyOp(polyglot.ext.pbnj.primitives.PBJInteger.range_log(kodkod.ast.IntConstant.constant(0),
                                                                                                                                                                       target_isOld,
                                                                                                                                                                       ArrayList.size_log(target,
                                                                                                                                                                                          target_isOld).minus(kodkod.ast.IntConstant.constant(1)),
                                                                                                                                                                       target_isOld),
                                                                                                                     false,
                                                                                                                     "some",
                                                                                                                     fallback_var_i,
                                                                                                                     ArrayList.elementData_get_log(target,
                                                                                                                                                   target_isOld).get_log(i,
                                                                                                                                                                         false).eq(e)));
    }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target,
                                                          boolean target_isOld) {
        return ArrayList.toPBJSet_log(target,
                                      target_isOld).size_log().eq(ArrayList.size_get_log(target,
                                                                                         target_isOld));
    }
}
