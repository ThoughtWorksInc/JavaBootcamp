package bootcamp.process.element;
import bootcamp.process.element.impl.Adder;
import bootcamp.process.element.impl.Divider;
import bootcamp.process.element.impl.Multiplier;
import bootcamp.process.element.impl.Subtractor;

import java.util.Optional;

public interface ElementFactory {
    static Optional<ProcessingElement> create(String operator) {
        if (operator == "+"){return Optional.of(new Adder());}
        else if (operator == "-"){return Optional.of(new Subtractor());}
        else if (operator == "x"){return Optional.of(new Multiplier());}
        else if (operator == "/"){return Optional.of(new Divider());}
        else return Optional.empty();

    }
}

