package bootcamp.process.element.impl;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DivisionElementTest {

    private DivisionElement divisionElement;

    @Before
    public void setUp() throws Exception {
        divisionElement = DivisionElement.getInstance();
    }

    @Test
    public void testDividesTwoNumbers() {
        BigDecimal result = divisionElement.process(BigDecimal.valueOf(12), BigDecimal.valueOf(4));
        assertEquals(BigDecimal.valueOf(3), result);
    }

    @Test
    public void testDividesAnotherTwoNumbers() {
        BigDecimal result = divisionElement.process(BigDecimal.valueOf(18), BigDecimal.valueOf(3));
        assertEquals(BigDecimal.valueOf(6), result);
    }
}