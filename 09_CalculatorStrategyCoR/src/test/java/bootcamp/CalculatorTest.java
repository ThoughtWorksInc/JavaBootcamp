package bootcamp;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.Multiplier;
import bootcamp.process.element.impl.Subtractor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void shouldReturnCorrectAdditionResultGivenValidInput(){
        Calculator calculator = new Calculator();
        Result expected = new Result(Status.SUCCESS, Optional.of(new BigDecimal("75")));
        Params params = new Params(new BigDecimal("25"), new BigDecimal("50"), "+");
        Result actual = calculator.calculate(params);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectSubtractionResultGivenValidInput(){
        Calculator calculator = new Calculator();
        Result expected = new Result(Status.SUCCESS, Optional.of(new BigDecimal("-25")));
        Params params = new Params(new BigDecimal("25"), new BigDecimal("50"), "-");
        Result actual = calculator.calculate(params);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectMultiplicationResultGivenValidInput(){
        Calculator calculator = new Calculator();
        Result expected = new Result(Status.SUCCESS, Optional.of(new BigDecimal("250")));
        Params params = new Params(new BigDecimal("25"), new BigDecimal("10"), "x");
        Result actual = calculator.calculate(params);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectDivisionResultGivenValidInput(){
        Calculator calculator = new Calculator();
        Result expected = new Result(Status.SUCCESS, Optional.of(new BigDecimal("12.00")));
        Params params = new Params(new BigDecimal("36"), new BigDecimal("3"), "/");
        Result actual = calculator.calculate(params);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnResultWithEmptyValueGivenValidOperator(){
        Calculator calculator = new Calculator();
        Result expected = new Result(Status.INVALID_OPERATOR, Optional.empty());
        Params params = new Params(new BigDecimal("36"), new BigDecimal("3"), "^");
        Result actual = calculator.calculate(params);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnResultWithEmptyValueWhenTryingToDivideByZero(){
        Calculator calculator = new Calculator();
        Result expected = new Result(Status.ARITHMETIC_ERROR, Optional.empty());
        Params params = new Params(new BigDecimal("36"), new BigDecimal("0"), "/");
        Result actual = calculator.calculate(params);
        assertEquals(expected, actual);
    }


}