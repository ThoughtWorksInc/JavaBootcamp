package bootcamp.process.operation;

import java.math.BigDecimal;

@FunctionalInterface
public interface ArithmeticOperation {
    BigDecimal operate(final BigDecimal x, final BigDecimal y) throws ArithmeticException;
}
