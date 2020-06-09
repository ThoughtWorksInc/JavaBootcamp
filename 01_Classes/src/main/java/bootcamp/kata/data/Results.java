/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {
    private final BigDecimal sum; // TODO use constructor initialisation
    private final BigDecimal difference; // TODO use constructor initialisation
    private final BigDecimal product; // TODO use constructor initialisation
    private final BigDecimal quotient; // TODO use constructor initialisation

    public Results(
            BigDecimal sumParam,
            BigDecimal diffParam,
            BigDecimal productParam,
            BigDecimal quotientParam)
    {
        sum = sumParam;
        difference = diffParam;
        product = productParam;
        quotient = quotientParam;
    }

    public final BigDecimal getSum() {
        return sum; // FIXME
    }

    public final BigDecimal getDifference() {
        return difference; // FIXME
    }

    public final BigDecimal getProduct() {
        return product; // FIXME
    }

    public final BigDecimal getQuotient() {
        return quotient; // FIXME
    }
}
