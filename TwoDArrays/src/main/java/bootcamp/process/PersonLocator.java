package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] _people;

    public PersonLocator(Person[][] people) {
        _people = people;
    }

    public Optional<Location> find(final Person person) {
        for (int x = 0; x < _people.length; x++) {
            for (int y = 0; y < _people[x].length; y++) {
                if (person.equals(_people[x][y])) {
                    return Optional.of(new Location(x, y));
                }
            }
        }

        return Optional.empty();
    }
}
