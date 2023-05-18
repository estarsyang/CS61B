public class BST {
    int val;
    BST left;
    BST right;
    public BST(int n) {
        val = n;
        left = right = null;
    }

    private int minValue(BST T) {
        if (T == null) {
            return Integer.MIN_VALUE;
        }
        int value = T.val;
        int minL = minValue(T.left);
        int minR = minValue(T.right);
        return Math.min(value,Math.min(minL, minR));
    }

    private int maxValue(BST T) {
        if (T == null) {
            return Integer.MAX_VALUE;
        }
        int value = T.val;
        int maxL = maxValue(T.left);
        int maxR = maxValue(T.right);
        return Math.min(value,Math.min(maxL, maxR));
    }

    public boolean isBST(BST T) {
        int minVal = minValue(T);
        int maxVal = maxValue(T);
        return isBSTHelper(T,minVal,maxVal);
    }

    private boolean isBSTHelper(BST T,int min, int max) {
        if (T == null) {
            return false;
        }
        if (T.val < min || T.val > max) {
            return false;
        } else {
            return isBSTHelper(T.left,min,T.val) && isBSTHelper(T.right,T.val, max);
        }
    }
}
