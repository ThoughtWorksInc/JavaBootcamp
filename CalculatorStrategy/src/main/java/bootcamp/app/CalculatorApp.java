package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.calculator.Calculator;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(final String[] args) {
        Params params = new Params(new BigDecimal(args[0]), new BigDecimal(args[1]), args[2]);
        Result result = new Calculator().calculate(params);

        if (result.getStatus() == Status.SUCCESS) {
            System.out.print(result.getValue());
        } else {
            System.out.print("Error in calculation: " + result.getStatus() + ":" + result.getStatusMessage());
        }
    }
}
