package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class ElementFactoryImpl extends ElementFactory {

    public ElementFactoryImpl() {
        super();
    }

    @Override
    public Optional<ProcessingElement> create(String operator) {
        if (this.elementMap.get(operator) != null) {
            return Optional.of(this.elementMap.get(operator));
        } else return Optional.empty();
    }
}
