package bootcamp;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import bootcamp.directory.AddressDirectory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddressDirectoryTest {

    private AddressDirectory addressDirectory;
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
        addressDirectory = new AddressDirectory(addressList);
    }

    @Test
    void shouldCreateAnAlphabeticallyOrderedDirectorySortedBySecondNameThenFirstName() {
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
        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        addressDirectory.updateAddress(testPerson, newAddress);
        assertEquals(newAddress, addressDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldAddAddressIntoDirectoryIfPersonDoesNotExist() {
        Person testPerson = new Person("Carly", "Simon");
        Address newAddress = new Address("50 Classic House", "Carnaby Road", "WC2E 6GG", "London");
        addressDirectory.updateAddress(testPerson, newAddress);
        assertEquals(newAddress, addressDirectory.getAddress(testPerson).get());
    }

    @Test
    void shouldRemoveAddressFromDirectoryIfPersonExist() {
        Person testPerson = new Person("Paul", "Newman");
        addressDirectory.remove(testPerson);
        assertTrue(addressDirectory.getAddress(testPerson).isEmpty());
    }

    @Test
    void shouldReturnListOfOnePersonLivingAtAnExistingAddress() {
        List<Person> expectedPeople = Arrays.asList(new Person("Paul", "Newman"));
        Address testAddress = new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York");
        assertEquals(expectedPeople, addressDirectory.getPeople(testAddress));
    }

    @Test
    void shouldReturnListOfMultiplePeopleLivingAtAnExistingAddress() {
        List<Person> expectedPeople = Arrays.asList(new Person("Missy", "Elliot"), new Person("Michael", "Jordan"));
        Address testAddress = new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        assertEquals(expectedPeople, addressDirectory.getPeople(testAddress));
    }

    @Test
    void shouldReturnAnEmptyListIfAddressDoesNotExistInDirectory() {
        Address testAddress = new Address("55 Broadway", "St. James's Park", "WC12 5BB", "London");
        assertTrue(addressDirectory.getPeople(testAddress).isEmpty());
    }

    @Test
    void shouldCorrectlyUpdateAddressForMultiplePeople() {
        List<Person> expectedPeople = Arrays.asList(new Person("Missy", "Elliot"), new Person("Michael", "Jordan"));
        Address newAddress = new Address("65 Borough Close", "New Hampshire", "934987", "Chicago");
        Address currentAddress = new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        addressDirectory.updateAddress(currentAddress, newAddress);
        assertEquals(expectedPeople, addressDirectory.getPeople(newAddress));
    }

    @Test
    void shouldRemoveAllPeopleLivingAtGivenAddressFromDirectory() {
        Address testAddress = new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        addressDirectory.remove(testAddress);
        assertTrue(addressDirectory.getAddress(new Person("Missy", "Elliot")).isEmpty());
        assertTrue(addressDirectory.getAddress(new Person("Michael", "Jordan")).isEmpty());
    }

    @Test
    void shouldReturnSuccessStatusIfUpdateAddressByPersonWasSuccessful() {
        Person testPerson = new Person("Missy", "Elliot");
        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        Status status = addressDirectory.updateAddress(testPerson, newAddress);
        assertEquals(Status.SUCCESS, status);
    }

//    @Test
//    void shouldReturnKeyNotFoundStatusIfUpdateAddressByPersonWasNotSuccessful() {
//        Person testPerson = new Person("Kelly", "Fisher");
//        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
//        Status status = addressDirectory.updateAddress(testPerson, newAddress);
//        assertEquals(Status.KEY_NOT_FOUND, status);
//    }

    @Test
    void shouldReturnSuccessStatusIfUpdateAddressByCurrentAddressForOnePersonWasSuccessful() {
        Address newAddress = new Address("65 Borough Close", "New Hampshire", "934987", "Chicago");
        Address currentAddress = new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        Status status = addressDirectory.updateAddress(currentAddress, newAddress);
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnKeyNotFoundStatusIfUpdateAddressByCurrentAddressForOnePersonWasNotSuccessful() {
        Address newAddress = new Address("65 Borough Close", "New Hampshire", "934987", "Chicago");
        Address currentAddress = new Address("77 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        Status status = addressDirectory.updateAddress(currentAddress, newAddress);
        assertEquals(Status.KEY_NOT_FOUND, status);
    }

    @Test
    void shouldReturnSuccessStatusIfPersonWasSuccessfullyRemoved() {
        Status status = addressDirectory.remove(new Person("Eva", "Coleman"));
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnKeyNotFoundStatusIfPersonToBeRemovedWasNotFound() {
        Status status = addressDirectory.remove(new Person("Kelly", "Fisher"));
        assertEquals(Status.KEY_NOT_FOUND, status);
    }

    @Test
    void shouldReturnSuccessStatusIfPersonWasSuccessfullyRemovedByAddress() {
        Status status = addressDirectory.remove(new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnKeyNotFoundStatusIfPersonWasNotFoundWhenTryingToRemovedByAddress() {
        Status status = addressDirectory.remove(new Address("77 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        assertEquals(Status.KEY_NOT_FOUND, status);
    }
}
