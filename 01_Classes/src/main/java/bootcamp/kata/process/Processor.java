/**
 * @author Omar Bashir
 */
package bootcamp.kata.process;

import bootcamp.kata.data.Params;
import bootcamp.kata.data.Results;

import java.math.BigDecimal;

public class Processor {
    public Results process(final Params params) {
        BigDecimal sum =  params.getX().add(params.getY());
        BigDecimal diff =  params.getX().subtract(params.getY());
        BigDecimal prod = params.getX().multiply(params.getY());
        BigDecimal quot = params.getX().divide(params.getY());
        return new Results(sum, diff, prod, quot);
    }
}
