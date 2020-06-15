package bootcamp.process.element.impl;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DivideTest {

    @Test
    public void shouldDivide() {
        BigDecimal result = new Divide().process(new BigDecimal("1"), new BigDecimal("2"));
        assertEquals(new BigDecimal("0.5"), result);
    }
}