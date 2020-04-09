package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {
    private final ElementFactory nextFactory;
    private final String operator;

    public ElementFactory(ElementFactory nextFactory, String operator) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }

    public ElementFactory(String operator) {
        this.operator = operator;
        this.nextFactory = null;
    }


    public  Optional<ProcessingElement> getProcessingElement(final String operator) {
        if (operator.equals(this.operator)) {
            return Optional.of(getProcessingElement());
        }
        else if (nextFactory.getProcessingElement(operator) != null) {
            return nextFactory.getProcessingElement(operator);
        }
        else return Optional.empty();

    }

    public abstract ProcessingElement getProcessingElement();
}
