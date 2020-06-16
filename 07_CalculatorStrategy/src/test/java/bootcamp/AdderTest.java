package bootcamp;

import bootcamp.element.impl.Adder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    @Test
    public void shouldCorrectlyAddTwoNumbersGivenValidInput(){
        Adder adder = new Adder();
        BigDecimal actual = adder.process(new BigDecimal("11"), new BigDecimal("6"));
        BigDecimal expected = new BigDecimal("17");
        assertEquals(expected, actual);
    }
}