/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Params {
    private final BigDecimal x;
    private final BigDecimal y;

    public Params() {
        this.x = new BigDecimal(0);
        this.y = new BigDecimal(0);
    }
    public Params(final BigDecimal x, final BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public final BigDecimal getX() {
        return x;
    }

    public final BigDecimal getY() { return y;
    }
}
