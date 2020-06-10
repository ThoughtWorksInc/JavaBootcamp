package bootcamp.data;

import java.math.BigDecimal;
import java.util.Optional;

public class Result {
    private final Status status;
    private final String statusMessage;
    private final Optional<BigDecimal> value;

    public  final static String ARITHMETIC_ERROR_MESSAGE = "there has been an arithmetic error";
    public  final static String SUCCESS_MESSAGE = "success";
    public  final static String INVALID_ERROR_MESSAGE = "invalid error message";

    public Result (Status status, String statusMessage){
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = Optional.empty();
    }

    public Result(Optional<BigDecimal> value){
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
