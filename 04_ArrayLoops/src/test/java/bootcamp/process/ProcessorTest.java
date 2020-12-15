package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        double[] exa = {1, 4, 12, -3, 3};
        Processor processor = new Processor(exa);
        Summary result = processor.process();

        assertEquals(result.getMin(), -3, 0.1);
        assertEquals(result.getMax(), 12, 0.1);
        assertEquals(result.getCount(), 5, 0.1);
        assertEquals(result.getSum(), 17, 0.1);
        assertEquals(result.getAverage(), 3.4, 0.1);

    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        double[] exa = {};
        Processor processor = new Processor(exa);
        Summary result = processor.process();

        assertEquals(result.getMin(), Double.NaN, 0.1);
        assertEquals(result.getMax(), Double.NaN, 0.1);
        assertEquals(result.getCount(), 0, 0.1);
        assertEquals(result.getSum(), 0, 0.1);
        assertEquals(result.getAverage(), Double.NaN, 0.1);
    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        double[] exa = {1, 4, 12, -3, 3};
        Processor processor = new Processor(exa);
        assertEquals(processor.getValue(2), 12, 0.1);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {
        double[] exa = {1, 4, 12, -3, 3};
        Processor processor = new Processor(exa);
        processor.getValue(50);



    }
}
