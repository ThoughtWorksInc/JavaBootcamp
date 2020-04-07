package bootcamp.process.element;

import bootcamp.process.element.impl.Adder;

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
