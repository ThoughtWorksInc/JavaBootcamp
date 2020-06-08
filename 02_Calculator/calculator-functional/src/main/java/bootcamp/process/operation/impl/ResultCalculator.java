package bootcamp.process.operation.impl;

import java.math.BigDecimal;
import java.util.Optional;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.operation.ArithmeticOperation;

public class ResultCalculator {
    public static Result calculateResult(final Optional<ArithmeticOperation> operation, final BigDecimal x,
            final BigDecimal y) {
        if (operation.isPresent()) {
            try {
                final var value = operation.get().operate(x, y);
                return new Result(Optional.of(value), Status.SUCCESS, "success");
            } catch (ArithmeticException error) {
                return new Result(Optional.empty(), Status.ARITHMETIC_ERROR, error.getMessage());
            }
        }

        return new Result(Optional.empty(), Status.INVALID_OPERATION, "Not a valid operator");
    }
}