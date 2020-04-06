package bootcamp.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTests {

    @Test
    public void equalsMethodWorks() {
        Person one = new Person("Michael", "Scott");
        Person two = new Person("Michael", "Scott");
        assertEquals(true, one.equals(two));
    }

    @Test
    public void equalsMethodFalseMatch() {
        Person one = new Person("Michael", "Scott");
        Person two = new Person("Jim", "Halpert");
        assertEquals(false, one.equals(two));
    }
}
