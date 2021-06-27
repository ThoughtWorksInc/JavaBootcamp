package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        BigDecimal result;
        switch(params.getOperator()) {
            case "+": result = params.getX().add(params.getY());
                break;
            case "-": result = params.getX().subtract(params.getY());
                break;
            case "x": result = params.getX().multiply(params.getY());
                break;
            case "/":
                if (params.getY() == new BigDecimal(0)) throw new ArithmeticException();
                    else { result = params.getX().divide(params.getY());}
                break;
            default: throw new IllegalArgumentException();
        }
        return result;

    }
}
