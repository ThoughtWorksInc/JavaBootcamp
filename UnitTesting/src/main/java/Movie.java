public class Movie {

    private final String title;
    private final int ageRestriction;

    public Movie(String title, int ageRestriction) {
        this.title = title;
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public String getTitle() {
        return title;
    }
}
