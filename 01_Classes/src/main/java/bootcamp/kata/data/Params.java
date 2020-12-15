/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Params {
    private BigDecimal x;
    private BigDecimal y;

    public Params(final BigDecimal a, final BigDecimal b) {
        this.x = a;
        this.y = b;
    }

    public final BigDecimal getX() {
        return x;
    }

    public final BigDecimal getY() {
        return y;
    }
}
