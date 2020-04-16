package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import org.junit.Test;
import org.junit.Before;

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
        directory.updateAddress(pair);
        assertEquals(address, directory.getAddress(person).get());
    }

    @Test
    public void removePerson() {
        AddressDirectory directory = new AddressDirectory(this.addressList);
        Person person = new Person("James", "Cotcher");
        directory.remove(person);
        assertEquals(Optional.empty(), directory.getAddress(person));

    }
}
