package bootcamp.kata.process;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ProcessorTests {

    private Results createAndProcess(final BigDecimal x, final BigDecimal y) {
        final Params params = new Params(new BigDecimal(3), new BigDecimal(2));
        return new Processor().process(params);
    }

    @Test
    public void testProcess() {
        final Results results = createAndProcess(new BigDecimal(5), new BigDecimal(2));
        assertNotNull(results);
        assertEquals(new BigDecimal(7), results.getSum());
        assertEquals(new BigDecimal(3), results.getDifference());
        assertEquals(new BigDecimal(10), results.getProduct());
        assertEquals(new BigDecimal(2.5), results.getQuotient());
    }

    @Test
    public void testProcessWithXZero() {
        final Results results = createAndProcess(new BigDecimal(0), new BigDecimal(2));
        assertNotNull(results);
        assertEquals(new BigDecimal(2), results.getSum());
        assertEquals(new BigDecimal(-2), results.getDifference());
        assertEquals(new BigDecimal(0), results.getProduct());
        assertEquals(new BigDecimal(0), results.getQuotient());
    }

    @Test(expected = ArithmeticException.class)
    public void testProcessWithYZero() {
        final Results results = createAndProcess(new BigDecimal(0), new BigDecimal(2));
    }}
