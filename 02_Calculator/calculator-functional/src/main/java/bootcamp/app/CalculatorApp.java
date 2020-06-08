package bootcamp.app;

import java.math.BigDecimal;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;

public class CalculatorApp {
    public static void main(final String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Please provide three arguments in the format: [number1] [operator] [number2]!");
        }

        final var params = new Params(new BigDecimal(args[0]), new BigDecimal(args[2]), args[1]);
        final var calculator = new Calculator();
        final var result = calculator.calculate(params);

        logAndExit(result);
    }

    private static void logAndExit(Result result) {
        if (result.value.isPresent()) {
            System.out.println(result.value.get());
        } else {
            System.err.println(result.statusMessage);
            System.exit(1);
        }
    }
}
