/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {

    private  BigDecimal sum;
    private  BigDecimal difference;
    private  BigDecimal product;
    private  BigDecimal quotient;

    public Results(BigDecimal sum, BigDecimal difference, BigDecimal product, BigDecimal quotient) {
        this.sum = sum;
        this.difference = difference;
        this.product = product;
        this.quotient = quotient;
    }

    public final BigDecimal getSum() {
        return this.sum;
    }

    public final BigDecimal getDifference() {
        return this.difference;
    }

    public final BigDecimal getProduct() {
        return this.product;
    }

    public final BigDecimal getQuotient() {
        return this.quotient;
    }
}
