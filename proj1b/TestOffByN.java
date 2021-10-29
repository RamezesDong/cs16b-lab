import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    OffByN offByN = new OffByN(5);
    @Test
    public void testequalChars() {
        boolean na = offByN.equalChars('a', 'f');
        boolean nb = offByN.equalChars('a', 'c');
        assertTrue(na);
        assertFalse(nb);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestOffByOne.class);
    }
}
