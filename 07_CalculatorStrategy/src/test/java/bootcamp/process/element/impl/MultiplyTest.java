package bootcamp.process.element.impl;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MultiplyTest {
    @Test
    public void shouldMultiply() {
        BigDecimal result = new Multiply().process(new BigDecimal("1"), new BigDecimal("2"));
        assertEquals(new BigDecimal("2"), result);
    }
}