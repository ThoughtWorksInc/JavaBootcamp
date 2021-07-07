import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ConcreteFactory;
import bootcamp.process.element.ProcessingElement;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void shouldReturnCorrectAdditionResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(33), new BigDecimal(12), "+");
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.create(parameters.getOperator());
        Calculator calculator = new Calculator(concreteFactory);
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(45))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnSubtractionCorrectResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(2), "-");
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.create(parameters.getOperator());
        Calculator calculator = new Calculator(concreteFactory);
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(1))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnMultiplicationCorrectResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(2), "x");
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.create(parameters.getOperator());
        Calculator calculator = new Calculator(concreteFactory);
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(6))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnDivisionCorrectResultForValidParameters() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(2), "/");
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.create(parameters.getOperator());
        Calculator calculator = new Calculator(concreteFactory);
        assertEquals(new Result(Status.SUCCESS, "", java.util.Optional.of(new BigDecimal(1.5))), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnArithmeticErrorForDivisionBy0() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(0), "/");
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.create(parameters.getOperator());
        Calculator calculator = new Calculator(concreteFactory);
        assertEquals(new Result(Status.ARITHMETIC_ERROR, "Division by 0", Optional.empty()), calculator.calculate(parameters));
    }

    @Test
    public void shouldReturnErrorForInvalidOperator() {
        Params parameters = new Params(new BigDecimal(3), new BigDecimal(0), "9");
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.create(parameters.getOperator());
        Calculator calculator = new Calculator(concreteFactory);
        assertEquals(new Result(Status.INVALID_OPERATION, "Invalid operation", Optional.empty()), calculator.calculate(parameters));

    }

}
