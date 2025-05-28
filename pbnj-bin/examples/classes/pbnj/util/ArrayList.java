package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJSet;

public class ArrayList<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable, polyglot.ext.pbnj.primitives.PBJObject {
    private static final long serialVersionUID =
      8683452581122892189L;
    
    public transient E[] elementData;
    
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
    
    public int indexOf_spec(Object value) {
        PBJSet<Integer> is =
          indexOf_spec_setComprehension_0(value);
        return is.size() ==
                 0 ? -1 : is.get();
    }
    
    public boolean contains_spec(Object value) {
        return indexOf_spec(value) >=
          0;
    }
    
    public PBJSet<E> toPBJSet() {
        return toPBJSet_setComprehension_2();
    }
    
    public boolean add_spec(Object o) {
        return size ==
                 old.size() +
                   1 &&
                 prevElemsUnchanged_spec(this.old.size() -
                                           1) &&
          this.elementData[old.size()] ==
            o;
    }
    
    public boolean remove_spec(Object o) {
        int s =
          old.size();
        boolean has =
          contains_spec(o);
        int idx =
          indexOf_spec(o);
        return (!has ||
                  size ==
                    s -
                      1 &&
                    prevElemsUnchanged_spec(idx -
                                              1) &&
                    prevElemsShifted_spec(idx,
                                          s -
                                            2)) &&
          (!(!has) ||
             unchanged_spec());
    }
    
    public boolean set_spec(int index,
                            Object o) {
        return size ==
                 old.size() &&
                 unchangedExcept_spec(index) &&
          this.elementData[index] ==
            o;
    }
    
    public boolean equals_spec(ArrayList<E> o) {
        return size ==
                 o.size() &&
          equals_spec_univQuantify_3(o);
    }
    
    public boolean prevElemsUnchanged_spec(int upto) {
        return prevElemsUnchanged_spec_univQuantify_4(upto);
    }
    
    public boolean prevElemsShifted_spec(int from,
                                         int upto) {
        return prevElemsShifted_spec_univQuantify_5(from,
                                                    upto);
    }
    
    public boolean unchanged_spec() {
        return this.size() ==
                 old.size() &&
          unchanged_spec_univQuantify_6();
    }
    
