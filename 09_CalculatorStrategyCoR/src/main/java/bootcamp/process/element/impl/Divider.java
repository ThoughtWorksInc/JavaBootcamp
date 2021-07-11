package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Divider implements ProcessingElement {
    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) throws ArithmeticException{
        if (y.equals(new BigDecimal(0))) throw new ArithmeticException();
        return x.divide(y);
    }
}
