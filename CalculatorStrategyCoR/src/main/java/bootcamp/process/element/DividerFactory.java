package bootcamp.process.element;

import bootcamp.process.element.impl.Divider;

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
