package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;

/**
 * TODO: The application should be able to handle 3 arguments (first number, second number, operation).
 * The application should write the results to the standard output.
 */
public class CalculatorApp {
    public static void main(final String[] args) {
        final Params params = new Params(new BigDecimal(3.2), new BigDecimal(1.8), "+");
        final BigDecimal result = new Calculator().calculate(params);
        System.out.println(result);
    }
}
