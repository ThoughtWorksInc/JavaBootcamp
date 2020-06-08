package bootcamp.process;

import org.junit.Before;
import org.junit.Test;

import bootcamp.data.Location;
import bootcamp.data.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

public class PersonLocatorTest {
  public static Person[][] peopleGrid;
  public static final Person omar = new Person("Omar", "Bashir");
  public static final Person gloria = new Person("Gloria", "Laoye");
  public static final Person olivia = new Person("Olivia", "Frost");
  public static final Person steph = new Person("Stephanie", "Fashagba");
  public static final Person will = new Person("Will", "Ensoll");
  public static final Person rahul = new Person("Rahul", "Rakshit");

  @Before
  public void resetPeopleGrid() {
    peopleGrid = new Person[3][3];
  }

  @Test
  public void testFind() {
    peopleGrid[0][1] = steph;
    PersonLocator personLocator = new PersonLocator(peopleGrid);

    Optional<Location> stephsLocation = personLocator.find(steph);

    assertThat(stephsLocation.get().x, is(0));
    assertThat(stephsLocation.get().y, is(1));
  }

  @Test
  public void testFindHasEmptyOptionalIfNotFound() {
    peopleGrid[0][1] = steph;
    peopleGrid[1][2] = olivia;
    PersonLocator personLocator = new PersonLocator(peopleGrid);

    Optional<Location> emptyLocationForWill = personLocator.find(will);

    assertTrue(emptyLocationForWill.isEmpty());
  }

  @Test
  public void testFindOnlyCaresAboutFirstOccurrence() {
    peopleGrid[1][1] = gloria;
    peopleGrid[2][2] = gloria;
    PersonLocator personLocator = new PersonLocator(peopleGrid);

    Optional<Location> gloriasLocation = personLocator.find(gloria);

    assertThat(gloriasLocation.get().x, is(1));
    assertThat(gloriasLocation.get().y, is(1));
  }
}