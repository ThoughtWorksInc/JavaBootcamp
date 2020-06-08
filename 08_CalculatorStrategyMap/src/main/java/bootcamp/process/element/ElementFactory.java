package bootcamp.process.element;

import java.util.HashMap;
import java.util.Map;

import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Subtractor;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.InvalidOperationResultCreator;
import bootcamp.process.element.impl.Multiplier;

public class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap;

    public ElementFactory() {
        elementMap = new HashMap<String, ProcessingElement>();
        elementMap.put("+", new Adder());
        elementMap.put("-", new Subtractor());
        elementMap.put("x", new Multiplier());
        elementMap.put("/", new Divider());
    }

    public ProcessingElement create(final String operator) {
        if (elementMap.containsKey(operator)) {
            return elementMap.get(operator);
        }

        return new InvalidOperationResultCreator();
    }
}