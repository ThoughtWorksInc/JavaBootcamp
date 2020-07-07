package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.impl.ElementFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class CalculatorTest {

    private AnnotationConfigApplicationContext applicationContext;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ElementFactory.class);
        calculator = applicationContext.getBean("calculator", Calculator.class);
    }

    @Test
    void shouldTriggerAdditionFromCalculateMethodWhenGivenCorrectParams() {
        Params params = new Params(new BigDecimal("3"), new BigDecimal("5"), "+");
        Result actualResult = calculator.calculate(params);
        Optional<BigDecimal> expectedResult = Optional.of(new BigDecimal("8"));
        assertEquals(expectedResult, actualResult.getValue());
    }

    @Test
    void shouldTriggerSubtractionFromCalculateMethodWhenGivenCorrectParams() {
        Params params = new Params(new BigDecimal("3"), new BigDecimal("5"), "-");
        Result actualResult = calculator.calculate(params);
        Optional<BigDecimal> expectedResult = Optional.of(new BigDecimal("-2"));
        assertEquals(expectedResult, actualResult.getValue());
    }

    @Test
    void shouldTriggerMultiplicationFromCalculateMethodWhenGivenCorrectParams() {
        Params params = new Params(new BigDecimal("3"), new BigDecimal("5"), "x");
        Result actualResult = calculator.calculate(params);
        Optional<BigDecimal> expectedResult = Optional.of(new BigDecimal("15"));
        assertEquals(expectedResult, actualResult.getValue());
    }

    @Test
    void shouldTriggerDivisionFromCalculateMethodWhenGivenCorrectParams() {
        Params params = new Params(new BigDecimal("30"), new BigDecimal("5"), "/");
        Result actualResult = calculator.calculate(params);
        Optional<BigDecimal> expectedResult = Optional.of(new BigDecimal("6"));
        assertEquals(expectedResult, actualResult.getValue());
    }

    @Test
    void shouldReturnSameInstanceOfCalculator() {
        Calculator calculator1 = applicationContext.getBean("calculator", Calculator.class);
        assertSame(calculator, calculator1);
    }
}