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
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        String operator = params.getOperator();
        Optional<ProcessingElement> optionalProcessingElement = this.factory.getProcessingElement(operator);
        Status status = Status.UNKNOWN_OPERATION;
        Optional<BigDecimal> value = Optional.empty();
        if (optionalProcessingElement.isPresent()) {
            value = optionalProcessingElement.get().process(x, y);
            if (value.isPresent()) {
                status = Status.SUCCESS;
            } else {
                status = Status.ARITHMETIC_ERROR;
            }
        }
        return new Result(status, status.toString(), value);
    }
}
