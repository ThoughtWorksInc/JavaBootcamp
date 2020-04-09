package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;


import java.math.BigDecimal;

public class CalculatorApp {

    public static void main(String[] args) {
        Params params;
        try {
            params = new Params(new BigDecimal(args[0]), new BigDecimal(args[1]), args[2]);
            Calculator calc = new Calculator();
            Result result = calc.calculate(params);
            System.out.println(result.getValue() + " " + result.getStatus() + " " + result.getStatusMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("You need to run this app from command line and include 3 arguments");
        }



    }
}