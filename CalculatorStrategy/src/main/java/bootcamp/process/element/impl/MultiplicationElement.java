package bootcamp.process.element.impl;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class MultiplicationElement implements ProcessingElement {

    private static MultiplicationElement INSTANCE;

    private MultiplicationElement() {}

    //    First time getInstance() is called, it runs through this function
//    INSTANCE will be null and so it will create a new AdditionElement
//    instance and return it
//    In future when getInstance() is called, it will return the INSTANCE
//    previously created (a singleton)
    public static MultiplicationElement getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MultiplicationElement();
        }

        return INSTANCE;
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.multiply(y);
    }
}
