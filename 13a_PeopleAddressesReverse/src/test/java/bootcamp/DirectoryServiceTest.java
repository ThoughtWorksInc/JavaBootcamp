package bootcamp;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.DirectoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectoryServiceTest {

    private List<PersonAddressPair> addressList;
    private DirectoryService directoryService;

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
        directoryService = new DirectoryService(addressList);
    }

//    @Test
//    void shouldCorrectlyCreateAPersonDirectoryGivenAValidListOfPeopleAndAddresses() {
//        DirectoryService directoryService = new DirectoryService();
//
//    }

    @Test
    void shouldUpdateAddressInBothDirectoriesGivenExistingPersonAndNewAddress() {
        Person person = new Person("Paul", "Newman");
        List<Person> expectedPerson = Arrays.asList(person);
        Address newAddress = new Address("68 Marriott Cottage", "Avenger Lane", "12345", "New York");
        Optional<Address> updatedAddress = Optional.of(newAddress);
        directoryService.updatePerson(person, newAddress);
        assertEquals(expectedPerson, directoryService.getPeople(newAddress));
        assertEquals(updatedAddress, directoryService.getAddress(person));
    }

    @Test
    void shouldAddPersonAndAddressToBothDirectoriesIfTheyDoNotExist() {
        Person person = new Person("Mary", "Higgins");
        List<Person> expectedPerson = Arrays.asList(person);
        Address newAddress = new Address("68 Marriott Cottage", "Barnaby Close", "AB16 8UG", "Aberdeen");
        Optional<Address> updatedAddress = Optional.of(newAddress);
        directoryService.updatePerson(person, newAddress);
        assertEquals(expectedPerson, directoryService.getPeople(newAddress));
        assertEquals(updatedAddress, directoryService.getAddress(person));
    }

    @Test
    void shouldAddPersonToBothDirectoriesIfTheyDoNotExistAtTheGivenAddress() {
        Person person = new Person("Mary", "Higgins");
        List<Person> expectedPeople = Arrays.asList(new Person("Eva", "Coleman"), person);
        Address address = new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        Optional<Address> updatedAddress = Optional.of(address);
        directoryService.updatePerson(person, address);
        assertEquals(expectedPeople, directoryService.getPeople(address));
        assertEquals(updatedAddress, directoryService.getAddress(person));
    }

    @Test
    void shouldUpdateBothDirectoriesForAllPeopleGivenCurrentAndNewAddress() {
        List<Person> people = Arrays.asList(new Person("Missy", "Elliot"), new Person("Michael", "Jordan"));
        Address currentAddress = new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London");
        Address newAddress = new Address("115 Majesty Hill", "Palomino Street", "LD7 9PX", "Leeds");
        Optional<Address> updatedAddress = Optional.of(newAddress);
        directoryService.updateAddress(currentAddress, newAddress);
        assertEquals(people, directoryService.getPeople(newAddress));
        assertEquals(updatedAddress, directoryService.getAddress(people.get(0)));
        assertEquals(updatedAddress, directoryService.getAddress(people.get(1)));
    }
}
