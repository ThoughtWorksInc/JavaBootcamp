package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Status;
import bootcamp.process.element.*;
import bootcamp.process.element.impl.AddElement;
import bootcamp.process.element.impl.BasicProcessingElementFactory;
import bootcamp.process.element.impl.DivElement;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void caculate_WhenCorrectInput_ReturnsResult(){
        BasicProcessingElementFactory factoryMock = mock(BasicProcessingElementFactory.class);
        ProcessingElement elementMock = mock(AddElement.class);
        when(elementMock.process(10,20)).thenReturn((double) 30);
        when(factoryMock.create("+")).thenReturn(Optional.of(elementMock));

        var sut = new Calculator(factoryMock);

        var result = sut.calculate(new Params(10,20, "+"));

        assertEquals(Double.valueOf(30.0), result.getValue().get());
    }

    @Test
    public void caculate_WhenIncorrectOperator_ReturnsCorrectErrorMEssg(){
        BasicProcessingElementFactory factoryMock = mock(BasicProcessingElementFactory.class);
        when(factoryMock.create("_")).thenReturn(Optional.empty());


        var sut = new Calculator(factoryMock);

        var result = sut.calculate(new Params(10,20, "_"));

        assertNotNull(result);
        assertEquals(Status.Failure, result.getStatus());
        assertEquals("Invalid operator", result.getStatusMessage());
    }

    @Test
    public void caculate_WhenIncorrectInput_ReturnsCorrectErrorMEssg(){
        BasicProcessingElementFactory factoryMock = mock(BasicProcessingElementFactory.class);
        ProcessingElement elementMock = mock(DivElement.class);
        when(elementMock.process(0,20)).thenThrow(new ArithmeticException("blah"));
        when(factoryMock.create("/")).thenReturn(Optional.of(elementMock));


        var sut = new Calculator(factoryMock);

        var result = sut.calculate(new Params(0,20, "/"));

        assertNotNull(result);
        assertEquals(Status.Failure, result.getStatus());
        assertEquals("Arithmetic Exception:blah", result.getStatusMessage());
    }
}
