package bootcamp.element.impl;

import bootcamp.element.ProcessingElement;

import java.math.BigDecimal;

public class Subtractor implements ProcessingElement {
    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.subtract(y);
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
