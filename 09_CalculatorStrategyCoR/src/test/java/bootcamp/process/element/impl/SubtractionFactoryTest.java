package bootcamp.process.element.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubtractionFactoryTest {
    @Test
    public void shouldReturnSubtractionInstance() {
        var factory = new SubtractionFactory("/");
        var element = factory.getProcessingElement();
        assert (element instanceof Subtraction);
    }
}