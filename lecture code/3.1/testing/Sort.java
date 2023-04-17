import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdRandom;

public class Sort {
    /** Sort strings destructively */
    public static void sort(String[] x) {
        // find the smallest item;
        // Move it to the front
        // Selection sort the rest (using recursion)
        sort(x, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallesIndex(x,start);
        swap(x,start, smallestIndex);
        sort(x, start + 1);
    }

    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallesIndex(String[] x,int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length;i++){
            int cmp =x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


}