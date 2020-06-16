package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class DivisionFactory extends ElementFactory {

    public static final String OPERATOR = "/";

    public DivisionFactory(ElementFactory nextFactory) {
        super(nextFactory, OPERATOR);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Division();
    }

    public DivisionFactory() {
        super(OPERATOR);
    }
}
