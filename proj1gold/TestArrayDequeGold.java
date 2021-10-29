import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testAarryDequeGold() {
        StudentArrayDeque<Integer> st1 = new StudentArrayDeque<>();

        for (int i = 0;i < 10;i++) {
            double numberBewteenOneandZero = StdRandom.uniform();
            if(numberBewteenOneandZero > 0.5) {
                st1.addFirst(i);
            } else {
                st1.addLast(i);
            }
        }
    }
}
