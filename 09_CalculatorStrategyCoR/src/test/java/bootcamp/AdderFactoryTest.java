package bootcamp;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.AdderFactory;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AdderFactoryTest {

    @Test
    void shouldReturnAdderWhenGivenCorrectOperator(){
        ElementFactory elementFactory = new AdderFactory();
        Adder expected = new Adder();
        assertEquals(expected, elementFactory.getProcessingElement("+").get());
    }

    @Test
    void shouldReturnEmptyOptionalWhenGivenIncorrectOperator(){
        ElementFactory elementFactory = new AdderFactory();
        assertEquals(Optional.empty(), elementFactory.getProcessingElement("^"));
    }

}