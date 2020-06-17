package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.*;

import java.math.BigDecimal;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        this.factory = new AdderFactory(new SubtractorFactory(new MultiplierFactory(new DividerFactory())));
    }

    public Result calculate(final Params params) {
        Optional<ProcessingElement> processingElement =
                factory.getProcessingElement(params.getOperator());
        if(processingElement.isEmpty()){
            return new Result(Status.INVALID_OPERATOR, Optional.empty());
        } else {
            try {
                BigDecimal processResult =
                        processingElement.get().process(params.getX(), params.getY());
                return new Result(Status.SUCCESS, Optional.of(processResult));
            } catch (ArithmeticException e){
                return new Result(Status.ARITHMETIC_ERROR, Optional.empty());
            }
        }
    }
}
