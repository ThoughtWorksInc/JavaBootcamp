package bootcamp;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.ElementFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static bootcamp.data.Elements.*;
import static bootcamp.data.Status.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private  final String invalidOperator = "=";
    private ElementFactory factory;
    private Calculator calculator;


    @Before
    public void setUp(){
        factory = new ElementFactoryImpl();
        calculator = new Calculator(factory);
    }

    @Test
    public void returnsResultOfAddition(){
        Params params = new Params(new BigDecimal(3.3), new BigDecimal(4.5), ADD.get());
        Result result = calculator.calculate(params);

        assertEquals(result.getStatus(), SUCCESS);
        assertEquals(result.getValue().get(), new BigDecimal(7.8));
        assertEquals(result.getStatusMessage(), Result.SUCCESS_MESSAGE);
    }

    @Test
    public void returnsResultOfDivision(){
        Params params = new Params(new BigDecimal("1.0"), new BigDecimal("2.0"), DIVIDE.get());
        Result result = calculator.calculate(params);

        assertEquals(result.getStatus(), SUCCESS);
        assertEquals(result.getValue().get(), new BigDecimal("0.5"));
        assertEquals(result.getStatusMessage(), Result.SUCCESS_MESSAGE);
    }

    @Test
    public void returnsResultOfMultiplication(){
        Params params = new Params(new BigDecimal(1.0), new BigDecimal(2.0), MULTIPLY.get());
        Result result = calculator.calculate(params);

        assertEquals(result.getStatus(), SUCCESS);
        assertEquals(result.getValue().get(), new BigDecimal(2.0));
        assertEquals(result.getStatusMessage(), Result.SUCCESS_MESSAGE);
    }

    @Test
    public void returnsResultWithInvalidOperatorErrorWhenGivenInvalidOperator(){
        Params invalidParams = new Params(new BigDecimal(2.3), new BigDecimal(4.5), invalidOperator);
        Result result = calculator.calculate(invalidParams);

        assertEquals(result.getStatus(), INVALID_OPERATION);
        assertEquals(result.getValue(), Optional.empty());
        assertEquals(result.getStatusMessage(), Result.INVALID_ERROR_MESSAGE);
    }

    @Test
    public void returnsResultWithArithmeticErrorWhenErrorOccurs(){
        Params invalidParams = new Params(new BigDecimal(2.3), new BigDecimal(0), DIVIDE.get());
        Result result = calculator.calculate(invalidParams);

        assertEquals(result.getStatus(), ARITHMETIC_ERROR);
        assertEquals(result.getValue(), Optional.empty());
        assertEquals(result.getStatusMessage(), Result.ARITHMETIC_ERROR_MESSAGE);
    }
}
