package bootcamp.process.element;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ElementFactoryTest {
    @Mock
    ElementFactory factory;


    public static class TestElementFactory extends ElementFactory {
        public TestElementFactory(ElementFactory nextFactory, String operator) {
            super(nextFactory, operator);
        }

        public TestElementFactory(String operator) {
            super(operator);
        }

        @Override
        public ProcessingElement getProcessingElement() {
            return (x, y) -> null;
        }
    }

    @Test
    public void returnsOptionalProcessingElementClassOperatorRecognised() {
        var testFactory = new TestElementFactory("+");
        var result = testFactory.getProcessingElement("+");
        assertTrue(result instanceof Optional);
        assertTrue(result.get() instanceof ProcessingElement);
    }
    @Test
    public void returnsOptionalEmptyWithNoNextFactoryOperatorNotRecognised() {
        var testFactory = new TestElementFactory("+");
        assertEquals(Optional.empty(), testFactory.getProcessingElement("-"));
    }

    @Test
    public void callsGetProcessingOnNextFactoryOperatorNotRecognised() {
        var testFactory = new TestElementFactory(factory, "+");
        testFactory.getProcessingElement("-");
        verify(factory).getProcessingElement("-");
    }
}