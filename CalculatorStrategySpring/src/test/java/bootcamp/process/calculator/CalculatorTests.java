package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CalculatorTests {
    private static Calculator calculator;
    private static ApplicationContext ctx;

    @BeforeClass
    public static void setup() {
        ctx = new AnnotationConfigApplicationContext(ElementFactory.class);
        calculator = ctx.getBean(Calculator.class);
    }

    @Test
    public void testCalculateAdder() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(2), "+");
        Result result = calculator.calculate(params);
        assertEquals(new BigDecimal (3), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateSubtractor() {
        Params params = new Params(new BigDecimal(2), new BigDecimal(1), "-");
        Result result = calculator.calculate(params);
        assertEquals(new BigDecimal (1), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateMultiplier() {
        Params params = new Params(new BigDecimal(1), new BigDecimal(2), "x");
        Result result = calculator.calculate(params);
        assertEquals(new BigDecimal (2), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testCalculateDivider() {
        Params params = new Params(new BigDecimal(2), new BigDecimal(1), "/");
        Result result = calculator.calculate(params);
        assertEquals(new BigDecimal (2), result.getValue().get());
        assertEquals(Status.SUCCESS, result.getStatus());
        assertEquals(null, result.getStatusMessage());
    }

    @Test
    public void testSingletonContext() {
        assertEquals(ctx.getBean(Calculator.class), ctx.getBean(Calculator.class));
    }
}
