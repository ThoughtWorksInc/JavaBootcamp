package bootcamp.calculatorstrategy;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

public class CalculatorTest {

    @Test
    public void shouldAddTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("1.8"),
                "+");

        final BigDecimal actual = new Calculator().calculate(params).getValue().get();
        assertEquals(new BigDecimal("5.0"), actual);
    }

    @Test
    public void shouldSubtractTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("1.8"),
                "-");

        final BigDecimal actual = new Calculator().calculate(params).getValue().get();
        assertEquals(new BigDecimal("1.4"), actual);
    }

    @Test
    public void shouldMultiplyTwoParams() {
        final Params params = new Params(new BigDecimal(2),
                new BigDecimal("4.7"),
                "x");

        final BigDecimal actual = new Calculator().calculate(params).getValue().get();
        assertEquals(new BigDecimal("9.4"), actual);
    }

    @Test
    public void shouldDivideTwoParams() {
        final Params params = new Params(new BigDecimal(7),
                new BigDecimal("0.4"),
                "/");

        final BigDecimal actual = new Calculator().calculate(params).getValue().get();
        assertEquals(new BigDecimal("17.5"), actual);
    }

    @Test
    public void shouldHandleArithmeticExceptionWhenDividingByZero() {
        final Params params = new Params(new BigDecimal(7),
                new BigDecimal(0),
                "/");
        final Status actual = new Calculator().calculate(params).getStatus();
        assertEquals(Status.ARITHMETIC_ERROR, actual);
    }

    @Test
    public void shouldHandleErrorWhenPassingInvalidOperator() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(1),
                ")");
        final Status actual = new Calculator().calculate(params).getStatus();
        assertEquals(Status.INVALID_OPERATION, actual);
    }
}
