package lab14lib;

import org.junit.Assert;

public class AcceleratingSawToothGenerator implements Generator {
    private int period;
    private int state;
    private double factor;

    public AcceleratingSawToothGenerator (int val, double factor) {
        try {
            Integer.valueOf(val);
            period = val;
            state = 0;
            this.factor = factor;
        } catch (NumberFormatException e) {
            Assert.fail("Value '" + val + "' is not an Integer");
        }
    }

    @Override
    public double next() {
        state ++;
        if (state % period == 0) {
            period *= factor;
            state = 0;
        }
        return normalize(state);
    }

    private double normalize(int s) {
        double d = (s % period) * 2.0 / (period * 1.0) - 1.0;
        return d;
    }
}
