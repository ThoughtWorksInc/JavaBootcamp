package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;

import java.math.BigDecimal;

public class CalculatorApp {
    public static void main(String[] args) {
        Params params = new Params(new BigDecimal(2), new BigDecimal(5), "x");
        Calculator calculator = new Calculator();
        Result result = calculator.calculate(params);
        System.out.println(result);
    }
}
