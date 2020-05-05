package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class Calculator {
    private final ProcessingElement adder;
    private final ProcessingElement subtractor;
    private final ProcessingElement multiplier;
    private final ProcessingElement divider;

    @Autowired
    public Calculator(@Autowired @Qualifier("adder") ProcessingElement adder,
                      @Autowired @Qualifier("subtractor") ProcessingElement subtractor,
                      @Autowired @Qualifier("multiplier") ProcessingElement multiplier,
                      @Autowired @Qualifier("divider") ProcessingElement divider) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }


    public Result calculate(final Params params) {
        // TODO select the processing element using the operator and process the operands.
        BigDecimal calulcation;

        switch (params.getOperator()) {
            case "x":
                calulcation = multiplier.apply(params.getX(), params.getY());
                break;
            case "+":
                calulcation = adder.apply(params.getX(), params.getY());
                break;
            case "/":
                calulcation = divider.apply(params.getX(), params.getY());
                break;
            case "-":
                calulcation = subtractor.apply(params.getX(), params.getY());
                break;
            default:
                throw new IllegalArgumentException("Input not recognised");
        }
        return new Result(Status.SUCCESS, "", Optional.of(calulcation));
    }
}
