package bootcamp.process.element.impl;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class ElementFactory {

    @Test
    public void testCorrectElementForAddition() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("+").get() instanceof Adder);
    }

    @Test
    public void testCorrectElementForSubtraction() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("-").get() instanceof Subtractor);
    }

    @Test
    public void testCorrectElementForDividing() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("/").get() instanceof Divider);
    }

    @Test
    public void testCorrectElementForMultiplying() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("x").get() instanceof Multiplier);
    }

    @Test
    public void testIncorrectOperator() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assertEquals(factory.create("p"), Optional.empty());
    }


}
