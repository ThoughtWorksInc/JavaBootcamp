package bootcamp.process.element;

import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.Multiplier;
import bootcamp.process.element.impl.Subtractor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ElementFactory {
    public Map<String, ProcessingElement> elementMap;

    public ElementFactory() {
        this.elementMap = new HashMap<>();;
        elementMap.put("+", new Adder());
        elementMap.put("-", new Subtractor());
        elementMap.put("x", new Multiplier());
        elementMap.put("/", new Divider());
    }
}
