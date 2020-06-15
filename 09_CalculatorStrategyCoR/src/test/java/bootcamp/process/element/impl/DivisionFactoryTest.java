package bootcamp.process.element.impl;

import org.junit.Test;

public class DivisionFactoryTest {
    @Test
    public void shouldReturnDivisionInstance() {
        var factory = new DivisionFactory("/");
        var element = factory.getProcessingElement();
        assert (element instanceof Division);
    }
}