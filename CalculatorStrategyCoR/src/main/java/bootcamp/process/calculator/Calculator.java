package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.AddFactory;
import bootcamp.process.element.impl.DivideFactory;
import bootcamp.process.element.impl.MultiplyFactory;
import bootcamp.process.element.impl.SubtractFactory;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        MultiplyFactory multiplyFactory = new MultiplyFactory("x");
        DivideFactory divideFactory = new DivideFactory(multiplyFactory, "/");
        SubtractFactory subtractFactory = new SubtractFactory(divideFactory, "-");
        this.factory = new AddFactory(subtractFactory, "+");
    }

    //TODO Constructor to create ElementFactory Chain of Responsibility.

    public Result calculate(final Params params) {
        Status status;
        Optional<BigDecimal> answer;
        String statusMessage;
        try {
            ProcessingElement operator = factory.getProcessingElement(params.getOperator()).get();
            answer = Optional.of(operator.process(params.getX(), params.getY()));
            status = Status.SUCCESS;
            statusMessage = "Calculation successful";
        } catch (ArithmeticException ex) {
            answer = Optional.empty();
            status = Status.ARITHMETIC_ERROR;
            statusMessage = "An Arithmetic Error occured";

        } catch (NoSuchElementException ex) {
            answer = Optional.empty();
            status = Status.INVALID_OPERATION;
            statusMessage = "Please enter only '+' '-' '/' '*' as operators";
        }
        return new Result(status, statusMessage, answer);
    }
}
