package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
  private final Person[][] peopleGrid;

  public PersonLocator(Person[][] peopleGrid) {
    this.peopleGrid = peopleGrid;
  }

  public Optional<Location> find(final Person person) {
    for (int x = 0; x < peopleGrid.length; x++) {
      for (int y = 0; y < peopleGrid[x].length; y++) {
        if (person.isSamePerson(peopleGrid[x][y])) {
          return Optional.of(new Location(x, y));
        }
      }
    }

    return Optional.empty();
  }
}
