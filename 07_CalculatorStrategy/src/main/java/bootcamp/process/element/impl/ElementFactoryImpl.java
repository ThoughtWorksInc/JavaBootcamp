package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {
    @Override
    public Optional<ProcessingElement> create(String operator) {
        Optional<ProcessingElement> operation;
        switch (operator) {
            case "+":
                operation = Optional.of(new Add());
                break;
            case "-":
                operation = Optional.of(new Subtract());
                break;
            case "/":
                operation = Optional.of(new Divide());
                break;
            case "x":
                operation = Optional.of(new Multiply());
                break;
            default:
                operation = Optional.empty();

        }
        return operation;
    }
}
