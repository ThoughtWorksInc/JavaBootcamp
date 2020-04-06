package bootcamp;

import bootcamp.data.Location;
import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Before;
import org.junit.Test;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PersonLocatorTests {

    private Person personA;
    private Person personB;
    private Person personD;
    private Person[][] people;

    @Before
    public void setUp() {
        personA = new Person("Will", "Ensoll");
        personB =  new Person("Bill", "Ensoll");
        personD = new Person("Will", "Ensoll");
        people = new Person[2][2];
    }

    @Test
    public void finds_person_in_array() {
        people[0][1] = personA;
        PersonLocator personLocator = new PersonLocator(people);
        Optional<Location> result = personLocator.find(personD);
        assertThat(result.get().getX(), is(0));
        assertThat(result.get().getY(), is(1));
    }

    @Test
    public void doesnt_find_person_in_array_returns_empty_optional() {
        people[0][1] = personA;
        PersonLocator personLocator = new PersonLocator(people);
        Optional<Location> result = personLocator.find(personB);
        assertThat(result, is(Optional.empty()));
    }
}
