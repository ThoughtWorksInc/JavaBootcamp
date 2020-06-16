package bootcamp.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.element.ElementFactory;
import bootcamp.element.ProcessingElement;

import java.math.BigDecimal;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory;

    public Calculator(ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {
        Optional<ProcessingElement> processingElement = factory.create(params.getOperator());
        Optional<BigDecimal> value = Optional.empty();
        Status status = Status.SUCCESS;
        if(processingElement.isEmpty()){
            status = Status.INVALID_OPERATION;
        } else {
            try {
                value = Optional.of(processingElement.get().process(params.getX(), params.getY()));
            } catch(ArithmeticException e){
                status = Status.ARITHMETIC_ERROR;
            }
        }
        return new Result(status, status.getMessage(), value);
    }
}
