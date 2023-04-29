
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

/**
 * Class to demonstrate how generic methods work in Java.
 */

public class MapHelper {


    /**
     *  Write the following three methods:
     /* get(key): Return item in map if it exists. */
    public static <K,V> V get(Map61B<K, V> sim, K key){
        if(sim.containKey(key)){
            return sim.get(key);
        }
        return null;
    }
     /*  maxKey(): Return max of all keys. Works only if x and y have comparable data */

    public static <K extends Comparable<K>,V> K maxKey(Map61B<K,V> sim){
        List<K> keyList = sim.keys();
        K largest = keyList.get(0);
        for (K k: keyList){
            if (k.compareTo(largest) > 0){
                largest = k;
            }
        }
        return largest;
    }

    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String,Integer>();
        m.put("horse",3);
        m.put("fish",9);
        m.put("house",10);

        Integer actual = MapHelper.get(m,"fish");
        Integer expected = 9;
        assertEquals(expected,actual);

        assertEquals(null, MapHelper.get(m, "sflajldf"));
    }
    @Test
    public void testMaxKey(){
        Map61B<String, Integer> m = new ArrayMap<>();
        m.put("horse",3);
        m.put("fish",9);
        m.put("house",10);

        assertEquals("house", MapHelper.maxKey(m));

    }

}
