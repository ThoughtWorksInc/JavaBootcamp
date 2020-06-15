package bootcamp;

import bootcamp.element.ProcessingElement;
import bootcamp.element.impl.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementFactoryImplTest {

    @Test
    void shouldReturnEmptyOptionalWhenGivenEmptyString() {
        ElementFactoryImpl elementFactory = new ElementFactoryImpl();
        assertTrue(elementFactory.create("").isEmpty());
    }

    @Test
    void shouldReturnEmptyOptionalWhenGivenIncorrectOperator() {
        ElementFactoryImpl elementFactory = new ElementFactoryImpl();
        assertTrue(elementFactory.create("$").isEmpty());
    }

    @Test
    void shouldReturnRelevantProcessingElementWhenGivenCorrectOperator() {
        ElementFactoryImpl elementFactory = new ElementFactoryImpl();
        ProcessingElement adder = new Adder();
        ProcessingElement subtractor = new Subtractor();
        ProcessingElement divider = new Divider();
        ProcessingElement multiplier = new Multiplier();
        assertTrue(adder.equals(elementFactory.create("+").get()));
        assertTrue(subtractor.equals(elementFactory.create("-").get()));
        assertTrue(divider.equals(elementFactory.create("/").get()));
        assertTrue(multiplier.equals(elementFactory.create("x").get()));
    }
}