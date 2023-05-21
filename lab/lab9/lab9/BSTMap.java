package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (key == null) {
            throw new UnsupportedOperationException();
        }
        if (p == null) return null;

        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            return getHelper(key, p.left);
        } else if (cmp > 0){
            return getHelper(key, p.right);
        } else {
            return p.value;
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (key == null) {
            throw new UnsupportedOperationException();
        }
        if (p == null){
            p = new Node(key, value);
            size += 1;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left = putHelper(key,value,p.left);
        } else if (cmp > 0) {
            p.right = putHelper(key,value,p.right);
        } else {
            p.value = value;
        }
        return p;

    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
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
        return keySetHelper(root, ks);
    }

    private Set<K> keySetHelper(Node p, Set<K> ks) {
        if (p == null){
            return null;
        }
        ks.add(p.key);
        keySetHelper(p.left,ks);
        keySetHelper(p.right, ks);
        return ks;
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls remove() with a null key");
        }
        V value = get(key);
        removeHelper(root, key);
        return value;
    }

    private Node removeHelper(Node p, K key) {
        if (p == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left = removeHelper(p.left, key);
        } else if(cmp > 0) {
            p.right = removeHelper(p.right, key);
        }
        // if key is same as root's key.
        // the node to be deleted.

        else {
            // node with only one child or no child
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            }
            // node with two children: get the inorder
            // successor(smallest in the right subtree
            p.key = minNode(p.right).key;
            p.value = minNode(p.right).value;

            // delete the inorder successor
            p.right = removeHelper(p.right, p.key);
        }
        return p;
    }

    public Node minNode(Node p) {
        K minKey = p.key;
        while (p.left != null) {
            minKey = p.left.key;
            p = p.left;
        }
        return p;
    }

    public V removeOpt(K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls remove() with a null key");
        }
        V value = get(key);
        removeOptHelper(root, key);
        return value;
    }
    private Node removeOptHelper(Node p, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(p.key);
        if (cmp < 0) {
            p.left = removeOptHelper(p.left, key);
            return p;
        } else if (cmp > 0) {
            p.right = removeOptHelper(p.right, key);
            return p;
        }
        // p is the node need to remove
        else {
            // one of children is null or no children
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            }
            // both of children exist
            Node succParent = p;

            // find successor
            Node succ = p.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // delete successor, since successor is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // if there is no succ, the assign
            // succ.left to succParent.right.
            if (succParent != p) {
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }
            // copy successor data to root
            p.key = succ.key;
            p.value = succ.value;
            return p;
        }
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        if (key == null || value == null) {
            throw new UnsupportedOperationException("calls remove() with a null key or null value");
        }
        V keyVal = get(key);
        if (keyVal == value) {
            removeHelper(root, key);
            return value;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<K> iterator() {
        // hashSet has iterator function!!
        return keySet().iterator();
    }




    public static void main(String[] args) {
        BSTMap<String, Integer> bstmap = new BSTMap<>();
//        bstmap.put("hello", 5);
//        bstmap.put("cat", 4);
//        bstmap.put("fish", 6);
//        bstmap.put("zebra", 9);

//        System.out.println(bstmap.size());
//        Set<String>  ks =  bstmap.keySet();
//
//        for (String i: ks) {
//            System.out.println(i);
//        }

        bstmap.put("k", 6);
        bstmap.put("e", 5);
        bstmap.put("v", 8);
        bstmap.put("b", 3);
        bstmap.put("g", 4);
        bstmap.put("p", 7);
        bstmap.put("y", 9);

        System.out.println(bstmap.remove("k"));

//        bstmap.removeOpt("k");
        System.out.println("he");

    }
}
