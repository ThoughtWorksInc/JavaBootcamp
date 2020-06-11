package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory;

    public Calculator(ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {
        Status status;
        String statusMessage;
        Optional<BigDecimal> value = Optional.empty();

        MathContext mc = new MathContext(2);

        Optional<ProcessingElement> operator = factory.create(params.getOperator());

        if (operator.isEmpty()) {
            status = Status.INVALID_OPERATOR;
            statusMessage = "Invalid Operator";
            return new Result(status, statusMessage, value);
        }

        try {
            status = Status.SUCCESS;
            statusMessage = "Success";
            value = Optional.of(operator.get().process(params.getX(), params.getY()).round(mc).stripTrailingZeros());

        } catch (ArithmeticException e) {
            status = Status.ARITHMETIC_ERROR;
            statusMessage = "Arithmetic Error";

        }

        return new Result(status, statusMessage, value);
    }
}
