package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ElementFactory.class);
        Params params = new Params(new BigDecimal(args[0]), new BigDecimal(args[1]), args[2]);
        Calculator calculator = ctx.getBean(Calculator.class);
        Result result = calculator.calculate(params);

        if (result.getStatus() == Status.SUCCESS) {
            System.out.print(result.getValue());
        } else {
            System.out.print("Error in calculation: " + result.getStatus() + ":" + result.getStatusMessage());
        }
    }
}
