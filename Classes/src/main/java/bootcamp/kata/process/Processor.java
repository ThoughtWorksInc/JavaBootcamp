/**
 * @author Omar Bashir
 */
package bootcamp.kata.process;

import java.math.BigDecimal;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;

public class Processor {
    public Results process(final Params params) {
        BigDecimal sum = params.getX().add(params.getY());
        BigDecimal difference = params.getX().subtract(params.getY());
        BigDecimal product = params.getX().multiply(params.getY());
        BigDecimal quotient = params.getX().divide(params.getY());
        Results result = new Results(sum, difference, product, quotient);
        return result;
    }
}
