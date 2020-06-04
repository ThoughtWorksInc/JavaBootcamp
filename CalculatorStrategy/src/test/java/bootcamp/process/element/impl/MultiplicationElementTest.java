package bootcamp.process.element.impl;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MultiplicationElementTest {

    private MultiplicationElement multiplicationElement;

    @Before
    public void setUp() {
        multiplicationElement = MultiplicationElement.getInstance();
    }

    @Test
    public void testmultipliesTwoNumbers() {
        BigDecimal result = multiplicationElement.process(BigDecimal.valueOf(3), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(9), result);
    }

    @Test
    public void testmultipliesAnotherTwoNumbers() {
        BigDecimal result = multiplicationElement.process(BigDecimal.valueOf(3), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(9), result);
    }
}