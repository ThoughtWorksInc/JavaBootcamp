package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class ElementFactoryImpl implements ElementFactory {
    @Override
    public Optional<ProcessingElement> create(String operator) {

        ProcessingElement processingElement = null;

        switch(operator) {
            case "+":
                processingElement = new Adder();
                break;
            case "-":
                processingElement = new Subtractor();
                break;
            case "x":
                processingElement = new Multiplier();
                break;
            case "/":
                processingElement = new Divisor();
                break;
        }

        return Optional.ofNullable(processingElement);
    }
}
