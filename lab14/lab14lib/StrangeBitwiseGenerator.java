package lab14lib;

import org.junit.Assert;

public class StrangeBitwiseGenerator implements Generator {
    private int period;
    private int state;

    public StrangeBitwiseGenerator(int val) {
        try {
            Integer.valueOf(val);
            period = val;
            state = 0;
        } catch (NumberFormatException e) {
            Assert.fail("Value '" + val + "' is not an Integer");
        }
    }

    @Override
    public double next() {
        state ++;
        double rs = normalize(state, period);
        return rs;
    }

    private double normalize(int s, int p) {
        double d = (s % p) * 2.0 / (p * 1.0) - 1.0;
        return d;
    }
}
