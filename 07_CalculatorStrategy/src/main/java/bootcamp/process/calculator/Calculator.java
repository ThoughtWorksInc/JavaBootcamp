package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.util.Optional;

import static bootcamp.data.Status.*;


public class Calculator {
    private final ElementFactory factory; //FIXME

    public Calculator(ElementFactory factory){
        this.factory = factory;
    }

    public Result calculate(final Params params) {

        Optional<ProcessingElement> element = factory.create(params.getOperator());

        if(element.isEmpty()) return new Result(INVALID_OPERATION, Result.INVALID_ERROR_MESSAGE);

        try {
            BigDecimal result = element.get().process(params.getX(), params.getY());
            return new Result(Optional.of(result));
        } catch (ArithmeticException e){
            return new  Result(ARITHMETIC_ERROR, Result.ARITHMETIC_ERROR_MESSAGE);
        }
    }
}
