package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ElementFactoryImplTest {
    private ElementFactory elementFactory;

    @Before
    public void setup() {
        elementFactory = new ElementFactoryImpl();
    }

    @Test
    public void testWhenGivenBadOperatorThenReturnsEmptyOptional() {
        Optional<ProcessingElement> processingElement = elementFactory.create("*");
        assertFalse(processingElement.isPresent());
    }

    @Test
    public void testReturnsAddProcessingElement() {
        assertEquals(AdditionElement.class, elementFactory.create("+").get().getClass());
    }

    @Test
    public void testReturnsSubtractProcessingElement() {
        assertEquals(SubtractionElement.class, elementFactory.create("-").get().getClass());
    }

    @Test
    public void testReturnsMultiplyProcessingElement() {
        assertEquals(MultiplicationElement.class, elementFactory.create("x").get().getClass());
    }

    @Test
    public void testReturnsDivideProcessingElement() {
        assertEquals(DivisionElement.class, elementFactory.create("/").get().getClass());
    }




}