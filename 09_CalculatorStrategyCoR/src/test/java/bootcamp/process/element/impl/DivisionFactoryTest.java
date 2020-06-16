package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DivisionFactoryTest {
    @Mock
    ElementFactory mockFactory;

    @Test
    public void shouldReturnDivisionInstanceWithCorrectOperator() {
        var factory = new DivisionFactory();
        var element = factory.getProcessingElement("/").get();
        assertEquals(element.getClass(), Division.class);
    }

    @Test
    public void shouldReturnOptionalEmptyWithIncorrectOperator() {
        var factory = new DivisionFactory();
        var element = factory.getProcessingElement("-");
        assertTrue(element.isEmpty());
    }

    @Test
    public void shouldReturnOptionalEmptyWhenOperatorDoesNotMatch() {
        when(mockFactory.getProcessingElement("-")).thenReturn(Optional.empty());
        DivisionFactory divisionFactory = new DivisionFactory(mockFactory);
        Optional<ProcessingElement> processingElement = divisionFactory.getProcessingElement("-");
        assertEquals(Optional.empty(), processingElement);
        verify(mockFactory).getProcessingElement("-");
    }
}