package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    PersonLocator(Person[][] people) {
        this.people = people;
    }

    public Optional<Location> find(final Person person) {
        for (int x = 0; x < people.length; x++) {
            for (int y = 0; y < people[x].length; y++) {
                if (person.equals(people[x][y])) {
                    return Optional.of(new Location(x, y));
                }
            }
        }

        return Optional.empty();
    }
}
