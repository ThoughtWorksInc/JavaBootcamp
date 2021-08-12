package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;

public class Factory implements ElementFactory {
    public ProcessingElement processingElement = null;

    @Override
    public Optional<ProcessingElement> create(String operator) {
        switch(operator){
            case "+" : {
                processingElement = new Adder();
                break;
            }
            case "-" : {
                processingElement = new Subtractor();
                break;
            }
            case "x" : {
                processingElement = new Multiplier();
                break;
            }
            case "/" : {
                processingElement = new Divider();
                break;
            }
        }
        return Optional.ofNullable(processingElement);
    }
}
