package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {

        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        String operator = params.getOperator();

        if (operator.equals("+")) return scale(add(x, y));
        if (operator.equals("-")) return scale(sub(x, y));
        if (operator.equals("x")) return scale(mult(x,y));
        if (operator.equals("/")) return scale(div(x,y));

        else throw new IllegalArgumentException("invalid operator");
    }

    private BigDecimal div(BigDecimal x, BigDecimal y) {
        if (denominatorIsZero(y)){
            throw new ArithmeticException("cannot divide by zero");
        }
        return x.divide(y, MathContext.DECIMAL32);
    }

    private boolean denominatorIsZero(BigDecimal y) {
        return y.setScale(2, RoundingMode.FLOOR).equals(new BigDecimal(0).setScale(2, RoundingMode.FLOOR));
    }

    private BigDecimal mult(BigDecimal x, BigDecimal y) {
        return x.multiply(y, MathContext.DECIMAL32);
    }

    private BigDecimal sub(BigDecimal x, BigDecimal y) {
        return x.subtract(y, MathContext.DECIMAL32);
    }

    private BigDecimal add(BigDecimal x, BigDecimal y) {
        return x.add(y, MathContext.DECIMAL32);
    }

    private BigDecimal scale(BigDecimal in){
        return in.setScale(2);
    }
}
