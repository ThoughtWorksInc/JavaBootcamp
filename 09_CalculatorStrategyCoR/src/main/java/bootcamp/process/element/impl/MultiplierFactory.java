package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class MultiplierFactory extends ElementFactory {
    public MultiplierFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public MultiplierFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Multiplier();
    }
}
