public class Tree {

    public void preOrder(Tree T) {
        if (T == null) {
            return;
        }
        print(T.key);
        preOrder(T.left);
        preOrder(T.right);
    }

    public void inOrder(Tree T) {
        if (T == null) {
            return;
        }
        inOrder(T.left);
        print(T.key);
        inOrder(T.right);
    }

    public void postOrder(Tree T) {
        if (T == null) {
            return;
        }
        postOrder(T.left);
        postOrder(T.right);
        print(T.key);
    }

    public void leveOrder(Tree T) {
        if (T == null) {
            return;
        }
        print(T.key);

    }
}
