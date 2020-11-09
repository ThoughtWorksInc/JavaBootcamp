package bootcamp.model;

public class Assignment {
    private final int studentId;
    private final int courseId;

    public Assignment(final int studentId, final int courseId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public int getCourseId() {
        return this.courseId;
    }
}
