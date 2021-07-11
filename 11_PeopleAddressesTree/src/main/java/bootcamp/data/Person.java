package bootcamp.data;

import javax.management.ObjectName;
import java.util.Comparator;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String secondName;

    // Fix the compilation error.
    @Override
    public int compareTo(Person person) {
        return getFirstName().compareToIgnoreCase(person.getFirstName());
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
