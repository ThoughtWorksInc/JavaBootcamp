package bootcamp.process.element;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap;

    //TODO create a constructor that instantiates the elementMap and populate it.
    public ElementFactory(Map<String, ProcessingElement> map) {
        elementMap = map;
        }
    // Implements the Template Method pattern
    public abstract Optional<ProcessingElement> getProcessingElement(String operator);
    public abstract Optional<ProcessingElement> create(final String operator);
}
