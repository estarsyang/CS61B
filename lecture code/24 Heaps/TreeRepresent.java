import java.security.Key;

/**
 * Represent one tree.
 * for example
 *      w
 *   x  y  z
 */
public class TreeRepresent {
    /** fixed-width nodes. */
    public class Tree1A<Key> {
        Key k;
        Tree1A left;
        Tree1A middle;
        Tree1A right;
        // ....

    }

    /** create mapping from node to children. */
    public class Tree1B<Key> {
        Key k;
        Tree1B[] children;
    }

    /** create mapping from node to children. */
    public class Tree1C<Key> {
        Key k;
        Tree1C favoredChild;
        Tree1C sibling;
    }

    /** store keys in an array, store parenetIDS in an array, like disjointSet. */
    public class Tree2<Key> {
        Key[] key;
        int[] parents;
        //...
    }

}
