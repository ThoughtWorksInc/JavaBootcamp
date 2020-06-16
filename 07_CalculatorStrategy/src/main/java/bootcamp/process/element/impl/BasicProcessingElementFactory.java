package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.ProcessingElementFactory;
import java.util.Optional;

public class BasicProcessingElementFactory implements ProcessingElementFactory {

    @Override
    public Optional<ProcessingElement> create(String operator) {

        if (operator.equals("+")) return Optional.of(new AddElement());
        if (operator.equals("-")) return Optional.of(new SubtractElement());
        if (operator.equals("/")) return Optional.of(new DivElement());
        if (operator.equals("*")) return Optional.of(new MultElement());

        else return Optional.empty();
    }
}
