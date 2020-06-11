package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public static final String SUCCESS_MESSAGE = "Success";
    public static final String INVALID_OPERATION_MESSAGE = "Invalid operator. Operator must be one of: 'x', '-', '/', '+'";
    public static final String ARITHMETIC_ERROR = "Arithmetic error";

    public Result(Status status, String statusMessage){
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = Optional.empty();
    }

    public Result(Optional<BigDecimal> value) {
        this.status = Status.SUCCESS;
        this.statusMessage = SUCCESS_MESSAGE;
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
