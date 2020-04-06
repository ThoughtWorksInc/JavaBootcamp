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


        int row = 0;
        int column = 0;
        while(column < this.people.length){
            row = 0;
            while(row < this.people[column].length && !person.equals(people[column][row])){
                row++;
            }
            column++;
        }

        return Optional.ofNullable(new Location(row, column));
    }

}
