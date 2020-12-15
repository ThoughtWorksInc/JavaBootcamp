package bootcamp.data;

public class Person {

    private final String firstName; //FIXME
    private final String secondName; //FIXME

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

    @Override
    public int hashCode() {
        return (this.firstName.hashCode() + this.secondName.hashCode()) /
                (this.firstName.hashCode() * this.secondName.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return p.firstName.equals(this.firstName)
                    && p.secondName.equals(this.secondName);
        }
        return false;
    }

}
