package pbnj.util;

import polyglot.ext.pbnj.primitives.PBJSet;

public class Vector<E>  extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable, polyglot.ext.pbnj.primitives.PBJObject {
    protected Object[] elementData;
    
    protected int elementCount;
    
    protected int capacityIncrement;
    
    private static final long serialVersionUID =
      -2767605614048989439L;
    
    public Vector(int initialCapacity,
                  int capacityIncrement) {
        super();
        if (initialCapacity <
              0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                                               initialCapacity);
        this.elementData =
          (new Object[initialCapacity]);
        this.capacityIncrement =
          capacityIncrement;
        polyglot.ext.pbnj.tologic.LogMap.addInstance(Vector.class,
                                                     this);
    }
    
    public Vector(int initialCapacity) {
        this(initialCapacity,
             0);
    }
    
    public Vector() {
        this(10);
    }
    
    public Vector(Collection<? extends E> c) {
        super();
        elementCount =
          c.size();
        elementData =
          (new Object[(int)
                        Math.min(elementCount *
                                   110L /
                                   100,
                                 Integer.MAX_VALUE)]);
        c.toArray(elementData);
        polyglot.ext.pbnj.tologic.LogMap.addInstance(Vector.class,
                                                     this);
    }
    
    public synchronized void copyInto(Object[] anArray) {
        System.arraycopy(elementData,
                         0,
                         anArray,
                         0,
                         elementCount);
    }
    
    public synchronized void trimToSize() {
        modCount++;
        int oldCapacity =
          elementData.length;
        if (elementCount <
              oldCapacity) {
            Object[] oldData =
              elementData;
            elementData =
              (new Object[elementCount]);
            System.arraycopy(oldData,
                             0,
                             elementData,
                             0,
                             elementCount);
        }
    }
    
    public synchronized void ensureCapacity(int minCapacity) {
        modCount++;
        ensureCapacityHelper(minCapacity);
    }
    
    private void ensureCapacityHelper(int minCapacity) {
        int oldCapacity =
          elementData.length;
        if (minCapacity >
              oldCapacity) {
            Object[] oldData =
              elementData;
            int newCapacity =
              capacityIncrement >
                0 ? oldCapacity +
                      capacityIncrement : oldCapacity *
                                            2;
            if (newCapacity <
                  minCapacity) {
                newCapacity =
                  minCapacity;
            }
            elementData =
              (new Object[newCapacity]);
            System.arraycopy(oldData,
                             0,
                             elementData,
                             0,
                             elementCount);
        }
    }
    
    public synchronized void setSize(int newSize) {
        modCount++;
        if (newSize >
              elementCount) {
            ensureCapacityHelper(newSize);
        } else {
            for (int i =
                   newSize;
                 i <
                   elementCount;
                 i++) {
                elementData[i] =
                  null;
            }
        }
        elementCount =
          newSize;
    }
    
    public synchronized int capacity() {
        return elementData.length;
    }
    
    public synchronized int size() {
        return elementCount;
    }
    
    public synchronized boolean isEmpty() {
        return elementCount ==
          0;
    }
    
    public Enumeration<E> elements() {
        return new Enumeration<E>() {
            int count =
              0;
            
            public boolean hasMoreElements() {
                return count <
                  elementCount;
            }
            
            public E nextElement() {
                if (count <
                      elementCount) {
                    return (E)
                             elementData[count++];
                }
                throw new NoSuchElementException("Vector Enumeration");
            }
        };
    }
    
    public boolean contains(Object elem) {
        return indexOf(elem,
                       0) >=
          0;
    }
    
    public int indexOf(Object elem) {
        return indexOf(elem,
                       0);
    }
    
