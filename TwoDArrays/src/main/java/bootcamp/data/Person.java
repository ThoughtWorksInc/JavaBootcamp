package bootcamp.data;

import java.util.Objects;

public class Person {
    private final String _lastName;
    private final String _firstName;

    public Person(String firstName, String lastName) {
        _firstName = firstName;
        _lastName = lastName;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(_lastName, person._lastName) &&
                Objects.equals(_firstName, person._firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_lastName, _firstName);
    }
}
