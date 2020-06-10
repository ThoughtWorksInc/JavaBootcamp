package bootcamp.process.element.impl;

import bootcamp.data.Elements;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.HashMap;
import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {

    private HashMap<String, ProcessingElement> validOperations = populateHashMap();

    @Override
    public Optional<ProcessingElement> create(String operator) {
        ProcessingElement processingElement = validOperations.get(operator);
        return processingElement != null ? Optional.of(processingElement) : Optional.empty();
    }

    public HashMap<String, ProcessingElement> populateHashMap() {
        HashMap<String, ProcessingElement> validOperations = new HashMap<String, ProcessingElement>();

        validOperations.put(Elements.ADD.get(), new Adder());
        validOperations.put(Elements.SUBTRACT.get(), new Subtractor());
        validOperations.put(Elements.DIVIDE.get(), new Divider());
        validOperations.put(Elements.MULTIPLY.get(), new Multiplier());

        return validOperations;
    }
}
