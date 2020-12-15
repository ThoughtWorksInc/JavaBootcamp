package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;


public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public Result(Status status) {
        this.status = status;
        this.statusMessage = status.toString();
        this.value = Optional.empty();
    }

    public Result(Optional<BigDecimal> value) {
        this.status = value.isPresent() ? Status.SUCCESS: Status.ARITHMETIC_ERROR;
        this.statusMessage = status.toString();
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Optional<BigDecimal> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.status + " : " +
                this.statusMessage + " : " +
                this.value.orElse(null);
    }
}
