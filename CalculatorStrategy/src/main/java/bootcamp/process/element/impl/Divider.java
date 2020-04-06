package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Divider implements ProcessingElement {
    public BigDecimal process(final BigDecimal x, final BigDecimal y) {
        return x.divide(y);
    }
}
