package bootcamp.model;

public class Course {
    private final int id;
    private final String title;

    public Course(final int id, final String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
