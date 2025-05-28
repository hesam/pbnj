package pbnj.examples.primitives;

import polyglot.ext.pbnj.primitives.PBJInternSet;
import polyglot.ext.pbnj.tologic.LogMap;
import java.util.Random;
import pbnj.util.HashSet;
import pbnj.util.Set;
import java.util.Collection;

public class PBJMap<K, V>  implements polyglot.ext.pbnj.primitives.PBJInternObject {
    static final Random rand =
      new Random();
    
    static final int MAX_LENGTH =
      10;
    
    public K[] keys;
    
    public V[] values;
    
    int size;
    
    private int capacity;
    
    public PBJMap() {
        this(MAX_LENGTH);
    }
    
    public PBJMap(int s) {
        super();
        this.capacity =
          s;
        this.keys =
          (K[])
            (new Object[capacity]);
        this.values =
          (V[])
            (new Object[capacity]);
        this.size =
          0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean valid() {
        return this.keys !=
                 null &&
                 this.values !=
                   null &&
                 this.size >=
                   0 &&
                 this.size <=
                   this.keys.length &&
                 this.keys.length ==
                   this.values.length &&
          uniqueKeys();
    }
    
    public boolean nonNullKeys() {
        return nonNullKeys_univQuantify_0();
    }
    
    public boolean uniqueKeys() {
        return uniqueKeys_univQuantify_2();
    }
    
    public PBJInternSet<K> keySet_spec() {
        return keySet_spec_setComprehension_4();
    }
    
    public Collection<K> keySet() {
        java.util.HashSet<K> res =
          new java.util.HashSet<K>();
        for (int i =
               0;
             i <
               size;
             i++)
            res.add(keys[i]);
        return res;
    }
    
    public Collection<V> getValues() {
        java.util.HashSet<V> res =
          new java.util.HashSet<V>();
        for (int i =
               0;
             i <
               size;
             i++)
            res.add(values[i]);
        return res;
    }
    
    public PBJInternSet<V> getValues_spec() {
        return getValues_spec_setComprehension_6();
    }
    
    public boolean containsKey_spec(Object key) {
        return keySet_spec().contains(key);
    }
    
    public boolean containsKey(Object key) {
        for (int i =
               0;
             i <
               size;
             i++)
            if (key.hashCode() ==
                  keys[i].hashCode())
                return true;
        return false;
    }
    
    public V get_spec(K key) {
        int i =
          indexOf((K)
                    key);
        return containsKey_spec(key) ? this.values[i] : null;
    }
    
    public boolean equals_spec(PBJMap<K, V> o) {
        return size ==
                 o.size &&
                 keySet_spec().equals(o.keySet_spec()) &&
          equals_spec_univQuantify_7(o);
    }
    
    public int indexOf(Object key) {
        PBJInternSet<Integer> is =
          indexOf_setComprehension_8(key);
        return is.size() ==
                 0 ? -1 : is.get();
    }
    
    private boolean unchanged() {
        return unchanged_univQuantify_9();
    }
    
    private boolean unchangedExcept(int e) {
        return unchangedExcept_univQuantify_10(e);
    }
    
    private boolean shiftStartingIndex(int e) {
        return shiftStartingIndex_univQuantify_11(e) &&
          shiftStartingIndex_univQuantify_12(e);
    }
    
    public boolean put_spec(K key,
                            V val) {
        return this.old.containsKey_spec(key) ? this.size ==
                                                  this.old.size &&
                                                  unchangedExcept(indexOf(key)) : this.size ==
                                                                                    1 +
                                                                                      this.old.size &&
                                                                                    this.keys[this.old.size] ==
                                                                                      key &&
                                                                                    this.values[this.old.size] ==
                                                                                      val &&
                                                                                    unchanged();
    }
    
    public void put_new_K_V_orig(K key,
                                 V val) {
        
    }
    
    public void put(K key,
                    V val) {
        if (containsKey(key))
            set(key,
                val);
        else
            insert(key,
                   val);
    }
    
    public V get(K key) {
        if (containsKey(key)) {
            return valueAt(key);
        } else {
            System.out.println("key " +
                               key +
                               " not found in: " +
                               this);
            System.out.println("keyset: " +
                               keySet());
            return null;
        }
    }
    
    public boolean remove_spec(K key) {
        return this.old.containsKey_spec(key) ? this.size ==
                                                  this.old.size -
                                                    1 &&
                                                  shiftStartingIndex(old.indexOf(key)) : this.size ==
                                                                                           this.old.size &&
                                                                                           unchanged();
    }
    
    public void remove(K key) {
        if (containsKey(key)) {
            delete(key);
        } else {
            System.out.println("key " +
                               key +
                               " not found in: " +
                               this);
            System.out.println("keyset: " +
                               keySet());
            System.exit(-1);
        }
    }
    
    public void insert(K key,
                       V val) {
        if (size ==
              capacity) {
            this.capacity =
              2 *
                capacity;
            K[] newKeys =
              (K[])
                (new Object[capacity]);
            V[] newValues =
              (V[])
                (new Object[capacity]);
            for (int i =
                   0;
                 i <
                   size;
                 i++) {
                newKeys[i] =
                  keys[i];
                newValues[i] =
                  values[i];
            }
            this.keys =
              newKeys;
            this.values =
              newValues;
        }
        keys[size] =
          key;
        values[size++] =
          val;
    }
    
    public void delete(K key) {
        int idx =
          indexOf(key);
        for (;
             idx <
               size -
                 1;
             idx++) {
            keys[idx] =
              keys[idx +
                     1];
            values[idx] =
              values[idx +
                       1];
        }
        size--;
    }
    
    public void set(K key,
                    V val) {
        int idx =
          indexOf(key);
        values[idx] =
          val;
    }
    
    private V valueAt_spec(K key) {
        int idx =
          indexOf(key);
        return values[idx];
    }
    
    private V valueAt(K key) {
        for (int i =
               0;
             i <
               size;
             i++)
            if (key.hashCode() ==
                  keys[i].hashCode())
                return values[i];
        return null;
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
              keys[i] +
              "->" +
              values[i] +
              " ";
        res +=
          "}";
        return res;
    }
    
    public static void main(String[] args) {
        LogMap.SolverOpt_debugLevel(1);
        LogMap.SolverOpt_IntBitWidth =
          5;
        int SIZE =
          2;
        final PBJMap<Integer, Integer> c =
          new PBJMap<Integer, Integer>();
        System.out.println(c);
        for (int i =
               0;
             i <
               SIZE;
             i++) {
            int v =
              rand.nextInt(10);
            System.out.println("adding " +
                               i +
                               " -> " +
                               v);
            c.put(i,
                  v);
            System.out.println(c);
        }
        c.put_new(11,
                  14);
        System.out.println(c);
    }
    
    public PBJMap<K, V> old;
    
    public boolean fallback_pbnj;
    
    Object fallback_field_result;
    
    public void fallback_field_result(Object r) {
        this.fallback_field_result =
          r;
    }
    
    public PBJMap(polyglot.ext.pbnj.tologic.LogExpr dontcare) {
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
        LogMap.addInstance(PBJMap.class,
                           this);
    }
    
    public void addInstanceForProblem(PBJMap toAdd,
                                      polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                      String fallback_targetTypeArgsStr) {
        fallback_problem.addToClassInstances(toAdd,
                                             PBJMap.class,
                                             "pbnj.examples.primitives.PBJMap",
                                             fallback_targetTypeArgsStr);
    }
    
    long startMethodTime;
    
    boolean isOld;
    
    Object fallback_consistencyLock;
    
    int fallback_updateTime;
    
    public PBJMap<K, V> old() {
        return this.old;
    }
    
    String[] fallback_typeArgs;
    
    public PBJMap<K, V> fallback_setTypeArgs(String[] args) {
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
        return PBJMap.classRelationizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classAtomizerStep =
      0;
    
    public static boolean isClassAtomized(polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        return PBJMap.classAtomizerStep ==
          fallback_problem.relationizerStep();
    }
    
    public static int classClonerStep =
      0;
    
    public static boolean isClassCloned() {
        return PBJMap.classClonerStep ==
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
            return ((polyglot.ext.pbnj.primitives.PBJInternObject)
                      cons.newInstance(args)).fallback_setTypeArgs(typeParamNames);
        }
        catch (Exception rte) {
            rte.printStackTrace();
            return null;
        }
    }
    
    public boolean put_new_K_V_checkContract(K key,
                                             V val) {
        return this.fallback_checkInvariants() &&
                 this.put_new_K_V_checkFieldsInvariants() &&
          put_spec(key,
                   val);
    }
    
    public void put_new_K_V_assertContract(K key,
                                           V val) {
        assert put_new_K_V_checkContract(key,
                                         val);
    }
    
    public void put_new_K_V_commitModel(K key,
                                        V val,
                                        polyglot.ext.pbnj.tologic.LogProblem fallback_problem) {
        fallback_problem.commitModel(this);
    }
    
    polyglot.ext.pbnj.tologic.LogProblem put_new_K_V_planb(K key,
                                                           V val) {
        boolean key_isOld =
          false;
        boolean val_isOld =
          false;
        System.out.println("\n" +
                             (this +
                                (" (" +
                                   (Thread.currentThread() +
                                      (": put_new" +
                                         ") initiated plan b...")))));
        polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
          LogMap.initRelationize();
        String fallback_targetTypeArgsStr =
          "";
        String[] fallback_targetTypeArgs =
          null;
        old.fallback_atomize(fallback_problem,
                             "",
                             null);
        if (key !=
              null &&
              key instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
            ((polyglot.ext.pbnj.primitives.PBJInternObject)
               key).old().fallback_atomize(fallback_problem,
                                           "",
                                           null);
        if (val !=
              null &&
              val instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
            ((polyglot.ext.pbnj.primitives.PBJInternObject)
               val).old().fallback_atomize(fallback_problem,
                                           "",
                                           null);
        fallback_problem.ObjToAtomMap();
        old.fallback_relationizeOld(fallback_problem,
                                    "",
                                    null);
        if (key !=
              null &&
              key instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
            ((polyglot.ext.pbnj.primitives.PBJInternObject)
               key).old().fallback_relationizeOld(fallback_problem,
                                                  "",
                                                  null);
        if (val !=
              null &&
              val instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
            ((polyglot.ext.pbnj.primitives.PBJInternObject)
               val).old().fallback_relationizeOld(fallback_problem,
                                                  "",
                                                  null);
        fallback_problem.initRelations();
        polyglot.ext.pbnj.tologic.LogExpr fallback_target =
          fallback_problem.objToSingletonRelation_log(this);
        boolean fallback_target_isOld =
          false;
        polyglot.ext.pbnj.tologic.LogExpr fallback_formula =
          PBJMap.put_new_K_V_checkContract_log(fallback_problem,
                                               fallback_target,
                                               fallback_targetTypeArgsStr,
                                               fallback_targetTypeArgs,
                                               fallback_target_isOld,
                                               fallback_problem.objToSingletonRelation_log(key),
                                               key_isOld,
                                               fallback_problem.objToSingletonRelation_log(val),
                                               val_isOld);
        boolean isSatisfiable =
          fallback_problem.solve("put_new_K_V",
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
    
    public void put_new(K key,
                        V val) {
        put_new_K_V_ensured(key,
                            val);
    }
    
    public void put_new_K_V_ensured(K key,
                                    V val) {
        initEnsuredMethod();
        if (key !=
              null &&
              key instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
            ((polyglot.ext.pbnj.primitives.PBJInternObject)
               key).fallback_clone();
        if (val !=
              null &&
              val instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
            ((polyglot.ext.pbnj.primitives.PBJInternObject)
               val).fallback_clone();
        try {
            put_new_K_V_orig(key,
                             val);
            put_new_K_V_assertContract(key,
                                       val);
        }
        catch (Throwable rte) {
            {
                rte.printStackTrace();
                polyglot.ext.pbnj.tologic.LogProblem fallback_problem =
                  put_new_K_V_planb(key,
                                    val);
                put_new_K_V_commitModel(key,
                                        val,
                                        fallback_problem);
            }
        }
    }
    
    public boolean put_new_K_V_checkFieldsInvariants() {
        return true &&
          (this.old ==
             null ||
             this.old.fallback_checkInvariants());
    }
    
    public void fallback_atomize(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                 String fallback_targetTypeArgsStr,
                                 String[] fallback_targetTypeArgs) {
        if (!isAtomized(fallback_problem)) {
            this.atomizerStep =
              fallback_problem.relationizerStep();
            PBJMap.fallback_classAtomize(fallback_problem,
                                         fallback_targetTypeArgsStr,
                                         fallback_targetTypeArgs);
            this.addInstanceForProblem(this.old,
                                       fallback_problem,
                                       fallback_targetTypeArgsStr);
            if (this.keys !=
                  null)
                for (int i0_keys =
                       0;
                     i0_keys <
                       this.keys.length;
                     i0_keys++)
                    if (this.keys[i0_keys] !=
                          null &&
                          this.keys[i0_keys] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.keys[i0_keys]).fallback_atomize(fallback_problem,
                                                                "",
                                                                null);
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
            PBJMap.fallback_classRelationizeOld(fallback_problem,
                                                fallback_targetTypeArgsStr,
                                                fallback_targetTypeArgs);
            if (this.keys !=
                  null)
                for (int i0_keys =
                       0;
                     i0_keys <
                       this.keys.length;
                     i0_keys++)
                    if (this.keys[i0_keys] !=
                          null &&
                          this.keys[i0_keys] instanceof polyglot.ext.pbnj.primitives.PBJInternObject)
                        ((polyglot.ext.pbnj.primitives.PBJInternObject)
                           this.keys[i0_keys]).fallback_relationizeOld(fallback_problem,
                                                                       "",
                                                                       null);
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
            PBJMap.keys_old_get_log(fallback_problem,
                                    fallback_targetTypeArgsStr,
                                    fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                           this,
                                                                           this.keys);
            PBJMap.values_old_get_log(fallback_problem,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs).array_put_log(fallback_problem,
                                                                             this,
                                                                             this.values);
            PBJMap.size_old_get_log(fallback_problem,
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
            PBJMap.classAtomizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classRelationizeOld(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                    String fallback_targetTypeArgsStr,
                                                    String[] fallback_targetTypeArgs) {
        if (!isClassRelationized(fallback_problem)) {
            PBJMap.classRelationizerStep =
              fallback_problem.relationizerStep();
        }
    }
    
    public static void fallback_classClone() {
        if (isClassCloned())
            return;
    }
    
    public PBJMap<K, V> fallback_clone() {
        if (isCloned())
            return old;
        PBJMap<K, V> res =
          null;
        PBJMap.fallback_classClone();
        try {
            res =
              (PBJMap<K, V>)
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
            if (this.keys !=
                  null) {
                res.keys =
                  (K[])
                    this.keys.clone();
                for (int i0_keys =
                       0;
                     i0_keys <
                       this.keys.length;
                     i0_keys++)
                    if (this.keys[i0_keys] !=
                          null &&
                          this.keys[i0_keys] instanceof polyglot.ext.pbnj.primitives.PBJInternObject) {
                        res.keys[i0_keys] =
                          (K)
                            ((polyglot.ext.pbnj.primitives.PBJInternObject)
                               this.keys[i0_keys]).fallback_clone();
                    }
            }
            if (this.values !=
                  null) {
                res.values =
                  (V[])
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
                          (V)
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
    
    public static polyglot.ext.pbnj.tologic.LogExpr keys_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "pbnj.examples.primitives.PBJMap",
                                   fallback_targetTypeArgsStr,
                                   "keys",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation keys_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "pbnj.examples.primitives.PBJMap",
                                      fallback_targetTypeArgsStr,
                                      "keys");
    }
    
    public K fallback_updateArrayField_keys(int index,
                                            K newVal) {
        this.keys[index] =
          newVal;
        return newVal;
    }
    
    public K[] fallback_updateField_keys(java.util.ArrayList<K> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.keys ==
              null ||
              this.keys.length !=
                s)
            this.keys =
              (K[])
                (new Object[s]);
        while (i <
                 s) {
            this.keys[i] =
              newVal.get(i);
            i++;
        }
        return this.keys;
    }
    
    public K[] fallback_updateField_keys(K[] newVal) {
        return this.keys =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr values_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                   polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                   String fallback_targetTypeArgsStr,
                                                                   String[] fallback_targetTypeArgs,
                                                                   boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "pbnj.examples.primitives.PBJMap",
                                   fallback_targetTypeArgsStr,
                                   "values",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation values_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                           String fallback_targetTypeArgsStr,
                                                                           String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "pbnj.examples.primitives.PBJMap",
                                      fallback_targetTypeArgsStr,
                                      "values");
    }
    
    public V fallback_updateArrayField_values(int index,
                                              V newVal) {
        this.values[index] =
          newVal;
        return newVal;
    }
    
    public V[] fallback_updateField_values(java.util.ArrayList<V> newVal) {
        int i =
          0;
        int s =
          newVal.size();
        if (this.values ==
              null ||
              this.values.length !=
                s)
            this.values =
              (V[])
                (new Object[s]);
        while (i <
                 s) {
            this.values[i] =
              newVal.get(i);
            i++;
        }
        return this.values;
    }
    
    public V[] fallback_updateField_values(V[] newVal) {
        return this.values =
          newVal;
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr size_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean isOld) {
        return LogMap.fieldGet_log(fallback_problem,
                                   fallback_target,
                                   "pbnj.examples.primitives.PBJMap",
                                   fallback_targetTypeArgsStr,
                                   "size",
                                   isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogRelation size_old_get_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs) {
        return LogMap.oldFieldGet_log(fallback_problem,
                                      "pbnj.examples.primitives.PBJMap",
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
    
    public boolean nonNullKeys_univQuantify_0() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (!(keys[i] !=
                    null))
                return false;
        }
        return true;
    }
    
    public boolean uniqueKeys_univQuantify_2() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (!uniqueKeys_univQuantify_1(i))
                return false;
        }
        return true;
    }
    
    public boolean uniqueKeys_univQuantify_1(int i) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (!(i ==
                    j ||
                    keys[i] !=
                      keys[j]))
                return false;
        }
        return true;
    }
    
    public PBJInternSet<K> keySet_spec_setComprehension_4() {
        PBJInternSet<K> res =
          new PBJInternSet<K>();
        for (K i : (java.util.ArrayList<K>)
                     LogMap.allInstances(LogMap.getGenericParamActualArg(PBJMap.class,
                                                                         "K",
                                                                         fallback_typeArgs))) {
            if (keySet_spec_existQuantify_3(i))
                res.add(i);
        }
        return res;
    }
    
    public boolean keySet_spec_existQuantify_3(K i) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (keys[j] ==
                  i)
                return true;
        }
        return false;
    }
    
    public PBJInternSet<V> getValues_spec_setComprehension_6() {
        PBJInternSet<V> res =
          new PBJInternSet<V>();
        for (V i : (java.util.ArrayList<V>)
                     LogMap.allInstances(LogMap.getGenericParamActualArg(PBJMap.class,
                                                                         "V",
                                                                         fallback_typeArgs))) {
            if (getValues_spec_existQuantify_5(i))
                res.add(i);
        }
        return res;
    }
    
    public boolean getValues_spec_existQuantify_5(V i) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         size -
                                                                           1)) {
            if (values[j] ==
                  i)
                return true;
        }
        return false;
    }
    
    public boolean equals_spec_univQuantify_7(PBJMap<K, V> o) {
        for (K i : keySet_spec()) {
            if (!(get_spec(i) ==
                    o.get_spec(i)))
                return false;
        }
        return true;
    }
    
    public PBJInternSet<Integer> indexOf_setComprehension_8(Object key) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.size -
                                                                           1)) {
            if (this.keys[i] ==
                  key)
                res.add(i);
        }
        return res;
    }
    
