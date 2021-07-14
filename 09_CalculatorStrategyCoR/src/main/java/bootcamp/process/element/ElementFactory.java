package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {
    private final ElementFactory nextFactory;
    private final String operator;

    // 2 constructor. One takes 2 arguments, the next ElementFactory in the chain and the operator for
    //this ElementFactory. For example, if this is adder factory and the next ElementFactory is subtractor
    //factory, nextFactory is the subtractor factory and operator is "+".
    //The 2nd constructor only takes the operator for this factory and sets nextFactory to null. This means that this
    //factory is the last in the chain.

    public ElementFactory(ElementFactory nextFactory, String operator) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }

    public ElementFactory(String operator) {
        this.operator = operator;
        this.nextFactory = null;
    }

    public Optional<ProcessingElement> getProcessingElement(final String operator) {
        /*
         * Compare operator passed as argument with operator instance variable. If they are the same, return this object
         * wrapped in an Optional object. If they are not the same, call the getProcessingElement method of nextFactory passing it the
         * operator argument. If nextElement is null, return Optional empty element.
         */
        if (operator.equals(this.operator)) return Optional.of(getProcessingElement());
        else {
            if (nextFactory != null) return nextFactory.getProcessingElement(operator);
            return Optional.empty();

        }
    }

    public abstract ProcessingElement getProcessingElement();

    public String getOperator() {
        return operator;
    }
}
