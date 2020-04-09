package bootcamp;

import bootcamp.data.Params;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactoryImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTests {
    @Test
    public void calculateAddition() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "+");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertThat(new BigDecimal(18), is(calc.calculate(params).getValue().get()));
    }

    @Test
    public void calculateSubtraction() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "-");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertThat(new BigDecimal(2), is(calc.calculate(params).getValue().get()));
    }

    @Test
    public void calculateDivision() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "/");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertThat(new BigDecimal("1.25"), is(calc.calculate(params).getValue().get()));
    }

    @Test
    public void calculateMultiplication() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(8), "x");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertThat(new BigDecimal(80), is(calc.calculate(params).getValue().get()));
    }

    @Test
    public void testArithmeticExceptionStatus() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(0), "/");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertThat(Status.ARITHMETIC_ERROR, is(calc.calculate(params).getStatus()));
    }

    @Test
    public void testIncorrectOperatorStatus() {
        Params params = new Params(new BigDecimal(10), new BigDecimal(9), "p");
        Calculator calc = new Calculator(new ElementFactoryImpl());
        assertThat(Status.INVALID_OPERATION, is(calc.calculate(params).getStatus()));
    }
}
