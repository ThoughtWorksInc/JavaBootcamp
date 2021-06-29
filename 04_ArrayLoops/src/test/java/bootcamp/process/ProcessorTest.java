package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        double [] arr = {1,2,3,4,5};
        Processor processor = new Processor(arr);
        Summary summary = new Summary(1.0, 5.0, 15.0, 5.0, 3.0);
        assertEquals(summary, processor.process());
    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        double [] arr = new double[0];
        Processor processor = new Processor(arr);
        Summary summary = new Summary(Double.NaN, Double.NaN, 0.0, 0.0, Double.NaN);
        assertEquals(summary, processor.process());
    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        double [] arr = {1,2,3};
        Processor processor = new Processor(arr);
        assertEquals(processor.getValue(2), 3, 0.0);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {
        double [] arr = {1,2,3};
        Processor processor = new Processor(arr);
        assertEquals(processor.getValue(5), 3, 0.0);

    }
}
