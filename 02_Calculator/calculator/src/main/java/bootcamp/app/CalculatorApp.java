package bootcamp.app;

import java.math.BigDecimal;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

public class CalculatorApp {
    public static void main(final String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Please provide three arguments in the format: [number1] [operator] [number2]!");
        }

        Params params = new Params(new BigDecimal(args[0]), new BigDecimal(args[2]), args[1]);
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(params));
    }
}
