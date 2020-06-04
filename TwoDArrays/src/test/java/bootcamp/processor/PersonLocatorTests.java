package bootcamp.processor;

import bootcamp.data.Location;
import bootcamp.data.Person;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonLocatorTests {

    @Test
    public void testCanLocatePerson() {
        Person[][] people = new Person[3][2];
        Person person = new Person("Olivia", "Frost");
        people[2][1] = person;
        PersonLocator personLocator = new PersonLocator(people);
        Optional<Location> location = personLocator.find(person);
        assertTrue(location.isPresent());
        assertEquals(2, location.get().getX());
        assertEquals(1, location.get().getY());
    }

    @Test
    public void testCannotLocatePerson() {
        Person[][] people = new Person[3][2];
        Person person = new Person("Olivia", "Frost");
        PersonLocator personLocator = new PersonLocator(people);
        Optional<Location> location = personLocator.find(person);
        assertFalse(location.isPresent());
    }

}
