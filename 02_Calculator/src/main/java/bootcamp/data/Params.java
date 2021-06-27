package bootcamp.data;

import java.math.BigDecimal;
import java.math.MathContext;

public class Params {
    private final BigDecimal x;
    private final BigDecimal y;
    private final String operator;

    public Params(final BigDecimal x, final BigDecimal y, final String operator) {
        this.x = x.round(MathContext.DECIMAL32);
        this.y = y.round(MathContext.DECIMAL32);
        this.operator = operator;
    }


    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }
}
