package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

public class Divider implements ProcessingElement {

    @Override
    public Optional<BigDecimal> process(BigDecimal x, BigDecimal y) {
        if (y.compareTo(BigDecimal.ZERO) == 0) {
            return Optional.empty();
        }
        else return Optional.of(x.divide(y, MathContext.DECIMAL64));
    }
}
