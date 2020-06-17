package bootcamp;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.AddressDirectory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressDirectoryTest {

    private AddressDirectory addressDirectory;

    @BeforeEach
    void setUp() {
        PersonAddressPair personAddressPair1 = new PersonAddressPair(
                new Person("Paul", "Newman"),
                new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York"));
        PersonAddressPair personAddressPair2 = new PersonAddressPair(
                new Person("Eva", "Coleman"),
                new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas"));
        PersonAddressPair personAddressPair3 = new PersonAddressPair(
                new Person("Missy", "Elliot"),
                new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        List<PersonAddressPair> addressList = Arrays.asList(personAddressPair1, personAddressPair2, personAddressPair3);
        addressDirectory = new AddressDirectory(addressList);
    }

    @Test
    void shouldReturnCorrectAddressIfPersonExistsInDirectory() {
        Person testPerson = new Person("Eva", "Coleman");
        Address expectedAddress = new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        assertEquals(expectedAddress, addressDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldReturnEmptyOptionalIfPersonDoesNotExistsInDirectory() {
        Person testPerson = new Person("Lilly", "Parsons");
        assertTrue(addressDirectory.getAddress(testPerson).isEmpty());
    }

    @Test
    void shouldUpdateAddressInDirectoryIfPersonExists() {
        Person testPerson = new Person("Missy", "Elliot");
        Address updatedAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        PersonAddressPair personAddressPair = new PersonAddressPair(testPerson, updatedAddress);
        addressDirectory.updateAddress(personAddressPair);
        assertEquals(updatedAddress, addressDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldAddAddressIntoDirectoryIfPersonDoesNotExist() {
        Person testPerson = new Person("Carly", "Simon");
        Address updatedAddress = new Address("50 Classic House", "Carnaby Road", "WC2E 6GG", "London");
        PersonAddressPair personAddressPair = new PersonAddressPair(testPerson, updatedAddress);
        addressDirectory.updateAddress(personAddressPair);
        assertEquals(updatedAddress, addressDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldRemoveAddressFromDirectoryIfPersonExist() {
        Person testPerson = new Person("Paul", "Newman");
        addressDirectory.remove(testPerson);
        assertTrue(addressDirectory.getAddress(testPerson).isEmpty());
    }
}