package bootcamp.process.operation.impl;

import java.math.BigDecimal;

import bootcamp.process.operation.ArithmeticOperation;

public class ArithmeticOperations {
    public static ArithmeticOperation add = (final BigDecimal x, final BigDecimal y) -> x.add(y);
    public static ArithmeticOperation subtract = (final BigDecimal x, final BigDecimal y) -> x.subtract(y);
    public static ArithmeticOperation multiply = (final BigDecimal x, final BigDecimal y) -> x.multiply(y);
    public static ArithmeticOperation divide = (final BigDecimal x, final BigDecimal y) -> x.divide(y);
}