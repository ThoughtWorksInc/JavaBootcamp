/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {
    private BigDecimal sum;
    private BigDecimal difference;
    private BigDecimal product;
    private BigDecimal quotient;

    public Results(BigDecimal x, BigDecimal y) {
        this.sum = x.add(y);
        this.difference = x.subtract(y);
        this.product = x.multiply(y);
        this.quotient = x.divide(y);

    }

    public final BigDecimal getSum() {
        return sum;
    }

    public final BigDecimal getDifference() {
        return difference;
    }

    public final BigDecimal getProduct() {
        return product;
    }

    public final BigDecimal getQuotient() {
        return quotient;
    }
}
