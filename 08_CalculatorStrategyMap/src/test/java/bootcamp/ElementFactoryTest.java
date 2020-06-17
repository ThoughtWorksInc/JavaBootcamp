package bootcamp;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ElementFactoryTest {

    @Test
    void shouldReturnAdderWhenGivenCorrectOperator() {
        ElementFactory elementFactory = new ElementFactoryImpl();
        Adder expected = new Adder();
        assertTrue(expected.equals(elementFactory.create("+").get()));
    }

    @Test
    void shouldReturnSubtractorWhenGivenCorrectOperator() {
        ElementFactory elementFactory = new ElementFactoryImpl();
        Subtractor expected = new Subtractor();
        assertTrue(expected.equals(elementFactory.create("-").get()));
    }

    @Test
    void shouldReturnMultiplierWhenGivenCorrectOperator() {
        ElementFactory elementFactory = new ElementFactoryImpl();
        Multiplier expected = new Multiplier();
        assertTrue(expected.equals(elementFactory.create("x").get()));
    }

    @Test
    void shouldReturnDividerWhenGivenCorrectOperator() {
        ElementFactory elementFactory = new ElementFactoryImpl();
        Divider expected = new Divider();
        assertTrue(expected.equals(elementFactory.create("/").get()));
    }
}