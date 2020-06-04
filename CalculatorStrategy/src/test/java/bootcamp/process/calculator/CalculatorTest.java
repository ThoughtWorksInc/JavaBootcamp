package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.impl.ElementFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator(new ElementFactoryImpl());
    }

    @Test
    public void testReturnsResultForAdditionOperation() {
        Result result = calculator.calculate(new Params(
                BigDecimal.valueOf(1),
                BigDecimal.valueOf(3),
                "+"
        ));
        assertEquals(
                new Result(
                        Status.SUCCESS,
                        "Success",
                        Optional.of(BigDecimal.valueOf(4))
                ),
                result
        );
    }

    @Test
    public void testReturnsResultForSubtractionOperation() {
        Result result = calculator.calculate(new Params(
                BigDecimal.valueOf(7),
                BigDecimal.valueOf(3),
                "-"
        ));
        assertEquals(
                new Result(
                        Status.SUCCESS,
                        "Success",
                        Optional.of(BigDecimal.valueOf(4))
                ),
                result
        );
    }

    @Test
    public void testReturnsResultForInvalidOperator() {
        Result result = calculator.calculate(new Params(
                BigDecimal.valueOf(7),
                BigDecimal.valueOf(3),
                "*"
        ));
        assertEquals(
                new Result(
                        Status.INVALID_OPERATOR,
                        "Please use a valid operator: +, -, x, /",
                        Optional.empty()
                ),
                result
        );
    }

    @Test
    public void testReturnsResultForArithmeticError() {
        Result result = calculator.calculate(new Params(
                BigDecimal.valueOf(7),
                BigDecimal.valueOf(0),
                "/"
        ));
        assertEquals(
                new Result(
                        Status.ARITHMETIC_ERROR,
                        "Division by zero",
                        Optional.empty()
                ),
                result
        );
    }
}