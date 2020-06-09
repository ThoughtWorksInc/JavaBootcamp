package bootcamp.data;

import java.util.Optional;

public class Result<T> {
    public final Status status;
    public final String message;
    public final Optional<T> value;

    public Result(final T value) {
        this.value = Optional.of(value);
        this.status = Status.SUCCESS;
        this.message = "Success";
    }

    public Result(final Status status, final String message) {
        this.value = Optional.empty();
        this.status = status;
        this.message = message;
    }

    public Result() {
        this.value = Optional.empty();
        this.status = Status.SUCCESS;
        this.message = "";
    }
}
