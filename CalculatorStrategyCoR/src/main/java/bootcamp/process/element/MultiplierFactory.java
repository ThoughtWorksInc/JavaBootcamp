package bootcamp.process.element;

import bootcamp.process.element.impl.Multiplier;

public class MultiplierFactory extends ElementFactory {
    public MultiplierFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public MultiplierFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new Multiplier();
    }
}
