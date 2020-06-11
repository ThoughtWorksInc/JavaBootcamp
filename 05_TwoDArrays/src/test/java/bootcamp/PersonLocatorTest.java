package bootcamp;

import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonLocatorTest {

    @Test
    public void shouldReturnLocationIfPersonWasFound(){
        // given
        Person[][] people = new Person[2][2];
        people[0][0] = new Person("John", "Smith");
        people[1][0] = new Person("Alan", "Sugar");
        people[0][1] = new Person("Courtney", "Cox");
        people[1][1] = new Person("Marianne", "Keys");
        PersonLocator personLocator = new PersonLocator(people);
        // when
        Optional<Location> location1 = Optional.of(new Location(1,1));
        Optional<Location> location2 = Optional.of(new Location(1,0));
        // then
        assertEquals(location1, personLocator.find(new Person("Marianne", "Keys")));
        assertEquals(location2, personLocator.find(new Person("Alan", "Sugar")));
    }

    @Test
    public void shouldReturnEmptyOptionalIfPersonNotFound(){
        // given
        Person[][] people = new Person[2][2];
        people[0][0] = new Person("John", "Smith");
        people[1][0] = new Person("Alan", "Sugar");
        people[0][1] = new Person("Courtney", "Cox");
        people[1][1] = new Person("Marianne", "Keys");
        PersonLocator personLocator = new PersonLocator(people);
        // when
        Optional<Location> location = personLocator.find(new Person("Keith", "Roberts"));
        // then
        assertFalse(location.isPresent());
    }
}