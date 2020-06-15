package bootcamp.process.element.impl;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SubtractTest {
    @Test
    public void shouldSubtract() {
        BigDecimal result = new Subtract().process(new BigDecimal("1"), new BigDecimal("2"));
        assertEquals(new BigDecimal("-1"), result);
    }

}