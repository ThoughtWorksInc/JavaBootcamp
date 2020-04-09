package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class SubtractFactory extends ElementFactory {
    public SubtractFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    protected SubtractFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Subtract();
    }
}
