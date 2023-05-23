import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private int size;

    Node root;

    public Tree() {
        root = null;
    }

    public int size() {
        return size;
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftH = height(root.left);
            int rightH = height(root.right);

            if (leftH > rightH) {
                return leftH + 1;
            } else {
                return rightH + 1;
            }
        }
    }


    public void print(int x) {
        System.out.println(x);
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        print(p.item);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        print(p.item);
        inOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        print(p.item);
    }

    public void leveOrder(Node p) {
        int h = height(root);
        int i;
        for (i = 1;i<=h;i++) {
            printCurLevel(root,i);
        }
    }

    private void printCurLevel(Node p, int level) {
        if (p == null) {
            return;
        }
        if (level == 1) {
            print(p.item);
        } else if (level > 1) {
            printCurLevel(p.left, level - 1);
            printCurLevel(p.right, level - 1);
        }
    }

    public void levelOrderByQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temNode = queue.poll();
            print(temNode.item);

            if (temNode.left != null) {
                queue.add(temNode.left);
            }

            if (temNode.right != null) {
                queue.add(temNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);

        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);

//        t.leveOrder(t.root);
        t.levelOrderByQueue(t.root);
    }
}
