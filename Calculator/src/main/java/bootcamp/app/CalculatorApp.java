package bootcamp.app;

import bootcamp.calculator.Calculator;
import bootcamp.data.Params;
import java.math.BigDecimal;

public class CalculatorApp {
    private static Prompter _prompter = new Prompter();

    public static void main(final String[] args) {
        _prompter.writeLine("Enter first number:");
        String firstNumber = _prompter.readline();
        _prompter.writeLine("Enter operation:");
        String operation = _prompter.readline();
        _prompter.writeLine("Enter second number:");
        String secondNumber = _prompter.readline();

        Params params = new Params(new BigDecimal(firstNumber), new BigDecimal(secondNumber), operation);

        BigDecimal calculation = new Calculator().calculate(params);

        _prompter.writeLine(calculation.toString());
    }
}
