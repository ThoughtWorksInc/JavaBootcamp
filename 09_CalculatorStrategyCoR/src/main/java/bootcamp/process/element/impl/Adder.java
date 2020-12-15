package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

public class Adder implements ProcessingElement {

    @Override
    public Optional<BigDecimal> process(BigDecimal x, BigDecimal y) {
        return Optional.of(x.add(y, MathContext.DECIMAL64));
    }
}
