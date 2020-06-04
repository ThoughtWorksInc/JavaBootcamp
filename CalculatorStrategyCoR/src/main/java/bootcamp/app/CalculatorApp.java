package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(String... args) {
        BigDecimal x = new BigDecimal(args[0]);
        BigDecimal y = new BigDecimal(args[1]);
        String operator = args[2];

        Result result = new Calculator().calculate(new Params(x, y, operator));
        System.out.println(result);
    }
}