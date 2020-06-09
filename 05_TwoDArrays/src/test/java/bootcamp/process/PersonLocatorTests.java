package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PersonLocatorTests {

    PersonLocator personLocator;
    Person subjectA;
    Person subjectB;

    @Before
    public void setUp() {
        Person[][] people = new Person[2][3];
        subjectA = new Person("Subject", "A");
        subjectB = new Person("Subject", "B");
        people[1][2] = subjectA;
        personLocator = new PersonLocator(people);
    }

    @Test
    public void testFindValue() {
        Optional<Location> result = personLocator.find(subjectA);
        assertEquals(1, result.get().getX());
        assertEquals(2, result.get().getY());

    }

    @Test
    public void testFindNoValue() {
        Optional<Location> result = personLocator.find(subjectB);
        assertFalse(result.isPresent());

    }
}
