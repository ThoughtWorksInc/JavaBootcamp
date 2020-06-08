package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;

public class Calculator {
    public BigDecimal calculate(final Params params) {
        switch (params.getOperator()) {
            case "+":
                return params.getX().add(params.getY());
            case "-":
                return params.getX().subtract(params.getY());
            case "x":
                return params.getX().multiply(params.getY());
            case "/":
                return params.getX().divide(params.getY());
            default:
                throw new IllegalArgumentException("Operator must be one of: +, -, x or /");
        }
    }
}
