package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class AddFactory extends ElementFactory {

    public AddFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    protected AddFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Add();
    }
}
