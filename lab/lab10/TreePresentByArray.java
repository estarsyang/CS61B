import org.junit.Test;
import static org.junit.Assert.*;
public class TreePresentByArray<K> {
    private K[] keys;
    private int size;
    private int DEFAULTSIZE = 14;

    public int size() {
        return size - 1;
    }


    public TreePresentByArray() {
        keys =(K[]) new String[DEFAULTSIZE];
        size = 1;
    }

    public K get(int i) {
        return keys[i];
    }

    public void insert(K key){
        if (size == 1) {
            keys[1] = key;
            size++;
            return;
        }
        insertHelper(1, key);
    }

    private void insertHelper(int rootIndex, K key) {
        if (keys[rootIndex] == null) {
            keys[rootIndex] = key;
            size++;
            return;
        }
        String rootStr = (String) keys[rootIndex];
        String keyStr = (String) key;
        int cmp = keyStr.compareTo(rootStr);
        if (cmp < 0) {
            insertHelper(2*rootIndex, key);
        } else if (cmp > 0){
            insertHelper(2*rootIndex+1, key);
        } else {
            keys[rootIndex] = key;
        }
    }

    public K parent(K key) {
        int pIdx = parentIndex(key);
        return keys[pIdx];
    }
    private int parentIndex(K key) {
        int kIdx = getKeyIndex(key);
        return kIdx / 2;
    }

    private int getKeyIndex(K key) {
        int i =-1;
        for (i= 1;i<size;i++) {
            if (keys[i] == key) {
                return i;
            }
        }
        return i;
    }

    public boolean contain(K key) {
        return getKeyIndex(key) != -1;
    }





    @Test
    public void TestInsert() {
        TreePresentByArray ta = new TreePresentByArray();
        ta.insert("k");
        ta.insert("e");
        ta.insert("v");
        ta.insert("b");
        ta.insert("g");
        ta.insert("p");
        ta.insert("y");


        assertNull(ta.get(0));
        String rootVal = (String) ta.get(1);
        assertEquals("k", rootVal);
        String minVal = (String) ta.get(4);
        assertEquals("b", minVal);

        K gParent =(K) ta.parent((K) "g");

        assertEquals("e", (String) gParent);

        int sizeNum = ta.size();
        assertEquals(7, sizeNum);

    }
}
