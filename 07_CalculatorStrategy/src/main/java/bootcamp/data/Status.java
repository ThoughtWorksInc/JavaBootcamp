package bootcamp.data;

public enum Status {
    ARITHMETIC_ERROR("Arithmetic Error"),
    INVALID_OPERATION("Invalid Operation"),
    SUCCESS("");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
