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
        Optional<Location> location = Optional.empty();
        int x = 0;
        boolean done = false;
        while (x < people.length && !done) {
            int y = 0;
            while (y < people[x].length && !done) {
                if (person.equals(people[x][y])) {
                    location = Optional.of(new Location(x, y));
                    done = true;
                }
                y++;
            }
            x++;
        }
        return location;
    }
}
