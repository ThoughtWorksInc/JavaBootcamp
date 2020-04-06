package bootcamp.process.element;

import java.math.BigDecimal;

public interface ProcessingElement {

    BigDecimal process(final BigDecimal x, final BigDecimal y);
}
