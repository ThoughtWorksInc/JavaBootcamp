package bootcamp.process.element;

import bootcamp.process.element.impl.Add;
import bootcamp.process.element.impl.Divide;
import bootcamp.process.element.impl.Multiply;
import bootcamp.process.element.impl.Subtract;

import java.util.*;

public abstract class ElementFactory {
    protected final Map<String, ProcessingElement> elementMap;

    protected ElementFactory() {
        elementMap = new HashMap<String, ProcessingElement>() {
            {
                put("+", new Add());
                put("-", new Subtract());
                put("x", new Multiply());
                put("/", new Divide());
            }
        };
    };

    public abstract Optional<ProcessingElement> create(final String operator);
}
