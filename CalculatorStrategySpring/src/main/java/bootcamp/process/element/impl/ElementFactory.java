package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

// TODO this is a configuration class.
// TODO this needs to scan components in the relevant package(s).
// TODO factory methods to be annotated as Bean
public class ElementFactory {
    ProcessingElement adder() {
        return (x, y) -> x.add(y);
    }

    ProcessingElement subtractor() {
        return (x, y) -> x.subtract(y);
    }

    ProcessingElement multiplier() {
        return (x, y) -> x.multiply(y);
    }

    ProcessingElement divider() {
        return (x, y) -> x.divide(y);
    }
}
