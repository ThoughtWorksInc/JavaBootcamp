package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {
        if (args.length != 3) {
            System.out.print("Incorrect number of arguments given: Provide 2 numbers and one operator.");
        }
        Params params = new Params(new BigDecimal(args[0]), new BigDecimal(args[1]), args[2]);
        System.out.print(new Calculator().calculate(params));
    }
}