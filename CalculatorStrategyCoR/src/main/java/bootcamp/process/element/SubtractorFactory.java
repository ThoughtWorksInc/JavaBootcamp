package bootcamp.process.element;

import bootcamp.process.element.impl.Subtractor;

public class SubtractorFactory extends ElementFactory {
    public SubtractorFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public SubtractorFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Subtractor();
    }
}
