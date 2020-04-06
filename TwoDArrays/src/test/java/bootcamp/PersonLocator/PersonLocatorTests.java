package bootcamp.PersonLocator;

import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonLocatorTests {
    public static Person[][] people;
    public static final Person atticus = new Person("Atticus", "Finch");
    public static final Person huckleberry = new Person("Huckleberry", "Finn");
    public static final Person jane = new Person("Jane", "Eyre");

    @Before
    public void setUpPeople() {
        people = new Person[2][2];
        people[0][1] = atticus;
        people[1][0] = huckleberry;
    }

    @Test
    public void testFindAfterFirstLocation() {
        PersonLocator locator = new PersonLocator(people);

        Optional<Location> location = locator.find(atticus);
        assertEquals(location.get().getX(), 0);
        assertEquals(location.get().getY(), 1);
    }

    @Test
    public void testFindWhenPersonNotFound() {
        PersonLocator locator = new PersonLocator(people);

        Optional<Location> location = locator.find(jane);
        assertFalse(location.isPresent());
    }

    @Test
    public void testFindWhenMultipleInstances() {
        people[1][1] = atticus;

        PersonLocator locator = new PersonLocator(people);

        Optional<Location> location = locator.find(atticus);
        assertEquals(location.get().getX(), 0);
        assertEquals(location.get().getY(), 1);
    }
}
