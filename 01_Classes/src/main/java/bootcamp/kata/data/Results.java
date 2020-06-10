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

    public Results(Params params){
        this.sum = params.getX().add(params.getY());
        this.difference = params.getX().subtract(params.getY());
        this.product = params.getX().multiply(params.getY());
        this.quotient = params.getX().divide(params.getY());
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
