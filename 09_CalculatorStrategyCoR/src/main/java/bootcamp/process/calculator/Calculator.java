package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.CoRFactory;

import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    // Constructor to create ElementFactory Chain of Responsibility.
    public Calculator () {
        factory = new CoRFactory(new CoRFactory(new CoRFactory(new CoRFactory("/"), "x"),
                        "-"), "+");
    }

    public Result calculate(final Params params) {
        // use the factory and implementations of ProcessingElement
        Optional <ProcessingElement> processingElement = factory.getProcessingElement(params.getOperator());

        try {
            return new Result(Status.SUCCESS, "", Optional.of(processingElement.get().process(params.getX(), params.getY())));
        } catch (ArithmeticException e) {
            return new Result(Status.ARITHMETIC_ERROR, "Division by 0", Optional.empty());
        } catch (Exception e) {
            return new Result(Status.INVALID_OPERATION, "Invalid operation", Optional.empty());
        }
    }
}
