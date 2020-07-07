package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ElementFactory.class);
        System.out.println("Enter an operation: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] split = userInput.split(" ");
        Params params = new Params(new BigDecimal(split[0]), new BigDecimal(split[2]), split[1]);
        Calculator calculator = applicationContext.getBean("calculator", Calculator.class);
        Result result = calculator.calculate(params);
        System.out.println(result.toString());
        applicationContext.close();
    }
}
