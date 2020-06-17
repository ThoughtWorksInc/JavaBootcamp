package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class MultiplierFactory extends ElementFactory {

    public MultiplierFactory(ElementFactory nextFactory) {
        super("x", nextFactory);
    }

    public MultiplierFactory() {
        super("x");
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Multiplier();
    }
}
