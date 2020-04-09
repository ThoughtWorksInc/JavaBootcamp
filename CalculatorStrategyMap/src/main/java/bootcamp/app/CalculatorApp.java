package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(String args[]) {
        Params params;
        try {
            Calculator calc = new Calculator(new ElementFactoryImpl());
            params = new Params(new BigDecimal(args[0]), new BigDecimal(args[2]), args[1]);
            Result result = calc.calculate(params);
            System.out.println(result.getValue() + " " + result.getStatus() + " " + result.getStatusMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("You need to run this app from command line and include 3 arguments");
        }
    }
}
