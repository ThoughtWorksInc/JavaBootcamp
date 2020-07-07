package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component("calculator")
public class Calculator {
    private final ProcessingElement adder;
    private final ProcessingElement subtractor;
    private final ProcessingElement multiplier;
    private final ProcessingElement divider;

    @Autowired
    public Calculator( @Qualifier("adder") ProcessingElement adder, @Qualifier("subtractor") ProcessingElement subtractor,
                       @Qualifier("multiplier") ProcessingElement multiplier, @Qualifier("divider") ProcessingElement divider) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }

    public Result calculate(final Params params) {
        switch (params.getOperator()) {
            case "+":
                return new Result(Status.SUCCESS, "", Optional.of(adder.apply(params.getX(), params.getY())));
            case "-":
                return new Result(Status.SUCCESS, "", Optional.of(subtractor.apply(params.getX(), params.getY())));
            case "x":
                return new Result(Status.SUCCESS, "", Optional.of(multiplier.apply(params.getX(), params.getY())));
            case "/":
                return new Result(Status.SUCCESS, "", Optional.of(divider.apply(params.getX(), params.getY())));
            default:
                return new Result(Status.INVALID_OPERATOR, "Invalid operator", Optional.empty());
        }
    }
}
