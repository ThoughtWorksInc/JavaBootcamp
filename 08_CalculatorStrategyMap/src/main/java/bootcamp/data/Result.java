package bootcamp.data;

import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<Double> value;

    public Result(Status status, String statusMessage, Optional<Double> value) {
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

    public Optional<Double> getValue() {
        return value;
    }
}
