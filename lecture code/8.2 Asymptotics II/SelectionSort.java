public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        int len = arr.length;
        for (int i=0;i < len - 1;i++){
            int minIndex = i;
            for (int j=i+1;j < len;j++){
                if (arr[minIndex] > arr[j] ){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,20,32};
        selectionSort(arr);
        for (int s: arr){
            System.out.println(s);
        }
    }
}
