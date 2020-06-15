package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class AdditionFactory extends ElementFactory {
    public AdditionFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public AdditionFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Addition();
    }
}
