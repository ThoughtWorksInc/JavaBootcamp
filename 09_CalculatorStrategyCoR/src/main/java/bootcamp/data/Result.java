package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status; //FIXME
    private final String statusMessage; //FIXME
    private final Optional<BigDecimal> value; //FIXME

    public Result(Status status, String statusMessage, Optional<BigDecimal> value) {
        this.status = status;
        this.statusMessage = statusMessage;
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
