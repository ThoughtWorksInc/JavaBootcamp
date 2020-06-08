package bootcamp.process.element.impl;

import java.math.BigDecimal;
import java.util.Optional;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;

public class InvalidOperationResultCreator implements ProcessingElement {
  public Result process(final BigDecimal x, final BigDecimal y) {
    return new Result(Optional.empty(), Status.INVALID_OPERATION, "Not a valid operator");
  }
}