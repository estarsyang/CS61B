/**
 * Traverse "deep nodes" before shallow ones
 * - preorder
 * - inorder
 * - postorder
 *
 *          D
 *       B      F
 *    A    C  E   G
 */
public class DepthFirstTraversals {
    /**
     * preOrder
     * output: D B A C F E G
     */
    public void preOrder(BST x) {
        if (x == null) {
            return;
        }
        preOrder(x.key);
        preOrder(x.left);
        preOrder(x.right);
    }

    /**
     * inOrder
     * output: A B C D E F G
     */

    public void inOrder(BST x) {
        if (x == null) {
            return;
        }
        inOrder(x.left);
        inOrder(x.key);
        inOrder(x.right);
    }

    /**
     * postOrder
     * output: A C B E G F D
     */

    public void postOrder(BST x) {
        if (x == null) {
            return;
        }
        postOrder(x.left);
        postOrder(x.right);
        postOrder(x.key);
    }
}
