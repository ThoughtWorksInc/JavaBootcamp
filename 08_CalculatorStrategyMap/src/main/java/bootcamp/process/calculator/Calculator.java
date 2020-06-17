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
        Optional<ProcessingElement> processingElement = factory.create(params.getOperator());
        if(processingElement.isEmpty()){
            return new Result(Status.INVALID_OPERATOR, Optional.empty());
        } else {
            try {
                BigDecimal processingResult = processingElement.get().process(params.getX(), params.getY());
                return new Result(Status.SUCCESS, Optional.of(processingResult));
            } catch(ArithmeticException e){
                return new Result(Status.ARITHMETIC_ERROR, Optional.empty());
            }
        }
    }
}
