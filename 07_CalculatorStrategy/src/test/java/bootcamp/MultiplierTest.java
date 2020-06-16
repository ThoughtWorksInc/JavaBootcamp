package bootcamp;

import bootcamp.element.impl.Multiplier;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MultiplierTest {

    @Test
    public void shouldCorrectlyMultiplyTwoNumbersGivenValidInput(){
        Multiplier multiplier = new Multiplier();
        BigDecimal actual = multiplier.process(new BigDecimal("25"), new BigDecimal("7"));
        BigDecimal expected = new BigDecimal("175");
        assertEquals(expected, actual);
    }
}