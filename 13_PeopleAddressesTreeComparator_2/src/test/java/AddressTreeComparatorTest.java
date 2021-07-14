import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import bootcamp.directory.AddressDirectory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class AddressTreeComparatorTest {
    List<PersonAddressPair> list;
    AddressDirectory directory;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(new PersonAddressPair(new Person("Anne", "Scott"), new Address("first line1","second line 1", "ABC1", "city1" )));
        list.add(new PersonAddressPair(new Person("Anne2", "Scott2"), new Address("first line1","second line 1", "ABC1", "city1" )));
        list.add(new PersonAddressPair(new Person("Anne3", "Scott3"), new Address("first line1","second line 1", "ABC1", "city1" )));

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
        assertFalse(directory.getPersonsAtAddress(newAddress).contains(person));

        directory.updateAddress(new PersonAddressPair(person, newAddress));
        assertEquals(directory.getAddress(person).get(), newAddress);
        assertTrue(directory.getPersonsAtAddress(newAddress).contains(person));

    }

    @Test
    public void ShouldInsertForNonExistingPerson() {
        Person person = new Person("No Person", "Baker");
        Address newAddress = new Address("line1B", "", "", "");
        List<Person> peopleBefore = directory.getPersonsAtAddress(newAddress);
        assertEquals(false, peopleBefore.contains(person));
        directory.updateAddress(new PersonAddressPair(person, newAddress));
        List<Person> peopleAfter = directory.getPersonsAtAddress(newAddress);
        assertEquals(true, peopleAfter.contains(person));
        assertTrue(directory.getPersonsAtAddress(newAddress).contains(person));
    }

    @Test
    public void ShouldRemoveExistingPerson() {
        Person person = new Person("Michael", "Wills");
        assertEquals(Status.SUCCESS, directory.remove(person));

        Optional<Address> address = directory.getAddress(person);
        assertEquals(true, address.isEmpty());
    }

//  MARK:  Reverse lookup implementation
    @Test
    public void ShouldReturnAllPeopleAtAnAddress() {
        Address address = new Address("first line1","second line 1", "ABC1", "city1" );
        List<Person> people = new ArrayList<>();
        people.add(new Person("Anne", "Scott"));
        people.add(new Person("Anne2", "Scott2"));
        people.add(new Person("Anne3", "Scott3"));
        List<Person> result = directory.getPersonsAtAddress(address);
        assertEquals(3, result.size());
        assertEquals(people, result);
    }

    @Test
    public void ShouldReturnEmptyListForNonexistentAddress() {
        Address address = new Address("first line12345","second line 1", "ABC1", "city1" );
        List<Person> result = directory.getPersonsAtAddress(address);
        assertEquals(true, result.isEmpty());
    }

    @Test
    public void ShouldUpdateAddressForAllResidents_Success() {
        Address newAddress = new Address("first line12345","second line 1", "ABC1", "city1" );
        Address oldAddress = new Address("first line1","second line 1", "ABC1", "city1" );
        List<Person> oldResidents = directory.getPersonsAtAddress(oldAddress);
        assertEquals(Status.SUCCESS,directory.updateAddress(oldAddress, newAddress));
        List<Person> newResidents = directory.getPersonsAtAddress(newAddress);
        assertEquals(oldResidents, newResidents);
        assertTrue(directory.getPersonsAtAddress(oldAddress).isEmpty());
        for (Person person: oldResidents) {
            assertEquals(directory.getAddress(person).get(), newAddress);
        }
    }

    @Test
    public void ShouldReturnKeyNotFoundForNonExistingAddressUpdate() {
        Address newAddress = new Address("first line12345","second line 1", "ABC1", "city1" );
        Address oldAddress = new Address("Not a real address","second line 1", "ABC1", "city1" );
        assertEquals(Status.KEY_NOT_FOUND, directory.updateAddress(oldAddress, newAddress));
    }


    @Test
    public void ShouldRemoveAddressAndCorrespondingPeople() {
        Address address = new Address("first line1","second line 1", "ABC1", "city1" );
        assertEquals(Status.SUCCESS, directory.remove(address));
        assertTrue(directory.getPersonsAtAddress(address).isEmpty());

    }
    @Test
    public void ShouldReturnKeyNotFoundForNonExistingAddressRemove() {
        Address address = new Address("Non existing","second line 1", "ABC1", "city1" );
        assertEquals(Status.KEY_NOT_FOUND, directory.remove(address));

    }
}

