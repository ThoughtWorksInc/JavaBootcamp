package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {
    private final ElementFactory nextFactory;
    private final String operator;

    public ElementFactory(String operator, ElementFactory nextFactory) {
        this.operator = operator;
        this.nextFactory = nextFactory;
    }

    public ElementFactory(String operator) {
        this.operator = operator;
        this.nextFactory = null;

    }

    public  Optional<ProcessingElement> getProcessingElement(final String operator) {
        if (this.operator.equals(operator)) {
            return Optional.of(this.getProcessingElement());
        }

        if (this.nextFactory != null) {
            return nextFactory.getProcessingElement(operator);
        } else {
            return Optional.empty();
        }
    }

    public abstract ProcessingElement getProcessingElement();
}
