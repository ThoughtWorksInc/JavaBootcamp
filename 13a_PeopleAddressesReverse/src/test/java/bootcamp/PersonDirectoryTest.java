package bootcamp;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import bootcamp.directory.PersonDirectory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonDirectoryTest {

    private PersonDirectory personDirectory;
    private List<PersonAddressPair> addressList;

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
        PersonAddressPair personAddressPair4 = new PersonAddressPair(
                new Person("Michael", "Jordan"),
                new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        addressList = Arrays.asList(personAddressPair1, personAddressPair2, personAddressPair3, personAddressPair4);
        personDirectory = new PersonDirectory(addressList);
    }

    @Test
    void shouldReturnAddressOfAGivenPersonProvidedTheyExistInPersonDirectory() {
        Person testPerson = new Person("Paul", "Newman");
        Optional<Address> testAddress = Optional.of(new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York"));
        assertEquals(testAddress, personDirectory.getAddress(testPerson));
    }

    @Test
    void shouldReturnEmptyOptionalIfPersonDoesNotExistsInDirectory() {
        Person testPerson = new Person("Lilly", "Parsons");
        assertTrue(personDirectory.getAddress(testPerson).isEmpty());
    }

    @Test
    void shouldUpdateAddressInDirectoryIfPersonExists() {
        Person testPerson = new Person("Missy", "Elliot");
        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        personDirectory.update(testPerson, newAddress);
        assertEquals(newAddress, personDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldAddAddressIntoDirectoryIfPersonDoesNotExist() {
        Person testPerson = new Person("Carly", "Simon");
        Address newAddress = new Address("50 Classic House", "Carnaby Road", "WC2E 6GG", "London");
        personDirectory.update(testPerson, newAddress);
        assertEquals(newAddress, personDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldRemoveAddressFromDirectoryIfPersonExists() {
        Person testPerson = new Person("Paul", "Newman");
        personDirectory.remove(testPerson);
        assertTrue(personDirectory.getAddress(testPerson).isEmpty());
    }

    @Test
    void shouldReturnSuccessStatusIfUpdateAddressWasSuccessful() {
        Person testPerson = new Person("Missy", "Elliot");
        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        Status status = personDirectory.update(testPerson, newAddress);
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnSuccessStatusIfPersonWasSuccessfullyRemoved() {
        Status status = personDirectory.remove(new Person("Eva", "Coleman"));
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnKeyNotFoundStatusIfPersonToBeRemovedWasNotFound() {
        Status status = personDirectory.remove(new Person("Kelly", "Fisher"));
        assertEquals(Status.KEY_NOT_FOUND, status);
    }

}