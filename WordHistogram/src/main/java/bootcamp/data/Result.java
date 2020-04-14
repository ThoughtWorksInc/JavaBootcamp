package bootcamp.data;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Result<T> {
    private final Status status;
    private final String message;
    private final Optional<T> value;

    public Result(T value) {
        this.status = Status.SUCCESS;
        this.message = "";
        this.value = Optional.ofNullable(value);
    }

    public Result(Status status, String message) {
        this.status = status;
        this.message = message;
        this.value = Optional.empty();
    }

    public Result() {
        this.status = Status.SUCCESS;
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
