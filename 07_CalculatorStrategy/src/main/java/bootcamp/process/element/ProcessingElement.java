package bootcamp.process.element;

import java.math.BigDecimal;

import bootcamp.data.Result;

public interface ProcessingElement {
    Result process(final BigDecimal x, final BigDecimal y);
}
