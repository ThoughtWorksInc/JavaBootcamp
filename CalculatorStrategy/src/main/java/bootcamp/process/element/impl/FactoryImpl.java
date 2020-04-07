package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class FactoryImpl implements ElementFactory {
    public Optional<ProcessingElement> create(final String operator) {
        switch(operator) {
            case "+":
                return Optional.ofNullable(new Adder());
            case "-":
                return Optional.ofNullable(new Subtractor());
            case "x":
                return Optional.ofNullable(new Multiplier());
            case "/":
                return Optional.ofNullable(new Divider());
            default:
                return Optional.empty();
        }
    }
}
