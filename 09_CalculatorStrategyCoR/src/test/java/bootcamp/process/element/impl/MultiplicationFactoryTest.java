package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Type;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MultiplicationFactoryTest {
    @Mock
    ElementFactory mockFactory;

    @Test
    public void shouldReturnMultiplicationInstanceWithCorrectOperator() {
        var factory = new MultiplicationFactory();
        var element = factory.getProcessingElement("x").get();
        assertEquals(element.getClass(), Multiplication.class);
    }

    @Test
    public void shouldReturnOptionalEmptyWithIncorrectOperator() {
        var factory = new MultiplicationFactory();
        var element = factory.getProcessingElement("-");
        assertTrue(element.isEmpty());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenOperatorDoesNotMatch() {
        when(mockFactory.getProcessingElement("-")).thenReturn(Optional.empty());
        MultiplicationFactory multiplicationFactory = new MultiplicationFactory(mockFactory);
        Optional<ProcessingElement> processingElement = multiplicationFactory.getProcessingElement("-");
        assertEquals(Optional.empty(), processingElement);
        verify(mockFactory).getProcessingElement("-");
    }
}