    public synchronized int indexOf(Object elem,
                                    int index) {
        if (elem ==
              null) {
            for (int i =
                   index;
                 i <
                   elementCount;
                 i++)
                if (elementData[i] ==
                      null)
                    return i;
        } else {
            for (int i =
                   index;
                 i <
                   elementCount;
                 i++)
                if (elem.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    public synchronized int lastIndexOf(Object elem) {
        return lastIndexOf(elem,
                           elementCount -
                             1);
    }
    
    public synchronized int lastIndexOf(Object elem,
                                        int index) {
        if (index >=
              elementCount)
            throw new IndexOutOfBoundsException(index +
                                                " >= " +
                                                elementCount);
        if (elem ==
              null) {
            for (int i =
                   index;
                 i >=
                   0;
                 i--)
                if (elementData[i] ==
                      null)
                    return i;
        } else {
            for (int i =
                   index;
                 i >=
                   0;
                 i--)
                if (elem.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    public synchronized E elementAt(int index) {
        if (index >=
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " >= " +
                                                     elementCount);
        }
        return (E)
                 elementData[index];
    }
    
    public synchronized E firstElement() {
        if (elementCount ==
              0) {
            throw new NoSuchElementException();
        }
        return (E)
                 elementData[0];
    }
    
    public synchronized E lastElement() {
        if (elementCount ==
              0) {
            throw new NoSuchElementException();
        }
        return (E)
                 elementData[elementCount -
                               1];
    }
    
    public synchronized void setElementAt(E obj,
                                          int index) {
        if (index >=
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " >= " +
                                                     elementCount);
        }
        elementData[index] =
          obj;
    }
    
    public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >=
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " >= " +
                                                     elementCount);
        } else
            if (index <
                  0) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
        int j =
          elementCount -
            index -
          1;
        if (j >
              0) {
            System.arraycopy(elementData,
                             index +
                               1,
                             elementData,
                             index,
                             j);
        }
        elementCount--;
        elementData[elementCount] =
          null;
    }
    
    public synchronized void insertElementAt(E obj,
                                             int index) {
        modCount++;
        if (index >
              elementCount) {
            throw new ArrayIndexOutOfBoundsException(index +
                                                     " > " +
                                                     elementCount);
        }
        ensureCapacityHelper(elementCount +
                               1);
        System.arraycopy(elementData,
                         index,
                         elementData,
                         index +
                           1,
                         elementCount -
                           index);
        elementData[index] =
          obj;
        elementCount++;
    }
    
    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount +
                               1);
        elementData[elementCount++] =
          obj;
    }
    
    public synchronized boolean removeElement(Object obj) {
        modCount++;
        int i =
          indexOf(obj);
        if (i >=
              0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }
    
    public synchronized void removeAllElements() {
        modCount++;
        for (int i =
               0;
             i <
               elementCount;
             i++)
            elementData[i] =
              null;
        elementCount =
          0;
    }
    
    public synchronized Object clone() {
        try {
            Vector<E> v =
              (Vector<E>)
                super.clone();
            v.elementData =
              (new Object[elementCount]);
            System.arraycopy(elementData,
                             0,
                             v.elementData,
                             0,
                             elementCount);
            v.modCount =
              0;
            return v;
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
    
    public synchronized Object[] toArray() {
        Object[] result =
          new Object[elementCount];
        System.arraycopy(elementData,
                         0,
                         result,
                         0,
                         elementCount);
        return result;
    }
    
    public synchronized <T> T[] toArray(T[] a) {
        if (a.length <
              elementCount)
            a =
              (T[])
                java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),
                                                    elementCount);
        System.arraycopy(elementData,
                         0,
                         a,
                         0,
                         elementCount);
        if (a.length >
              elementCount)
            a[elementCount] =
              null;
        return a;
    }
    
    public synchronized E get(int index) {
        if (index >=
              elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        return (E)
                 elementData[index];
    }
    
    public synchronized E get_spec(int index) {
        return (E)
                 elementData[index];
    }
    
    public synchronized E set(int index,
                              E element) {
        if (index >=
              elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object oldValue =
          elementData[index];
        elementData[index] =
          element;
        return (E)
                 oldValue;
    }
    
    public synchronized boolean add(E o) {
        modCount++;
        ensureCapacityHelper(elementCount +
                               1);
        elementData[elementCount++] =
          o;
        return true;
    }
    
    public boolean remove(Object o) {
        return removeElement(o);
    }
    
    public void add(int index,
                    E element) {
        insertElementAt(element,
                        index);
    }
    
    public synchronized E remove(int index) {
        modCount++;
        if (index >=
              elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object oldValue =
          elementData[index];
        int numMoved =
          elementCount -
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
        elementData[--elementCount] =
          null;
        return (E)
                 oldValue;
    }
    
    public void clear() {
        removeAllElements();
    }
    
    public synchronized boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }
    
    public synchronized boolean addAll(Collection<? extends E> c) {
        modCount++;
        Object[] a =
          c.toArray();
        int numNew =
          a.length;
        ensureCapacityHelper(elementCount +
                               numNew);
        System.arraycopy(a,
                         0,
                         elementData,
                         elementCount,
                         numNew);
        elementCount +=
          numNew;
        return numNew !=
          0;
    }
    
    public synchronized boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }
    
    public synchronized boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }
    
    public synchronized boolean addAll(int index,
                                       Collection<? extends E> c) {
        modCount++;
        if (index <
              0 ||
              index >
                elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        Object[] a =
          c.toArray();
        int numNew =
          a.length;
        ensureCapacityHelper(elementCount +
                               numNew);
        int numMoved =
          elementCount -
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
        elementCount +=
          numNew;
        return numNew !=
          0;
    }
    
    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }
    
    public synchronized int hashCode() {
        return super.hashCode();
    }
    
    public synchronized String toString() {
        return super.toString();
    }
    
    public synchronized List<E> subList(int fromIndex,
                                        int toIndex) {
        return Collections.synchronizedList(super.subList(fromIndex,
                                                          toIndex),
                                            this);
    }
    
    protected synchronized void removeRange(int fromIndex,
                                            int toIndex) {
        modCount++;
        int numMoved =
          elementCount -
          toIndex;
        System.arraycopy(elementData,
                         toIndex,
                         elementData,
                         fromIndex,
                         numMoved);
        int newElementCount =
          elementCount -
          (toIndex -
             fromIndex);
        while (elementCount !=
                 newElementCount)
            elementData[--elementCount] =
              null;
    }
    
    private synchronized void writeObject(java.io.ObjectOutputStream s)
          throws java.io.IOException {
        s.defaultWriteObject();
    }
    
    public PBJSet<E> toPBJSet() {
        return toPBJSet_setComprehension_1();
    }
    
    Vector old;
    
    Object result;
    
    public void result(Object r) {
        this.result =
          r;
    }
    
    public Vector(polyglot.ext.pbnj.tologic.LogObjSet dontcare) {
        super();
    }
    
    Object[] resultArray;
    
    public void resultArray(Object[] r) {
        this.resultArray =
          r;
    }
    
    public boolean verifyInvariants() {
        return toPBJSet().size() ==
          size();
    }
    
    long startMethodTime;
    
    public Vector old() {
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
                                                                 Vector.class);
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
                                                             "elementCount_old").put_log(this,
                                                                                         this.elementCount);
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
                                                             "elementCount").put_log(old,
                                                                                     old.elementCount);
        }
    }
    
    public Vector<E> fallback_clone() {
        if (isCloned())
            return this.old;
        Vector<E> res =
          null;
        try {
            this.clonerStep =
              polyglot.ext.pbnj.tologic.LogMap.clonerStep();
            res =
              (Vector<E>)
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
                  (Object[])
                    this.elementData.clone();
                for (int i_elementData =
                       0;
                     i_elementData <
                       this.elementData.length;
                     i_elementData++)
                    if (this.elementData[i_elementData] !=
                          null)
                        res.elementData[i_elementData] =
                          (Object)
                            ((polyglot.ext.pbnj.primitives.PBJObject)
                               this.elementData[i_elementData]).fallback_clone();
            }
            res.elementCount =
              this.elementCount;
        }
        catch (Exception rte) {
            rte.printStackTrace();
            System.exit(1);
        }
        return res;
    }
    
    public void fallback_updateField_elementData(java.util.ArrayList<Object> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.elementData ==
              null)
            this.elementData =
              (new Object[s]);
        while (i <
                 s) {
            this.elementData[i] =
              newVal.get(i);
            i++;
        }
    }
    
    public void fallback_updateField_elementCount(Integer newVal) {
        this.elementCount =
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
        for (E e : (E[])
                     this.elementData) {
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
                                                                     Vector.class);
    }
    
    public static kodkod.ast.IntExpression elementCount_get_log(kodkod.ast.Expression target,
                                                                boolean isOld) {
        return polyglot.ext.pbnj.tologic.LogMap.fieldGet_log(target,
                                                             isOld ? "elementCount_old" : "elementCount",
                                                             Vector.class).sum();
    }
    
    public static PBJSet<Integer> setMap_elementCount(PBJSet<Vector> objs,
                                                      java.lang.String ... fieldNs) {
        PBJSet<Integer> res =
          new PBJSet<Integer>();
        java.util.Iterator<Vector> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().elementCount);
        }
        return res;
    }
    
    static {
               polyglot.ext.pbnj.tologic.LogMap.newClassForLog(Vector.class);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(Vector.class,
                                                              "elementData",
                                                              Vector.class,
                                                              Object.class,
                                                              Object.class,
                                                              false,
                                                              true,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(Vector.class,
                                                              "elementData",
                                                              Vector.class,
                                                              Object.class,
                                                              Object.class,
                                                              false,
                                                              true,
                                                              false,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(Vector.class,
                                                              "elementCount",
                                                              Vector.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              true,
                                                              false,
                                                              false);
               polyglot.ext.pbnj.tologic.LogMap.newInstVarRel(Vector.class,
                                                              "elementCount",
                                                              Vector.class,
                                                              Integer.class,
                                                              Integer.class,
                                                              false,
                                                              false,
                                                              false,
                                                              false,
                                                              false);
           }
    
    public static synchronized kodkod.ast.IntExpression size_log(kodkod.ast.Expression target,
                                                                 boolean target_isOld) {
        return Vector.elementCount_get_log(target,
                                           target_isOld);
    }
    
    public static synchronized kodkod.ast.Expression get_spec_log(kodkod.ast.Expression target,
                                                                  boolean target_isOld,
                                                                  kodkod.ast.IntExpression index,
                                                                  boolean index_isOld) {
        return Vector.elementData_get_log(target,
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
        return polyglot.ext.pbnj.tologic.LogObjSet.setComprehensionOp(Vector.elementData_get_log(target,
                                                                                                 target_isOld),
                                                                      e,
                                                                      polyglot.ext.pbnj.tologic.LogObjSet.quantifyOp(polyglot.ext.pbnj.primitives.PBJInteger.range_log(kodkod.ast.IntConstant.constant(0),
                                                                                                                                                                       target_isOld,
                                                                                                                                                                       Vector.size_log(target,
                                                                                                                                                                                       target_isOld).minus(kodkod.ast.IntConstant.constant(1)),
                                                                                                                                                                       target_isOld),
                                                                                                                     false,
                                                                                                                     "some",
                                                                                                                     fallback_var_i,
                                                                                                                     Vector.elementData_get_log(target,
                                                                                                                                                target_isOld).get_log(i,
                                                                                                                                                                      false).eq(e)));
    }
    
    public static kodkod.ast.Formula verifyInvariants_log(kodkod.ast.Expression target,
                                                          boolean target_isOld) {
        return Vector.toPBJSet_log(target,
                                   target_isOld).size_log().eq(Vector.size_log(target,
                                                                               target_isOld));
    }
}
