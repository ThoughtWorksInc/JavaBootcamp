package bootcamp.data;

public class Person {
    public final String firstName;
    public final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean isSamePerson(Person personToCompare) {
        if (personToCompare == null) {
            return false;
        }

        return personToCompare.firstName.equals(firstName) && personToCompare.lastName.equals(lastName);
    }
}
