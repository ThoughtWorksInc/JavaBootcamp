package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.impl.ElementFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

public class CalculatorTests {
    private static Calculator calculator;
    private static ApplicationContext appContext;

    @BeforeClass
    public static void setUp() {
        appContext = new AnnotationConfigApplicationContext(ElementFactory.class);
        calculator = appContext.getBean(Calculator.class);
    }

    @Test
    public void testAdd() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(1.8), "+");
        final Result result = calculator.calculate(params);
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.statusMessage, is("success"));
        assertThat(result.value.get().doubleValue(), is(closeTo(5.0, 0.000000000000001)));
    }

    @Test
    public void testSubtract() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(0.2), "-");
        final Result result = calculator.calculate(params);
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.statusMessage, is("success"));
        assertThat(result.value.get().doubleValue(), is(closeTo(3.0, 0.000000000000001)));
    }

    @Test
    public void testMultiply() {
        final Params params = new Params(new BigDecimal(2.25), new BigDecimal(2), "x");
        final Result result = calculator.calculate(params);
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.statusMessage, is("success"));
        assertThat(result.value.get().doubleValue(), is(closeTo(4.5, 0.000000000000001)));
    }

    @Test
    public void testDivide() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(0.4), "/");
        final Result result = calculator.calculate(params);
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.statusMessage, is("success"));
        assertThat(result.value.get().doubleValue(), is(closeTo(8.0, 0.000000000000001)));
    }

    @Test
    public void testDivideBy0() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(0), "/");
        final Result result = calculator.calculate(params);
        assertThat(result.status, is(Status.ARITHMETIC_ERROR));
        assertThat(result.statusMessage, is("Division by zero"));
        assertTrue(result.value.isEmpty());
    }

    @Test
    public void testIncorrectOperator() {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(1), "*");
        final Result result = calculator.calculate(params);
        assertThat(result.status, is(Status.INVALID_OPERATION));
        assertThat(result.statusMessage, is("Not a valid operator"));
        assertTrue(result.value.isEmpty());
    }
}
