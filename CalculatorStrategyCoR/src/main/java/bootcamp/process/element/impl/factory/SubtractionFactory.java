package bootcamp.process.element.impl.factory;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.element.SubtractionElement;

public class SubtractionFactory extends ElementFactory {

    public SubtractionFactory(String operator, ElementFactory nextFactory) {
        super(operator, nextFactory);
    }

    public SubtractionFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return SubtractionElement.getInstance();
    }
}