    private boolean unchanged_univQuantify_9() {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.old.size -
                                                                           1)) {
            if (!(this.keys[i] ==
                    this.old.keys[i] &&
                    this.values[i] ==
                      this.old.values[i]))
                return false;
        }
        return true;
    }
    
    private boolean unchangedExcept_univQuantify_10(int e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         this.old.size -
                                                                           1)) {
            if (!(i ==
                    e ||
                    this.keys[i] ==
                      this.old.keys[i] &&
                      this.values[i] ==
                        this.old.values[i]))
                return false;
        }
        return true;
    }
    
    private boolean shiftStartingIndex_univQuantify_11(int e) {
        for (int j : polyglot.ext.pbnj.primitives.PBJInternInteger.range(0,
                                                                         e -
                                                                           1)) {
            if (!(this.keys[j] ==
                    this.old.keys[j] &&
                    this.values[j] ==
                      this.old.values[j]))
                return false;
        }
        return true;
    }
    
    private boolean shiftStartingIndex_univQuantify_12(int e) {
        for (int i : polyglot.ext.pbnj.primitives.PBJInternInteger.range(e,
                                                                         this.size -
                                                                           1)) {
            if (!(this.keys[i] ==
                    this.old.keys[i +
                                    1] &&
                    this.values[i] ==
                      this.old.values[i +
                                        1]))
                return false;
        }
        return true;
    }
    
    public static PBJInternSet<Integer> setMap_size(PBJInternSet<PBJMap> objs,
                                                    java.lang.String ... fieldNs) {
        PBJInternSet<Integer> res =
          new PBJInternSet<Integer>();
        java.util.Iterator<PBJMap> i =
          objs.iterator();
        while (i.hasNext()) {
            res.add(i.next().size);
        }
        return res;
    }
    
    public static void fallback_initClassDefs() {
        
    }
    
    static {
               LogMap.newClassForLog(PBJMap.class,
                                     true,
                                     "K",
                                     "V");
               LogMap.newGenericInstVarRel("keys",
                                           PBJMap.class,
                                           "pbnj.examples.primitives.PBJMap",
                                           Object.class,
                                           "K",
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
               LogMap.newGenericInstVarRel("values",
                                           PBJMap.class,
                                           "pbnj.examples.primitives.PBJMap",
                                           Object.class,
                                           "V",
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
               LogMap.newGenericInstVarRel("size",
                                           PBJMap.class,
                                           "pbnj.examples.primitives.PBJMap",
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
        return PBJMap.size_get_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr valid_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                              polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                              String fallback_targetTypeArgsStr,
                                                              String[] fallback_targetTypeArgs,
                                                              boolean fallback_target_isOld) {
        return PBJMap.keys_get_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld).no().not().and(PBJMap.values_get_log(fallback_problem,
                                                                                               fallback_target,
                                                                                               fallback_targetTypeArgsStr,
                                                                                               fallback_targetTypeArgs,
                                                                                               fallback_target_isOld).no().not()).and(PBJMap.size_get_log(fallback_problem,
                                                                                                                                                          fallback_target,
                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                          fallback_target_isOld).gte(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                           kodkod.ast.IntConstant.constant(0)))).and(PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                         fallback_target_isOld).lte(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                        fallback_target_isOld).length_get_log(fallback_problem))).and(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                          fallback_target_isOld).length_get_log(fallback_problem).eq(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           fallback_target_isOld).length_get_log(fallback_problem))).and(PBJMap.uniqueKeys_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               fallback_target_isOld));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr nonNullKeys_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
                                                                                                                                                    PBJMap.size_get_log(fallback_problem,
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
                                                            "all",
                                                            fallback_var_i,
                                                            PBJMap.keys_get_log(fallback_problem,
                                                                                fallback_target,
                                                                                fallback_targetTypeArgsStr,
                                                                                fallback_targetTypeArgs,
                                                                                fallback_target_isOld).get_log(fallback_problem,
                                                                                                               i,
                                                                                                               false).eq(fallback_problem.null_log()).not());
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr uniqueKeys_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
        return polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                            polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                    fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                    "",
                                                                                                                                                    null,
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                          kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                    fallback_target_isOld,
                                                                                                                                                    PBJMap.size_get_log(fallback_problem,
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
                                                            "all",
                                                            fallback_var_i,
                                                            polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                         polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                 fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                 "",
                                                                                                                                                                                                 null,
                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                 new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                       kodkod.ast.IntConstant.constant(0)),
                                                                                                                                                                                                 fallback_target_isOld,
                                                                                                                                                                                                 PBJMap.size_get_log(fallback_problem,
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
                                                                                                         "all",
                                                                                                         fallback_var_j,
                                                                                                         i.eq(j).or(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                        fallback_target,
                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                        fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                       i,
                                                                                                                                                                       false).eq(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                    j,
                                                                                                                                                                                                                                    false)).not())));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr keySet_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(fallback_problem.allInstances_log(fallback_targetTypeArgs[LogMap.getTypeVariableIndex(PBJMap.class,
                                                                                                                                                          "K")],
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
                                                                                                                                                                                                         PBJMap.size_get_log(fallback_problem,
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
                                                                                                                 PBJMap.keys_get_log(fallback_problem,
                                                                                                                                     fallback_target,
                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                    j,
                                                                                                                                                                    false).eq(i)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr getValues_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
        return polyglot.ext.pbnj.tologic.LogExpr.setComprehensionOp(fallback_problem.allInstances_log(fallback_targetTypeArgs[LogMap.getTypeVariableIndex(PBJMap.class,
                                                                                                                                                          "V")],
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
                                                                                                                                                                                                         PBJMap.size_get_log(fallback_problem,
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
                                                                                                                 PBJMap.values_get_log(fallback_problem,
                                                                                                                                       fallback_target,
                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                       fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                      j,
                                                                                                                                                                      false).eq(i)));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr containsKey_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                         polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                         String fallback_targetTypeArgsStr,
                                                                         String[] fallback_targetTypeArgs,
                                                                         boolean fallback_target_isOld,
                                                                         polyglot.ext.pbnj.tologic.LogExpr key,
                                                                         boolean key_isOld) {
        return PBJMap.keySet_spec_log(fallback_problem,
                                      fallback_target,
                                      fallback_targetTypeArgsStr,
                                      fallback_targetTypeArgs,
                                      fallback_target_isOld).contains_log(fallback_problem,
                                                                          key,
                                                                          key_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr get_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr key,
                                                                 boolean key_isOld) {
        polyglot.ext.pbnj.tologic.LogExpr i =
          PBJMap.indexOf_log(fallback_problem,
                             fallback_target,
                             fallback_targetTypeArgsStr,
                             fallback_targetTypeArgs,
                             fallback_target_isOld,
                             key,
                             fallback_target_isOld);
        boolean i_isOld =
          false;
        return PBJMap.containsKey_spec_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           fallback_target_isOld,
                                           key,
                                           key_isOld).thenElse(PBJMap.values_get_log(fallback_problem,
                                                                                     fallback_target,
                                                                                     fallback_targetTypeArgsStr,
                                                                                     fallback_targetTypeArgs,
                                                                                     fallback_target_isOld).get_log(fallback_problem,
                                                                                                                    i,
                                                                                                                    false),
                                                               fallback_problem.null_log());
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
        polyglot.ext.pbnj.tologic.LogExpr i =
          new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                kodkod.ast.Variable.unary("i"));
        return PBJMap.size_get_log(fallback_problem,
                                   fallback_target,
                                   fallback_targetTypeArgsStr,
                                   fallback_targetTypeArgs,
                                   fallback_target_isOld).eq(PBJMap.size_get_log(fallback_problem,
                                                                                 o,
                                                                                 fallback_targetTypeArgsStr,
                                                                                 fallback_targetTypeArgs,
                                                                                 o_isOld)).and(PBJMap.keySet_spec_log(fallback_problem,
                                                                                                                      fallback_target,
                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                      fallback_targetTypeArgs,
                                                                                                                      fallback_target_isOld).equals_log(fallback_problem,
                                                                                                                                                        PBJMap.keySet_spec_log(fallback_problem,
                                                                                                                                                                               o,
                                                                                                                                                                               fallback_targetTypeArgsStr,
                                                                                                                                                                               fallback_targetTypeArgs,
                                                                                                                                                                               o_isOld),
                                                                                                                                                        fallback_target_isOld)).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                 PBJMap.keySet_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                        fallback_target_isOld),
                                                                                                                                                                                                                                                                 "<K>",
                                                                                                                                                                                                                                                                 new String[] { "K" },
                                                                                                                                                                                                                                                                 fallback_target_isOld),
                                                                                                                                                                                                                                 false,
                                                                                                                                                                                                                                 "all",
                                                                                                                                                                                                                                 i,
                                                                                                                                                                                                                                 PBJMap.get_spec_log(fallback_problem,
                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                                                                                     i,
                                                                                                                                                                                                                                                     i_isOld).eq(PBJMap.get_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                     o,
                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                     o_isOld,
                                                                                                                                                                                                                                                                                     i,
                                                                                                                                                                                                                                                                                     i_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr indexOf_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                String fallback_targetTypeArgsStr,
                                                                String[] fallback_targetTypeArgs,
                                                                boolean fallback_target_isOld,
                                                                polyglot.ext.pbnj.tologic.LogExpr key,
                                                                boolean key_isOld) {
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
                                                                                                                                                       PBJMap.size_get_log(fallback_problem,
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
                                                               PBJMap.keys_get_log(fallback_problem,
                                                                                   fallback_target,
                                                                                   fallback_targetTypeArgsStr,
                                                                                   fallback_targetTypeArgs,
                                                                                   fallback_target_isOld).get_log(fallback_problem,
                                                                                                                  i,
                                                                                                                  false).eq(key));
        boolean is_isOld =
          false;
        return is.size_log(fallback_problem).eq(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                      kodkod.ast.IntConstant.constant(0))).thenElse(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                          kodkod.ast.IntConstant.constant(1)).negate(),
                                                                                                                                    is.get_log(fallback_problem));
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
                                                                                                                                                    PBJMap.size_get_log(fallback_problem,
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
                                                            PBJMap.keys_get_log(fallback_problem,
                                                                                fallback_target,
                                                                                fallback_targetTypeArgsStr,
                                                                                fallback_targetTypeArgs,
                                                                                fallback_target_isOld).get_log(fallback_problem,
                                                                                                               i,
                                                                                                               false).eq(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                             fallback_target,
                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                             true).get_log(fallback_problem,
                                                                                                                                                           i,
                                                                                                                                                           false)).and(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                            i,
                                                                                                                                                                                                                            false).eq(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                            true).get_log(fallback_problem,
                                                                                                                                                                                                                                                                          i,
                                                                                                                                                                                                                                                                          false))));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr unchangedExcept_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
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
                                                                                                                                                    PBJMap.size_get_log(fallback_problem,
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
                                                            i.eq(e).or(PBJMap.keys_get_log(fallback_problem,
                                                                                           fallback_target,
                                                                                           fallback_targetTypeArgsStr,
                                                                                           fallback_targetTypeArgs,
                                                                                           fallback_target_isOld).get_log(fallback_problem,
                                                                                                                          i,
                                                                                                                          false).eq(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                        fallback_target,
                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                        true).get_log(fallback_problem,
                                                                                                                                                                      i,
                                                                                                                                                                      false)).and(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                        fallback_target,
                                                                                                                                                                                                        fallback_targetTypeArgsStr,
                                                                                                                                                                                                        fallback_targetTypeArgs,
                                                                                                                                                                                                        fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                       i,
                                                                                                                                                                                                                                       false).eq(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                                       fallback_target,
                                                                                                                                                                                                                                                                       fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                       fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                       true).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                     i,
                                                                                                                                                                                                                                                                                     false)))));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr shiftStartingIndex_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                            polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                            String fallback_targetTypeArgsStr,
                                                                            String[] fallback_targetTypeArgs,
                                                                            boolean fallback_target_isOld,
                                                                            polyglot.ext.pbnj.tologic.LogExpr e,
                                                                            boolean e_isOld) {
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
                                                                                                                                                    e.minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                  kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                    fallback_target_isOld),
                                                                                            "<java.lang.Integer>",
                                                                                            new String[] { "java.lang.Integer" },
                                                                                            fallback_target_isOld),
                                                            false,
                                                            "all",
                                                            fallback_var_j,
                                                            PBJMap.keys_get_log(fallback_problem,
                                                                                fallback_target,
                                                                                fallback_targetTypeArgsStr,
                                                                                fallback_targetTypeArgs,
                                                                                fallback_target_isOld).get_log(fallback_problem,
                                                                                                               j,
                                                                                                               false).eq(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                             fallback_target,
                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                             true).get_log(fallback_problem,
                                                                                                                                                           j,
                                                                                                                                                           false)).and(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                             fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                            j,
                                                                                                                                                                                                                            false).eq(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                            true).get_log(fallback_problem,
                                                                                                                                                                                                                                                                          j,
                                                                                                                                                                                                                                                                          false)))).and(polyglot.ext.pbnj.tologic.LogExpr.quantifyOp(PBJInternSet.toPBJInternSet_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                     polyglot.ext.pbnj.primitives.PBJInternInteger.range_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_problem.class_log(polyglot.ext.pbnj.primitives.PBJInternInteger.class),
                                                                                                                                                                                                                                                                                                                                                                                                                             "",
                                                                                                                                                                                                                                                                                                                                                                                                                             null,
                                                                                                                                                                                                                                                                                                                                                                                                                             fallback_target_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                             e,
                                                                                                                                                                                                                                                                                                                                                                                                                             e_isOld,
                                                                                                                                                                                                                                                                                                                                                                                                                             PBJMap.size_get_log(fallback_problem,
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
                                                                                                                                                                                                                                                                                                                                     "all",
                                                                                                                                                                                                                                                                                                                                     fallback_var_i,
                                                                                                                                                                                                                                                                                                                                     PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                         fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                        i,
                                                                                                                                                                                                                                                                                                                                                                                        false).eq(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                      true).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                    i.plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                    false)).and(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     i,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     false).eq(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     true).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   i.plus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                kodkod.ast.IntConstant.constant(1))),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   false)))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr put_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                 String fallback_targetTypeArgsStr,
                                                                 String[] fallback_targetTypeArgs,
                                                                 boolean fallback_target_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr key,
                                                                 boolean key_isOld,
                                                                 polyglot.ext.pbnj.tologic.LogExpr val,
                                                                 boolean val_isOld) {
        return PBJMap.containsKey_spec_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           true,
                                           key,
                                           key_isOld).and(PBJMap.size_get_log(fallback_problem,
                                                                              fallback_target,
                                                                              fallback_targetTypeArgsStr,
                                                                              fallback_targetTypeArgs,
                                                                              fallback_target_isOld).eq(PBJMap.size_get_log(fallback_problem,
                                                                                                                            fallback_target,
                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                            fallback_targetTypeArgs,
                                                                                                                            true)).and(PBJMap.unchangedExcept_log(fallback_problem,
                                                                                                                                                                  fallback_target,
                                                                                                                                                                  fallback_targetTypeArgsStr,
                                                                                                                                                                  fallback_targetTypeArgs,
                                                                                                                                                                  fallback_target_isOld,
                                                                                                                                                                  PBJMap.indexOf_log(fallback_problem,
                                                                                                                                                                                     fallback_target,
                                                                                                                                                                                     fallback_targetTypeArgsStr,
                                                                                                                                                                                     fallback_targetTypeArgs,
                                                                                                                                                                                     fallback_target_isOld,
                                                                                                                                                                                     key,
                                                                                                                                                                                     key_isOld),
                                                                                                                                                                  fallback_target_isOld))).or(PBJMap.containsKey_spec_log(fallback_problem,
                                                                                                                                                                                                                          fallback_target,
                                                                                                                                                                                                                          fallback_targetTypeArgsStr,
                                                                                                                                                                                                                          fallback_targetTypeArgs,
                                                                                                                                                                                                                          true,
                                                                                                                                                                                                                          key,
                                                                                                                                                                                                                          key_isOld).not().and(PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                   fallback_target_isOld).eq(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                                                                                                                                                                                   kodkod.ast.IntConstant.constant(1)).plus(PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                true))).and(PBJMap.keys_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                               PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   true),
                                                                                                                                                                                                                                                                                                                                                                                                                                                               false).eq(key)).and(PBJMap.values_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         fallback_target_isOld).get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            true),
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        false).eq(val)).and(PBJMap.unchanged_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 fallback_target_isOld))));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr remove_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                    polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                    String fallback_targetTypeArgsStr,
                                                                    String[] fallback_targetTypeArgs,
                                                                    boolean fallback_target_isOld,
                                                                    polyglot.ext.pbnj.tologic.LogExpr key,
                                                                    boolean key_isOld) {
        return PBJMap.containsKey_spec_log(fallback_problem,
                                           fallback_target,
                                           fallback_targetTypeArgsStr,
                                           fallback_targetTypeArgs,
                                           true,
                                           key,
                                           key_isOld).and(PBJMap.size_get_log(fallback_problem,
                                                                              fallback_target,
                                                                              fallback_targetTypeArgsStr,
                                                                              fallback_targetTypeArgs,
                                                                              fallback_target_isOld).eq(PBJMap.size_get_log(fallback_problem,
                                                                                                                            fallback_target,
                                                                                                                            fallback_targetTypeArgsStr,
                                                                                                                            fallback_targetTypeArgs,
                                                                                                                            true).minus(new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                                                                                                                                              kodkod.ast.IntConstant.constant(1)))).and(PBJMap.shiftStartingIndex_log(fallback_problem,
                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                      fallback_target_isOld,
                                                                                                                                                                                                                                                      PBJMap.indexOf_log(fallback_problem,
                                                                                                                                                                                                                                                                         fallback_target,
                                                                                                                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                         true,
                                                                                                                                                                                                                                                                         key,
                                                                                                                                                                                                                                                                         key_isOld),
                                                                                                                                                                                                                                                      true))).or(PBJMap.containsKey_spec_log(fallback_problem,
                                                                                                                                                                                                                                                                                             fallback_target,
                                                                                                                                                                                                                                                                                             fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                             fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                             true,
                                                                                                                                                                                                                                                                                             key,
                                                                                                                                                                                                                                                                                             key_isOld).not().and(PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                      fallback_target,
                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                      fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                      fallback_target_isOld).eq(PBJMap.size_get_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                    true)).and(PBJMap.unchanged_log(fallback_problem,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgsStr,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_targetTypeArgs,
                                                                                                                                                                                                                                                                                                                                                                                                                    fallback_target_isOld))));
    }
    
    private static polyglot.ext.pbnj.tologic.LogExpr valueAt_spec_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                      polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                      String fallback_targetTypeArgsStr,
                                                                      String[] fallback_targetTypeArgs,
                                                                      boolean fallback_target_isOld,
                                                                      polyglot.ext.pbnj.tologic.LogExpr key,
                                                                      boolean key_isOld) {
        polyglot.ext.pbnj.tologic.LogExpr idx =
          PBJMap.indexOf_log(fallback_problem,
                             fallback_target,
                             fallback_targetTypeArgsStr,
                             fallback_targetTypeArgs,
                             fallback_target_isOld,
                             key,
                             key_isOld);
        boolean idx_isOld =
          false;
        return PBJMap.values_get_log(fallback_problem,
                                     fallback_target,
                                     fallback_targetTypeArgsStr,
                                     fallback_targetTypeArgs,
                                     fallback_target_isOld).get_log(fallback_problem,
                                                                    idx,
                                                                    false);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr fallback_checkInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                 polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                 String fallback_targetTypeArgsStr,
                                                                                 String[] fallback_targetTypeArgs,
                                                                                 boolean fallback_target_isOld) {
        return PBJMap.valid_log(fallback_problem,
                                fallback_target,
                                fallback_targetTypeArgsStr,
                                fallback_targetTypeArgs,
                                fallback_target_isOld);
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr put_new_K_V_checkContract_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                  String fallback_targetTypeArgsStr,
                                                                                  String[] fallback_targetTypeArgs,
                                                                                  boolean fallback_target_isOld,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr key,
                                                                                  boolean key_isOld,
                                                                                  polyglot.ext.pbnj.tologic.LogExpr val,
                                                                                  boolean val_isOld) {
        return PBJMap.fallback_checkInvariants_log(fallback_problem,
                                                   fallback_target,
                                                   fallback_targetTypeArgsStr,
                                                   fallback_targetTypeArgs,
                                                   fallback_target_isOld).and(PBJMap.put_new_K_V_checkFieldsInvariants_log(fallback_problem,
                                                                                                                           fallback_target,
                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                           fallback_targetTypeArgs,
                                                                                                                           fallback_target_isOld)).and(PBJMap.put_spec_log(fallback_problem,
                                                                                                                                                                           fallback_target,
                                                                                                                                                                           fallback_targetTypeArgsStr,
                                                                                                                                                                           fallback_targetTypeArgs,
                                                                                                                                                                           fallback_target_isOld,
                                                                                                                                                                           key,
                                                                                                                                                                           key_isOld,
                                                                                                                                                                           val,
                                                                                                                                                                           val_isOld));
    }
    
    public static polyglot.ext.pbnj.tologic.LogExpr put_new_K_V_checkFieldsInvariants_log(polyglot.ext.pbnj.tologic.LogProblem fallback_problem,
                                                                                          polyglot.ext.pbnj.tologic.LogExpr fallback_target,
                                                                                          String fallback_targetTypeArgsStr,
                                                                                          String[] fallback_targetTypeArgs,
                                                                                          boolean fallback_target_isOld) {
        return new polyglot.ext.pbnj.tologic.LogExpr(fallback_problem,
                                                     kodkod.ast.Formula.TRUE).and(fallback_target.eq(fallback_problem.null_log()).or(PBJMap.fallback_checkInvariants_log(fallback_problem,
                                                                                                                                                                         fallback_target,
                                                                                                                                                                         fallback_targetTypeArgsStr,
                                                                                                                                                                         fallback_targetTypeArgs,
                                                                                                                                                                         true)));
    }
}
