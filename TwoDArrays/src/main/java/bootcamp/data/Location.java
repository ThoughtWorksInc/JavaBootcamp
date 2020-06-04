package bootcamp.data;

public class Location {
    private final int x;
    private final int y;

    public Location(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
}
