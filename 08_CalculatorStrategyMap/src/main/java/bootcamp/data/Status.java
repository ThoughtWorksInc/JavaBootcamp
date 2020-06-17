package bootcamp.data;

public enum Status {
    SUCCESS(""),
    ARITHMETIC_ERROR("ARITHMETIC ERROR - Can't divide by zero"),
    INVALID_OPERATOR("INVALID OPERATOR");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}