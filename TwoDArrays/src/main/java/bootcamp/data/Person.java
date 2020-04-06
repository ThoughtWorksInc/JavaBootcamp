package bootcamp.data;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean equals(Person foundPerson) {
        if (foundPerson == null ) {
            return false;
        }
        return getFirstName().equals(foundPerson.getFirstName()) &&
                getLastName().equals(foundPerson.getLastName());
    }
}
