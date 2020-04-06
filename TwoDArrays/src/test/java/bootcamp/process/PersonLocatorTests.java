package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonLocatorTests {

    Person[][] people = {{new Person("Jim", "Halpert"), new Person("Pam", "Beasley"), new Person("Michael", "Scott")}, {new Person("Dwight", "Schrute"), new Person("Andy", "Bernard"), new Person("Stanley", "Hudson")}, {new Person("Kelly", "Kapoor"), new Person("Creed", "Bratton"), new Person("Darryl", "Philbin")}};
    PersonLocator locator = new PersonLocator(people);

    @Test
    public void findCorrectPersonX() {
        Person toBeFound = new Person("Creed", "Bratton");
        Optional<Location> location = locator.find(toBeFound);
        assertEquals(2, location.get().getX());
    }

    @Test
    public void findCorrectPersonY() {
        Person toBeFound = new Person("Creed", "Bratton");
        Optional<Location> location = locator.find(toBeFound);
        assertEquals(1, location.get().getY());
    }

    @Test
    public void dontFindWrongPerson() {
        Person toBeFound = new Person("Toby", "Flenderson");
        Optional<Location> location = locator.find(toBeFound);
        assertEquals(Optional.empty(), location);

    }
}
