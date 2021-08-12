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

    //TODO create a constructor that instantiates the elementMap and populate it.
    public ElementFactory(){
        elementMap = new HashMap<>();
        elementMap.put("Adder", new Adder());
        elementMap.put("Subtractor", new Subtractor());
        elementMap.put("Divider", new Divider());
        elementMap.put("Multiplier", new Multiplier());
    }



    public abstract Optional<ProcessingElement> create(final String operator);
}
