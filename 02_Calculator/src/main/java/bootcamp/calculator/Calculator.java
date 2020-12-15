package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {

        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        String operator = params.getOperator();

        if (operator == "+"){
            BigDecimal ans = x.add(y);
            return ans.setScale(2, RoundingMode.FLOOR).stripTrailingZeros();
        }
        else if (operator == "-"){
            BigDecimal ans = x.subtract(y);
            return ans.setScale(2, RoundingMode.FLOOR).stripTrailingZeros();
        }
        else if (operator == "x") {
            BigDecimal ans = x.multiply(y);
            return ans.setScale(2, RoundingMode.FLOOR).stripTrailingZeros();
        }
        else if (operator == "/") {
            BigDecimal ans = x.divide(y);
            return ans.setScale(2, RoundingMode.FLOOR).stripTrailingZeros();
        }
        else throw new IllegalArgumentException();
    }
}
