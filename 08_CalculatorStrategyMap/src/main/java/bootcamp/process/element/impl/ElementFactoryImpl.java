package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class ElementFactoryImpl extends ElementFactory {

    public ElementFactoryImpl(){
        super();
    }

    @Override
    public Optional<ProcessingElement> create(String operator) {
        return Optional.ofNullable(super.elementMap.get(operator));
    }
}
