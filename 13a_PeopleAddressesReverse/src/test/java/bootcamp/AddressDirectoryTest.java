package bootcamp;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import bootcamp.directory.AddressDirectory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    void shouldReturnPersonLivingAtGivenAddressProvidedTheyExistInDirectory() {
        List<Person> testPerson = Arrays.asList(new Person("Paul", "Newman"));
        Address testAddress = new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York");
        assertEquals(testPerson, addressDirectory.getPeople(testAddress));
    }

    @Test
    void shouldReturnAListIfMultiplePeopleLiveAtTheSameGivenAddress() {
        List<Person> testPeople = Arrays.asList(new Person("Missy", "Elliot"), new Person("Michael", "Jordan"));
        Address testAddress = new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        assertEquals(testPeople, addressDirectory.getPeople(testAddress));
    }

    @Test
    void shouldReturnEmptyListIfPersonDoesNotExistInDirectory() {
        Address testAddress = new Address("75 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        assertTrue(addressDirectory.getPeople(testAddress).isEmpty());
    }

    @Test
    void shouldUpdateAddressInDirectoryIfPersonExists() {
        List<Person> testPerson = Arrays.asList(new Person("Eva", "Coleman"));
        Address currentAddress = new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        addressDirectory.update(currentAddress, newAddress);
        assertEquals(testPerson, addressDirectory.getPeople(newAddress));
    }

    @Test
    void shouldAddAddressIntoDirectory() {
        Person testPerson = new Person("Carly", "Simon");
        List<Person> expectedPeople = Arrays.asList(testPerson);
        Address newAddress = new Address("50 Classic House", "Carnaby Road", "WC2E 6GG", "London");
        addressDirectory.add(testPerson, newAddress);
        assertEquals(expectedPeople, addressDirectory.getPeople(newAddress));
    }

    @Test
    void shouldRemoveAddressFromDirectoryIfExists() {
        Address testAddress = new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York");
        addressDirectory.remove(testAddress);
        assertTrue(addressDirectory.getPeople(testAddress).isEmpty());
    }

    @Test
    void shouldReturnSuccessStatusIfUpdateAddressWasSuccessful() {
        List<Person> testPerson = Arrays.asList(new Person("Eva", "Coleman"));
        Address currentAddress = new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        Address newAddress = new Address("49 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        Status status = addressDirectory.update(currentAddress, newAddress);
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnKeyNotFoundStatusIfAddressToBeUpdatedWasNotFound() {
        Address currentAddress = new Address("20 California Road", "Sleepy Hollow", "45777", "Dallas");
        Address newAddress = new Address("55 Arty Lane", "Old Trafford", "AL5 0PX", "Leeds");
        Status status = addressDirectory.update(currentAddress, newAddress);
        assertEquals(Status.KEY_NOT_FOUND, status);
    }

    @Test
    void shouldReturnSuccessStatusIfAddressWasSuccessfullyRemoved() {
        Address testAddress = new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        Status status = addressDirectory.remove(testAddress);
        assertEquals(Status.SUCCESS, status);
    }

    @Test
    void shouldReturnKeyNotFoundStatusIfAddressToBeRemovedWasNotFound() {
        Address testAddress = new Address("20 California Road", "Sleepy Hollow", "45777", "Dallas");
        Status status = addressDirectory.remove(testAddress);
        assertEquals(Status.KEY_NOT_FOUND, status);
    }

}