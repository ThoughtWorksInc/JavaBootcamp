package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {

    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public Result(Status status, String statusMessage, Optional<BigDecimal> value) {
        this.value = value;
        this.statusMessage = statusMessage;
        this.status = status;
    }

    //TODO Constructor. If there was an error in processing, set the relevant status, message and value to empty Optional.
    //TODO Getters
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
