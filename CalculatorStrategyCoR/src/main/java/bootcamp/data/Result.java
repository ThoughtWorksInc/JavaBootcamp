package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public Result(final Status status, final String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = Optional.empty();
    }

    public Result(final Optional<BigDecimal> value) {
        this.status = Status.SUCCESS;
        this.statusMessage = null;
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
}
