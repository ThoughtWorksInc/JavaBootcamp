package bootcamp.process;

import bootcamp.data.Summary;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProcessTests {
    public static double[] array = {3, 123, 1.3, 4, -1.2};

    @Test
    public void testGetSummary() {
        final Processor processor = new Processor(array);
        Summary summary = processor.process();
        assertTrue(summary instanceof Summary);
        assertEquals(summary.getMin(), -1.2, .01);
        assertEquals(summary.getMax(), 123, .01);
        assertEquals(summary.getSum(), 130.1, .01);
        assertEquals(summary.getCount(), 5, .01);
        assertEquals(summary.getAverage(), 26.02, .01);
    }

    @Test
    public void testGetSummaryEmptyArray() {
        final Processor processor = new Processor(new double[0]);
        Summary summary = processor.process();
        assertEquals(summary.getMin(), Double.NaN, .01);
        assertEquals(summary.getMax(), Double.NaN, .01);
        assertEquals(summary.getSum(), 0, .01);
        assertEquals(summary.getCount(), 0, .01);
        assertEquals(summary.getAverage(), Double.NaN, .01);
    }

    @Test
    public void testGetValue() {
        Processor processor = new Processor(array);
        assertEquals(123, processor.getValue(1), 0);
    }

    @Test
    public void testGetValueOutOfArrayBounds() {
        Processor processor = new Processor(array);
        assertEquals(Double.NaN, processor.getValue(5), 0);
    }
}
