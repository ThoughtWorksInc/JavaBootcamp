package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AddressDirectoryTests {
    private AddressDirectory directory;
    public final Person huck = new Person("Huckleberry", "Finn");
    public final Person atticus = new Person("Atticus", "Finch");
    public final Person scout = new Person("Scout", "Finch");
    public final Person winnie = new Person("Winnie", "ThePooh");
    public final Address mississippi = new Address("River", "Boat", "M1HB", "Mississippi");
    public final Address maycomb = new Address("Maycomb", "County", "MCA", "Alabama");
    public final Address hundredAcre = new Address("HundredAcre", "Woods", "HAW", "Forest");

    @Before
    public void init() {
        List<PersonAddressPair> addressList = Arrays.asList(
                new PersonAddressPair(huck, mississippi),
                new PersonAddressPair(atticus, maycomb),
                new PersonAddressPair(winnie, hundredAcre)
        );
        directory = new AddressDirectory(addressList);
    }

    @Test
    public void testGetAddressExisting() {
        assertEquals(mississippi, directory.getAddress(huck).get());
    }

    @Test
    public void testGetAddressMissing() {
        assertEquals(Optional.empty(), directory.getAddress(scout));
    }

    @Test
    public void testUpdateAddressOnExisting() {
        directory.updateAddress(new PersonAddressPair(huck, maycomb));
        assertEquals(maycomb, directory.getAddress(huck).get());
    }

    @Test
    public void testUpdateAddressWithNew() {
        directory.updateAddress(new PersonAddressPair(scout, maycomb));
        assertEquals(maycomb, directory.getAddress(scout).get());
    }

    @Test
    public void testRemoveAddressOfOneOccupant() {
        directory.remove(huck);
        assertEquals(Optional.empty(), directory.getAddress(huck));
    }
}
