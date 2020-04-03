package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;

import java.util.OptionalDouble;

import static org.junit.Assert.*;

public class ProcessTests {

    public static double[] array = {1.2, 2.4, 8.6};

    @Test
    public void testGetSummary() {
        final Processor processor = new Processor(array);
        assertTrue(processor.process() instanceof Summary);
    }

    @Test
    public void testGetSummaryEmptyArray() {
        final Processor processor = new Processor(new double[0]);
        assertTrue(processor.process() instanceof Summary);
    }

    @Test
    public void testGetValue() {
        final Processor processor = new Processor(array);
        assertEquals(2.4, processor.getValue(1).getAsDouble(), 0);
    }

    @Test
    public void testGetValueOutOfArrayBounds() {
        final Processor processor = new Processor(array);
        assertEquals(OptionalDouble.empty(), processor.getValue(4));
    }



}
