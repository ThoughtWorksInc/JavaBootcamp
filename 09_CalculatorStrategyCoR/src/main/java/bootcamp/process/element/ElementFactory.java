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

    public ElementFactory getNextFactory() {
        return nextFactory;
    }

    public final Optional<ProcessingElement> getProcessingElement(final String operator){
        if(this.operator.equals(operator)){
            return Optional.of(getProcessingElement());
        } else if (nextFactory != null){
            return nextFactory.getProcessingElement(operator);
        } else {
            return Optional.empty();
        }
    }
        /* TODO
         * Compare operator passed as argument with operator instance variable. If they are the same, return this object
         * wrapped in an Optional object. If they are not the same, call the getProcessingElement method of nextFactory passing it the
         * operator argument. If nextElement is null, return Optional empty element.
         */
    public abstract ProcessingElement getProcessingElement();
}
