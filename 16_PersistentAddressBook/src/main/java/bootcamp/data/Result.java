package bootcamp.data;


import java.util.Optional;

public class Result<T> {
    private final Status status;
    private final String statusMessage;
    private final Optional<T> value;

    public Result(Status status) {
        this.status = status;
        this.statusMessage = status.toString();
        this.value = Optional.empty();
    }

    public Result(Status status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.value = Optional.empty();
    }

    public Result(T value) {
        this.status = Status.SUCCESS;
        this.statusMessage = status.toString();
        this.value = Optional.of(value);
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Optional<T> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.status + " : " +
                this.statusMessage + " : " +
                this.value;
    }
}