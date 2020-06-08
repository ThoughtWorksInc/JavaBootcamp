package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.ElementFactory;

public class Calculator {
    private ElementFactory factory;

    public Calculator() {
        factory = new ElementFactory();
    }

    public Result calculate(final Params params) {
        final var processingElement = factory.create(params.operator);
        return processingElement.process(params.x, params.y);
    }
}
