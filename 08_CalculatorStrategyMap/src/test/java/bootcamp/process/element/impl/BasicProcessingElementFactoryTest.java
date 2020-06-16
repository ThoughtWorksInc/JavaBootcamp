

import bootcamp.process.element.impl.AddElement;
import bootcamp.process.element.impl.BasicProcessingElementFactory;
import org.junit.Test;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class BasicProcessingElementFactoryTest {

    @Test
    public void create_CreatesCorrectElement(){
        var sut = new BasicProcessingElementFactory();

        var result = sut.create("+");

        assertThat(result.get(), instanceOf(AddElement.class));
    }

    @Test
    public void create_WhenNoElement_ReturnsEmpty(){
        var sut = new BasicProcessingElementFactory();

        var result = sut.create("(");

        assertEquals(Optional.empty(),result);
    }

}
