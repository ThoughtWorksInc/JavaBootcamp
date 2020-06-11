package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class DividerFactory extends ElementFactory {


    public DividerFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public DividerFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Divider();
    }
}
