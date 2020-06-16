package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

public class MultElement implements ProcessingElement {

    @Override
    public double process(double x, double y) {
        return x*y;
    }
}
