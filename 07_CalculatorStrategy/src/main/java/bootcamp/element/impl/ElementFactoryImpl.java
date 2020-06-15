package bootcamp.element.impl;

import bootcamp.element.ElementFactory;
import bootcamp.element.ProcessingElement;

import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {
    @Override
    public Optional<ProcessingElement> create(String operator) {
        switch (operator) {
            case "+":
                return Optional.of(new Adder());
            case "-":
                return Optional.of(new Subtractor());
            case "/":
                return Optional.of(new Divider());
            case "x":
                return Optional.of(new Multiplier());
            default:
                return Optional.empty();
        }
    }
}
