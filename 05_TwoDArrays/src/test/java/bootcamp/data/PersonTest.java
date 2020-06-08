package bootcamp.data;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
  @Test
  public void testIsSamePerson() {
    Person omar = new Person("Omar", "Bashir");
    Person alsoOmar = new Person("Omar", "Bashir");

    assertTrue(omar.isSamePerson(alsoOmar));
  }

  @Test
  public void testIsSamePersonWhenNull() {
    Person omar = new Person("Omar", "Bashir");

    assertFalse(omar.isSamePerson(null));
  }
}