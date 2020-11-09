package bootcamp.persistencemock;

import bootcamp.model.Course;
import bootcamp.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Store {
    private final List<Student> students;
    private final List<Course> courses;
    private final CourseToStudentMap courseMap;

    public Store() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.courseMap = new CourseToStudentMap();
        populateStudents();
        populateCourses();
    }

    private void populateCourses() {
        this.courses.addAll(List.of(new Course(201, "Data Structure Fundamentals"),
                new Course(202, "Discrete Mathematics"),
                new Course(203, "Programming in Java"),
                new Course(204, "Computer Networks"),
                new Course(205, "Software Architecture")));
    }

    private void populateStudents() {
        this.students.addAll(List.of(new Student(101, "James", "Wright"),
                new Student(102, "Amanda", "Carpenter"),
                new Student(103, "Zaman", "Khan"),
                new Student(104, "Wendy", "Chan"),
                new Student(105, "Smantha", "Frost"),
                new Student(106, "Aasia", "Iqbal"),
                new Student(107, "Charles", "Bloom"),
                new Student(108, "David", "Mason"),
                new Student(109, "Susan", "Ingold"),
                new Student(110, "Beth", "Harris")));
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public Student getStudent(final int id) throws NotFoundException {
        final Optional<Student> student = students.stream().filter(x -> x.getId() == id).findFirst();
        if (student.isEmpty()) throw new NotFoundException(id, "Student");
        return student.get();
    }

    public Course getCourse(final int id) throws NotFoundException {
        final Optional<Course> course = courses.stream().filter(x -> x.getId() == id).findFirst();
        if (course.isEmpty()) throw new NotFoundException(id, "Course");
        return course.get();
    }

    private Student getStudentInternal(final int id) {
        try {
            return getStudent(id);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Course getCourseInternal(final int id) {
        try {
            return getCourse(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudentsInACourse(final int courseId) throws NotFoundException {
        getCourse(courseId); // Just to check if the course exists
        Optional<Set<Integer>> studentIds = courseMap.getStudentsInACourse(courseId);
        return studentIds.isEmpty()?
                new ArrayList<Student>() :
                studentIds.get().stream().map(x -> getStudentInternal(x)).collect(Collectors.toList());
    }

    public List<Course> getCoursesForAStudent(final int studentId) throws NotFoundException {
        getStudent(studentId); // Just to check if the student exists
        Optional<Set<Integer>> courseIds = courseMap.getCoursesForAStudent(studentId);
        return courseIds.isEmpty() ?
                new ArrayList<Course>() :
                courseIds.get().stream().map(x -> getCourseInternal(x)).collect(Collectors.toList());
    }

    public void assignStudentToACourse(final int studentId, final int courseId) throws NotFoundException {
        getStudent(studentId);
        getCourse(courseId);
        courseMap.addStudent(courseId, studentId);
    }
 }
