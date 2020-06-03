package bootcamp.kata.process;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProcessorTests {

    @Test
    public void testProcess() {
        final Params params = new Params(new BigDecimal(5), new BigDecimal(2));
        Processor processor = new Processor();

        final Results results = processor.process(params);

        assertNotNull(results);
        assertEquals(new BigDecimal(7), results.getSum());
        assertEquals(new BigDecimal(3), results.getDifference());
        assertEquals(new BigDecimal(10), results.getProduct());
        assertEquals(new BigDecimal(2.5), results.getQuotient());
    }

    @Test
    public void testProcessWithXZero() {
        final Params params = new Params(new BigDecimal(0), new BigDecimal(2));
        Processor processor = new Processor();

        final Results results = processor.process(params);

        assertNotNull(results);
        assertEquals(new BigDecimal(2), results.getSum());
        assertEquals(new BigDecimal(-2), results.getDifference());
        assertEquals(new BigDecimal(0), results.getProduct());
        assertEquals(new BigDecimal(0), results.getQuotient());
    }

    @Test(expected = ArithmeticException.class)
    public void testProcessWithYZero() {
        final Params params = new Params(new BigDecimal(2), new BigDecimal(0));
        Processor processor = new Processor();

        processor.process(params);
    }
}
