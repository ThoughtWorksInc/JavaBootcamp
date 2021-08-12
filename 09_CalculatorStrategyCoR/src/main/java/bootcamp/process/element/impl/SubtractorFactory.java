package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class SubtractorFactory extends ElementFactory {
    private final String operator;
    public SubtractorFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
        this.operator = operator;
    }

    @Override
    public ProcessingElement getProcessingElement() {
        if(operator.equals("-")){
            return new Subtractor();
        }
        return null;
    }
}
