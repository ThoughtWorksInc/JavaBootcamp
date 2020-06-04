package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {

        BigDecimal arg1 = new BigDecimal(args[0]);
        BigDecimal arg2 = new BigDecimal(args[1]);
        String arg3 = args[2];
        final Params params = new Params(arg1, arg2, arg3);
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(params));
    }
}
