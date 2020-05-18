package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AddressDirectoryTests {


    public List<PersonAddressPair> addressList = new ArrayList<PersonAddressPair>();

    @Before
    public void init() {

        Person person1 = new Person("James", "Cotcher");
        Person person2 = new Person("Michael", "Scarn");
        Person person3 = new Person("Jim", "Halpert");

        Address address1 = new Address("19", "New address", "SW9 5LP", "London");
        Address address2 = new Address("21", "Old address", "S10 3PK", "Sheffield");

        PersonAddressPair pair1 = new PersonAddressPair(person1, address1);
        PersonAddressPair pair2 = new PersonAddressPair(person2, address2);
        PersonAddressPair pair3 = new PersonAddressPair(person3, address2);

        this.addressList.add(pair1);
        this.addressList.add(pair2);
        this.addressList.add(pair3);
    }


    @Test
    public void testConstructor() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        assert (directory != null);
    }

    @Test
    public void getAddress() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Address address = directory.getAddress(new Person("James", "Cotcher")).get();
        assertEquals (new Address("19", "New address", "SW9 5LP", "London"), address);
    }

    @Test
    public void updateAddress() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Person person = new Person("James", "Cotcher");
        Address address = new Address("10", "Brixton road", "BR10 9PB", "Brixton");
        PersonAddressPair pair = new PersonAddressPair(person, address);
        assertEquals(Status.SUCCESS ,directory.updateAddress(pair));
        assertEquals(address, directory.getAddress(person).get());
    }
    @Test
    public void updateAddressNoPerson() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Person person = new Person("Wrong", "Person");
        Address address = new Address("10", "Brixton road", "BR10 9PB", "Brixton");
        PersonAddressPair pair = new PersonAddressPair(person, address);
        assertEquals(Status.KEY_NOT_FOUND, directory.updateAddress(pair));
    }

    @Test
    public void removePerson() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Person person = new Person("James", "Cotcher");
        assertEquals(Status.SUCCESS, directory.remove(person));
        assertEquals(Optional.empty(), directory.getAddress(person));
    }
    @Test
    public void removeInvalidPerson() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Person person = new Person("Wrong", "Person");
        assertEquals(Status.KEY_NOT_FOUND, directory.remove(person));
    }

    @Test
    public void getPerson() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        ArrayList<Person> results= new ArrayList<Person>(directory.getPeople(new Address("19", "New address", "SW9 5LP", "London")));
        assertEquals (new Person("James", "Cotcher"), results.get(0));
    }

    @Test
    public void getPeople() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        ArrayList<Person> results= new ArrayList<Person>(directory.getPeople(new Address("21", "Old address", "S10 3PK", "Sheffield")));
        assertEquals (2, results.size());
        assertEquals (new Person("Jim", "Halpert"), results.get(0));
        assertEquals (new Person("Michael", "Scarn"), results.get(1));
    }

    @Test
    public void wrongAddressSearch() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        ArrayList<Person> results= new ArrayList<Person>(directory.getPeople(new Address("212", "Wrong address", "S10 9PK", "Hull")));
        assertEquals(0, results.size());
    }

    @Test
    public void updateAddresses() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        assertEquals(Status.SUCCESS, directory.updateAddress(new Address("21", "Old address", "S10 3PK", "Sheffield"), new Address("21", "Seconds lane", "S21 2GO", "London")));
        assertEquals(new Address("21", "Seconds lane", "S21 2GO", "London"), directory.getAddress(new Person("Michael", "Scarn")).get());
    }

    @Test
    public void removeAddress() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Address address = new Address("21", "Old address", "S10 3PK", "Sheffield");
        assertEquals(Status.SUCCESS, directory.remove(address));
        assertEquals(0, directory.getPeople(new Address("21", "Old address", "S10 3PK", "Sheffield")).size());
    }

    @Test
    public void removeAddressWrongAddress() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Address address = new Address("99", "Fake Street", "S10 1PO", "Luton");
        assertEquals(Status.KEY_NOT_FOUND, directory.remove(address));
    }
}