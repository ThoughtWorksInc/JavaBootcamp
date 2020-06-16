package bootcamp;

import bootcamp.element.ProcessingElement;
import bootcamp.element.impl.Divider;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {

    @Test
    void shouldCorrectlyDivideTwoNumbersGivenValidInput() {
        ProcessingElement divider = new Divider();
        BigDecimal expected = new BigDecimal("7.00");
        BigDecimal actual = divider.process(new BigDecimal("21"), new BigDecimal("3"));
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowArithmeticExceptionWhenTryingToDivideByZero() {
        ProcessingElement divider = new Divider();
        assertThrows(ArithmeticException.class,
                () -> divider.process(new BigDecimal(10), new BigDecimal(0)));
    }
}