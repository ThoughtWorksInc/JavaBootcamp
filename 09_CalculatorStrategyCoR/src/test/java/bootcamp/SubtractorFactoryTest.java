package bootcamp;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SubtractorFactoryTest {

    @Test
    void shouldReturnDividerWhenGivenCorrectOperator(){
        ElementFactory elementFactory = new SubtractorFactory();
        Subtractor expected = new Subtractor();
        assertEquals(expected, elementFactory.getProcessingElement("-").get());
    }

    @Test
    void shouldReturnEmptyOptionalWhenGivenIncorrectOperator(){
        ElementFactory elementFactory = new SubtractorFactory();
        assertEquals(Optional.empty(), elementFactory.getProcessingElement("^"));
    }

}