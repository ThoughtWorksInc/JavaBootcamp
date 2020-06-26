package bootcamp.data;

import java.util.Optional;

public class Result<T> {
    private final Status status;
    private final String message;
    private final Optional<T> value;

    public Result(Optional<T> value) {
        this.status = Status.Success;
        this.message = "";
        this.value = value;
    }

    public Result(Status status, String message) {
        this.status = status;
        this.message = message;
        this.value = Optional.empty();
    }

    public Result() {
        this.status = Status.Success;
        this.message = "";
        this.value = Optional.empty();
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
