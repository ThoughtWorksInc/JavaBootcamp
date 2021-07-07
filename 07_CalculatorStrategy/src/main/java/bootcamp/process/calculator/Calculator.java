package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory;

    // Constructor to initialise factory.
    public Calculator(ElementFactory elementFactory) {
        this.factory = elementFactory;
    }

    public Result calculate(final Params params) {
        // using the factory and implementations of ProcessingElement
        Optional<ProcessingElement> processingElement = factory.create(params.getOperator());

        try {
            return new Result(Status.SUCCESS, "", Optional.ofNullable(processingElement.get().process(params.getX(), params.getY())));
        } catch (ArithmeticException e) {
            return new Result(Status.ARITHMETIC_ERROR, "Division by 0", Optional.empty());
        } catch (Exception e) {
            return new Result(Status.INVALID_OPERATION, "Invalid operation", Optional.empty());
        }
    }
}
