/**
 * @author Omar Bashir
 */
package bootcamp.kata.process;

import java.math.BigDecimal;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;

public class Processor {
    public Results process(final Params params) {
        final BigDecimal sum = params.getX().add(params.getY());
        final BigDecimal difference = params.getX().subtract(params.getY());
        final BigDecimal product = params.getX().multiply(params.getY());
        final BigDecimal quotient = params.getX().divide(params.getY());

        return new Results(sum, difference, product, quotient);
    }
}
