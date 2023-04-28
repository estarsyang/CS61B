import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        String s1 = "cat";
        assertFalse(palindrome.isPalindrome(s1));
        String s2 = "racecar";
        assertTrue(palindrome.isPalindrome(s2));
        String s3 = "acca";
        assertTrue(palindrome.isPalindrome(s3));
        String s4 = "horse";
        assertFalse(palindrome.isPalindrome(s4));
    }

    @Test
    public void testIsOffByOnePalindrome(){
        CharacterComparator offByOne = new OffByOne();
        String s1 = "flake";
        assertTrue(palindrome.isPalindrome(s1,offByOne));
        String s2 = "aba";
        assertFalse(palindrome.isPalindrome(s2,offByOne));
    }
}
