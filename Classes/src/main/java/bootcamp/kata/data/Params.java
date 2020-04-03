/**
 * @author Omar Bashir
 */
package bootcamp.kata.data;

import java.math.BigDecimal;

public class Params {
    private final BigDecimal x; // TODO use constructor initialisation
    private final BigDecimal y; // TODO use constructor initialisation

    public Params(final BigDecimal x, final BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public final BigDecimal getX() {
        return this.x; // FIXME
    }

    public final BigDecimal getY() {
        return this.y; // FIXME
    }
}
