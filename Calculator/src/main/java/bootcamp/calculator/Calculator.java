package bootcamp.calculator;

import bootcamp.data.Params;

import java.math.BigDecimal;
import java.math.MathContext;

public class Calculator {
  public BigDecimal calculate(final Params params) {
    BigDecimal x = params.getX();
    BigDecimal y = params.getY();
    String operator = params.getOperator();

    BigDecimal result;

    switch (operator) {
      case "+":
        result = x.add(y, MathContext.DECIMAL32).stripTrailingZeros();
        break;
      case "-":
        result = x.subtract(y, MathContext.DECIMAL32).stripTrailingZeros();
        break;
      case "x":
        result = x.multiply(y, MathContext.DECIMAL32).stripTrailingZeros();
        break;
      case "/":
        result = x.divide(y, MathContext.DECIMAL32).stripTrailingZeros();
        break;
      default:
        throw new IllegalArgumentException();
    }

    return result;
  }
}
