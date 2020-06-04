package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public Result(final Status status, final String statusMessage, final Optional<BigDecimal> value) {
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
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Result))
            return false;

        Result that = (Result) o;

        return this.status.equals(that.getStatus()) &&
                this.statusMessage.equals(that.getStatusMessage()) &&
                this.value.equals(that.getValue());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder()
                .append("Status: ")
                .append(this.status)
                .append("\nMessage: ")
                .append(this.statusMessage);

        this.value.ifPresent(bigDecimal -> stringBuilder
                .append("\nValue: ")
                .append(bigDecimal));

        return stringBuilder.toString();
    }
}


