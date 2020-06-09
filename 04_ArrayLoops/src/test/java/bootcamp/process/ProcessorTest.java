package bootcamp.process;

import bootcamp.data.Summary;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        double[] array = {1, 2};
        final Summary summary = new Processor(array).process();
        assertEquals((1), summary.getMin(), 0);
        assertEquals((2), summary.getMax(), 0);
        assertEquals((3), summary.getSum(), 0);
        assertEquals((2), summary.getCount(), 0);
        assertEquals((1.5), summary.getAverage(), 0);
    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        double[] array = {};
        final Summary summary = new Processor(array).process();
        assertEquals((Double.NaN), summary.getMin(), 0);
        assertEquals((Double.NaN), summary.getMax(), 0);
        assertEquals((0), summary.getSum(), 0);
        assertEquals((0), summary.getCount(), 0);
        assertEquals((Double.NaN), summary.getAverage(), 0);
    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        double[] array = {1, 2};
        double value = new Processor(array).getValue(1);
        assertEquals(2, value, 0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {
        double[] array = {};
        new Processor(array).getValue(1);
    }
}
