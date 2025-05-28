package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJInternSet;

public class ArrayList<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable, polyglot.ext.pbnj.primitives.PBJInternObject {
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
    
    public boolean valid() {
        return this.size() >=
                 0 &&
          this.size() <=
            this.elementData.length;
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
        PBJInternSet<Integer> is =
          indexOf_spec_setComprehension_0(value);
        return is.size() ==
                 0 ? -1 : is.get();
    }
    
    public boolean contains_spec(Object value) {
        return indexOf_spec(value) >=
          0;
    }
    
    public PBJInternSet<E> toPBJInternSet() {
        return toPBJInternSet_setComprehension_2();
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
          size();
        boolean has =
          old.contains_spec(o);
        int idx =
          old.indexOf_spec(o);
        return has ? s ==
                       old.size() -
                         1 &&
                       prevElemsUnchanged_spec(idx -
                                                 1) &&
                       prevElemsShifted_spec(idx,
                                             s -
                                               1) : unchanged_spec();
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
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public ArrayList(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        polyglot.ext.pbnj.tologic.LogMap.addInstance(ArrayList.class,
                                                     this);
    }
    
    public void addInstanceForProblem(ArrayList toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             ArrayList.class,
                                             "pbnj.util.ArrayList",
                                             fallback_targetTypeArgsStr);
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
    
    public static int classRelationizerStep =
      0;
    
    public static boolean isClassRelationized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return ArrayList.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return ArrayList.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return ArrayList.classClonerStep ==
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
            ArrayList.fallback_classAtomize(fallback_problem,
                                            fallback_targetTypeArgsStr,
                                            fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.elementData !=
                  null)
                for (int i0_elementData =
                       0;
                     i0_elementData <
                       this.elementData.length;
                     i0_elementData++)
                    if (this.elementData[i0_elementData] !=
                          null &&
                          this.elementData[i0_elementData] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.elementData[i0_elementData]).fallback_atomize(fallback_problem,
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
            ArrayList.fallback_classRelationizeOld(fallback_problem,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs);
            if (this.elementData !=
                  null)
                for (int i0_elementData =
                       0;
                     i0_elementData <
                       this.elementData.length;
                     i0_elementData++)
                    if (this.elementData[i0_elementData] !=
                          null &&
                          this.elementData[i0_elementData] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.elementData[i0_elementData]).fallback_relationizeOld(fallback_problem,
                                                                                     "",
                                                                                     null);
            for (E e : this)
                if (e !=
                      null &&
                      e instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                    ((polyglot.ext.pbnj.primitives.PBJInternObject)
                       e).fallback_relationizeOld(fallback_problem,
                                                  fallback_targetTypeArgs[polyglot.ext.pbnj.tologic.LogMap.getTypeVariableIndex(ArrayList.class,
                                                                                                                                "E")],
                                                  null);
            ArrayList.elementData_old_get_log(fallback_problem,
                                              fallback_targetTypeArgsStr,
                                              fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                                     this,
                                                                                     this.elementData);
            ArrayList.size_old_get_log(fallback_problem,
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
            ArrayList.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            ArrayList.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public ArrayList<E> fallback_clone() {
        if (isCloned())
            return old;
        ArrayList<E> res =
          null;
        ArrayList.fallback_classClone();
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
            this.clonerStep =
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            if (this.elementData !=
                  null) {
                res.elementData =
                  (E[])
                    this.elementData.clone();
                for (int i0_elementData =
                       0;
                     i0_elementData <
                       this.elementData.length;
                     i0_elementData++)
                    if (this.elementData[i0_elementData] !=
                          null &&
                          this.elementData[i0_elementData] instanceof polyglot.ext.pbnj.primitives.PBJInternObject) {
                        res.elementData[i0_elementData] =
                          (E)
                            ((polyglot.ext.pbnj.primitives.PBJInternObject)
                               this.elementData[i0_elementData]).fallback_clone();
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr elementData_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                        polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                        String fallback_targetTypeArgsStr,
                                                                        String[] fallback_targetTypeArgs,
                                                                        boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.util.ArrayList",
                                                             fallback_targetTypeArgsStr,
                                                             "elementData",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation elementData_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                String fallback_targetTypeArgsStr,
                                                                                String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.util.ArrayList",
                                                                fallback_targetTypeArgsStr,
                                                                "elementData");
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
              this.elementData.length !=
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(fallback_problem,
                                                             fallback_target,
                                                             "pbnj.util.ArrayList",
                                                             fallback_targetTypeArgsStr,
                                                             "size",
                                                             isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation size_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return polyglot.ext.pbnj.tologic.LogMap.oldFieldGet_log(fallback_problem,
                                                                "pbnj.util.ArrayList",
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
    
    public PBJInternSet<Integer> indexOf_spec_setComprehension_0(Object value) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.size -
                                                                           1)) {
            if (this.elementData[i] ==
                  value)
                res.add(i);
        }
        return res;
    }
    
    public PBJInternSet<E> toPBJInternSet_setComprehension_2() {
        PBJInternSet<E> res =
          new PBJInternSet<E>();
        for (E e : this.elementData) {
            if (toPBJInternSet_existQuantify_1(e))
                res.add(e);
        }
        return res;
    }
    
    public boolean toPBJInternSet_existQuantify_1(E e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.size() -
                                                                           1)) {
            if (this.elementData[i] ==
                  e)
                return true;
        }
        return false;
    }
    
    public boolean equals_spec_univQuantify_3(ArrayList<E> o) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         o.size() -
                                                                           1)) {
            if (!(this.elementData[i] ==
                    o.elementData[i]))
                return false;
        }
        return true;
    }
    
