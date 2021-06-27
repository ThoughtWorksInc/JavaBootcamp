package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(final String[] args) {
        /* Default input
        Params params = new Params(new BigDecimal(3.2),new BigDecimal(1.8), "+");
        Calculator calc = new Calculator();
        BigDecimal result = calc.calculate(params);
        System.out.println(result.stripTrailingZeros());
         */

        // testing cli args[]
        if (args.length == 2) System.out.println("Printing args" + args[0] + args[1]);

        // CLI input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your first number");
        BigDecimal p1 = scanner.nextBigDecimal();
        System.out.println("Input your second number");
        BigDecimal p2 = scanner.nextBigDecimal();
        System.out.println("Input the operation you would like to perform: + - / x");
        String operation = scanner.next();
        Params params = new Params(p1, p2, operation);
        Calculator calc = new Calculator();
        BigDecimal result = calc.calculate(params);
        System.out.println(result.stripTrailingZeros());


        /*   Fun way to explain why using big decimals is important
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);

        BigDecimal _a = new BigDecimal("0.02");
        BigDecimal _b = new BigDecimal("0.03");
        BigDecimal _c = _b.subtract(_a);
        System.out.println(_c);
        */

    }
}
