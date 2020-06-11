package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Add implements ProcessingElement {
    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }
}
