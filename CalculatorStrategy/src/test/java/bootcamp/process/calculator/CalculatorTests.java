package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Status;


import bootcamp.process.element.impl.ElementFactoryImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class CalculatorTests {

    @Test
    public void calculateAddition() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "+");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertEquals(new BigDecimal(18), calc.calculate(params).getValue().get());
    }

    @Test
    public void calculateSubtraction() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "-");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertEquals(new BigDecimal(2), calc.calculate(params).getValue().get());
    }

    @Test
    public void calculateDivision() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "/");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertEquals(new BigDecimal("1.25"), calc.calculate(params).getValue().get());
    }

    @Test
    public void calculateMultiplication() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "x");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertEquals(new BigDecimal(80), calc.calculate(params).getValue().get());
    }

    @Test
    public void testArithmeticExceptionStatus() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(0), "/");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertEquals(Status.ARITHMETIC_ERROR, calc.calculate(params).getStatus());
    }

    @Test
    public void testIncorrectOperatorStatus() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(9), "p");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertEquals(Status.INVALID_OPERATION, calc.calculate(params).getStatus());
    }
}
