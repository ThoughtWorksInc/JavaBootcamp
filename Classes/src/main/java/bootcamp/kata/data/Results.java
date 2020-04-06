/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Results {

    private BigDecimal x;
    private BigDecimal y;

    public Results(Params params) {
        x = params.getX();
        y = params.getY();
    }

    public BigDecimal getSum() {
        return x.add(y);
    }

    public BigDecimal getDifference() {
        return x.subtract(y);
    }

    public BigDecimal getProduct() {
        return x.multiply(y);
    }

    public BigDecimal getQuotient() {
        return x.divide(y);
    }


}
