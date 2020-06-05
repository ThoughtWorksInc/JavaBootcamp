package bootcamp.process.element;

import java.util.Map;
import java.util.Optional;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap = null; //FIXME

    //TODO create a constructor that instantiates the elementMap and populate it.

    public abstract Optional<ProcessingElement> create(final String operator);
}
