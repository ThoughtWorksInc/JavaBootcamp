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
        Optional<Location> loc = Optional.empty();
        for (int i=0; i< people.length; i++)
            for (int j=0; j< people[i].length; j++) {
                if (person.equals(people[i][j])) loc = Optional.of(new Location(i, j));
            }
        return loc;
    }
}