    public boolean prevElemsUnchanged_spec_univQuantify_4(int upto) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         upto)) {
            if (!(this.elementData[i] ==
                    this.old.elementData[i]))
                return false;
        }
        return true;
    }
    
    public boolean prevElemsShifted_spec_univQuantify_5(int from,
                                                        int upto) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(from,
                                                                         upto)) {
            if (!(this.elementData[i] ==
                    this.old.elementData[i +
                                           1]))
                return false;
        }
        return true;
    }
    
    public boolean unchanged_spec_univQuantify_6() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.old.size() -
                                                                           1)) {
            if (!(this.elementData[i] ==
                    this.old.elementData[i]))
                return false;
        }
        return true;
    }
    
    private boolean unchangedExcept_spec_univQuantify_7(int e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
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
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<ArrayList> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<ArrayList> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(ArrayList.class,
                                                               true,
                                                               "E");
               polyglot.ext.pbnj.tologic.LogMap.newGenericInstVarRel("elementData",
                                                                     ArrayList.class,
                                                                     "pbnj.util.ArrayList",
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
                                                                     ArrayList.class,
                                                                     "pbnj.util.ArrayList",
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr valid_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return ArrayList.size_log(fallback_problem,
                                  fallback_target,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs,
                                  fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                   kodkod.ast.IntConstant.constant(0))).and(ArrayList.size_log(fallback_problem,
                                                                                                                                                               fallback_target,
                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                               fallback_target_isOld).lte(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                        fallback_target_isOld).length_get_log(fallback_problem)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                             polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                             String fallback_targetTypeArgsStr,
                                                             String[] fallback_targetTypeArgs,
                                                             boolean fallback_target_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr isEmpty_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs,
                                                                boolean fallback_target_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                      kodkod.ast.IntConstant.constant(0)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr get_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr index,
                                                                 boolean index_isOld) {
        return ArrayList.elementData_get_log(fallback_problem,
                                             fallback_target,
                                             fallback_targetTypeArgsStr,
                                             fallback_targetTypeArgs,
                                             fallback_target_isOld).get_log(fallback_problem,
                                                                            index,
                                                                            false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr indexOf_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                     polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                     String fallback_targetTypeArgsStr,
                                                                     String[] fallback_targetTypeArgs,
                                                                     boolean fallback_target_isOld,
                                                                     polyglot.ext.pbnj.tologic.LogExpr value,
                                                                     boolean value_isOld) {
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
        polyglot.ext.pbnj.tologic.LogExpr is =
          polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                               polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                       fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                       "",
                                                                                                                                                       null,
                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                       new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                             kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                       fallback_target_isOld,
                                                                                                                                                       ArrayList.size_get_log(fallback_problem,
                                                                                                                                                                              fallback_target,
                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                              fallback_target_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                       fallback_target_isOld),
                                                                                               "<java.lang.Integer>",
                                                                                               new String[] { "java.lang.Integer" },
                                                                                               fallback_target_isOld),
                                                               fallback_var_i,
                                                               ArrayList.elementData_get_log(fallback_problem,
                                                                                             fallback_target,
                                                                                             fallback_targetTypeArgsStr,
                                                                                             fallback_targetTypeArgs,
                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                            i,
                                                                                                                            false).eq(value));
        boolean is_isOld =
          false;
        return is.size_log(fallback_problem).eq(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                      kodkod.ast.IntConstant.constant(0))).thenElse(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                          kodkod.ast.IntConstant.constant(1)).negate(),
                                                                                                                                    is.get_log(fallback_problem));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr contains_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld,
                                                                      polyglot.ext.pbnj.tologic.LogExpr value,
                                                                      boolean value_isOld) {
        return ArrayList.indexOf_spec_log(fallback_problem,
                                          fallback_target,
                                          fallback_targetTypeArgsStr,
                                          fallback_targetTypeArgs,
                                          fallback_target_isOld,
                                          value,
                                          value_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                 kodkod.ast.IntConstant.constant(0)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr toPBJInternSet_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                       polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                       String fallback_targetTypeArgsStr,
                                                                       String[] fallback_targetTypeArgs,
                                                                       boolean fallback_target_isOld) {
        boolean e_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr e =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("e"));
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
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(ArrayList.elementData_get_log(fallback_problem,
                                                                                                  fallback_target,
                                                                                                  fallback_targetTypeArgsStr,
                                                                                                  fallback_targetTypeArgs,
                                                                                                  fallback_target_isOld),
                                                                    e,
                                                                    polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                 polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                         fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                         "",
                                                                                                                                                                                                         null,
                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                         new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                         fallback_target_isOld,
                                                                                                                                                                                                         ArrayList.size_log(fallback_problem,
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
                                                                                                                 ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                               fallback_target,
                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                               fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                              i,
                                                                                                                                                                              false).eq(e)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr add_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr o,
                                                                 boolean o_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   true).plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                    kodkod.ast.IntConstant.constant(1)))).and(ArrayList.prevElemsUnchanged_spec_log(fallback_problem,
                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                                                                                    ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                       true).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                         kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                    fallback_target_isOld)).and(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                                                                              fallback_target,
                                                                                                                                                                                                                                                                              fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                              fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                              fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                             ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                true),
                                                                                                                                                                                                                                                                                                             false).eq(o));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr remove_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld,
                                                                    polyglot.ext.pbnj.tologic.LogExpr o,
                                                                    boolean o_isOld) {
        polyglot.ext.pbnj.tologic.LogExpr s =
          ArrayList.size_log(fallback_problem,
                             fallback_target,
                             fallback_targetTypeArgsStr,
                             fallback_targetTypeArgs,
                             fallback_target_isOld);
        boolean s_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr has =
          ArrayList.contains_spec_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      true,
                                      o,
                                      o_isOld);
        boolean has_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr idx =
          ArrayList.indexOf_spec_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     true,
                                     o,
                                     o_isOld);
        boolean idx_isOld =
          false;
        return has.and(s.eq(ArrayList.size_log(fallback_problem,
                                               fallback_target,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs,
                                               true).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                 kodkod.ast.IntConstant.constant(1)))).and(ArrayList.prevElemsUnchanged_spec_log(fallback_problem,
                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                 idx.minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                 fallback_target_isOld)).and(ArrayList.prevElemsShifted_spec_log(fallback_problem,
                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                                                                 idx,
                                                                                                                                                                                                                                                 idx_isOld,
                                                                                                                                                                                                                                                 s.minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                               kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                 fallback_target_isOld))).or(has.not().and(ArrayList.unchanged_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                        fallback_target_isOld)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr set_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr index,
                                                                 boolean index_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr o,
                                                                 boolean o_isOld) {
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   true)).and(ArrayList.unchangedExcept_spec_log(fallback_problem,
                                                                                                                                 fallback_target,
                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                 fallback_target_isOld,
                                                                                                                                 index,
                                                                                                                                 index_isOld)).and(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                 fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                index,
                                                                                                                                                                                                                false).eq(o));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr equals_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld,
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
        return ArrayList.size_get_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                                   o,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   o_isOld)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                              polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                      fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                      "",
                                                                                                                                                                                                                                      null,
                                                                                                                                                                                                                                      fallback_target_isOld,
                                                                                                                                                                                                                                      new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                                      fallback_target_isOld,
                                                                                                                                                                                                                                      ArrayList.size_log(fallback_problem,
                                                                                                                                                                                                                                                         o,
                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                         o_isOld).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                              kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                      fallback_target_isOld),
                                                                                                                                                                              "<java.lang.Integer>",
                                                                                                                                                                              new String[] { "java.lang.Integer" },
                                                                                                                                                                              fallback_target_isOld),
                                                                                                                                              false,
                                                                                                                                              "all",
                                                                                                                                              fallback_var_i,
                                                                                                                                              ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                           i,
                                                                                                                                                                                                           false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                                                   o,
                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                   o_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                    i,
                                                                                                                                                                                                                                                                    false))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr prevElemsUnchanged_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                String fallback_targetTypeArgsStr,
                                                                                String[] fallback_targetTypeArgs,
                                                                                boolean fallback_target_isOld,
                                                                                polyglot.ext.pbnj.tologic.LogExpr upto,
                                                                                boolean upto_isOld) {
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
                                                                                                                                                    upto,
                                                                                                                                                    upto_isOld),
                                                                                            "<java.lang.Integer>",
                                                                                            new String[] { "java.lang.Integer" },
                                                                                            fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            ArrayList.elementData_get_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetTypeArgsStr,
                                                                                          fallback_targetTypeArgs,
                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                         i,
                                                                                                                         false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                 fallback_target,
                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                 true).get_log(fallback_problem,
                                                                                                                                                                               i,
                                                                                                                                                                               false)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr prevElemsShifted_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                              String fallback_targetTypeArgsStr,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr from,
                                                                              boolean from_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr upto,
                                                                              boolean upto_isOld) {
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
                                                                                                                                                    from,
                                                                                                                                                    from_isOld,
                                                                                                                                                    upto,
                                                                                                                                                    upto_isOld),
                                                                                            "<java.lang.Integer>",
                                                                                            new String[] { "java.lang.Integer" },
                                                                                            fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_i,
                                                            ArrayList.elementData_get_log(fallback_problem,
                                                                                          fallback_target,
                                                                                          fallback_targetTypeArgsStr,
                                                                                          fallback_targetTypeArgs,
                                                                                          fallback_target_isOld).get_log(fallback_problem,
                                                                                                                         i,
                                                                                                                         false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                 fallback_target,
                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                 true).get_log(fallback_problem,
                                                                                                                                                                               i.plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                            kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                               false)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr unchanged_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
        return ArrayList.size_log(fallback_problem,
                                  fallback_target,
                                  fallback_targetTypeArgsStr,
                                  fallback_targetTypeArgs,
                                  fallback_target_isOld).eq(ArrayList.size_log(fallback_problem,
                                                                               fallback_target,
                                                                               fallback_targetTypeArgsStr,
                                                                               fallback_targetTypeArgs,
                                                                               true)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                       polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                               fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                               "",
                                                                                                                                                                                                                               null,
                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                               new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                     kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                                               fallback_target_isOld,
                                                                                                                                                                                                                               ArrayList.size_log(fallback_problem,
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
                                                                                                                                       ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                     fallback_target,
                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                    i,
                                                                                                                                                                                                    false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                            true).get_log(fallback_problem,
                                                                                                                                                                                                                                                          i,
                                                                                                                                                                                                                                                          false))));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr unchangedExcept_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                              String fallback_targetTypeArgsStr,
                                                                              String[] fallback_targetTypeArgs,
                                                                              boolean fallback_target_isOld,
                                                                              polyglot.ext.pbnj.tologic.LogExpr e,
                                                                              boolean e_isOld) {
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
                                                                                                                                                    ArrayList.size_log(fallback_problem,
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
                                                            i.eq(e).or(ArrayList.elementData_get_log(fallback_problem,
                                                                                                     fallback_target,
                                                                                                     fallback_targetTypeArgsStr,
                                                                                                     fallback_targetTypeArgs,
                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                    i,
                                                                                                                                    false).eq(ArrayList.elementData_get_log(fallback_problem,
                                                                                                                                                                            fallback_target,
                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                            true).get_log(fallback_problem,
                                                                                                                                                                                          i,
                                                                                                                                                                                          false))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return ArrayList.valid_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld);
    }
}
