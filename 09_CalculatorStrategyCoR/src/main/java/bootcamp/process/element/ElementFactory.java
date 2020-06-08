package bootcamp.process.element;

public abstract class ElementFactory {
    private final ElementFactory nextFactory;
    private final String operator;

    public ElementFactory(final ElementFactory nextFactory, final String operator) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }

    public ElementFactory() {
        this.nextFactory = null;
        this.operator = null;
    }

    public ProcessingElement getProcessingElement(final String requestedOperator) {
        if (operator == null || operator.equals(requestedOperator)) {
            return getProcessingElement();
        }
        return nextFactory.getProcessingElement(requestedOperator);
    }

    public abstract ProcessingElement getProcessingElement();
}
