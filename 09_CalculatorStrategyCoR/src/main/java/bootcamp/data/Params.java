package bootcamp.data;

import java.math.BigDecimal;

public class Params {
    private final BigDecimal x; //FIXME
    private final BigDecimal y; //FIXME
    private final String operator; //FIXME

    public Params(BigDecimal bx, BigDecimal y, String operator) {
        this.x = bx;
        this.y = y;
        this.operator = operator;
    }

    public BigDecimal getBx() {
        return this.x;
    }

    public BigDecimal getY() {
        return this.y;
    }

    public String getOperator() {
        return this.operator;
    }
}
