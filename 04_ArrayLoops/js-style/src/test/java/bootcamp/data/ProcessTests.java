package bootcamp.data;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.OptionalDouble;

import org.junit.jupiter.api.Test;

public class ProcessTests {
    public static double[] array = { 1.2, 2.4, 8.6 };

    @Test
    public void canGetSummary() {
        final Processor processor = new Processor(array);
        assertTrue(processor.process() instanceof Summary);
    }

    @Test
    public void canGetSummaryFromEmptyArray() {
        final Processor processor = new Processor(new double[0]);
        assertTrue(processor.process() instanceof Summary);
    }

    @Test
    public void canGetValueByIndex() {
        final Processor processor = new Processor(array);
        assertThat(processor.getValue(1).getAsDouble(), is(2.4));
    }

    @Test
    public void getsEmptyOptionalWhenGetValueWithIndexOutOfBounds() {
        final Processor processor = new Processor(array);
        assertThat(processor.getValue(100), is(OptionalDouble.empty()));
    }

    @Test
    public void getsEmptyOptionalWhenGetValueWithNegativeIndex() {
        final Processor processor = new Processor(array);
        assertThat(processor.getValue(-10), is(OptionalDouble.empty()));
    }
}
