package bootcamp.persistencemock;

import java.util.*;
import java.util.stream.Collectors;

public class CourseToStudentMap {
    private Map<Integer, Set<Integer>> map;

    public CourseToStudentMap() {
        this.map = new HashMap<>();
    }

    public void addStudent(final int courseId, final int studentId) {
        if (!map.containsKey(courseId)) {
            map.put(courseId, new HashSet<>());
        }

        map.get(courseId).add(studentId);
    }

    public Optional<Set<Integer>> getStudentsInACourse(final int courseId) {
        return map.containsKey(courseId) ? Optional.of(map.get(courseId)) : Optional.empty();
    }

    public Optional<Set<Integer>> getCoursesForAStudent(final int studentId) {
        final Set<Integer> courseIds = map.entrySet().stream().
                filter(entry -> entry.getValue().contains(studentId)).
                map(entry -> entry.getKey()).
                collect(Collectors.toSet());

        return courseIds.isEmpty() ? Optional.empty() : Optional.of(courseIds);
    }
}
