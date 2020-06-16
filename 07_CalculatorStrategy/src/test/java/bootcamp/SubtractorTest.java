package bootcamp;

import bootcamp.element.impl.Subtractor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SubtractorTest {

    @Test
    public void shouldCorrectlySubtractTwoNumbersGivenValidInput(){
        Subtractor subtractor = new Subtractor();
        BigDecimal actual = subtractor.process(new BigDecimal("21"), new BigDecimal(28));
        BigDecimal expected = new BigDecimal("-7");
        assertEquals(expected, actual);
    }
}