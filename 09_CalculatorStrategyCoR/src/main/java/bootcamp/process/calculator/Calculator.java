package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.AdderFactory;
import bootcamp.process.element.impl.DividerFactory;
import bootcamp.process.element.impl.MultiplierFactory;
import bootcamp.process.element.impl.SubtractorFactory;

import java.security.PublicKey;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    //TODO Constructor to create ElementFactory Chain of Responsibility.
    public Calculator (ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {
        //FIXME using the factory and implementations of ProcessingElement
       Optional <ProcessingElement> processingElement = factory.getProcessingElement(params.getOperator());

        try {
            return new Result(Status.SUCCESS, "", Optional.ofNullable(processingElement.get().process(params.getX(), params.getY())));
        } catch (ArithmeticException e) {
            return new Result(Status.ARITHMETIC_ERROR, "Division by 0", Optional.empty());
        } catch (Exception e) {
            return new Result(Status.INVALID_OPERATION, "Invalid operation", Optional.empty());
        }
    }
}
