package bootcamp;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.AdderFactory;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.DividerFactory;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DividerFactoryTest {

    @Test
    void shouldReturnDividerWhenGivenCorrectOperator(){
        ElementFactory elementFactory = new DividerFactory();
        Divider expected = new Divider();
        assertEquals(expected, elementFactory.getProcessingElement("/").get());
    }

    @Test
    void shouldReturnEmptyOptionalWhenGivenIncorrectOperator(){
        ElementFactory elementFactory = new AdderFactory();
        assertEquals(Optional.empty(), elementFactory.getProcessingElement("^"));
    }
}