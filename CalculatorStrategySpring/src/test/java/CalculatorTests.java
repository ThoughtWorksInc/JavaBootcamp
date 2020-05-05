import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTests {
    static ApplicationContext ctx;
    Calculator calc;

    @BeforeClass
    public static void contextSetUp() {
        ctx = new AnnotationConfigApplicationContext(ElementFactory.class);
    }

    @Before
    public void setUp() {
        calc = ctx.getBean(Calculator.class);

    }

    @Test
    public void addition_triggers_adder() {
        Params testParams = new Params(new BigDecimal("1"), new BigDecimal("2"), "+");
        Result result = calc.calculate(testParams);
        assertThat(result.getValue().get(), is(new BigDecimal(3)));
    }

    @Test
    public void subtraction_triggers_subtract() {
        Params testParams = new Params(new BigDecimal("2"), new BigDecimal("1"), "-");
        Result result = calc.calculate(testParams);
        assertThat(result.getValue().get(), is(new BigDecimal(1)));
    }

    @Test
    public void multiplication_triggers_multiplier() {
        Params testParams = new Params(new BigDecimal("2"), new BigDecimal("1"), "x");
        Result result = calc.calculate(testParams);
        assertThat(result.getValue().get(), is(new BigDecimal(2)));
    }


    @Test
    public void division_triggers_divider() {
        Params testParams = new Params(new BigDecimal("2"), new BigDecimal("1"), "/");
        Result result = calc.calculate(testParams);
        assertThat(result.getValue().get(), is(new BigDecimal(2)));
    }


    @Test
    public void applicationContext_returns_singleton() {
        assertThat(calc, is(ctx.getBean(Calculator.class)));
    }
}