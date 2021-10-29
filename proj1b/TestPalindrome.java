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
    public void testIsPalindorme() {
        String word = "1223221";
        boolean a = palindrome.isPalindrome(word);
        // assertTrue(palindrome.isPalindrome(word));
        String word2 = "23456";
        assertFalse(palindrome.isPalindrome(word2));
    }

    @Test
    public void testIsPalidormeOffByOne() {
        CharacterComparator offByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("amssyuww", offByOne));
        assertTrue(palindrome.isPalindrome("abcdab", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
    }

    //public static void main(String[] args) {
    //    jh61b.junit.TestRunner.runTests("all", TestPalindrome.class);
    //}
    //Uncomment this class once you've created your Palindrome class. */
}
