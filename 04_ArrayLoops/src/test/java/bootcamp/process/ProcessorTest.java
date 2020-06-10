package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {

        var sut = new Processor(new double[]{1,2,3,4});

        var result = sut.process();

        assertEquals(result.getMax(), 4, 0.001);
        assertEquals(result.getMin(), 1, 0.001);
        assertEquals(result.getCount(), 4);
        assertEquals(result.getSum(), 10, 0.001);
        assertEquals(result.getAverage(), 2.5, 0.001);
    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {

        var sut = new Processor(new double[]{});

        var result = sut.process();

        assertEquals(result.getMax(), Double.NaN, 0.001);
        assertEquals(result.getMin(), Double.NaN, 0.001);
        assertEquals(result.getCount(), 0);
        assertEquals(result.getSum(), Double.NaN, 0.001);
        assertEquals(result.getAverage(), Double.NaN, 0.001);
    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {

        var sut = new Processor(new double[] {1,2,3,4,5});

        var result = sut.getValue(3);

        assertEquals(4d, result, 0.001);
    }

    @Test
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {

        var sut = new Processor(new double[] {1,2,3});

        var result = sut.getValue(3);

        assertEquals(Double.NaN, result, 0.001);
    }
}
