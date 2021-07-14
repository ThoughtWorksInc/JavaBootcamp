package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;

import java.math.BigDecimal;

public class Main {
    public static void main (String [] args) {
        Params params = new Params(new BigDecimal(4), new BigDecimal(5), "-");
        Calculator calculator = new Calculator();
        Result res = calculator.calculate(params);
        System.out.println(res);

    }
}
