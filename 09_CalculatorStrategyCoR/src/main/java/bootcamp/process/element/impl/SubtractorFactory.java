package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class SubtractorFactory extends ElementFactory {
    public SubtractorFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Subtractor();
    }
}