package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.impl.AdderFactory;
import bootcamp.process.element.impl.DividerFactory;
import bootcamp.process.element.impl.MultiplierFactory;
import bootcamp.process.element.impl.SubtractorFactory;

import java.math.BigDecimal;

public class Main {
    public static void main (String [] args) {
        Params params = new Params(new BigDecimal(4), new BigDecimal(5), "-");
        ElementFactory multiplier = new MultiplierFactory(null,params.getOperator());
        ElementFactory divider = new DividerFactory(multiplier, params.getOperator());
        ElementFactory subtractor = new SubtractorFactory(divider,params.getOperator());
        ElementFactory adder = new AdderFactory(subtractor, params.getOperator());
        Calculator calculator = new Calculator(subtractor);
        Result res = calculator.calculate(params);
        System.out.println(res.getStatus() + "" + res.getStatusMessage() + "" + res.getValue());





    }
}
