package bootcamp.process.element;

import java.util.Optional;

public interface ElementFactory {
    Optional<ProcessingElement> create(final String operator);
}