package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.ProcessingElementFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BasicProcessingElementFactory implements ProcessingElementFactory {

    private final Map<String, ProcessingElement> map;

    public BasicProcessingElementFactory(Map<String, ProcessingElement> map) {

        this.map = map;
    }

    @Override
    public Optional<ProcessingElement> create(String operator) {

        try {
            return Optional.of(map.get(operator));
        } catch (NullPointerException e){
            return Optional.empty();
        }
    }
}
