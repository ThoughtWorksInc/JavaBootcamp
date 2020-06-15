package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class MultiplicationFactory extends ElementFactory {
    public MultiplicationFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public MultiplicationFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Multiplication();
    }
}
