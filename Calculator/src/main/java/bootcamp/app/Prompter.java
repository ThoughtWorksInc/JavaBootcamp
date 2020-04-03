package bootcamp.app;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class Prompter {
    private static PrintStream _outputStream = new PrintStream(System.out);
    private static Scanner _scanner = new Scanner(System.in);

    public String readline() {
        String operation = _scanner.nextLine();
        return operation;
    }

    public void writeLine(String input) {
        _outputStream.println(input);
    }
}
