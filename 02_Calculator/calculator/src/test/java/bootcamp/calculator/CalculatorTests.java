package bootcamp.calculator;

import bootcamp.data.Params;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

public class CalculatorTests {
    @Test
    public void testAdd() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(1.8), "+");
        final BigDecimal result = new Calculator().calculate(params);
        assertThat(result.doubleValue(), is(closeTo(5.0, 0.000000000000001)));
    }

    @Test
    public void testSubtract() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(0.2), "-");
        final BigDecimal result = new Calculator().calculate(params);
        assertThat(result.doubleValue(), is(closeTo(3.0, 0.000000000000001)));
    }

    @Test
    public void testMutiply() {
        final Params params = new Params(new BigDecimal(2.25), new BigDecimal(2), "x");
        final BigDecimal result = new Calculator().calculate(params);
        assertThat(result.doubleValue(), is(closeTo(4.5, 0.000000000000001)));
    }

    @Test
    public void testDivide() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(0.4), "/");
        final BigDecimal result = new Calculator().calculate(params);
        assertThat(result.doubleValue(), is(closeTo(8.0, 0.000000000000001)));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideBy0() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(0), "/");
        final BigDecimal result = new Calculator().calculate(params);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectOperator() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(1), "*");
        final BigDecimal result = new Calculator().calculate(params);
    }
}
