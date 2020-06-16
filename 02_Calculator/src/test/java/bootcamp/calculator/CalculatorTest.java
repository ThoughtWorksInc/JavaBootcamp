package bootcamp.calculator;

import bootcamp.data.Params;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class CalculatorTest {

    @Test
    public void testAdd() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(1.8),
                "+");
        final BigDecimal result = new Calculator().calculate(params);
        assertEquals(new BigDecimal(5), result);
    }

    @Test
    public void testSubtract() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0.2),
                "-");
        final BigDecimal result = new Calculator().calculate(params);
        assertEquals(new BigDecimal(3), result);
    }

    @Test
    public void testMutiply() {
        final Params params = new Params(new BigDecimal(2.25),
                new BigDecimal(2),
                "x");
        final BigDecimal result = new Calculator().calculate(params);
        assertEquals(new BigDecimal(4.5), result);
    }

    @Test
    public void testDivide() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0.4),
                "/");
        final BigDecimal result = new Calculator().calculate(params);
        assertEquals(new BigDecimal(8), result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideBy0() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0),
                "/");
        final BigDecimal result = new Calculator().calculate(params);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectOperator() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(1),
                "*");
        final BigDecimal result = new Calculator().calculate(params);
    }
}