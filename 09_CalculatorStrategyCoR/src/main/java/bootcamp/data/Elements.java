package bootcamp.data;

public enum Elements {
    ADD("+"),
    DIVIDE("/"),
    MULTIPLY("x"),
    SUBTRACT("-");

    public String getElement(){
        return element;
    }

    private String element;

    Elements(String element) {
        this.element = element;
    }
}
