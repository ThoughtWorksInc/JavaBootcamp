package bootcamp.processor;



import bootcamp.data.Summary;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProcessorTests {

    @Test
    public void testMin() {
        final Processor processor = new Processor(new double[]{1, 2, 3});
        final Summary result = processor.process();
        assertEquals(1d, result.getMin(), 0d);
    }

    @Test
    public void testMax() {
        final Processor processor = new Processor(new double[]{2, 7, 4});
        final Summary result = processor.process();
        assertEquals(7d, result.getMax(), 0d);
    }

    @Test
    public void testSum() {
        final Processor processor = new Processor(new double[]{2, 4, 3, 1});
        final Summary result = processor.process();
        assertEquals(10, result.getSum(), 0d);
    }
    @Test
    public void testCount() {
        final Processor processor = new Processor(new double[]{1, 1, 2, 3});
        final Summary result = processor.process();
        assertEquals(4d, result.getCount(), 0d);
    }
    @Test
    public void testAverage() {
        final Processor processor = new Processor(new double[]{1, 4, 2, 3});
        final Summary result = processor.process();
        assertEquals(2.5d, result.getAverage(), 0d);
    }

    @Test
    public void testGetSummaryEmptyArray() {
        final Processor processor = new Processor(new double[]{});
        final Summary result = processor.process();
        assertEquals(Double.NaN, result.getMin(), 0d);
    }

    @Test
    public void testGetValue() {
        final Processor processor = new Processor(new double[]{1, 2, 3});
        final double result = processor.getValue(0);
        assertEquals(1d, result, 0d);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetValueOutOfArrayBounds() {
        final Processor processor = new Processor(new double[]{1, 2, 3});
        final double result = processor.getValue(3);
    }
}
