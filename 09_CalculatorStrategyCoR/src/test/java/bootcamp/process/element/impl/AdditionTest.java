package bootcamp.process.element.impl;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AdditionTest {

    @Test
    public void shouldAddTwoBigDecimals() {
        BigDecimal result = new Addition().process(new BigDecimal("1"), new BigDecimal("2"));
        assertEquals(new BigDecimal("3"), result);
    }
}