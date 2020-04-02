package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;

public class Calculator {

    public BigDecimal calculate(final Params params) {

        final BigDecimal calculated;
        if (params.getOperator().equals("+")) {
            calculated = add(params.getX(), params.getY());
        } else if (params.getOperator().equals("-")) {
            calculated = subtract(params.getX(), params.getY());
        }
        else if (params.getOperator().equals("x")) {
            calculated = multiply(params.getX(), params.getY());
        }
        else if (params.getOperator().equals("/")) {
            calculated = divide(params.getX(), params.getY());
        } else {
            throw new IllegalArgumentException("Argument must be '+', '-', 'x', or '/' ");

        }
        return calculated;
    }

    private BigDecimal add(BigDecimal x, BigDecimal y) {
        return x.add(y).stripTrailingZeros();
    }

    private BigDecimal subtract(BigDecimal x, BigDecimal y) {
        return x.subtract(y).stripTrailingZeros();
    }

    private BigDecimal multiply(BigDecimal x, BigDecimal y) {
        return x.multiply(y).stripTrailingZeros();
    }
    private BigDecimal divide(BigDecimal x, BigDecimal y) {
        return x.divide(y).stripTrailingZeros();
    }
}
