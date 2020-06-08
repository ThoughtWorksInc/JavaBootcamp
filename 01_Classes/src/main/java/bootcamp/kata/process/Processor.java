/**
 * @author Omar Bashir
 */
package bootcamp.kata.process;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;

import java.math.BigDecimal;

public class Processor {
    public Results process(final Params params) {

        BigDecimal x = params.getX();
        BigDecimal y = params.getY();

        BigDecimal sum = x.add(y);
        BigDecimal difference = x.subtract(y);
        BigDecimal product = x.multiply(y);
        BigDecimal quotient = x.divide(y);

        return new Results(sum, difference, product, quotient);

    }
}
