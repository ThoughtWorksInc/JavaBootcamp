package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class AdderFactory extends ElementFactory {

    public AdderFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }
    public AdderFactory(String operator) {
        super(operator);
    }
    @Override
    public ProcessingElement getProcessingElement() {
        return new Adder();
    }



}
