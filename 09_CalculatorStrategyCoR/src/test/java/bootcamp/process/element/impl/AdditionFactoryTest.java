package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdditionFactoryTest {

    @Mock
    ElementFactory mockFactory;

    @Test
    public void shouldReturnAdditionInstanceWithCorrectOperator() {
        var factory = new AdditionFactory();
        var element = factory.getProcessingElement("+").get();
        assertEquals(element.getClass(), Addition.class);
    }

    @Test
    public void shouldReturnOptionalEmptyWithIncorrectOperator() {
        var factory = new AdditionFactory();
        var element = factory.getProcessingElement("-");
        assertTrue(element.isEmpty());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenOperatorDoesNotMatch() {
        when(mockFactory.getProcessingElement("-")).thenReturn(Optional.empty());
        AdditionFactory additionFactory = new AdditionFactory(mockFactory);
        Optional<ProcessingElement> processingElement = additionFactory.getProcessingElement("-");
        assertEquals(Optional.empty(), processingElement);
        verify(mockFactory).getProcessingElement("-");
    }
}