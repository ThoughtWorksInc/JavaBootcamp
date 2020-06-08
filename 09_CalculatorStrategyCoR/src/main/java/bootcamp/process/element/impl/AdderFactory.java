package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class AdderFactory extends ElementFactory {
    public AdderFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Adder();
    }
}