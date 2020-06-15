package bootcamp.calculator;
import bootcamp.data.Params;
import java.math.BigDecimal;
import java.math.MathContext;

public class Calculator {

    public BigDecimal calculate(final Params params) {

        final BigDecimal x = params.getX();
        final BigDecimal y = params.getY();
        final String operator = params.getOperator();
        BigDecimal result;
        result = performOperation(x, y, operator);
        return roundResult(result);
    }

    private BigDecimal roundResult(BigDecimal result) {
        MathContext mc = new MathContext(2);
        return result.round(mc).stripTrailingZeros();
    }

    private BigDecimal performOperation(BigDecimal x, BigDecimal y, String operator) {
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
                result = x.divide(y);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }
}
