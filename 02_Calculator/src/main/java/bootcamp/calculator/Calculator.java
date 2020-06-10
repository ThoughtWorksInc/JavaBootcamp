package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        String operation = params.getOperator();
        BigDecimal result;

        if(operation.equals("+")){
            result = params.getX().add(params.getY());
        } else if(operation.equals("-")){
            result = params.getX().subtract(params.getY());
        } else if(operation.equals("x")){
            result = params.getX().multiply(params.getY());
        } else if(operation.equals("/")){
            result = params.getX().divide(params.getY());
        } else {
            throw new IllegalArgumentException();
        }
        return result.setScale(2, RoundingMode.HALF_DOWN).stripTrailingZeros();
    }
}
