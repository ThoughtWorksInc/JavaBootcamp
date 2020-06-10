package bootcamp;

import bootcamp.data.Elements;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.*;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class ElementFactoryImplTest {

    ElementFactory elementFactory;
    private String invalidOperator = "=";

    @Test
    public void getsEmptyOptionalWhenInvalidOperationIsDone(){

        elementFactory = new ElementFactoryImpl();

        Optional<ProcessingElement> elementOptional =  elementFactory.create(invalidOperator);

        assertTrue(elementOptional.isEmpty());

    }

    @Test
    public void getsAdderClassWhenPassedAppropriateOperator(){

        elementFactory = new ElementFactoryImpl();

        Optional<ProcessingElement> elementOptional =  elementFactory.create(Elements.ADD.get());

        assertTrue(elementOptional.isPresent());
        assertTrue(elementOptional.get() instanceof Adder);

    }

    @Test
    public void getsDivisionClassWhenPassedAppropriateOperator(){

        elementFactory = new ElementFactoryImpl();

        Optional<ProcessingElement> elementOptional =  elementFactory.create(Elements.DIVIDE.get());

        assertTrue(elementOptional.isPresent());
        assertTrue(elementOptional.get() instanceof Divider);

    }

    @Test
    public void getsSubtractClassWhenPassedAppropriateOperator(){

        elementFactory = new ElementFactoryImpl();

        Optional<ProcessingElement> elementOptional =  elementFactory.create(Elements.SUBTRACT.get());

        assertTrue(elementOptional.isPresent());
        assertTrue(elementOptional.get() instanceof Subtractor);
    }

    @Test
    public void getsMultiplierClassWhenPassedAppropriateOperator(){

        elementFactory = new ElementFactoryImpl();

        Optional<ProcessingElement> elementOptional =  elementFactory.create(Elements.MULTIPLY.get());

        assertTrue(elementOptional.isPresent());
        assertTrue(elementOptional.get() instanceof Multiplier);
    }

}
