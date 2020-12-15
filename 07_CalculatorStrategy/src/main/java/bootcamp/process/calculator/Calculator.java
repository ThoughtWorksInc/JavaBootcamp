package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.util.Optional;


public class Calculator {
    public Result calculate(final Params params) {
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        String operator = params.getOperator();
        Optional<ProcessingElement> optionalProcessingElement = ElementFactory.create(operator);
        Optional<BigDecimal> result = Optional.empty();
        Status status = Status.UNKNOWN_OPERATION;
        if (optionalProcessingElement.isPresent()) {
            ProcessingElement pe = optionalProcessingElement.get();
            result = pe.process(x, y);
            if (result.isEmpty()) {
                status = Status.ARITHMETIC_ERROR;
            } else {
                status = Status.SUCCESS;
            }
        }
        return new Result(status, status.toString(), result);
    }
}
