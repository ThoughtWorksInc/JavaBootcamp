package bootcamp.data;

import java.math.BigDecimal;

public class Params {
    public final BigDecimal x;
    public final BigDecimal y;
    public final String operator;

    public Params(final BigDecimal x, final BigDecimal y, final String operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }
}
