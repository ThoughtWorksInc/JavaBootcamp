package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

public class ElementFactoryImpl implements ElementFactory {
  public ProcessingElement create(final String operator) {
    switch (operator) {
      case "+":
        return new Adder();
      case "-":
        return new Subtractor();
      case "x":
        return new Multiplier();
      case "/":
        return new Divider();
      default:
        return new InvalidOperationResultCreator();
    }
  }
}