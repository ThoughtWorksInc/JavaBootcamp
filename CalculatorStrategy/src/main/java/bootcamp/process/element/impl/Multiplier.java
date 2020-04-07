package bootcamp.process.element.impl;

import bootcamp.process.element.ElementFactory;
import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.util.Optional;

public class Multiplier implements ProcessingElement {

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.multiply(y);
    }
}
