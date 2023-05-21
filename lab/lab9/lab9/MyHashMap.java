package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  @author Your name here
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private static final double MAX_LF = 0.75;

    private ArrayMap<K, V>[] buckets;
    private int size;

    private int loadFactor() {
        return size / buckets.length;
    }

    public MyHashMap() {
        buckets = new ArrayMap[DEFAULT_SIZE];
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        this.size = 0;
        for (int i = 0; i < this.buckets.length; i += 1) {
            this.buckets[i] = new ArrayMap<>();
        }
    }

    /** Computes the hash function of the given key. Consists of
     *  computing the hashcode, followed by modding by the number of buckets.
     *  To handle negative numbers properly, uses floorMod instead of %.
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }

        int numBuckets = buckets.length;
        return Math.floorMod(key.hashCode(), numBuckets);
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        int i = hash(key);
        return buckets[i].get(key);
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        int i = hash(key);
        ArrayMap am = buckets[i];
        if (!am.containsKey(key)){
            size += 1;
        }
        am.put(key,value);
    }

    /**
     * Resize implement
     *
     */

    public MyHashMap(int size) {
        buckets = new ArrayMap[size];
        this.clear();
    }

    private void rezise(int newSize) {
        MyHashMap<K,V> newHashMap = new MyHashMap<K,V>(newSize);
        for (ArrayMap<K,V> am: buckets) {
            for (K key: am) {
                newHashMap.put(key, am.get(key));
            }
        }
        this.buckets = newHashMap.buckets;
        this.size = newHashMap.size;
    }

    public void putResize(K key, V value) {

        if (loadFactor() >= MAX_LF) {
            rezise(size * 2);
        }
        int i = hash(key);
        ArrayMap am = buckets[i];
        if (!am.containsKey(key)){
            size += 1;
        }
        am.put(key,value);
    }


    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        Set<K> ks = new HashSet<K>();
        for(ArrayMap<K,V> am: buckets) {
            ks.addAll(am.keySet());
        };
        return ks;
    }

    /* Removes the mapping for the specified key from this map if exists.
     * Not required for this lab. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        int i = hash(key);
        ArrayMap am = buckets[i];

        if (!am.containsKey(key)) {
            return null;
        }
        size -= 1;

        return (V) am.remove(key);
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for this lab. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }


    public static void main(String[] args) {
        MyHashMap<String, Integer> mhm = new MyHashMap<>();
        mhm.put("a", 1);
        mhm.put("b",2);
        mhm.put("c",3);

        for (String s: mhm.keySet()){
            System.out.println(s);
        }

        mhm.remove("a");
        System.out.println(mhm.get("a"));
        System.out.println(mhm.size);

        Iterator mhmLoop = mhm.iterator();
        System.out.println(mhmLoop.hasNext());

    }
}
