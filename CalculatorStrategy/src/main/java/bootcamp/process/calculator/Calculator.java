package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory;

    public Calculator(ElementFactoryImpl factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {
        Status status;
        Optional<BigDecimal> answer;
        String statusMessage;
        try {
            ProcessingElement element = factory.create(params.getOperator()).get();
            answer = Optional.of(element.process(params.getX(), params.getY()));
            status = Status.SUCCESS;
            statusMessage = "Calculation successful";
        } catch (ArithmeticException ex) {
            answer = Optional.empty();
            status = Status.ARITHMETIC_ERROR;
            statusMessage = "There was an arithmetic error";
        } catch (NoSuchElementException ex) {
            answer = Optional.empty();
            status = Status.INVALID_OPERATION;
            statusMessage = "The operator was not '+', '-', '/' or 'x', and so the calculation failed. ";
        }
        return new Result(status, statusMessage, answer);
    }
}