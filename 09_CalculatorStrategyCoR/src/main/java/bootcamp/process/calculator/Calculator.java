package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.*;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        final var badResultfactory = new InvalidOperationResultCreatorFactory();
        final var dividerFactory = new DividerFactory(badResultfactory, "/");
        final var multiplierFactory = new MultiplierFactory(dividerFactory, "x");
        final var subtractorFactory = new SubtractorFactory(multiplierFactory, "-");
        this.factory = new AdderFactory(subtractorFactory, "+");
    }

    public Result calculate(final Params params) {
        var processingElement = factory.getProcessingElement(params.operator);
        return processingElement.process(params.x, params.y);
    }
}
