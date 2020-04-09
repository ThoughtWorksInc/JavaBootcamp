package bootcamp;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;


import static org.junit.Assert.assertThat;

public class ElementFactoryTests {
        ElementFactory factory;
    @Before
    public void setUp() {
        MultiplyFactory multiplyFactory = new MultiplyFactory("x");
        DivideFactory divideFactory = new DivideFactory(multiplyFactory, "/");
        SubtractFactory subtractFactory = new SubtractFactory(divideFactory, "-");
        factory = new AddFactory(subtractFactory, "+");
    }

    @Test
    public void testCorrectElementForAddition() {
        assert(factory.getProcessingElement("+").get() instanceof Add);
    }

    @Test
    public void testCorrectElementForSubtraction() {
        assert(factory.getProcessingElement("-").get() instanceof Subtract);
    }

    @Test
    public void testCorrectElementForDividing() {
        assert(factory.getProcessingElement("/").get() instanceof Divide);
    }

    @Test
    public void testCorrectElementForMultiplying() {
        assert(factory.getProcessingElement("x").get() instanceof Multiply);
    }

    @Test
    public void testIncorrectOperator() {
        assertThat(factory.getProcessingElement("*"), is(Optional.empty()));
    }
}
