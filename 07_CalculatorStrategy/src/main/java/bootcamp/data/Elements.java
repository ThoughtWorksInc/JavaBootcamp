package bootcamp.data;

public enum Elements {

    ADD("+"),
    DIVIDE("/"),
    MULTIPLY("*"),
    SUBTRACT("-");


    private String string;

    public String get(){
        return string;
    }

    Elements(String string) {
        this.string = string;
    }
}
