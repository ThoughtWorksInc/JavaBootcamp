package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(final Person[][] people) {
        this.people = people;
    }

    public Optional<Location> find(final Person person) {

        int x = 0;
        while (x < people.length) {
            for(int y = 0; y < people[x].length; y++) {
                if (person.equals(people[x][y])) {
                    return Optional.of(new Location(x, y));
                }
            }
            x++;
        }
        return Optional.empty();
    }
}
