package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.ElementFactoryImpl;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        factory = new ElementFactoryImpl();
    }

    public Result calculate(final Params params) {
        var processingElement = factory.create(params.operator);
        return processingElement.process(params.x, params.y);
    }
}
