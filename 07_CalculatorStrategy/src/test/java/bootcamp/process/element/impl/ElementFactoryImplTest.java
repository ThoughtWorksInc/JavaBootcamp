package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ElementFactoryImplTest {
    @Test
    public void shouldReturnAddInstance() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        ProcessingElement result = factory.create("+").get();
        assert(result instanceof Add);
    }
    @Test
    public void shouldReturnSubtractInstance() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        ProcessingElement result = factory.create("-").get();
        assert(result instanceof Subtract);
    }
    @Test
    public void shouldReturnDivideInstance() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        ProcessingElement result = factory.create("/").get();
        assert(result instanceof Divide);
    }
    @Test
    public void shouldReturnMultiplyInstance() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        ProcessingElement result = factory.create("x").get();
        assert(result instanceof Multiply);
    }
    @Test
    public void shouldReturnOptionalEmptyWhenInvalid() {
        ElementFactoryImpl factory = new ElementFactoryImpl();
        Optional<ProcessingElement> result = factory.create("9");
        assertEquals(result, Optional.empty());
    }
}