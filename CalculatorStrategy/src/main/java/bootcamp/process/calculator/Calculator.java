package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import com.sun.scenario.effect.impl.prism.PrDrawable;

import java.math.BigDecimal;
import java.util.Optional;


public class Calculator {
    private final ElementFactory factory;

    public Calculator(final ElementFactory factory) {
        this.factory = factory;
    }

    public Result calculate(final Params params) {

//      implements the factory to create a strategy (element) to use based on operator
        Optional<ProcessingElement> processingElement = factory.create(params.getOperator());

        if (processingElement.isPresent()) {
            try {
//              processes params
                BigDecimal value = processingElement.get().process(params.getX(), params.getY());
//              returns success result
                return new Result(Status.SUCCESS, "Success", Optional.ofNullable(value));
            } catch(ArithmeticException e) {
                return new Result(
                        Status.ARITHMETIC_ERROR,
                        e.getMessage(),
                        Optional.empty()
                );
            }
        } else {
            return new Result(
                    Status.INVALID_OPERATOR,
                    "Please use a valid operator: +, -, x, /",
                    Optional.empty()
            );
        }
    }
}

// get operator from params
// use factory impl + operator to create strategy to use (elements)
// Then apply element to numbers from params
// return result object containing status object etc

// Good use case for using char instead of String as operator

//        ifPresent() removes the need to use get() on the optional
//        .get() gets the object from inside the optional object