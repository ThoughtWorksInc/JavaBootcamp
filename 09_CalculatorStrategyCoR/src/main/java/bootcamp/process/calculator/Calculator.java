package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.AdditionFactory;
import bootcamp.process.element.impl.DivisionFactory;
import bootcamp.process.element.impl.MultiplicationFactory;
import bootcamp.process.element.impl.SubtractionFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Calculator {
    private ElementFactory factory;

    public Calculator() {
        this.factory = new AdditionFactory();
        this.factory = new SubtractionFactory(this.factory);
        this.factory = new MultiplicationFactory(this.factory);
        this.factory = new DivisionFactory(this.factory);
    }

    public Result calculate(final Params params) {
        Status status;
        String statusMessage;
        Optional<BigDecimal> value = Optional.empty();

        Optional<ProcessingElement> operator = factory.getProcessingElement(params.getOperator());
        try {
            status = Status.SUCCESS;
            statusMessage = "Success";
            value = Optional.of(operator.get().process(params.getX(), params.getY()));

        } catch (ArithmeticException e) {
            status = Status.ARITHMETIC_ERROR;
            statusMessage = "Arithmetic Error";

        } catch (NoSuchElementException ex) {
            status = Status.INVALID_OPERATOR;
            statusMessage = "Invalid Operator";
        }

        return new Result(status, statusMessage, value);
    }
}
