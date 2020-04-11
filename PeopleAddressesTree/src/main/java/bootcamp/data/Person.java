package bootcamp.data;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String secondName;

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(Person o) {
        if (firstName.equals(o.firstName) && secondName.equals(o.secondName)) {
            return 0;
        } else return -1;
    }
}
