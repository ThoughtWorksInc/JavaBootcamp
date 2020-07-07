package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public Result(Status status, String message, Optional<BigDecimal> value) {
        this.status = status;
        this.statusMessage = message;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public Optional<BigDecimal> getValue() {
        return value;
    }

    public String getMessage(){
        return statusMessage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Result r = (Result) obj;
        return status.equals(r.status) && value.equals(r.value);
    }

    @Override
    public String toString() {
        return value.isEmpty() ? "Error: no value" : " = " + value.get();
    }
}
