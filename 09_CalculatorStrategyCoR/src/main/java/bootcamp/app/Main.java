package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        Integer n1 = scan.nextInt();
        System.out.println("Enter another number");
        Integer n2 = scan.nextInt();
        System.out.println("Enter an opeation symbol - + x /");
        String operation = scan.next();
        Params params = new Params(new BigDecimal(n1), new BigDecimal(n2), operation);
        Calculator calculator = new Calculator();
        Result res = calculator.calculate(params);
        System.out.println(res);

    }
}
