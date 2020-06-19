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

    public static final String CORRECT_OPERATOR = "+";
    public static final String INCORRECT_OPERATOR = "-";
    @Mock
    ElementFactory mockFactory;

    @Test
    public void shouldReturnAdditionInstanceWithCorrectOperator() {
        var factory = new AdditionFactory();
        var element = factory.getProcessingElement(CORRECT_OPERATOR).get();
        assertEquals(element.getClass(), Addition.class);
    }

    @Test
    public void shouldReturnOptionalEmptyWithIncorrectOperator() {
        var factory = new AdditionFactory();
        var element = factory.getProcessingElement(INCORRECT_OPERATOR);
        assertTrue(element.isEmpty());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenOperatorDoesNotMatch() {
        when(mockFactory.getProcessingElement(INCORRECT_OPERATOR)).thenReturn(Optional.empty());
        AdditionFactory additionFactory = new AdditionFactory(mockFactory);
        Optional<ProcessingElement> processingElement = additionFactory.getProcessingElement(INCORRECT_OPERATOR);
        assertEquals(Optional.empty(), processingElement);
        verify(mockFactory).getProcessingElement(INCORRECT_OPERATOR);
    }
}