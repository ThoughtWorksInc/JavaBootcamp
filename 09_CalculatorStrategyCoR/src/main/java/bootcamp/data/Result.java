package bootcamp.data;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    // If there was an error in processing, set the relevant status, message and value to empty Optional.
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

    @Override
    public String toString() {
        return "Status is: "+ this.getStatus() + "\nMessage:  "+ this.getStatusMessage() + "\nValue: " + (getValue().isPresent() ? getValue().get() : Optional.empty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return status == result.status && Objects.equals(statusMessage, result.statusMessage) && Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, statusMessage, value);
    }
}
