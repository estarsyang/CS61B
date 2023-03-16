public class Sort {
    public static void sort(String[] x){
        // Find the smallest item
        // Move it to the front
        // Selection sort the rest

        sort(x, 0);
    }

    /** Sorts x starting at position start */
    public static void sort(String[] x, int start) {
        if(start == x.length) {
            return;
        }
        int smallestIndex = findSmallest(x,start );
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /** Swap item a with b. */
    public static void swap(String[] x,int a,int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }


    /** Return the smallest String in x. */
    public static int findSmallest(String[] x,int start) {
        int smallestIndex = start;
        for (int i= start;i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if(cmp < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
