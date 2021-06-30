package bootcamp.process;

import bootcamp.data.Location;

import java.util.Optional;

public class PersonLocator<Person> {
    private final Person[][] people;

    public PersonLocator (Person[][] persons) {
        this.people = persons.clone();
    }

    public Optional<Location> find(final Person person) {
        Optional<Location> loc = Optional.empty();
        for (int i=0; i< people.length; i++)
            for (int j=0; j< people[i].length; j++) {
                if (person.hashCode() == people[i][j].hashCode()) {
                    if (person.equals(people[i][j])) {
                        loc = Optional.of(new Location(i, j));
                        break;
                    }
                } else continue;
            }
        return loc;
    }
}
