package bootcamp.process.element.impl.operations;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class Adder implements ProcessingElement {

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }
}
