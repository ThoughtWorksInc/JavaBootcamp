package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SubtractionElementTest {

    private ProcessingElement subtractionElement;

    @Before
    public void setUp() {
        subtractionElement = SubtractionElement.getInstance();
    }

    @Test
    public void testSubtractsTwoNumbers() {
        BigDecimal result = subtractionElement.process(BigDecimal.valueOf(6), BigDecimal.valueOf(4));
        assertEquals(BigDecimal.valueOf(2), result);
    }

    @Test
    public void testSubtractsAnotherTwoNumbers() {
        BigDecimal result = subtractionElement.process(BigDecimal.valueOf(9), BigDecimal.valueOf(4));
        assertEquals(BigDecimal.valueOf(5), result);
    }
}