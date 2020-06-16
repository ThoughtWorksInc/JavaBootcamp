package bootcamp.process.element;

import java.util.Optional;

public interface ProcessingElementFactory {
    Optional<ProcessingElement> create(final String operator);
}


