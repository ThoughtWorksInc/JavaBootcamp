package bootcamp.process.element.impl.factory;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.element.AdditionElement;

import java.util.Optional;

public class AdditionFactory extends ElementFactory {

    public AdditionFactory(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public AdditionFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return AdditionElement.getInstance();
    }
}
