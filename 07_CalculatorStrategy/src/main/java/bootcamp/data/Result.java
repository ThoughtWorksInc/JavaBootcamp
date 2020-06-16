package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final Optional<BigDecimal> value;

    public Result(Status status, Optional<BigDecimal> value) {
        this.status = status;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage(){
        return status.getMessage();
    }

    public Optional<BigDecimal> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " = " + value.get();
    }
}
