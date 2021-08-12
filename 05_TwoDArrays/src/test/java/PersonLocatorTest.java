import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Optional;

public class PersonLocatorTest {
    @Test
    public void shouldReturnLocationOfPersonThatIsInTheArray() {
        Person person1 = new Person("Arman", "Jalilian");
        Person person2 = new Person("Jack", "Reacher");
        Person person3 = new Person("John", "Wick");
        Person person4 = new Person("Vin", "Diesel");
        Person person5 = new Person("Tom", "Walker");
        Person person6 = new Person("Tracy", "Chapman");
        Person person7 = new Person("Julie", "Adams");

        Person[][] people = new Person[][]{
                {person1,person2},
                {person3,person4},
                {person5, person6, person7},
        };

        PersonLocator locator = new PersonLocator(people);
        Optional<Location> actual = locator.find(person7);
        Optional<Location> expected = Optional.of(new Location(2, 2));
        assertEquals(actual,expected);
    }

    @Test
    public void shouldHandleANullValueWithoutThrowingException(){
        Person person1 = new Person("Arman", "Jalilian");
        Person person2 = new Person("Jack", "Reacher");
        Person person3 = new Person("John", "Wick");
        Person person4 = new Person("Vin", "Diesel");
        Person person5 = new Person("Tom", "Walker");
        Person person6 = new Person("Tracy", "Chapman");
        Person person7 = new Person("Julie", "Adams");

        Person person8 = new Person("Thomas", "Nigels");

        Person[][] people = new Person[][]{
                {person1,person2},
                {person3,person4},
                {person5, person6, person7},
        };

        PersonLocator locator = new PersonLocator(people);
        Optional<Location> actual = locator.find(person8);
        Optional<Location> expected = Optional.empty();
        assertEquals(actual,expected);
    }
}
