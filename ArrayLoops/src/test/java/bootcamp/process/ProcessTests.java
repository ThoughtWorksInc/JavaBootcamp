package bootcamp.process;

import bootcamp.data.Summary;
import org.junit.Test;

import static java.lang.Double.NaN;
import static org.junit.Assert.*;

public class ProcessTests {

    @Test
    public void testGetSummary() {
        double[] arr = {1.2, 5.5, 7.28, -3.76, -0.01};
        Summary summary = new Processor(arr).process();
        assertEquals(-3.76, summary.getMin(), 0.01);
        assertEquals(7.28, summary.getMax(), 0.01);
        assertEquals(5, summary.getCount(), 1);
        assertEquals(10.21, summary.getSum(), 0.01);
        assertEquals(2.042, summary.getAverage(), 0.001);
    }

    @Test
    public void testGetSummaryEmptyArray() {
        double[] arr = {};
        Summary summary = new Processor(arr).process();
        assertEquals(Double.NaN, summary.getMin(), 0.01);
        assertEquals(Double.NaN, summary.getMax(), 0.01);
        assertEquals(0, summary.getCount(), 1);
        assertEquals(0, summary.getSum(), 0.01);
        assertEquals(Double.NaN, summary.getAverage(), 0.001);
    }

    @Test
    public void testGetValue() {
        double[] arr = {1.2, 5.5, 7.28, -3.76, -0.01};
        assertEquals(1.2, new Processor(arr).getValue(0), 0.01);
        assertEquals(5.5, new Processor(arr).getValue(1), 0.01);
        assertEquals(7.28, new Processor(arr).getValue(2), 0.01);
        assertEquals(-3.76, new Processor(arr).getValue(3), 0.01);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetValueOutOfArrayBounds() {
        double[] arr = {3, 4, 2, 7};
        final double value = new Processor(arr).getValue(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetValueOutOfEmptyArray() {
        double[] arr = {};
        final double value = new Processor(arr).getValue(0);
    }
}
