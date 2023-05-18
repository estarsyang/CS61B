/**
 * BST, binary Search Tree
 * For every node X in the tree
 * 1. Every key in the left subtree is less than X's key.
 * 2. Every key in the right subtree is greater than X's key.
 */
public class BST {
    public BST find(BST T, Key sk){
        if (T == null){
            return null;
        }
        if (sk.keyequals(T.label())){
            return T;
        } else if(sk < T.label()) {
            return find(T.left, sk);
        } else {
            return find(T.right, sk);
        }
    }

    public BST insert(BST T, Key ik){
        if(T == null){
            return new BST(ik);
        }
        if(ik < T.label()){
            T.left = insert(T.left, ik);
        } else if(ik > T.label()){
            T.right = insert(T.right, ik);
        }
        return T;
    }
}
