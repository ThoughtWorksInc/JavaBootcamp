package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class DivideFactory extends ElementFactory {
    public DivideFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    protected DivideFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Divide();
    }
}
