/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {
    private final BigDecimal sum;
    private final BigDecimal difference;
    private final BigDecimal product;
    private final BigDecimal quotient;

    public Results () {
        this.sum = new BigDecimal(0);
        this.difference = new BigDecimal(0);
        this.product = new BigDecimal(0);
        this.quotient = new BigDecimal(0);
    }
    public Results (BigDecimal sum, BigDecimal difference, BigDecimal product, BigDecimal quotient) {
        this.sum = sum;
        this.difference = difference;
        this.product = product;
        this.quotient = quotient;
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