    private boolean unchangedExcept_spec(int e) {
        return unchangedExcept_spec_univQuantify_7(e);
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
    
    public ArrayList<E> old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public ArrayList(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean checkInvariants() {
        return this.size() >=
                 0 &&
          toPBJSet().size() ==
            this.size;
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public ArrayList<E> old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public ArrayList<E> fallback_setTypeArgs(String[] args) {
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
            return ((polyglot.ext.pbnj.primitives.PBJObject)
                      cons.newInstance(args)).fallback_setTypeArgs(typeParamNames);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetType,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            fallback_problem.addToClassInstances(this.old,
                                                 ArrayList.class,
                                                 fallback_targetType);
            if (this.elementData !=
                  null)
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null &&
                          this.elementData[i_elementData] instanceof polyglot.ext.pbnj.primitives.PBJObject)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.elementData[i_elementData]).fallback_atomize(fallback_problem,
                                                                             fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(ArrayList.class,
                                                                                                                                                           "E")],
                                                                             null);
        }
    }
    
    public void fallback_relationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                        String fallback_targetType,
                                        String[] fallback_targetTypeArgs) {
        if (!isRelationized(fallback_problem)) {
            this.relationizerStep =
              fallback_problem.relationizerStep();
            if (this.elementData !=
                  null)
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null &&
                          this.elementData[i_elementData] instanceof polyglot.ext.pbnj.primitives.PBJObject)
                        ((polyglot.ext.pbnj.primitives.PBJObject)
                           this.elementData[i_elementData]).fallback_relationizeOld(fallback_problem,
                                                                                    fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(ArrayList.class,
                                                                                                                                                                  "E")],
                                                                                    null);
            for (E e : this)
                if (e !=
                      null &&
                      e instanceof polyglot.ext.pbnj.primitives.PBJObject)
                    ((polyglot.ext.pbnj.primitives.PBJObject)
                       e).fallback_relationizeOld(fallback_problem,
                                                  fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(ArrayList.class,
                                                                                                                                "E")],
                                                  null);
            polyglot.ext.pbnj.tologic.LogMap.instVarRelOld_log0(fallback_targetType,
                                                                "elementData").array_put_log(fallback_problem,
                                                                                             this,
                                                                                             this.elementData);
            polyglot.ext.pbnj.tologic.LogMap.instVarRelOld_log0(fallback_targetType,
                                                                "size").put_log(fallback_problem,
                                                                                this,
                                                                                this.size);
        }
    }
    
    public ArrayList<E> fallback_clone() {
        if (isCloned())
            return old;
        this.clonerStep =
          polyglot.ext.pbnj.tologic.LogMap.clonerStep();
        ArrayList<E> res =
          null;
        try {
            res =
              (ArrayList<E>)
                super.clone();
            res.isOld =
              true;
            this.old =
              res;
            res.old =
              this;
            this.fallback_consistencyLock =
              new Object();
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
                          null &&
                          this.elementData[i_elementData] instanceof polyglot.ext.pbnj.primitives.PBJObject)
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
    
    public E fallback_updateArrayField_elementData(int index,
                                                   E newVal) {
        this.elementData[index] =
          newVal;
        return newVal;
    }
    
    public E[] fallback_updateField_elementData(java.util.ArrayList<E> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.elementData ==
              null ||
              this.elementData.length <
                s)
            this.elementData =
              (E[])
                (new Object[s]);
        while (i <
                 s) {
            this.elementData[i] =
              newVal.get(i);
            i++;
        }
        return this.elementData;
    }
    
    public E[] fallback_updateField_elementData(E[] newVal) {
        return this.elementData =
          newVal;
    }
    
    public int fallback_updateField_size(Integer newVal) {
        return this.size =
          newVal;
    }
    
    public PBJSet<Integer> fieldsClosure_Integer(Object fallback_target,
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
    
    public PBJSet<Integer> indexOf_spec_setComprehension_0(Object value) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   this.size -
                                                                     1)) {
            if (this.elementData[i] ==
                  value)
                res.add(i);
        }
        return res;
    }
    
    public PBJSet<E> toPBJSet_setComprehension_2() {
        PBJSet<E> res =
          new PBJSet<E>();
        for (E e : this.elementData) {
            if (toPBJSet_existQuantify_1(e))
                res.add(e);
        }
        return res;
    }
    
    public boolean toPBJSet_existQuantify_1(E e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   this.size() -
                                                                     1)) {
            if (this.elementData[i] ==
                  e)
                return true;
        }
        return false;
    }
    
    public boolean equals_spec_univQuantify_3(ArrayList<E> o) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   o.size() -
                                                                     1)) {
            if (!(this.elementData[i] ==
                    o.elementData[i]))
                return false;
        }
        return true;
    }
    
    public boolean prevElemsUnchanged_spec_univQuantify_4(int upto) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   upto)) {
            if (!(this.elementData[i] ==
                    this.old.elementData[i]))
                return false;
        }
        return true;
    }
    
    public boolean prevElemsShifted_spec_univQuantify_5(int from,
                                                        int upto) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(from,
                                                                   upto)) {
            if (!(this.elementData[i] ==
                    this.old.elementData[i +
                                           1]))
                return false;
        }
        return true;
    }
    
    public boolean unchanged_spec_univQuantify_6() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   this.old.size() -
                                                                     1)) {
            if (!(this.elementData[i] ==
                    this.old.elementData[i]))
                return false;
        }
        return true;
    }
    
    private boolean unchangedExcept_spec_univQuantify_7(int e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInteger.range(0,
                                                                   this.old.size() -
                                                                     1)) {
            if (!(i ==
                    e ||
                    this.elementData[i] ==
                      this.old.elementData[i]))
                return false;
        }
        return true;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr elementData_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetType,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "elementData",
                                                             fallback_targetType,
                                                             fallback_targetTypeArgs,
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "size",
                                                             fallback_targetType,
                                                             fallback_targetTypeArgs,
                                                             isOld);
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
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(ArrayList.class,
                                                               true,
                                                               "E");
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("elementData",
                                                                     ArrayList.class,
                                                                     "pbnj.util.ArrayList<[E]>",
                                                                     Object.class,
                                                                     "E",
                                                                     null,
                                                                     true,
                                                                     false,
                                                                     true,
                                                                     true,
                                                                     false,
                                                                     false,
                                                                     false);
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("size",
                                                                     ArrayList.class,
                                                                     "pbnj.util.ArrayList<[E]>",
                                                                     Integer.class,
                                                                     "int",
                                                                     null,
                                                                     false,
                                                                     false,
                                                                     false,
                                                                     true,
                                                                     false,
                                                                     false,
                                                                     false);
           }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                             polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                             String fallback_targetType,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetType,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr get_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr index,
                                                                 boolean index_isOld) {
        return ArrayList.elementData_get_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetType,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld).get_log(fallback_problem,
                                                                            index,
                                                                            false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr indexOf_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                     polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                     String fallback_targetType,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean fallback_target_isOld,
                                                                     polyglot.ext.pbnj.tologic.LogExpr value,
                                                                     boolean value_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        polyglot.ext.pbnj.tologic.LogExpr is =
          polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                   polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                     new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)),
                                                                                                                                     fallback_target_isOld,
                                                                                                                                     ArrayList.size_get_log(fallback_problem,
                                                                                                                                                            fallback_target,
                                                                                                                                                            fallback_targetType,
                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                            fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                     fallback_target_isOld),
                                                                                   "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                   new String[] { "java.lang.Integer" },
                                                                                   fallback_target_isOld),
                                                               fallback_var_i,
                                                               ArrayList.elementData_get_log(fallback_problem,
                                                                                             fallback_target,
                                                                                             fallback_targetType,
                                                                                             fallback_targetTypeArgs,
                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                            i,
                                                                                                                            false).eq(value));
        boolean is_isOld =
          false;
        return is.size_log(fallback_problem).eq(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0))).thenElse(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1)).negate(),
                                                                                                                                    is.get_log(fallback_problem));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr contains_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                      String fallback_targetType,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld,
                                                                      polyglot.ext.pbnj.tologic.LogExpr value,
                                                                      boolean value_isOld) {
        return ArrayList.indexOf_spec_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetType,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld,
                                          value,
                                          value_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr toPBJSet_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld) {
        boolean e_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr e =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("e"));
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(ArrayList.elementData_get_log(fallback_problem,
                                                                                                  fallback_target,
                                                                                                  fallback_targetType,
                                                                                                  fallback_targetTypeArgs,
                                                                                                  fallback_target_isOld),
                                                                    e,
                                                                    polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                                                                     polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                                                                       new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                                                       ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                          fallback_targetType,
                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                          fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                       fallback_target_isOld),
                                                                                                                                     "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                                                                     new String[] { "java.lang.Integer" },
                                                                                                                                     fallback_target_isOld),
                                                                                                                 false,
                                                                                                                 "some",
                                                                                                                 fallback_var_i,
                                                                                                                 ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                               fallback_target,
                                                                                                                                               fallback_targetType,
                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                               fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                              i,
                                                                                                                                                                              false).eq(e)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr add_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr o,
                                                                 boolean o_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetType,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetType,
                                                                                   fallback_targetTypeArgs,
                                                                                   true).plus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1)))).and(ArrayList.prevElemsUnchanged_spec_log(fallback_problem,
                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                    fallback_targetType,
                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                    ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                       fallback_targetType,
                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                       true).minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                    fallback_target_isOld)).and(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                              fallback_targetType,
                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                              fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                             ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                fallback_targetType,
                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                true),
                                                                                                                                                                                                                                                                                                             false).eq(o));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr remove_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetType,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld,
                                                                    polyglot.ext.pbnj.tologic.LogExpr o,
                                                                    boolean o_isOld) {
        polyglot.ext.pbnj.tologic.LogExpr s =
          ArrayList.size_log(fallback_problem,
                             fallback_target,
                             fallback_targetType,
                             fallback_targetTypeArgs,
                             true);
        boolean s_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr has =
          ArrayList.contains_spec_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetType,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld,
                                      o,
                                      o_isOld);
        boolean has_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr idx =
          ArrayList.indexOf_spec_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetType,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld,
                                     o,
                                     o_isOld);
        boolean idx_isOld =
          false;
        return has.implies(ArrayList.size_get_log(fallback_problem,
                                                  fallback_target,
                                                  fallback_targetType,
                                                  fallback_targetTypeArgs,
                                                  fallback_target_isOld).eq(s.minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1)))).and(ArrayList.prevElemsUnchanged_spec_log(fallback_problem,
                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                          fallback_targetType,
                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                          idx.minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                          fallback_target_isOld)).and(ArrayList.prevElemsShifted_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                          fallback_targetType,
                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                          fallback_target_isOld,
                                                                                                                                                                                                                                                                          idx,
                                                                                                                                                                                                                                                                          idx_isOld,
                                                                                                                                                                                                                                                                          s.minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(2))),
                                                                                                                                                                                                                                                                          fallback_target_isOld))).and(has.not().implies(ArrayList.unchanged_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                      fallback_targetType,
                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr set_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetType,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr index,
                                                                 boolean index_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr o,
                                                                 boolean o_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetType,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetType,
                                                                                   fallback_targetTypeArgs,
                                                                                   true)).and(ArrayList.unchangedExcept_spec_log(fallback_problem,
                                                                                                                                 fallback_target,
                                                                                                                                 fallback_targetType,
                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                 fallback_target_isOld,
                                                                                                                                 index,
                                                                                                                                 index_isOld)).and(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                 fallback_targetType,
                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                 fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                index,
                                                                                                                                                                                                                false).eq(o));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr equals_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetType,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld,
                                                                    polyglot.ext.pbnj.tologic.LogExpr o,
                                                                    boolean o_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetType,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                                   o,
                                                                                   fallback_targetType,
                                                                                   fallback_targetTypeArgs,
                                                                                   o_isOld)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                                                                                                  polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                    ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                       o,
                                                                                                                                                                                                                                       fallback_targetType,
                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                       o_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                    fallback_target_isOld),
                                                                                                                                                                  "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                                                                                                  new String[] { "java.lang.Integer" },
                                                                                                                                                                  fallback_target_isOld),
                                                                                                                                              false,
                                                                                                                                              "all",
                                                                                                                                              fallback_var_i,
                                                                                                                                              ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetType,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                           i,
                                                                                                                                                                                                           false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                                                   o,
                                                                                                                                                                                                                                                   fallback_targetType,
                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                   o_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                    i,
                                                                                                                                                                                                                                                                    false))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr prevElemsUnchanged_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                String fallback_targetType,
                                                                                String[] fallback_targetTypeArgs,
                                                                                boolean fallback_target_isOld,
                                                                                polyglot.ext.pbnj.tologic.LogExpr upto,
                                                                                boolean upto_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                  new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)),
                                                                                                                                  fallback_target_isOld,
                                                                                                                                  upto,
                                                                                                                                  upto_isOld),
                                                                                "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                new String[] { "java.lang.Integer" },
                                                                                fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            ArrayList.elementData_get_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetType,
                                                                                          fallback_targetTypeArgs,
                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                         i,
                                                                                                                         false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                 fallback_target,
                                                                                                                                                                 fallback_targetType,
                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                 true).get_log(fallback_problem,
                                                                                                                                                                               i,
                                                                                                                                                                               false)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr prevElemsShifted_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                              String fallback_targetType,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr from,
                                                                              boolean from_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr upto,
                                                                              boolean upto_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                  from,
                                                                                                                                  from_isOld,
                                                                                                                                  upto,
                                                                                                                                  upto_isOld),
                                                                                "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                new String[] { "java.lang.Integer" },
                                                                                fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            ArrayList.elementData_get_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetType,
                                                                                          fallback_targetTypeArgs,
                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                         i,
                                                                                                                         false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                 fallback_target,
                                                                                                                                                                 fallback_targetType,
                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                 true).get_log(fallback_problem,
                                                                                                                                                                               i.plus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                               false)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr unchanged_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetType,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean fallback_target_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return ArrayList.size_log(fallback_problem,
                                  fallback_target,
                                  fallback_targetType,
                                  fallback_targetTypeArgs,
                                  fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                               fallback_target,
                                                                               fallback_targetType,
                                                                               fallback_targetTypeArgs,
                                                                               true)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                                                                                           polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                                                                                             new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                                                             ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                fallback_targetType,
                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                true).minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                             fallback_target_isOld),
                                                                                                                                                           "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                                                                                           new String[] { "java.lang.Integer" },
                                                                                                                                                           fallback_target_isOld),
                                                                                                                                       false,
                                                                                                                                       "all",
                                                                                                                                       fallback_var_i,
                                                                                                                                       ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                     fallback_target,
                                                                                                                                                                     fallback_targetType,
                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                    i,
                                                                                                                                                                                                    false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                            fallback_targetType,
                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                            true).get_log(fallback_problem,
                                                                                                                                                                                                                                                          i,
                                                                                                                                                                                                                                                          false))));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr unchangedExcept_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                              String fallback_targetType,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr e,
                                                                              boolean e_isOld) {
        boolean i_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr quantVar_i =
          new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.Variable.unary("i"));
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(quantVar_i.expr());
        polyglot.ext.pbnj.tologic.LogExpr fallback_var_i =
          quantVar_i;
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJSet.toPBJSet_log(fallback_problem,
                                                                                polyglot.ext.pbnj.primitives.PBJInteger.range_log(fallback_problem,
                                                                                                                                  new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0)),
                                                                                                                                  fallback_target_isOld,
                                                                                                                                  ArrayList.size_log(fallback_problem,
                                                                                                                                                     fallback_target,
                                                                                                                                                     fallback_targetType,
                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                     true).minus(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(1))),
                                                                                                                                  fallback_target_isOld),
                                                                                "polyglot.ext.pbnj.primitives.PBJSet<java.lang.Integer>",
                                                                                new String[] { "java.lang.Integer" },
                                                                                fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            i.eq(e).or(ArrayList.elementData_get_log(fallback_problem,
                                                                                                     fallback_target,
                                                                                                     fallback_targetType,
                                                                                                     fallback_targetTypeArgs,
                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                    i,
                                                                                                                                    false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetType,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            true).get_log(fallback_problem,
                                                                                                                                                                                          i,
                                                                                                                                                                                          false))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetType,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean fallback_target_isOld) {
        return ArrayList.size_log(fallback_problem,
                                  fallback_target,
                                  fallback_targetType,
                                  fallback_targetTypeArgs,
                                  fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(kodkod.ast.IntConstant.constant(0))).and(ArrayList.toPBJSet_log(fallback_problem,
                                                                                                                                                                   fallback_target,
                                                                                                                                                                   fallback_targetType,
                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                   fallback_target_isOld).size_log(fallback_problem).eq(ArrayList.size_get_log(fallback_problem,
                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                               fallback_targetType,
                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                               fallback_target_isOld)));
    }
}
