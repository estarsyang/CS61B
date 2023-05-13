import java.sql.Array;

public class demo {
    /**
     * this is for Asymptotic Analysis
     * Execution cost
     * Object: determine if a sorted array contains any duplicates;
     */

    public static boolean dup1(int[] a){
        for (int i=0;i<a.length;i++){
            for (int j=i+1;j<a.length;j++){
                if (a[i]== a[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dup2(int[] a){
        for (int i=0;i<a.length - 1;i++){
            if(a[i] == a[i+1]){
                return true;
            }
        }
        return false;
    }

    public static int[] makeArr(int len, int keyNum){
        int[] arr = new int[len];
        for (int i=0;i<len;i++){
            if (i==keyNum){
                arr[i] = i - 1;
            } else {
                arr[i] = i;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int dupNum = Integer.parseInt(args[1]);
        int[] intArr = makeArr(n,dupNum);
        System.out.println(dup1(intArr));
//        System.out.println(dup2(intArr));


    }
}
