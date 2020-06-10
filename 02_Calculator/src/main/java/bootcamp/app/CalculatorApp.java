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
        Params inputParams = new Params(new BigDecimal(args[0]), new BigDecimal(args[2]), args[1]);
        Calculator calc = new Calculator();
        printResult(args, calc.calculate(inputParams));
    }

    private static void printResult(String[] args, BigDecimal result){
        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
    }

}