package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class LocatorTest {

    @Test
    public void shouldReturnLocationIfValueIsFound () {
        Person [][] people = {{new Person("FN00", "LN00"), new Person("FN01", "LN01"), new Person("FN02", "LN02")},
                            {new Person("FN10", "LN10"), new Person("FN11", "LN11"), new Person("FN12", "LN12")}};
        PersonLocator locator = new PersonLocator(people);
        assertEquals(Optional.of(new Location(0,0)), locator.find(new Person("FN00", "LN00")));
    }

    @Test
    public void shouldNotReturnLocationIfValueIsNotFound () {
        Person [][] people = {{new Person("FN00", "LN00"), new Person("FN01", "LN01"), new Person("FN02", "LN02")},
                {new Person("FN10", "LN10"), new Person("FN11", "LN11"), new Person("FN12", "LN12")}};
        PersonLocator locator = new PersonLocator(people);
        assertNotEquals(Optional.of(new Location(0,0)), locator.find(new Person("FN40", "LN00")));
    }
}
