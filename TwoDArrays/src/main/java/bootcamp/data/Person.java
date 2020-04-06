package bootcamp.data;

public class Person {
    private final String firstName;
    private final String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean equals(Person otherPerson) {
        return getFirstName().equals(otherPerson.getFirstName()) &&
                getLastName().equals(otherPerson.getLastName());
    }
}
