package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {

        BigDecimal x = new BigDecimal(args[0]);
        BigDecimal y = new BigDecimal(args[1]);
        String operator = args[2];

        Params params = new Params(x, y, operator);
        Result result = new Calculator().calculate(params);

        System.out.println(result.getStatus());
        System.out.println(result.getStatusMessage());

        if (result.getStatus().equals(Status.SUCCESS)) {
            System.out.println(result.getValue().get());
        }

    }

}