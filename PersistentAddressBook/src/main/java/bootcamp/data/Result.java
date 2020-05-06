package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result<T> {
    private final Status status; //FIXME

    private final String statusMessage; //FIXME
    private final Optional<T> value; //FIXME

    public Result(Status status, String statusMessage, Optional<T> value) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = value;
    }

    public Result(Status status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = Optional.empty();
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Optional<T> getValue() {
        return value;
    }

}
