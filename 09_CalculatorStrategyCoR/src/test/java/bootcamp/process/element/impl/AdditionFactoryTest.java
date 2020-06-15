package bootcamp.process.element.impl;

import org.junit.Test;


public class AdditionFactoryTest {
    @Test
    public void shouldReturnAdditionInstance() {
        var factory = new AdditionFactory("+");
        var element = factory.getProcessingElement();
        assert (element instanceof Addition);
    }
}