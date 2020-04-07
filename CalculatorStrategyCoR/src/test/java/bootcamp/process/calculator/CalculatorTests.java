package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class CalculatorTests {
    @Test
    public void testCalculateAdder() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(2), "+");
        Result result = new Calculator().calculate(params);
        assertEquals(new BigDecimal (3), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateSubtractor() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(2), "-");
        Result result = new Calculator().calculate(params);
        assertEquals(new BigDecimal(-1), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateMultiplier() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(2), "x");
        Result result = new Calculator().calculate(params);
        assertEquals(new BigDecimal(2), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateDivider() {
        Params params = new Params(new BigDecimal(2), new BigDecimal(2), "/");
        Result result = new Calculator().calculate(params);
        assertEquals(new BigDecimal (1), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateInvalidOperator() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(2), "*");
        Result result = new Calculator().calculate(params);
        assertFalse(result.getValue().isPresent());
        assertEquals(Status.INVALID_OPERATION, result.getStatus());
        assertEquals("Invalid operator provided.", result.getStatusMessage());
    }

    @Test
    public void testCalculateArithmeticError() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(0), "/");
        Result result = new Calculator().calculate(params);
        assertFalse(result.getValue().isPresent());
        assertEquals(Status.ARITHMETIC_ERROR, result.getStatus());
        assertEquals("Division by zero", result.getStatusMessage());
    }
}