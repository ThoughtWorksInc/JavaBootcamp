package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.element.ProcessingElement;

// TODO this is a Component
public class Calculator {
    private final ProcessingElement adder = null; //FIXME
    private final ProcessingElement subtractor = null; //FIXME
    private final ProcessingElement multiplier = null; //FIXME
    private final ProcessingElement divider = null; //FIXME

    // TODO Calculator to be autowired to inject ProcessingElements
    public Calculator(/* TODO Use qualifier to get adder by name */ ProcessingElement adder,
            /* TODO Use qualifier to get subtractor by name */ ProcessingElement subtractor,
            /* TODO Use qualifier to get multiplier by name */ ProcessingElement multiplier,
            /* TODO Use qualifier to get divider by name */ ProcessingElement divider) {
        // TODO assign and initialise processing elements.
    }


    public Result calculate(final Params params) {
        // TODO select the processing element using the operator and process the operands.
        return null;
    }
}
