package bootcamp.process.element;

import bootcamp.process.element.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap;

    public ElementFactory() {
        this.elementMap = new ProcessingElementFactory().getProcessingElementMap();
    }

    public abstract Optional<ProcessingElement> create(final String operator);
}
