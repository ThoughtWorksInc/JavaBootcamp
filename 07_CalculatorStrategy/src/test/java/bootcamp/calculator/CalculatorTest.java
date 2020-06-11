package bootcamp.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.ElementFactoryImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

public class CalculatorTest {

    private Calculator calculator;
    @Before
    public void setUp() {
        ElementFactory factory = new ElementFactoryImpl();
        calculator = new Calculator(factory);
    }

    @Test
    public void shouldAddTwoParams() {
        final Params params = new Params(BigDecimal.valueOf(3.2),
                BigDecimal.valueOf(1.8),
                "+");


        final Result result = calculator.calculate(params);

        assertEquals(BigDecimal.valueOf(5), result.getValue().get());
    }

    @Test
    public void shouldSubtractTwoParams() {
        final Params params = new Params(BigDecimal.valueOf(3.2),
                BigDecimal.valueOf(0.2),
                "-");

        final Result result = calculator.calculate(params);

        assertEquals(BigDecimal.valueOf(3), result.getValue().get());
    }

    @Test
    public void shouldMultiplyTwoParams() {
        final Params params = new Params(BigDecimal.valueOf(2.25),
                BigDecimal.valueOf(2),
                "x");

        final Result result = calculator.calculate(params);

        assertEquals(Optional.of(BigDecimal.valueOf(4.5)), result.getValue());
    }

    @Test
    public void shouldDivideTwoParams() {
        final Params params = new Params(BigDecimal.valueOf(3.2),
                BigDecimal.valueOf(0.4),
                "/");

        final Result result = calculator.calculate(params);

        assertEquals(BigDecimal.valueOf(8), result.getValue().get());
    }

    @Test
    public void shouldReturnArithmeticExceptionMessageWhenDividingByZero() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(0),
                "/");

        final Result result = calculator.calculate(params);
        assertEquals("Arithmetic Error", result.getStatusMessage());
        assertEquals(Status.ARITHMETIC_ERROR, result.getStatus());
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionMessageWhenPassingInvalidOperator() {
        final Params params = new Params(new BigDecimal(3.2),
                new BigDecimal(1),
                "*");

        final Result result = calculator.calculate(params);
        assertEquals("Invalid Operator", result.getStatusMessage());
        assertEquals(Status.INVALID_OPERATOR, result.getStatus());
    }
}
