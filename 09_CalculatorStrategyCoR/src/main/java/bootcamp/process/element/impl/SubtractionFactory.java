package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class SubtractionFactory extends ElementFactory {

    public static final String OPERATOR = "-";

    public SubtractionFactory(ElementFactory nextFactory) {
        super(nextFactory, OPERATOR);
    }

    public SubtractionFactory() {
        super(OPERATOR);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Subtraction();
    }
}
