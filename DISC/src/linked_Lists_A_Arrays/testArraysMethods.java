package linked_Lists_A_Arrays;

public class testArraysMethods {
    public static void checkInsert() {
        int[] input = {5,9,14,15};
        int[] except = {5,9,6,14,15};
        int[] result = ArraysMethods.insert(input,6,2);
        org.junit.Assert.assertArrayEquals(except, result);
    }

    public static void checkReverse() {
        int[] input = {1,2,3};
        int[] except = {3,2,1};
        ArraysMethods.reverse(input);
        org.junit.Assert.assertArrayEquals(except, input);
    }

    public static void checkReplicate() {
        int[] input = {3,2,1};
        int[] except = {3,3,3,2,2,1};
        int[] result = ArraysMethods.replicate(input);
        org.junit.Assert.assertArrayEquals(except, result);
    }

    public static void main(String[] args) {
        checkInsert();
        checkReverse();
        checkReplicate();
    }
}
