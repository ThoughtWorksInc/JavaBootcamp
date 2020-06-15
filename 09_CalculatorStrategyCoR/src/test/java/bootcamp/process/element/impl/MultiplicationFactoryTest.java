package bootcamp.process.element.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicationFactoryTest {
    @Test
    public void shouldReturnMultiplicationInstance() {
        var factory = new MultiplicationFactory("/");
        var element = factory.getProcessingElement();
        assert (element instanceof Multiplication);
    }
}