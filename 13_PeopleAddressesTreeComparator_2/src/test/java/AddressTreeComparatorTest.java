import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.AddressDirectory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AddressTreeComparatorTest {
    List<PersonAddressPair> list;
    AddressDirectory directory;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(new PersonAddressPair(new Person("Anne", "Scott"), new Address("first line1","second line 1", "ABC1", "city1" )));
        list.add(new PersonAddressPair(new Person("Ryan", "Thomas"), new Address("first line2","second line 2", "ABC2", "city2" )));
        list.add(new PersonAddressPair(new Person("Michael", "Wills"), new Address("first line3","second line 3", "ABC3", "city3" )));
        list.add(new PersonAddressPair(new Person("Lorraine", "Baker"), new Address("first line4","second line 4", "ABC4", "city4" )));
        directory = new AddressDirectory(list);
    }
    @Test
    public void ShouldReturnAddressForExistingPerson() {
        Address address = directory.getAddress(new Person("Anne", "Scott")).get();
        assertEquals(new Address("first line1","second line 1", "ABC1", "city1" ), address);
    }
    @Test
    public void ShouldReturnEmptyForNonExistingPerson() {
        Optional<Address> address = directory.getAddress(new Person("not Anne", "Scott"));
        assertEquals(true, address.isEmpty());
    }
    @Test
    public void ShouldUpdateForExistingPerson() {
        Person person = new Person("Lorraine", "Baker");
        Address newAddress = new Address("line1B", "", "", "");
        directory.updateAddress(new PersonAddressPair(person, newAddress));
        assertEquals(directory.getAddress(person).get(), newAddress);
    }
    @Test
    public void ShouldNotUpdateForNonExistingPerson() {
        Person person = new Person("No Person", "Baker");
        Address newAddress = new Address("line1B", "", "", "");
        AddressDirectory cloneDirectory = new AddressDirectory(list);
        directory.updateAddress(new PersonAddressPair(person, newAddress));
        assertEquals(directory, cloneDirectory);
    }

    @Test
    public void ShouldRemoveExistingPerson() {
        Person person = new Person("Michael", "Wills");
        assertEquals(true, directory.hasPerson(person));
        directory.remove(person);
        assertEquals(false, directory.hasPerson(person));
    }

}

