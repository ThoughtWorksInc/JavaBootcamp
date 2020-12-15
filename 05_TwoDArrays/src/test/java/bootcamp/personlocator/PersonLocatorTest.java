package bootcamp.personlocator;

import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class PersonLocatorTest {

    PersonLocator locator;

    @Before
    public void before() {
        Person[][] array = new Person[][] {
                {new Person("joe", "bloggs"), new Person("sally", "bloggs"), new Person("jermiah", "bullfrog")},
                {new Person("phillip", "scofield"), new Person("lemo", "nade"), new Person("frank", "enstein")}
        };
        Optional<Location> location = Optional.empty();
        this.locator = new PersonLocator(array);
    }

    @Test
    public void canFindPersonIfPresent() {
        Person p = new Person("phillip", "scofield");
        Assert.assertTrue(this.locator.find(p).isPresent());
    }


    @Test
    public void cannotFindPersonIfNotPresent() {
        Person p = new Person("dora", "explorer");
        Assert.assertTrue(this.locator.find(p).isEmpty());
    }
}
