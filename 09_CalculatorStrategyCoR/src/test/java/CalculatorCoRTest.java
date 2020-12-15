import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculatorCoRTest {

    Calculator calculator;

    @Before
    public void before() {
        /* Create chain */
        SubtractorFactory subtractorFactory = new SubtractorFactory(null);
        AdderFactory adderFactory = new AdderFactory(subtractorFactory, "+");
        DividerFactory dividerFactory = new DividerFactory(adderFactory, "/");
        MultiplierFactory multiplierFactory = new MultiplierFactory(dividerFactory, "x");
        this.calculator = new Calculator(multiplierFactory);
    }

    @Test
    public void testDivideByZero() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "/";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assert result.getStatus() == Status.ARITHMETIC_ERROR;
    }

    @Test
    public void testInvalidOperator() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "$";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assert result.getStatus() == Status.UNKNOWN_OPERATION;
    }

    @Test
    public void testAddition() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "+";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assert result.getValue().isPresent();
        assert result.getValue().get().equals(BigDecimal.TEN);
    }

    @Test
    public void testMultiplication() {
        BigDecimal x = BigDecimal.ZERO;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "+";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assert result.getValue().isPresent();
        assert result.getValue().get().equals(BigDecimal.ZERO);
    }

    @Test
    public void testSubtraction() {
        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.ZERO;
        String operator = "+";
        Params params = new Params(x, y, operator);
        Result result = this.calculator.calculate(params);
        assert result.getValue().isPresent();
        assert result.getValue().get().equals(BigDecimal.TEN);
    }
}