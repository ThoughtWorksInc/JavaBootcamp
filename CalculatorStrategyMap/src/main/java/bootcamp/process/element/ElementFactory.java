package bootcamp.process.element;

import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.Multiplier;
import bootcamp.process.element.impl.Subtractor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap;

    public ElementFactory() {
        HashMap<String, ProcessingElement> map = new HashMap<String, ProcessingElement>();
        map.put("+", new Adder());
        map.put("-", new Subtractor());
        map.put("/", new Divider());
        map.put("x", new Multiplier());
        this.elementMap = map;
    }

    public abstract Optional<ProcessingElement> create(final String operator);
}
