package bootcamp.data;

public class Person implements Comparable<Person> {
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

    @Override
    public int compareTo(Person person) {
        return this.firstName.compareTo(person.getFirstName());
    }
}
