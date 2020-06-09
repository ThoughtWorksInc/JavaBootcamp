package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal calculate(final Params params) {
        final BigDecimal x = params.getX();
        final BigDecimal y = params.getY();
        final String operator = params.getOperator();

        BigDecimal result;


        switch(operator) {
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
                if (y.equals(new BigDecimal(0))) {
                    throw new ArithmeticException();
                } else {
                    result = x.divide(y);
                }
                break;
            default:
                throw new IllegalArgumentException();
        }

        MathContext mc = new MathContext(2);
        return result.round(mc).stripTrailingZeros();
    }
}
