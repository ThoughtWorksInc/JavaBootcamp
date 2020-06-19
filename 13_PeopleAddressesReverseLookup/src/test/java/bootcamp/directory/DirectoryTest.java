package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class DirectoryTest {

    Directory directory;
    Person personOne;
    Person personTwo;
    Person personThree;
    Address addressOne;
    Address addressTwo;

    @Before
    public void setUp() {
        this.personOne = new Person("John", "Smith");
        this.personTwo = new Person("Archie", "Sample");
        this.personThree = new Person("Not", "Here");
        this.addressOne = new Address("123", "TestTown", "EX123", "Test");
        this.addressTwo = new Address( "456", "TestTown", "EX123", "Test");
        var list = new ArrayList<PersonAddressPair>();
        list.add(new PersonAddressPair(personOne, addressOne));
        list.add(new PersonAddressPair(personTwo, addressOne));
        this.directory = new Directory(list);
    }

    @Test
    public void getAddressWhenPersonExistsReturnsOptionalAddress() {
        assertEquals(Optional.of(this.addressOne),
                directory.getAddress(this.personOne));
    }

    @Test
    public void getAddressWhenPersonDoesNotExistReturnsOptionalEmpty() {
        assertEquals(Optional.empty(), directory.getAddress(personThree));
    }

    @Test
    public void getPeopleWhenAddressExistsReturnsListOfPeople() {
        List<Person> expected = new ArrayList<>();
        expected.add(personOne);
        expected.add(personTwo);
        assertEquals(expected, directory.getPeople(addressOne));
    }

    @Test
    public void getPeopleWhenAddressDoesNotExistsReturnsEmptyList() {
        List<Person> expected = new ArrayList<>();
        assertEquals(expected, directory.getPeople(addressTwo));
    }

    @Test
    public void updateAddressWithAddressShouldUpdateForAll() {
        this.directory.updateAddress(addressOne, addressTwo);
        var expected = new ArrayList<>();
        expected.add(personOne);
        expected.add(personTwo);
        assertEquals(expected, directory.getPeople(addressTwo));
        assertEquals(directory.getAddress(personOne), Optional.of(addressTwo));
        assertEquals(directory.getAddress(personTwo), Optional.of(addressTwo));
        assertEquals(Collections.EMPTY_LIST, directory.getPeople(addressOne));
    }
    @Test
    public void updateAddressWithExistingAddressNotInDirectory() {
        var result = this.directory.updateAddress(addressTwo, addressOne);
        assertEquals(Status.KEY_NOT_FOUND, result);
    }

    @Test
    public void updateAddressWithAddressShouldReturnSuccess() {
        var result = this.directory.updateAddress(addressOne, addressTwo);
        assertEquals(Status.SUCCESS, result);
    }

    @Test
    public void updateAddressWhenPersonExists() {
        var result = this.directory.updateAddress(new PersonAddressPair(this.personOne, this.addressTwo));
        assertEquals(Optional.of(this.addressTwo), this.directory.getAddress(this.personOne));
        assertFalse(directory.getPeople(addressOne).contains(personOne));
        assertTrue(directory.getPeople(addressTwo).contains(personOne));
        assertEquals(Status.SUCCESS, result);
    }

    @Test
    public void updateAddressWhenPersonDoesNotExists() {
        var result = this.directory.updateAddress(new PersonAddressPair(this.personThree, this.addressTwo));
        assertEquals(Optional.of(this.addressTwo), this.directory.getAddress(this.personThree));
        assertEquals(Status.SUCCESS, result);
    }

    @Test
    public void removeWhenPersonExists() {
        var result = this.directory.remove(this.personOne);
        assertEquals(Optional.empty(), this.directory.getAddress(this.personOne));
        assertFalse(directory.getPeople(addressOne).contains(personOne));
        assertEquals(Status.SUCCESS, result);
    }

    @Test
    public void removeWhenPersonDoesNotExist() {
        var result = this.directory.remove(this.personThree);
        assertEquals(Status.KEY_NOT_FOUND, result);
    }

    @Test
    public void removeWhenAddressExists() {
        var status = directory.remove(addressOne);
        assertEquals(Status.SUCCESS, status);
        assertEquals(Collections.EMPTY_LIST, this.directory.getPeople(addressOne));
    }
    @Test
    public void removeWhenAddressDoesNotExist() {
        var status = directory.remove(new Address("1","2","3", "4"));
        assertEquals(Status.KEY_NOT_FOUND, status);
    }
}