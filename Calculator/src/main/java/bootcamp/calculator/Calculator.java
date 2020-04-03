package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        String operator = params.getOperator();
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        BigDecimal result;
        switch(operator){
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
                throw new IllegalArgumentException();
        };
        result = result.setScale(2, ROUND_HALF_UP).stripTrailingZeros();
        return result;
    }
}
