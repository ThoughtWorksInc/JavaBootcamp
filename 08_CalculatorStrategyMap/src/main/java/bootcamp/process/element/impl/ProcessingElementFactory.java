package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.util.Map;

public class ProcessingElementFactory {

    public Map<String, ProcessingElement> getProcessingElementMap(){
        return Map.of("+", new Adder(),
                "-", new Subtractor(),
                "x", new Multiplier(),
                "/", new Divider());
    }

}
