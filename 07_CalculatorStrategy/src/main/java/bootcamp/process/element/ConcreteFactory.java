package bootcamp.process.element;

import bootcamp.process.element.impl.operations.Adder;
import bootcamp.process.element.impl.operations.Divider;
import bootcamp.process.element.impl.operations.Multiplier;
import bootcamp.process.element.impl.operations.Subtractor;

import java.util.Optional;

public class ConcreteFactory implements ElementFactory {

    @Override
     public Optional<ProcessingElement> create(final String operator) {
        switch (operator) {
            case ("+"): return Optional.of(new Adder());
            case ("-"): return Optional.of(new Subtractor());
            case ("x"): return Optional.of(new Multiplier());
            case ("/"): return Optional.of(new Divider());
            default: return Optional.empty();
        }
    }
}
