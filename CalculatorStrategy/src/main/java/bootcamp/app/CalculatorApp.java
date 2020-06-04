package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(String... args) {
        BigDecimal x = new BigDecimal(args[0]);
        BigDecimal y = new BigDecimal(args[1]);
        String operator = args[2];

        Result result = new Calculator(new ElementFactoryImpl())
                .calculate(new Params(x, y, operator));
//      .println implicitly runs toString() on anything you pass to it
        System.out.println(result);
    }
}