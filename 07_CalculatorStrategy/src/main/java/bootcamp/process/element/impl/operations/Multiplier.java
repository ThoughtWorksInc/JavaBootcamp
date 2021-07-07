package bootcamp.process.element.impl.operations;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Multiplier implements ProcessingElement {
    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.multiply(y);
    }
}
