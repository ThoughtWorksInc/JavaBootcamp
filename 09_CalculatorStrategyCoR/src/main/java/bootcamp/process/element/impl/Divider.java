package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.math.MathContext;

public class Divider implements ProcessingElement {

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.divide(y, MathContext.DECIMAL32).stripTrailingZeros();
    }
}
