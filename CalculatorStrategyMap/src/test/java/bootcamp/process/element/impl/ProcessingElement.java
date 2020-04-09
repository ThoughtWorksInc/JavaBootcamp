package bootcamp.process.element.impl;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProcessingElement {

    @Test
    public void testAdder() {
        Adder element = new Adder();
        assertEquals(BigDecimal.TEN, element.process(new BigDecimal(7), new BigDecimal(3)));
    }

    @Test
    public void testSubtractor() {
        Subtractor element = new Subtractor();
        assertEquals(BigDecimal.TEN, element.process(new BigDecimal(15), new BigDecimal(5)));
    }

    @Test
    public void testDivider() {
        Divider element = new Divider();
        assertEquals(BigDecimal.TEN, element.process(new BigDecimal(90), new BigDecimal(9)));
    }

    @Test
    public void testMultiplier() {
        Multiplier element = new Multiplier();
        assertEquals(BigDecimal.TEN, element.process(new BigDecimal(2), new BigDecimal(5)));
    }

}
