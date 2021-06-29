package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator (Person[][] persons) {
        this.people = persons.clone();
    }
    public Optional<Location> find(final Person person) {
        return null; //FIXME
    }
}
