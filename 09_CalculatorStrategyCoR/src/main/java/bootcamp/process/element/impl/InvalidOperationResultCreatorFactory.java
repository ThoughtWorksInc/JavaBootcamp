package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class InvalidOperationResultCreatorFactory extends ElementFactory {
    public InvalidOperationResultCreatorFactory() {
        super();
    }

    @Override
    public ProcessingElement getProcessingElement() {
        return new InvalidOperationResultCreator();
    }
}