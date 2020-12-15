import bootcamp.process.calculator.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTest {

    private static Calculator calculator;

    private static ApplicationContext applicationContext;

    @BeforeClass
    public static void beforeClass() {
        applicationContext = new AnnotationConfigApplicationContext("bootcamp");
        calculator = applicationContext.getBean(Calculator.class);
    }

    @Test
    public void testSingleton() {
        Calculator newCalculator = applicationContext.getBean(Calculator.class);
        Assert.assertEquals(calculator, newCalculator);
    }

    @Test
    public void testDI() {
        Assert.assertNotEquals(calculator.getAdder(), null);
        Assert.assertNotEquals(calculator.getMultiplier(), null);
        Assert.assertNotEquals(calculator.getDivider(), null);
        Assert.assertNotEquals(calculator.getSubtractor(), null);
    }
}