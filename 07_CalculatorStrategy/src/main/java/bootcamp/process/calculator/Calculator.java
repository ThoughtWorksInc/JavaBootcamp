package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.math.BigDecimal;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory = new ElementFactoryImpl();

    public Result calculate(final Params params) {

        Optional<ProcessingElement> processingElement = factory.create(params.getOperator());

        if(!processingElement.isPresent()){
            Result result = new Result(Status.INVALID_OPERATION, "The operation chosen is invalid. Please choose an " +
                    "operator from " +
                    "the following: +, -, x," +
                    " /");
            return result;
        }else if(params.getOperator() == "/" && params.getY().equals(0)){
            Result result = new Result(Status.ARITHMETIC_ERROR, "This operation has encountered an arithmetic error. " +
                    "Please check your parameters and try again.");
            return result;
        }else{
            BigDecimal val = processingElement.get().process(params.getX(), params.getY());
            return new Result(Status.SUCCESS, Optional.ofNullable(val));
        }
    }
}
