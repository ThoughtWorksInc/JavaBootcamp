package bootcamp.controller;

import bootcamp.model.Assignment;
import bootcamp.model.Course;
import bootcamp.model.Student;
import bootcamp.persistencemock.NotFoundException;
import bootcamp.persistencemock.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    Store store;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(this.store.getStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable("id") final int id) throws NotFoundException {
        Student student = this.store.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = this.store.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourse(@PathVariable("id") final int id) throws NotFoundException {
        Course course = this.store.getCourse(id);
        return new ResponseEntity<>(course, HttpStatus.OK);

    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public ResponseEntity<List<Student>> assign(Assignment assignment) throws NotFoundException {
        this.store.assignStudentToACourse(assignment.getStudentId(), assignment.getCourseId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/enrollment/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> enrollment(@PathVariable("id") final int id) throws NotFoundException {
        List<Student> students = this.store.getStudentsInACourse(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/my-courses/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> myCourses(@PathVariable("id") final int id) throws NotFoundException {
        List<Course> courses = this.store.getCoursesForAStudent(id);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}