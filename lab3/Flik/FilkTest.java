import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {

    @Test
    public void testFilk() {
        int a=2,b=3;
        int c=4,d=4;
        assertTrue(Flik.isSameNumber(c,d));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", FilkTest.class);
    }
}
