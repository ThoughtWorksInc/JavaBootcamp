package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(final String[] args) {
        Scanner values = new Scanner(System.in);

        System.out.println("Enter first argument:");
        String x = values.nextLine();

        System.out.println("Enter second argument:");
        String y = values.nextLine();

        System.out.println("Enter an operator:");
        String operator = values.nextLine();

        System.out.println("Final operation: " + x + " " + operator + " " + y);

        Params params = new Params(new BigDecimal(x), new BigDecimal(y), operator);
        System.out.println("Answer: " + new Calculator().calculate(params));
    }
}
