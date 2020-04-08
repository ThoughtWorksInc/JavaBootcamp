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

    public Calculator(ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {
        Status status;
        Optional<BigDecimal> answer;
        String statusMessage;
        try {
            ProcessingElement operator = factory.create(params.getOperator()).get();
            answer = Optional.of(operator.process(params.getX(), params.getY()));
            status = Status.SUCCESS;
            statusMessage = "Calculation successful";
        } catch (ArithmeticException ex) {
            answer = Optional.empty();
            status = Status.ARITHMETIC_ERROR;
            statusMessage = "An Arithmetic Error occured";

        } catch (IllegalArgumentException ex) {
            answer = Optional.empty();
            status = Status.INVALID_OPERATION;
            statusMessage = "Please enter only '+' '-' '/' '*' as operators";
        }
        return new Result(status, statusMessage, answer);
    }
}
