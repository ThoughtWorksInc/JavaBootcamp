import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonLocatorTest {

    PersonLocator personLocator;
    Person[][] people;

    @Before
    public void setUp() {

        Person person1 = new Person("Philip", "Banks");
        Person person2 = new Person("Ashley", "Banks");
        Person person3 = new Person("Geofrey", " ");
        Person person4 = new Person("Carlton", "Banks");

        people = new Person[][]{{person1, person2}, {person3, person4}};

        personLocator = new PersonLocator(people);
    }


    @Test
    public void shouldGetLocationOfPersonInArray() {

        Optional<Location> location = personLocator.find(new Person("Carlton", "Banks"));

        int x = location.get().getX();
        int y = location.get().getY();

        assertTrue(location.isPresent());
        assertEquals(x, 1);
        assertEquals(y, 1);
    }

    @Test
    public void shouldReturnEmptyOptionalIfNotPresent() {

        Optional<Location> location = personLocator.find(new Person("Jesus", "Christ"));

        assertTrue(location.isEmpty());
    }


}