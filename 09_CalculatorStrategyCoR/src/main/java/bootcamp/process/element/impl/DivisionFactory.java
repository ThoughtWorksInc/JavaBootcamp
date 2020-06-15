package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class DivisionFactory extends ElementFactory {
    public DivisionFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Division();
    }

    public DivisionFactory(String operator) {
        super(operator);
    }
}
