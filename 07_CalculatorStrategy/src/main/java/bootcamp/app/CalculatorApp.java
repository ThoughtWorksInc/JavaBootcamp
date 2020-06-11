package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {

        BigDecimal x = new BigDecimal(args[0]);
        BigDecimal y = new BigDecimal(args[1]);
        String operator = args[2];

        Params params = new Params(x, y, operator);
        ElementFactory factory = new ElementFactoryImpl();
        Result result = new Calculator(factory).calculate(params);

        System.out.println(result.getStatus());
        System.out.println(result.getStatusMessage());
        System.out.println(result.getValue().get());
    }


}