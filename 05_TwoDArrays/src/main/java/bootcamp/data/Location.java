package bootcamp.data;

public class Location {
    private final int x; //= Integer.MIN_VALUE;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Location location = (Location) object;
        return this.x == location.getX() && this.y == location.getY();
    }
}
