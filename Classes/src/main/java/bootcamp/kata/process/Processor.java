/**
 * @author Omar Bashir
 */
package bootcamp.kata.process;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;

import java.math.BigDecimal;

public class Processor {
    public Results process(final Params params) {
        final BigDecimal x = params.getX();
        final BigDecimal y = params.getY();

        return new Results(sum(x, y), difference(x, y), product(x, y), quotient(x, y));
    }

    private BigDecimal sum(final BigDecimal x, final BigDecimal y) {
        return x.add(y);
    }

    private BigDecimal difference(final BigDecimal x, final BigDecimal y) {
        return x.subtract(y);
    }

    private BigDecimal product(final BigDecimal x, final BigDecimal y) {
        return x.multiply(y);
    }

    private BigDecimal quotient(final BigDecimal x, final BigDecimal y) {
        return x.divide(y);
    }
}
