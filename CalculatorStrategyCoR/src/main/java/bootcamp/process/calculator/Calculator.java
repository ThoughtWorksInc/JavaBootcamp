package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.factory.AdditionFactory;
import bootcamp.process.element.impl.factory.DivisionFactory;
import bootcamp.process.element.impl.factory.MultiplicationFactory;
import bootcamp.process.element.impl.factory.SubtractionFactory;

import java.math.BigDecimal;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        ElementFactory divisionFactory = new DivisionFactory("/", null);
        ElementFactory multiplicationFactory = new MultiplicationFactory("x", divisionFactory);
        ElementFactory subtractionFactory = new SubtractionFactory("-", multiplicationFactory);
        ElementFactory additionFactory = new AdditionFactory("+", subtractionFactory);
        this.factory = additionFactory;

    }


    public Result calculate(final Params params) {

        Optional<ProcessingElement> processingElement = this.factory.getProcessingElement(params.getOperator());

        if (processingElement.isPresent()) {
            try {
                BigDecimal value = processingElement.get().process(params.getX(), params.getY());
                return new Result(Status.SUCCESS, "Success", Optional.ofNullable(value));
            } catch(ArithmeticException e) {
                return new Result(Status.ARITHMETIC_ERROR, e.getMessage(), Optional.empty());
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

