package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();


    @Test
    public void shouldAddTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("1.8"),
                "+");


        final Result result = calculator.calculate(params);

        assertEquals(new BigDecimal("5.0"), result.getValue().get());
    }

    @Test
    public void shouldSubtractTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("0.2"),
                "-");

        final Result result = calculator.calculate(params);

        assertEquals(new BigDecimal("3.0"), result.getValue().get());
    }

    @Test
    public void shouldMultiplyTwoParams() {
        final Params params = new Params(new BigDecimal("2.25"),
                new BigDecimal("2"),
                "x");

        final Result result = calculator.calculate(params);

        assertEquals(Optional.of(new BigDecimal("4.50")), result.getValue());
    }

    @Test
    public void shouldDivideTwoParams() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("0.4"),
                "/");

        final Result result = calculator.calculate(params);

        assertEquals(new BigDecimal("8"), result.getValue().get());
    }

    @Test
    public void shouldReturnArithmeticExceptionMessageWhenDividingByZero() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("0"),
                "/");

        final Result result = calculator.calculate(params);
        assertEquals("Arithmetic Error", result.getStatusMessage());
        assertEquals(Status.ARITHMETIC_ERROR, result.getStatus());
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionMessageWhenPassingInvalidOperator() {
        final Params params = new Params(new BigDecimal("3.2"),
                new BigDecimal("1"),
                "*");

        final Result result = calculator.calculate(params);
        assertEquals("Invalid Operator", result.getStatusMessage());
        assertEquals(Status.INVALID_OPERATOR, result.getStatus());
    }

}