package bootcamp.calculator;

import bootcamp.data.Params;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class CalculatorTest {

    @Test
    public void shouldAddTwoParams() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(1.8),
                "+");

        final BigDecimal result = new Calculator().calculate(params);

        assertEquals(new BigDecimal(5), result);
    }

    @Test
    public void shouldSubtractTwoParams() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0.2),
                "-");

        final BigDecimal result = new Calculator().calculate(params);

        assertEquals(new BigDecimal(3), result);
    }

    @Test
    public void shouldMutiplyTwoParams() {
        final Params params = new Params(new BigDecimal(2.25),
                new BigDecimal(2),
                "x");

        final BigDecimal result = new Calculator().calculate(params);

        assertEquals(new BigDecimal(4.5), result);
    }

    @Test
    public void shouldDivideTwoParams() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0.4),
                "/");

        final BigDecimal result = new Calculator().calculate(params);

        assertEquals(new BigDecimal(8), result);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticExceptionWhenDividingByZero() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0),
                "/");
        Calculator calculator = new Calculator();

        calculator.calculate(params);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenPassingInvalidOperator() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(1),
                "*");
        Calculator calculator = new Calculator();

        calculator.calculate(params);
    }
}
