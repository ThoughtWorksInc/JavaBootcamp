/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Params {
    private final BigDecimal x;
    private final BigDecimal y;

    public Params(final BigDecimal x, final BigDecimal y) {
        this.x = new BigDecimal(String.valueOf(x));
        this.y = new BigDecimal(String.valueOf(y));
    }

    public final BigDecimal getX() {
        return x;
    }

    public final BigDecimal getY() {
        return y;
    }
}
