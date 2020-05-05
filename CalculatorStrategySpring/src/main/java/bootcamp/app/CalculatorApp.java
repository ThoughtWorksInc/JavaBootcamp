package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class CalculatorApp {

    public static void main(final String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Please provide three arguments in the format: [number1] [operator] [number2]!");
        }

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ElementFactory.class);
        Params params = new Params(new BigDecimal(args[0]), new BigDecimal(args[2]), args[1]);
        Calculator calc = ctx.getBean(Calculator.class);
        Result result = calc.calculate(params);
        System.out.println(result.getStatus() + " " + result.getValue().get());
    }
}
