package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.util.Optional;


public class Calculator {
    private final ProcessingElementFactory factory;

    public Calculator(ProcessingElementFactory factory) {

        this.factory = factory;
    }

    public Result calculate(final Params params) {

        String operator = params.getOperator();
        double x = params.getX();
        double y = params.getY();
        Optional<ProcessingElement> element = factory.create(operator);

        if (element.isEmpty()) {
            return new Result(
                    Status.Failure,
                    "Invalid operator",
                    Optional.empty());
        }

        try {
            return new Result(
                    Status.Success,
                    "",
                    Optional.of(element.get().process(x, y)));

        } catch (ArithmeticException e) {
            return new Result(
                    Status.Failure,
                    "Arithmetic Exception:" + e.getMessage(),
                    Optional.empty()
            );
        }
    }
}
