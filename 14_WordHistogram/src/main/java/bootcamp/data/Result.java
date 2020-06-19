package bootcamp.data;

import java.util.Optional;

public class Result<T> {
    private final Status status;
    private final String message;
    private Optional<T> value = Optional.empty();

    public Result(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Optional<T> value) {
        this.value = value;
        this.status = Status.SUCCESS;
        this.message = "";
    }

    public Result() {
        this.status = Status.SUCCESS;
        this.message = "";
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Optional<T> getValue() {
        return value;
    }

}
