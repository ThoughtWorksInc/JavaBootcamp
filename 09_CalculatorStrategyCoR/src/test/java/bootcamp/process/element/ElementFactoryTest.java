package bootcamp.process.element;

import bootcamp.process.element.impl.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ElementFactoryTest {
    ElementFactory factory;

    @Before
    public void setUp() {
        this.factory = new AdditionFactory("+");
        this.factory = new DivisionFactory(this.factory, "/");
        this.factory = new MultiplicationFactory(this.factory, "x");
        this.factory = new SubtractionFactory(this.factory, "-");
    }

    @Test
    public void shouldReturnAdditionInstance() {
        var element = factory.getProcessingElement("+").get();
        assert(element instanceof Addition);
    }

    @Test
    public void shouldReturnSubtractionInstance() {
        var element = factory.getProcessingElement("-").get();
        assert(element instanceof Subtraction);
    }

    @Test
    public void shouldReturnMultiplicationInstance() {
        var element = factory.getProcessingElement("x").get();
        assert(element instanceof Multiplication);
    }

    @Test
    public void shouldReturnDivisionInstance() {
        var element = factory.getProcessingElement("/").get();
        assert(element instanceof Division);
    }

    @Test
    public void shouldReturnOptionalEmpty() {
        var element = factory.getProcessingElement("&");
        assertEquals(Optional.empty(), element);

    }
}