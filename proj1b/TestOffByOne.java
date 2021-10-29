import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testequalChars() {
        boolean na = offByOne.equalChars('a', 'b');
        boolean nb = offByOne.equalChars('a', 'c');
        assertTrue(na);
        assertFalse(nb);
    }

//    public static void main(String[] args) {
//        jh61b.junit.TestRunner.runTests("all", TestOffByOne.class);
//    }
    // Your tests go here.
    //Uncomment thisacterComparator interface and OffByOne class. **/
}
