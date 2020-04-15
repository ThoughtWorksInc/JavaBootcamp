package bootcamp.process.element;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public interface ProcessingElement extends BiFunction<BigDecimal, BigDecimal, BigDecimal> {
}
