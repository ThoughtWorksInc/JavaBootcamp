package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class ElementFactory {



    DividerFactory dividerFactory = new DividerFactory("/");
    MultiplierFactory multiplierFactory = new MultiplierFactory(dividerFactory, "x");
    SubtractorFactory subtractorFactory = new SubtractorFactory(multiplierFactory, "-");
    AdderFactory factory = new AdderFactory(subtractorFactory, "+");

    @Test
    public void testCorrectElementForAddition() {
        ProcessingElement element = factory.getProcessingElement("+").get();
        assert(element instanceof Adder);
    }

    @Test
    public void testCorrectElementForSubtraction() {
        ProcessingElement element = factory.getProcessingElement("-").get();
        assert(element instanceof Subtractor);
    }

    @Test
    public void testCorrectElementForDividing() {
        ProcessingElement element = factory.getProcessingElement("/").get();
        assert(element instanceof Divider);
    }

    @Test
    public void testCorrectElementForMultiplying() {
        ProcessingElement element = factory.getProcessingElement("x").get();
        assert(element instanceof Multiplier);
    }

    @Test (expected = NullPointerException.class)
    public void testIncorrectOperator() {
        ProcessingElement element = factory.getProcessingElement("p").get();
        assertEquals(element, Optional.empty());
    }


}
