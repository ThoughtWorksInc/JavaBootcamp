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
        if(processingElement.isEmpty()){
            return new Result(Status.INVALID_OPERATION, Optional.empty());
        } else {
            try {
                ProcessingElement processingElement1 = processingElement.get();
                Optional<BigDecimal> value = Optional.of(processingElement1.process(params.getX(), params.getY()));
                return new Result(Status.SUCCESS, value);
            } catch(ArithmeticException e){
                return new Result(Status.ARITHMETIC_ERROR, Optional.empty());
            }
        }
    }
}
