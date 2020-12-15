package bootcamp.data;

import java.math.BigDecimal;

public class Params {
    private final BigDecimal bx;
    private final BigDecimal y;
    private final String operator;

    public Params(BigDecimal bx, BigDecimal y, String operator) {
        this.bx = bx;
        this.y = y;
        this.operator = operator;
    }

    public BigDecimal getBx() {
        return bx;
    }

    public BigDecimal getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }
}

