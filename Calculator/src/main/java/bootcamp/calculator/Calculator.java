package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        BigDecimal result;

        switch(params.getOperator()) {
            case "+":
                result = x.add(y);
                break;
            case "-":
                result = x.subtract(y);
                break;
            case "x":
                result = x.multiply(y);
                break;
            case "/":
                result = x.divide(y);
                break;
            default:
                throw new IllegalArgumentException("Operator must be one of: +, -, x, /");
        }
        return result.setScale(1, RoundingMode.HALF_UP).stripTrailingZeros();
    }
}
