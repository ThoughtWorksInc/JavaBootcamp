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

    public Results(Params p){
        this.sum = p.getX().add(p.getY());
        this.difference = p.getX().subtract(p.getY());
        this.product = p.getX().multiply(p.getY());
        this.quotient = p.getX().divide(p.getY());
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
