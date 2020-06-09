
/**
 * TODO: The application should be able to handle 3 arguments (first number, second number, operation).
 * The application should write the results to the standard output.
 */
package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {

        BigDecimal x = BigDecimal.valueOf(Long.parseLong(args[0]));
        BigDecimal y = BigDecimal.valueOf(Long.parseLong(args[1]));
        String operator = args[2];

        Params params = new Params(x, y, operator);
        BigDecimal result = new Calculator().calculate(params);

        System.out.println(result);
    }


}

