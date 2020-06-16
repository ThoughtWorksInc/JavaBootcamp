package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class MultiplicationFactory extends ElementFactory {

    public static final String OPERATOR = "x";

    public MultiplicationFactory(ElementFactory nextFactory) {
        super(nextFactory, OPERATOR);
    }

    public MultiplicationFactory() {
        super(OPERATOR);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Multiplication();
    }
}
