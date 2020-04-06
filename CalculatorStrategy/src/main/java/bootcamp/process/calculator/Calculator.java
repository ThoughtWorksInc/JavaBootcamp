package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.FactoryImpl;

import java.math.BigDecimal;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        this.factory = new FactoryImpl();
    }

    public Result calculate(final Params params) {
        Optional<ProcessingElement> processingElement = factory.create(params.getOperator());
        if (!processingElement.isPresent()) {
            return new Result(Status.INVALID_OPERATION, "Invalid operator provided.", Optional.empty());
        }

        try {
            BigDecimal value = processingElement.get().process(params.getX(), params.getY());
            return new Result(Status.SUCCESS, null, Optional.ofNullable(value));
        } catch(Exception e) {
            return new Result(Status.ARITHMETIC_ERROR, e.getMessage(), Optional.empty());
        }
    }
}
