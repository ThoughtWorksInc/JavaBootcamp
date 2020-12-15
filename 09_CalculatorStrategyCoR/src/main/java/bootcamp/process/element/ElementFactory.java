package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {
    private final ElementFactory nextFactory; //FIXME
    private final String operator; //FIXME

    protected ElementFactory(String operator) {
        this.operator = operator;
        this.nextFactory = null;
    }

    protected ElementFactory(ElementFactory nextFactory, String operator) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }


    public Optional<ProcessingElement> getProcessingElement(final String operator) {
        if (operator.equals(this.operator)) {
            return Optional.of(this.getProcessingElement());
        } else if (this.nextFactory != null) {
            return nextFactory.getProcessingElement(operator);
        } else {
            return Optional.empty();
        }
    }

    public abstract ProcessingElement getProcessingElement();
}
