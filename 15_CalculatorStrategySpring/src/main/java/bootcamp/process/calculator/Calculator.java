package bootcamp.process.calculator;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;

@Component
public class Calculator {
    private final ProcessingElement adder;
    private final ProcessingElement subtractor;
    private final ProcessingElement multiplier;
    private final ProcessingElement divider;

    @Autowired
    public Calculator(@Qualifier("adder") ProcessingElement adder,
            @Qualifier("subtractor") ProcessingElement subtractor,
            @Qualifier("multiplier") ProcessingElement multiplier, @Qualifier("divider") ProcessingElement divider) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }

    public Result calculate(final Params params) {
        final var operationLambda = determineOperation(params.operator);
        return calculateResult(operationLambda, params.x, params.y);
    }

    private Optional<ProcessingElement> determineOperation(String operator) {
        switch (operator) {
            case "+":
                return Optional.of(adder);
            case "-":
                return Optional.of(subtractor);
            case "x":
                return Optional.of(multiplier);
            case "/":
                return Optional.of(divider);
            default:
                return Optional.empty();
        }
    }

    private Result calculateResult(final Optional<ProcessingElement> operation, final BigDecimal x,
            final BigDecimal y) {
        if (operation.isPresent()) {
            try {
                final var value = operation.get().apply(x, y);
                return new Result(Optional.of(value), Status.SUCCESS, "success");
            } catch (ArithmeticException error) {
                return new Result(Optional.empty(), Status.ARITHMETIC_ERROR, error.getMessage());
            }
        }

        return new Result(Optional.empty(), Status.INVALID_OPERATION, "Not a valid operator");
    }
}
