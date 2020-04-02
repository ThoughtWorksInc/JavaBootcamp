/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {
    private final BigDecimal x;
    private final BigDecimal y;
    private final BigDecimal sum;
    private final BigDecimal difference;
    private final BigDecimal product;
    private final BigDecimal quotient;

    public Results(Params params) {
        this.x = params.getX();
        this.y = params.getY();
        this.sum = getSum();
        this.difference = getDifference();
        this.product = getProduct();
        this.quotient = getQuotient();
    }



    public final BigDecimal getSum() {
        return x.add(y);
    }

    public final BigDecimal getDifference() {
        return x.subtract(y);
    }

    public final BigDecimal getProduct() {
        return x.multiply(y);
    }

    public final BigDecimal getQuotient() {
        return x.divide(y);
    }
}
