package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.AdderFactory;
import bootcamp.process.element.impl.DividerFactory;
import bootcamp.process.element.impl.MultiplierFactory;
import bootcamp.process.element.impl.SubtractorFactory;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Calculator {
    private final ElementFactory factory;

    public Calculator() {
        DividerFactory dividerFactory = new DividerFactory("/");
        MultiplierFactory multiplierFactory = new MultiplierFactory(dividerFactory, "x");
        SubtractorFactory subtractorFactory = new SubtractorFactory(multiplierFactory, "-");
        this.factory = new AdderFactory(subtractorFactory, "+");
    }

    public Result calculate(final Params params) {
        Status status;
        Optional<BigDecimal> answer;
        String statusMessage;
        try {
            String operator = params.getOperator();
            Optional<ProcessingElement> elementOptional = factory.getProcessingElement(operator);
            ProcessingElement element = elementOptional.get();
            answer = Optional.of(element.process(params.getX(), params.getY()));
            status = Status.SUCCESS;
            statusMessage = "Calculation successful";
        } catch (ArithmeticException ex) {
            answer = Optional.empty();
            status = Status.ARITHMETIC_ERROR;
            statusMessage = "There was an arithmetic error";
        } catch (NoSuchElementException ex) {
            answer = Optional.empty();
            status = Status.INVALID_OPERATION;
            statusMessage = "The operator was not '+', '-', '/' or 'x', and so the calculation failed. ";
        } catch (NullPointerException ex) {
            answer = Optional.empty();
            status = Status.INVALID_OPERATION;
            statusMessage = "The operator was not '+', '-', '/' or 'x', and so the calculation failed. ";
        }
        return new Result(status, statusMessage, answer);
    }
}
