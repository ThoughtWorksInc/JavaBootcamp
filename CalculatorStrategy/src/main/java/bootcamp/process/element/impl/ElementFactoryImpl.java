package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {

/*
    Constants are defined as static on a class because they should
    not change & if it wasn't static each time an instance of ElementFactoryImpl
    is created, the constant would be copied into it- which would be a waste of
    memory so better to just define it on the top level class.

    Inside <type of key, type of value> <operator, processingElement>
    First part
    private static final Map<String, ProcessingElement> elementMap = createElementMap();

      When this class is loaded for the first time, the vars and functions in it are created
      elementMap is created and so createElementMap() is run which creates a new hashmap with the
      processingElements in it.
      This only runs once when the class is first loaded & any time elementMap is used, it is a
      reference to the map created when the class was loaded.
 */


    private static final Map<String, ProcessingElement> elementMap = createElementMap();

    private static Map<String, ProcessingElement> createElementMap() {
        Map<String, ProcessingElement> elementMap = new HashMap<>();
        elementMap.put("+", AdditionElement.getInstance());
        elementMap.put("-", SubtractionElement.getInstance());
        elementMap.put("x", MultiplicationElement.getInstance());
        elementMap.put("/", DivisionElement.getInstance());
        return elementMap;
    }

    @Override
    public Optional<ProcessingElement> create(String operator) {
        return Optional.ofNullable(elementMap.get(operator));
    }
}
