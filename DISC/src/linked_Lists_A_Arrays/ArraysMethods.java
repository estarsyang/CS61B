package linked_Lists_A_Arrays;

import java.sql.Array;

public class ArraysMethods {


    public static int[] insert(int[] arr, int item, int position) {
        int size = arr.length;
        int[] result = new int[size + 1];
        position = Math.min(size, position);
        for(int i = 0;i< position;i++) {
            result[i] = arr[i];
        }
        result[position] = item;
        for (int i = position;i< size;i++) {
            result[i+1] = arr[i];
        }
        return result;

    }

    public static void reverse(int[] arr) {
        for(int i=0; i<arr.length / 2;i++) {
            int j = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static  int[] replicate(int[] arr) {
        int total = 0;
        for(int item:arr) {
            total += item;
        }
        int[] result = new int[total];

        int i = 0;
        for(int item:arr) {
            for (int counter = 0; counter < item;counter++) {
                result[i] = item;
                i++;
            }
        }
        return  result;
    }




}
