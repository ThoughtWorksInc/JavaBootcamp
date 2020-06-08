package bootcamp.directory;

import java.util.*;

import bootcamp.data.*;

class TestData {
    protected static final Person darthVader = new Person("Darth", "Vader");
    protected static final Person rey = new Person("Rey", null);
    protected static final Person yoda = new Person("Yoda", null);
    protected static final Person nonExistentPerson = new Person("nobody", "no one");
    protected static final Address deathStar = new Address("Control Room", "Top Floor", null, "Death Star");
    protected static final Address coruscant = new Address("2nd floor, apartment 3", "Jedi Council", "abc123",
            "Coruscant");
    protected static final Address jakku = new Address("Nowhere", "Outskirts of somewhere, nowhere", null, "Tatooine");
    protected static final Address millenniumFalcon = new Address("anywhere", "everywhere", "all 12 parsecs",
            "Millennium Falcon");

    protected static List<PersonAddressPair> initialPairs = new ArrayList<PersonAddressPair>(
            Arrays.asList(new PersonAddressPair(darthVader, deathStar), new PersonAddressPair(rey, jakku),
                    new PersonAddressPair(yoda, coruscant)));

    protected static ArrayList<PersonAddressPair> getInitialPairs() {
        return new ArrayList<PersonAddressPair>(initialPairs);
    }
}