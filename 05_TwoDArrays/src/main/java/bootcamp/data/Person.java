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

    @Override
    public int hashCode() {
        return (
                (this.firstName.hashCode() + this.lastName.hashCode())
                        /
                        (this.firstName.hashCode() * this.lastName.hashCode())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return
                    other.firstName.equals(this.firstName)
                            && other.lastName.equals(this.lastName);

        }

        return false;
    }
}
