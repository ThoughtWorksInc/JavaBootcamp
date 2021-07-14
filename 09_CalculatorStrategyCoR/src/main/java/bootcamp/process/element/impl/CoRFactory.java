package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class CoRFactory extends ElementFactory {

    public CoRFactory(ElementFactory nextFactory, String operator) {
        super(nextFactory, operator);
    }

    public CoRFactory(String operator) {
        super(operator);
    }

    @Override
    public ProcessingElement getProcessingElement() {
        switch(this.getOperator()){
            case "+":
                return new Adder();
            case "-":
                return new Subtractor();
            case "x":
                return new Multiplier();
            case "/":
                return new Divider();
            default:
                return null;
        }
    }
}
