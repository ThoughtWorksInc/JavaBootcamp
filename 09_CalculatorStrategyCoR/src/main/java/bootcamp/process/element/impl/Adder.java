package bootcamp.process.element.impl;

import java.math.BigDecimal;
import java.util.Optional;
import java.lang.ArithmeticException;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;

public class Adder implements ProcessingElement {
  public Result process(final BigDecimal x, final BigDecimal y) {
    try {
      var value = Optional.of(x.add(y));
      return new Result(value, Status.SUCCESS, "success");
    } catch (ArithmeticException error) {
      return new Result(Optional.empty(), Status.ARITHMETIC_ERROR, error.getMessage());
    }
  }
}