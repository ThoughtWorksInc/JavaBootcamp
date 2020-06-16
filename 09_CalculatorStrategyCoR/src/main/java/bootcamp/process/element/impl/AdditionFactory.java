package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class AdditionFactory extends ElementFactory {

    public static final String OPERATOR = "+";

    public AdditionFactory(ElementFactory nextFactory) {

        super(nextFactory, OPERATOR);
    }

    public AdditionFactory() {
        super(OPERATOR);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Addition();
    }
}
