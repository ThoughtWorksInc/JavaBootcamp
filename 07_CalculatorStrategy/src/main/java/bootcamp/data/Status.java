package bootcamp.data;

public enum Status {
    ARITHMETIC_ERROR("Arithmetic Error: Cannot divide by 0"),
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
