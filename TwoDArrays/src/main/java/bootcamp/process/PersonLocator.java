package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(Person[][] people){
        this.people = people;
    }

    public Optional<Location> find(final Person person) {
        Location location = null;

        for(int column = 0; column<people.length; column++){
            for(int row = 0; row<people[column].length; row++){
                Person currentPerson = people[column][row];
                if(person.equals(currentPerson)){
                    location = new Location(row, column);
                    break;
                }
            }
        }
        return Optional.ofNullable(location);
    }

}
