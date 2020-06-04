package bootcamp.processor;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(final Person[][] people) {
        this.people = people;
    }

    public Optional<Location> find(final Person person) {
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[i].length; j++) {
                if (person.equals(people[i][j])) {
                    return Optional.of(new Location(i, j));
                }
            }
        }

        return Optional.empty();
    }
}



