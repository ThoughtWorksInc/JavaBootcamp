package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class AdderFactory extends ElementFactory {

    public AdderFactory(ElementFactory nextFactory) {
        super("+", nextFactory);
    }

    public AdderFactory() {
        super("+");
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Adder();
    }
}
