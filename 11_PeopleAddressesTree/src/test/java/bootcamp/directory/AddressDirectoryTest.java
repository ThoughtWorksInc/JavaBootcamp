package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

public class AddressDirectoryTest {

    AddressDirectory directory;
    Person person;
    Person nextPerson;
    Address address;
    Address nextAddress;

    @Before
    public void setUp() {
        this.person = new Person("John", "Smith");
        this.nextPerson = new Person("Not", "Here");
        this.address = new Address("123", "TestTown", "EX123", "Test");
        this.nextAddress = new Address( "456", "TestTown", "EX123", "Test");
        var list = Collections.singletonList(new PersonAddressPair(person, address));
        this.directory = new AddressDirectory(list);
    }

    @Test
    public void getAddressWhenPersonExistsReturnsOptionalAddress() {
        assertEquals(Optional.of(this.address), directory.getAddress(this.person));
    }

    @Test
    public void getAddressWhenPersonDoesNotExistReturnsOptionalEmpty() {
        assertEquals(Optional.empty(), directory.getAddress(nextPerson));
    }

    @Test
    public void updateAddressWhenPersonExists() {
        this.directory.updateAddress(new PersonAddressPair(this.person, this.nextAddress));
        assertEquals(Optional.of(this.nextAddress), this.directory.getAddress(this.person));
    }

    @Test
    public void updateAddressWhenPersonDoesNotExists() {
        this.directory.updateAddress(new PersonAddressPair(this.nextPerson, this.nextAddress));
        assertEquals(Optional.of(this.nextAddress), this.directory.getAddress(this.nextPerson));
    }

    @Test
    public void removeAddressWhenPersonExists() {
        this.directory.remove(this.person);
        assertEquals(Optional.empty(), this.directory.getAddress(this.person));
    }

}