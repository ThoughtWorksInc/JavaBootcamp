package bootcamp.process.element.impl;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AdditionElementTest {

    private AdditionElement additionElement;

    @Before
    public void setup() {
        additionElement = AdditionElement.getInstance();
    }


    @Test
    public void testAddsTwoNumbers() {
        BigDecimal result = additionElement.process(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(3), result);
    }

    @Test
    public void testAddsAnotherTwoNumbers() {
        BigDecimal result = additionElement.process(BigDecimal.valueOf(4), BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(6), result);
    }

}
