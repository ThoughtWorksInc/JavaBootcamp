import bootcamp.data.Person;
import bootcamp.process.PersonLocator;
import org.junit.Test;
import static org.junit.Assert.*;


public class PersonLocatorTest {

    @Test
    public void find_WhenPersonAvl_ReturnsLocation(){
        var myMan = new Person("my", "man");

        Person[][] peeps = {
                {new Person("a","1"), new Person("b","2")},
                {new Person("c","3"), new Person("my","man")}};

        var sut = new PersonLocator(peeps);

        var result = sut.find(myMan);

        assertTrue(result.isPresent());
        assertEquals(result.get().getX(), 1);
        assertEquals(result.get().getY(), 1);
    }

    @Test
    public void find_WhenPersonNotAvl_ReturnsEmpty(){
        var myMan = new Person("my", "man");

        Person[][] peeps = {
                {new Person("a","1"), new Person("b","2")},
                {new Person("c","3"), new Person("d","4")}};

        var sut = new PersonLocator(peeps);

        var result = sut.find(myMan);

        assertFalse(result.isPresent());
    }
}
