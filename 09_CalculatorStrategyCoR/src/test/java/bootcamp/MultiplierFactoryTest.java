package bootcamp;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MultiplierFactoryTest {

    @Test
    void shouldReturnDividerWhenGivenCorrectOperator(){
        ElementFactory elementFactory = new MultiplierFactory();
        Multiplier expected = new Multiplier();
        assertEquals(expected, elementFactory.getProcessingElement("x").get());
    }

    @Test
    void shouldReturnEmptyOptionalWhenGivenIncorrectOperator(){
        ElementFactory elementFactory = new MultiplierFactory();
        assertEquals(Optional.empty(), elementFactory.getProcessingElement("^"));
    }

}