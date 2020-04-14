package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
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
    public final Address newHome = new Address("New", "Home", "NH", "WhoKnows");

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
    public void testUpdateAddressViaPairOnExistingPersonAndAddress() {
        assertEquals(Status.SUCCESS, directory.updateAddress(new PersonAddressPair(huck, maycomb)));
        assertEquals(maycomb, directory.getAddress(huck).get());
        assertFalse(directory.getPeople(mississippi).contains(huck));
        List<Person> result = directory.getPeople(maycomb);
        assertTrue(result.contains(huck));
        assertTrue(result.contains(atticus));
    }

    @Test
    public void testUpdateAddressViaPairWithNewPersonAndAddress() {
        assertEquals(Status.SUCCESS, directory.updateAddress(new PersonAddressPair(scout, newHome)));
        assertEquals(newHome, directory.getAddress(scout).get());
        assertEquals(new ArrayList<>( Arrays.asList(scout)), directory.getPeople(newHome));
    }

    @Test
    public void testUpdateAddressViaPairWithNewPersonExistingAddress() {
        assertEquals(Status.SUCCESS, directory.updateAddress(new PersonAddressPair(scout, maycomb)));
        assertEquals(maycomb, directory.getAddress(scout).get());
        assertTrue(directory.getPeople(maycomb).contains(scout));
        assertTrue(directory.getPeople(maycomb).contains(atticus));
    }

    @Test
    public void testUpdateAddressViaAddress() {
        Address newMaycomb = new Address("Maycomb", "County", "NEWPOSTCODE", "Alabama");
        assertEquals(Status.SUCCESS, directory.updateAddress(maycomb, newMaycomb));
        assertEquals(newMaycomb, directory.getAddress(atticus).get());
        assertEquals(new ArrayList<>( Arrays.asList(atticus)), directory.getPeople(newMaycomb));
        assertEquals(new ArrayList<Person>(), directory.getPeople(maycomb));
    }

    @Test
    public void testUpdateAddressViaAddressWhenNotFound() {
        Address newMaycomb = new Address("Maycomb", "County", "NEWPOSTCODE", "Alabama");
        assertEquals(Status.KEY_NOT_FOUND, directory.updateAddress(newHome, newMaycomb));
    }

    @Test
    public void testRemoveAddressViaPerson() {
        assertEquals(Status.SUCCESS, directory.remove(huck));
        assertEquals(Optional.empty(), directory.getAddress(huck));
        assertEquals(new ArrayList<Person>(), directory.getPeople(mississippi));
    }

    @Test
    public void testRemoveAddressViaPersonNotFound() {
        assertEquals(Status.KEY_NOT_FOUND, directory.remove(scout));
    }

    @Test
    public void testRemoveAddress() {
        assertEquals(Status.SUCCESS, directory.remove(mississippi));
        assertEquals(Optional.empty(), directory.getAddress(huck));
        assertEquals(new ArrayList<Person>(), directory.getPeople(mississippi));
    }

    @Test
    public void testRemoveAddressNotFound() {
        assertEquals(Status.KEY_NOT_FOUND, directory.remove(newHome));
    }
}
