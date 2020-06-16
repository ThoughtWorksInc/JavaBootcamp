package bootcamp.data;

public class Params {
    private final double x;
    private final double y;
    private final String operator;

    public Params(double x, double y, String operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }

    //TODO Constructor
    //TODO Getters
}
