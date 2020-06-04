package bootcamp.process.element.impl.element;

import bootcamp.process.element.ProcessingElement;

import java.math.BigDecimal;

public class SubtractionElement implements ProcessingElement {

    private static SubtractionElement INSTANCE;

    private SubtractionElement() {}

    //    First time getInstance() is called, it runs through this function
//    INSTANCE will be null and so it will create a new AdditionElement
//    instance and return it
//    In future when getInstance() is called, it will return the INSTANCE
//    previously created (a singleton)
    public static SubtractionElement getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SubtractionElement();
        }

        return INSTANCE;
    }

    @Override
    public BigDecimal process(BigDecimal x, BigDecimal y) {
        return x.subtract(y);
    }
}

