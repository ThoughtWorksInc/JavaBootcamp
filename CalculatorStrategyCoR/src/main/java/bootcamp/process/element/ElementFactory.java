package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {
    public final ElementFactory nextFactory;
    public final String operator;

    public ElementFactory(final ElementFactory nextFactory, final String operator) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }

    public ElementFactory(final String operator) {
        this.nextFactory = null;
        this.operator = operator;
    }

    public  Optional<ProcessingElement> getProcessingElement(final String argOperator) {
        if (operator.equals(argOperator)) {
            return Optional.ofNullable(getProcessingElement());
        } else {
            if (nextFactory != null) {
                return nextFactory.getProcessingElement(argOperator);
            } else {
                return Optional.empty();
            }
        }
    }

    public abstract ProcessingElement getProcessingElement();
}
