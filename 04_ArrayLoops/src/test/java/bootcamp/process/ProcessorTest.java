package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        // given
        Double[] array = new Double[5];
        array[0] = 6.0;
        array[1] = 7.0;
        array[2] = 3.0;
        array[3] = 5.0;
        array[4] = 4.0;
        Processor processor = new Processor(array);
        // when
        Summary summary = processor.process();
        // then
        assertEquals(new Summary(3.0, 7.0, 25.0, 5, 5.0), summary);
    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        // given
        Double[] array = new Double[5];
        Processor processor = new Processor(array);
        // when
        Summary summary = processor.process();
        // then
        assertEquals(new Summary(Double.NaN, Double.NaN, 0, 0, Double.NaN), summary);
    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        // given
        Double[] array = new Double[5];
        array[0] = 6.0;
        array[1] = 7.0;
        array[2] = 3.0;
        array[3] = 5.0;
        array[4] = 4.0;
        Processor processor = new Processor(array);
        // when
        Double value = processor.getValue(3);
        Double expectedValue = 5.0;
        // then
        assertEquals(expectedValue, value);
    }

    @Test
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {
        // given
        Double[] array = new Double[5];
        array[0] = 6.0;
        array[1] = 7.0;
        array[2] = 3.0;
        array[3] = 5.0;
        array[4] = 4.0;
        Processor processor = new Processor(array);
        // when
        Double value = processor.getValue(7);
        Double expectedValue = Double.NaN;
        // then
        assertEquals(expectedValue, value);
    }
}
