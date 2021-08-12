package bootcamp.process.element;

import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.Multiplier;
import bootcamp.process.element.impl.Subtractor;

import java.util.Optional;

public class Factory extends ElementFactory{
    private ProcessingElement processingElement = null;

    @Override
    public Optional<ProcessingElement> create(String operator) {
        switch(operator){
            case "+" : {
                processingElement = elementMap.get("Adder");
                break;
            }
            case "-" : {
                processingElement = elementMap.get("Subtractor");
                break;
            }
            case "x" : {
                processingElement = elementMap.get("Multiplier");
                break;
            }
            case "/" : {
                processingElement = elementMap.get("Divider");
                break;
            }
        }
        return Optional.ofNullable(processingElement);
    }
}
