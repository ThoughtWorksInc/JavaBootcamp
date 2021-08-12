package bootcamp.calculatorstrategy;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        var x = params.getX();
        var y = params.getY();
        var operator = params.getOperator();
        BigDecimal result;
        switch (operator) {
            case "+":
                result = x.add(y).setScale(1, RoundingMode.HALF_DOWN).stripTrailingZeros();
                break;
            case "-":
                result = x.subtract(y).setScale(1, RoundingMode.HALF_DOWN).stripTrailingZeros();;
                break;
            case "/":
                result = x.divide(y).setScale(1, RoundingMode.HALF_DOWN).stripTrailingZeros();;
                break;
            case "x":
                result = x.multiply(y).setScale(1, RoundingMode.HALF_DOWN).stripTrailingZeros();;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }
}
