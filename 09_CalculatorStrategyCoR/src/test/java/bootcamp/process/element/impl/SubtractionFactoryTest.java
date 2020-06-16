package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubtractionFactoryTest {
    @Mock
    ElementFactory mockFactory;

    @Test
    public void shouldReturnSubtractionInstanceWithCorrectOperator() {
        var factory = new SubtractionFactory();
        var element = factory.getProcessingElement("-").get();
        assertEquals(element.getClass(), Subtraction.class);
    }

    @Test
    public void shouldReturnOptionalEmptyWithIncorrectOperator() {
        var factory = new SubtractionFactory();
        var element = factory.getProcessingElement("l");
        assertTrue(element.isEmpty());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenOperatorDoesNotMatch() {
        when(mockFactory.getProcessingElement("/")).thenReturn(Optional.empty());
        SubtractionFactory subtractionFactory = new SubtractionFactory(mockFactory);
        Optional<ProcessingElement> processingElement = subtractionFactory.getProcessingElement("/");
        assertEquals(Optional.empty(), processingElement);
        verify(mockFactory).getProcessingElement("/");
    }
}
