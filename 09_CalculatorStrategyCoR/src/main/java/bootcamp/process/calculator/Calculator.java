package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.*;

import java.math.BigDecimal;
import java.util.Optional;

import static bootcamp.data.Elements.*;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        this.factory = getFactoryChain();
    }

    public ElementFactory getFactoryChain() {
        ElementFactory adderFactory = new AdderFactory(ADD.getElement());
        ElementFactory dividerFactory = new DividerFactory(adderFactory, DIVIDE.getElement());
        ElementFactory multiplierFactory = new MultiplierFactory(dividerFactory, MULTIPLY.getElement());
        return new SubtractorFactory(multiplierFactory, SUBTRACT.getElement());
    }

    public Result calculate(final Params params) {

        Optional<ProcessingElement> retrievedElement = factory.getProcessingElement(params.getOperator());

        if (retrievedElement.isEmpty()) return new Result(Status.INVALID_OPERATION, Result.INVALID_OPERATION_MESSAGE);

        try {
            BigDecimal resultingValue = retrievedElement.get().process(params.getX(), params.getY());
            return new Result(Optional.of(resultingValue));
        } catch (ArithmeticException e) {
            return new Result(Status.ARITHMETIC_ERROR, Result.ARITHMETIC_ERROR);
        }
    }
}
