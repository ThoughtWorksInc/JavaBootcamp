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


@Component
@Scope("singleton")
public class Calculator {

    private final ProcessingElement adder;

    private final ProcessingElement subtractor;

    private final ProcessingElement multiplier;

    private final ProcessingElement divider;

    @Autowired
    public Calculator(@Qualifier("adder") ProcessingElement adder,
                      @Qualifier("subtractor") ProcessingElement subtractor,
                      @Qualifier("multiplier") ProcessingElement multiplier,
                      @Qualifier("divider") ProcessingElement divider) {

        this.adder = adder;
        this.divider = divider;
        this.multiplier = multiplier;
        this.subtractor = subtractor;
    }

    public ProcessingElement getAdder() {
        return adder;
    }

    public ProcessingElement getSubtractor() {
        return subtractor;
    }

    public ProcessingElement getMultiplier() {
        return multiplier;
    }

    public ProcessingElement getDivider() {
        return divider;
    }

    public Result calculate(final Params params) {
        String operator = params.getOperator();
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        Optional<BigDecimal> value;
        switch (operator) {
            case "+":
                value = Optional.ofNullable(this.adder.apply(x, y));
                break;
            case "-":
                value = Optional.ofNullable(this.subtractor.apply(x, y));
                break;
            case "/":
                value = Optional.ofNullable(this.divider.apply(x, y));
                break;
            case "x":
                value = Optional.ofNullable(this.multiplier.apply(x, y));
                break;
            default:
                return new Result(Status.INVALID_OPERATOR);
        }
        return new Result(value);
    }


}
