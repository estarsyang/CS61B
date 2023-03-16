import  org.junit.Test;
import static   org.junit.Assert.*;

public class TestSort {

    // a method to test Sort.sort method.
    @Test
    public static void testSort() {
        String[] input = {"i","hava","an", "egg"};
        String[] expected = {"an", "egg", "hava","i"};

        Sort.sort(input);

        assertArrayEquals(expected, input);

    }

    @Test
    public static void checkFindSmallest() {
        String[] input = {"i","hava","an", "egg"};
        int except = 2;

        int actual = Sort.findSmallest(input,0);
        assertEquals(except, actual);

        String[] input2 = {"there","are","many","pigs"};
        int except2 = 2;

        int actual2 = Sort.findSmallest(input2,2);
        assertEquals(except2, actual2);
    }

    @Test
    public static void checkSwap() {
        String[] input = {"i","hava","an", "egg"};
        int a = 0;
        int b = 2;
        String[] except = {"an","hava","i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(except, input);
    }
}
