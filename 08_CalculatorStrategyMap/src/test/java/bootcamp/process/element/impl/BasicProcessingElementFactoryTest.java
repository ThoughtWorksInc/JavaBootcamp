package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.AddElement;
import bootcamp.process.element.impl.BasicProcessingElementFactory;
import org.junit.Test;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class BasicProcessingElementFactoryTest {

    @Test
    public void create_CreatesCorrectElement(){
        Map<String, ProcessingElement> map = Collections.singletonMap("+",new AddElement());
        var sut = new BasicProcessingElementFactory(map);

        var result = sut.create("+");

        assertThat(result.get(), instanceOf(AddElement.class));
    }

    @Test
    public void create_WhenNoElement_ReturnsEmpty(){
        var map = Collections.<String, ProcessingElement>singletonMap("+",new AddElement());
        var sut = new BasicProcessingElementFactory(map);

        var result = sut.create("(");

        assertEquals(Optional.empty(),result);
    }

}
