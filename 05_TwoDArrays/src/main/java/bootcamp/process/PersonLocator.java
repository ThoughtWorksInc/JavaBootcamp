package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(Person[][] people) {
        this.people = people;
    }


    public Optional<Location> find(final Person person) {
        for (int i = 0; i < this.people.length; i++) {
            Person[] persons = this.people[i];
            for (int j = 0; j < persons.length; j++ ) {
                Person p = persons[j];
                if (p.equals(person)) {
                    return Optional.of(new Location(i, j));

                }
            }
        }
        return Optional.empty();
    }
}
