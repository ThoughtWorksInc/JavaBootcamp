package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {

    @Override
    public Optional<ProcessingElement> create(String operator) {
        Optional<ProcessingElement> element;
        switch(operator) {
            case "+":
                element = Optional.of(new Adder());
                break;
            case "-":
                element = Optional.of(new Subtractor());
                break;
            case "/":
                element = Optional.of(new Divider());
                break;
            case "x":
                element = Optional.of(new Multiplier());
                break;
            default:
                element = Optional.empty();
        }
        return element;
    }
}
