package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.MathContext;

public class Calculator {
    BigDecimal result;

    public BigDecimal calculate(final Params params) {

        switch (params.getOperator()) {
            case "+":
                result = params.getX().add(params.getY());
                break;
            case "-":
                result = params.getX().subtract(params.getY());
                break;
            case "x":
                result = params.getX().multiply(params.getY());
                break;
            case "/":
                result = params.getX().divide(params.getY());
                break;
            default:
                throw new IllegalArgumentException("Not a valid input");
        }
        return result.round(MathContext.DECIMAL64).stripTrailingZeros();
    }
}
