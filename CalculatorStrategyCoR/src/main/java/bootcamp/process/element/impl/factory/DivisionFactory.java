package bootcamp.process.element.impl.factory;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.element.DivisionElement;

public class DivisionFactory extends ElementFactory {

    public DivisionFactory(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public DivisionFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return DivisionElement.getInstance();
    }
}
