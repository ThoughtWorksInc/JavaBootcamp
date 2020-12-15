import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void before() {
        this.calculator = new Calculator();
    }

    @Test
    public void testDivideByZero() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "/";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assertEquals(result.getStatus(), Status.ARITHMETIC_ERROR);
    }

    @Test
    public void testInvalidOperator() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "$";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assertEquals(result.getStatus(), Status.UNKNOWN_OPERATION);
    }

    @Test
    public void testAddition() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "+";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assertTrue(result.getValue().isPresent());
        assertEquals(result.getValue().get(), BigDecimal.TEN);
    }
}
