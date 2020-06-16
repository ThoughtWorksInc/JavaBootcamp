package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.*;

import java.util.HashMap;


public class Program {

    public static void main(String[] args){
        var x = Double.parseDouble(args[0]);
        var y = Double.parseDouble(args[1]);;
        var operator = args[2];

        var calculator = new Calculator(new BasicProcessingElementFactory(populateProcessingElements()));
        var params = new Params(x,y,operator);
        var result = calculator.calculate(params);

        System.out.println(result);
    }

    private static HashMap<String, ProcessingElement> populateProcessingElements() {
        var map = new HashMap<String, ProcessingElement>();

        map.put("-", new SubtractElement());
        map.put("+", new AddElement());
        map.put("*", new MultElement());
        map.put("/", new DivElement());

        return map;
    }
}
