package bootcamp.process.element.impl.factory;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.element.MultiplicationElement;

public class MultiplicationFactory extends ElementFactory {

    public MultiplicationFactory(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public MultiplicationFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return MultiplicationElement.getInstance();
    }
}
