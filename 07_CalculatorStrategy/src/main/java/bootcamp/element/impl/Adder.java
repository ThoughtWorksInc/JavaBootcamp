package bootcamp.element.impl;

import bootcamp.element.ProcessingElement;

import java.math.BigDecimal;

public class Adder implements ProcessingElement {
    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) {
            return false;
        }
    return getClass() == obj.getClass();
    }
}
