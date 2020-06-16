package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(Person[][] people) {
        this.people = people;
    }

    public Optional<Location> find(Person person) {

        for (int i = 0; i<people.length ; i++){
            for (int j = 0; j<people[i].length; j++){
                var dude = people[i][j];
                if (dude.equals(person)) return Optional.of(new Location(i, j));
            }
        }

        return Optional.empty();
    }
}
