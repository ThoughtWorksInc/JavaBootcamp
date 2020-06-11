package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AddressDirectoryTest {

    private AddressDirectory directory;
    private List<PersonAddressPair> addressPairList;

    @Before
    public void setUp() {
        populateDirectory();
        directory = new AddressDirectory(addressPairList);
    }

    @Test
    public void getPersonAddressIfInDirectory() {
        Address address = directory.getAddress(new Person("John", "Doe")).get();

        assertEquals("Cheeseville", address.getCity());
        assertEquals("ch3 rr1", address.getPostCode());
        assertEquals("Cherryville", address.getSecondLine());
        assertEquals("2 Cherry Lane", address.getFirstLine());
    }

    @Test
    public void returnsEmptyOptionalIfPersonDoesNotExist() {
        Optional<Address> addressOptional = directory.getAddress(new Person("Tim", "Tams"));

        assertTrue(addressOptional.isEmpty());
    }

    @Test
    public void updatesAddressOfExistingPerson() {
        Person existingPerson = new Person("John", "Doe");
        Address updatedAddress = new Address("first line", "second line", "post code", "city");
        directory.updateAddress(new PersonAddressPair(existingPerson, updatedAddress));

        assertEquals(directory.getAddress(existingPerson).get(), updatedAddress);
    }

    @Test
    public void addsNewAddressOnUpdateIfPersonDoesNotExist() {

        Person newPerson = new Person("Not John", "Doe");
        Address updatedAddress = new Address("first line", "second line", "post code", "city");

        directory.updateAddress(new PersonAddressPair(newPerson, updatedAddress));

        assertEquals(directory.getAddress(newPerson).get(), updatedAddress);
    }

    @Test
    public void removesPersonFromDirectory() {
        Person existingPerson = new Person("John", "Doe");

        directory.remove(existingPerson);

        assertTrue(directory.getAddress(existingPerson).isEmpty());
    }


    private void populateDirectory() {

        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Jane", "Doe");
        Address address1 = new Address("2 Cherry Lane", "Cherryville", "ch3 rr1", "Cheeseville");
        Address address2 = new Address("12 Ice cream Lane", "Iceville", "ic3 ee3", "IceVille");

        addressPairList = new ArrayList<>();
        addressPairList.add(new PersonAddressPair(person1, address1));
        addressPairList.add(new PersonAddressPair(person2, address2));
    }
}
