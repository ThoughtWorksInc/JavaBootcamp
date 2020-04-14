package bootcamp.data;

public class Person {

    private final String firstName;
    private final String secondName;

    public Person(final String firstName, final String secondName) {
        this.firstName = firstName;
       this.secondName = secondName;

    }
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Person person = (Person) object;
        return firstName.equals(person.firstName) &&
                secondName.equals(person.secondName);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), firstName, secondName);
    }
}
