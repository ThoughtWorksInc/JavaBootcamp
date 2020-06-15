package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class SubtractionFactory extends ElementFactory {
    public SubtractionFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public SubtractionFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Subtraction();
    }
}
