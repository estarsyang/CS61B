//package Map61B;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ArrayMap<K,V> implements Map61B<K,V> {

    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap(){
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size=0;
    }
    /** return index if key exist in ArrayMap, -1 otherwise */
    private int keyIndex(K key){
        for (int i=0;i<size;i++){
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    public boolean containKey(K key){
        int keyIndex = keyIndex(key);
        return keyIndex > -1;
    }

    public void put(K key, V value){
        int keyIndex = keyIndex(key);
        // not exist;
        if(keyIndex == -1){
            keys[size] = key;
            values[size] = value;
            size +=1;
            return;
        }
        values[keyIndex] = value;
    }

    public V get(K key){
        int keyIndex = keyIndex(key);
        return values[keyIndex];
    }

    public int size(){
        return size;
    }
    public List<K> keys(){
        List<K> keyList = new ArrayList<K>();
        for (int i=0;i<size;i++){
            keyList.add(keys[i]);
        }
        return keyList;
    }

    @Test
    public void test(){
        ArrayMap<Integer, Integer> am = new ArrayMap<>();
        am.put(2,5);
        int expected = 5;
        assertEquals((Integer) expected,am.get(2));
    }

    public static void main(String[] args) {
        ArrayMap<String,Integer> m = new ArrayMap<String, Integer>();
        m.put("horse",3);
        m.put("fish",9);
        m.put("house",10);

    }
}
