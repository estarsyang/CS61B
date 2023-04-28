import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN{

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
//    CharacterComparator offByFive = new OffByN();
    static CharacterComparator offByFive = new OffByN(5);

    // Your tests go here.
    @Test
    public void testEqualChars(){
        assertTrue(offByFive.equalChars('a','f'));
        assertTrue(offByFive.equalChars('f','a'));
        assertFalse(offByFive.equalChars('f','h'));
    }

}
