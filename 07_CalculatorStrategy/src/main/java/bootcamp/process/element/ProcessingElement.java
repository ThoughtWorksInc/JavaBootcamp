package bootcamp.process.element;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProcessingElement {
    Optional<BigDecimal> process(final BigDecimal x, final BigDecimal y);
}
