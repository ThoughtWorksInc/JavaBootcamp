package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Subtractor implements ProcessingElement {
    public BigDecimal process(final BigDecimal x, final BigDecimal y) {
        return x.subtract(y);
    }
}
