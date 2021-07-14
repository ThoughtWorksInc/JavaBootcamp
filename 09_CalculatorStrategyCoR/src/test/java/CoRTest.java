import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CoRTest {
    @Test
    public void shouldReturnCorrectAdditionResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(33), new BigDecimal(12), "+");
        Calculator calculator = new Calculator();
        Result res = calculator.calculate(parameters);
        assertEquals(new Result(Status.SUCCESS, "", Optional.of(new BigDecimal(45))), res);
    }

    @Test
    public void shouldReturnSubtractionCorrectResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(2), "-");
        Calculator calculator = new Calculator();
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(1))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnMultiplicationCorrectResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(2), "x");
        Calculator calculator = new Calculator();
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(6))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnDivisionCorrectResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(2), "/");
        Calculator calculator = new Calculator();
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(1.5))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnArithmeticErrorForDivisionBy0() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(0), "/");
        Calculator calculator = new Calculator();
        assertEquals(new Result(Status.ARITHMETIC_ERROR, "Division by 0", Optional.empty()), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnErrorForInvalidOperator() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(0), "9");
        Calculator calculator = new Calculator();
        assertEquals(new Result(Status.INVALID_OPERATION, "Invalid operation", Optional.empty()), calculator.calculate(parameters));

    }

}
