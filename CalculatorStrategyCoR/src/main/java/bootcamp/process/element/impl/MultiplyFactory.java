package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class MultiplyFactory extends ElementFactory {
    public MultiplyFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public MultiplyFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Multiply();
    }
}
