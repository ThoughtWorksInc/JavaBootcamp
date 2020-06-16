package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ProcessorTests {

    Person[][] people = {
            {new Person("John","Smith"), new Person("Susan", "Pollard")},
            {new Person("Anne", "Marie"), new Person("Benjamin", "Bucket")}
    };
    PersonLocator personLocator = new PersonLocator(people);

    @Test
    public void testExistingPerson() {
        Person person = new Person("Susan", "Pollard");
        Optional<Location> location = personLocator.find(person);
        assertTrue(location.isPresent());
    }

    @Test
    public void testNonExistingPerson() {
        Person person = new Person("Susan", "Marie");
        Optional<Location> location = personLocator.find(person);

    }
}
