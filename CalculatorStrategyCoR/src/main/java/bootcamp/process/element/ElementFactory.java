package bootcamp.process.element;

import java.util.Optional;

public abstract class ElementFactory {

    private final ElementFactory nextFactory; //FIXME
    private final String operator; //FIXME

    //TODO 2 constructor. One takes 2 arguments, the next ElementFactory in the chain and the operator for
    //this ElementFactory. For example, if this is adder factory and the next ElementFactory is subtractor
    //factory, nextFactory is the subtractor factory and operator is "+".
    //The 2nd constructor only takes the operator for this factory and sets nextFactory to null. This means that this
    //factory is the last in the chain.

    protected ElementFactory(ElementFactory nextFactory, String operator) {
        this.nextFactory = nextFactory;
        this.operator = operator;
    }

    protected ElementFactory(String operator) {
        this.nextFactory = null;
        this.operator = operator;
    }

    public Optional<ProcessingElement> getProcessingElement(final String operator) {
    if (this.operator.equals(operator)) {
        return Optional.of(getProcessingElement());
    } else if (nextFactory == null) {
        return Optional.empty();
    }

    return nextFactory.getProcessingElement(operator);

    }

    public abstract ProcessingElement getProcessingElement();
}
