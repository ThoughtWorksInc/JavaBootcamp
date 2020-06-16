package bootcamp;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;
import bootcamp.element.impl.ElementFactoryImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldCorrectlyCalculateSubtractionResultGivenValidParameters() {
        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Params testParams = new Params(new BigDecimal("7"), new BigDecimal("3"), "-");
        BigDecimal actual = calculator.calculate(testParams).getValue().get();
        BigDecimal expected = new BigDecimal("4");
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyCalculateAdditionResultGivenValidParameters() {
        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Params testParams = new Params(new BigDecimal("2"), new BigDecimal("3"), "+");
        BigDecimal actual = calculator.calculate(testParams).getValue().get();
        BigDecimal expected = new BigDecimal("5");
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyCalculateMultiplicationResultGivenValidParameters() {
        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Params testParams = new Params(new BigDecimal("7"), new BigDecimal("3"), "x");
        BigDecimal actual = calculator.calculate(testParams).getValue().get();
        BigDecimal expected = new BigDecimal("21");
        assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyCalculateDivisionResultGivenValidParameters() {
        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Params testParams = new Params(new BigDecimal("20"), new BigDecimal("5"), "/");
        BigDecimal actual = calculator.calculate(testParams).getValue().get();
        BigDecimal expected = new BigDecimal("4.00");
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyResultObjectGivenInvalidOperator() {
        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Params testParams = new Params(new BigDecimal("20"), new BigDecimal("5"), "$");
        Optional<BigDecimal> actual = calculator.calculate(testParams).getValue();
        assertTrue(actual.isEmpty());
    }
    @Test
    void shouldReturnEmptyResultObjectTryingToDivideByZero() {
        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Params testParams = new Params(new BigDecimal("20"), new BigDecimal("0"), "/");
        Optional<BigDecimal> actual = calculator.calculate(testParams).getValue();
        assertTrue(actual.isEmpty());
    }


}