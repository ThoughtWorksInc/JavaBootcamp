package bootcamp.data;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String secondName;

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
    public int compareTo(Person o) {
        if (this.firstName.equals(o.firstName) && this.secondName.equals(o.secondName)) {
            return 0;
        }
        else return (this.toString().compareTo(o.toString()));
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return (this.getFirstName() == person.getFirstName() && this.getSecondName() == person.getSecondName());
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName;
    }
}
