package bootcamp.process.calculator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.AutoPopulatingList;

public class CalculatorTests {
    private static ApplicationContext ctx;

    @BeforeClass
    public static void setup() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AutoPopulatingList.ElementFactory.class);
        ctx.getBean(Calculator.Class);
    }

    @Test
    public void testCalculate() {
        assertThat()
    }
}
