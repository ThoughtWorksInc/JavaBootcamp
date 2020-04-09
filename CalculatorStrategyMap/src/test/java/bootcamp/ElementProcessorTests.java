package bootcamp;

import bootcamp.process.element.impl.*;
import org.junit.Test;

import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;


import static org.junit.Assert.assertThat;

public class ElementProcessorTests {
    @Test
    public void testCorrectElementForAddition() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("+").get() instanceof Add);
    }

    @Test
    public void testCorrectElementForSubtraction() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("-").get() instanceof Subtract);
    }

    @Test
    public void testCorrectElementForDividing() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("/").get() instanceof Divide);
    }

    @Test
    public void testCorrectElementForMultiplying() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assert(factory.create("x").get() instanceof Multiply);
    }

    @Test
    public void testIncorrectOperator() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        assertThat(factory.create("*"), is(Optional.empty()));
    }
}
