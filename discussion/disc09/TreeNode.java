
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int n) {
        val = n;
        left = null;
        right = null;
    }


    public static boolean isBSTBad(TreeNode T) {
        if (T == null) {
            return true;
        } else if (T.left != null && T.left.val > T.val) {
            return false;
        } else if (T.right != null && T.right.val < T.val) {
            return false;
        } else {
            return isBSTBad(T.left) && isBSTBad(T.right);
        }
    }

    public static int minValue(TreeNode T) {
        if (T == null) {
            return Integer.MIN_VALUE;
        }
        int value = T.val;
        int leftMin = minValue(T.left);
        int rightMin = minValue(T.right);
        return Math.min(value, Math.min(leftMin, rightMin));
    }

    public static int maxValue(TreeNode T) {
        if (T == null) {
            return Integer.MAX_VALUE;
        }
        int value = T.val;
        int leftMax = maxValue(T.left);
        int rightMax = maxValue(T.right);
        return Math.max(value, Math.max(leftMax, rightMax));
    }

    public static boolean isBSTGood(TreeNode T) {
        return isBSTHelper(T, minValue(T), maxValue(T));
    }

    public static boolean isBSTHelper(TreeNode T, int min, int max) {
        if (T == null) {
            return false;
        } else if (T.val < min || T.val > max) {
            return false;
        } else {
            return isBSTHelper(T.left, min, T.val) && isBSTHelper(T.right, T.val, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(isBSTBad(root));
    }
}
