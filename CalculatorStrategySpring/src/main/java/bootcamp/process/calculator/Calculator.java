package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
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
    public Calculator(@Qualifier("adder") ProcessingElement adder,
            @Qualifier("subtractor") ProcessingElement subtractor,
            @Qualifier("multiplier") ProcessingElement multiplier,
            @Qualifier("divider") ProcessingElement divider) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
    }


    public Result calculate(final Params params) {
        BigDecimal x = params.getX();
        BigDecimal y = params.getY();
        ProcessingElement processor;

        switch(params.getOperator()) {
            case "+":
                processor = adder;
                break;
            case "-":
                processor = subtractor;
                break;
            case "x":
                processor = multiplier;
                break;
            case "/":
                processor = divider;
                break;
            default:
                throw new IllegalArgumentException("Operator must be one of: +, -, x, /");
        }

        return new Result(Optional.ofNullable(processor.apply(x, y)));
    }
}
