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

        Results results = new Results(x, y);

        return results;

    }
}
