package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AddressDirectoryTest {

    private List<PersonAddressPair> longList;
    private AddressDirectory directory;

    @Before
    public void setup(){
        var testPerson = createBlah();
        var testAddress = createBlahAddress();
        longList = Arrays.asList(new PersonAddressPair(testPerson, testAddress), new PersonAddressPair(new Person("Blah2","Blahsky"), testAddress));
        directory = new AddressDirectory(longList);
    }

    @Test
    public void getAddress_WhenPErsonExists_ReturnsAddress(){

        var result = directory.getAddress(createBlah());

        assertEquals(createBlahAddress(), result.get());
    }

    @Test
    public void getAddress_WhenPersonDoesntExist_ReturnsAddress(){
        var result = directory.getAddress(new Person("blu","blusky"));

        assertEquals(Optional.empty(), result);
    }

    @Test
    public void updateAddress_WhenPersonExists_UpdatesAddress(){
        var newTestAddress = new Address("1","2","3","4");

        directory.updateAddress(new PersonAddressPair(createBlah(), newTestAddress));
        var result1 = directory.getAddress(createBlah());
        var result2 = directory.getAddress(new Person("Blah2","Blahsky"));

        assertEquals(newTestAddress, result1.get());
        assertEquals(newTestAddress, result2.get());
    }

    @Test
    public void updateAddress_WhenPersonNotExists_UpdatesAddress(){
        var newTestPerson = new Person("blu","blusky");
        var newTestAddress = new Address("1","2","3","4");

        directory.updateAddress(new PersonAddressPair(newTestPerson, newTestAddress));
        var result = directory.getAddress(newTestPerson);

        assertEquals(newTestAddress, result.get());
    }

    @Test
    public void shouldRemoveWhenPresent(){
        var person = createBlah();

        directory.remove(person);

        assertEquals(Optional.empty(), directory.getAddress(person));
    }

    @Test
    public void shouldNotFailWhenNotPresentAndAskedToRemove(){
        var person = createBlah();

        directory.remove(person);
        directory.remove(person);

        assertEquals(Optional.empty(), directory.getAddress(person));
    }

    private Person createBlah(){
        return new Person("Blah","Blahsky");
    }

    private Address createBlahAddress(){
        return new Address("Blahouse",
                "Blahstreet",
                "code",
                "city");
    }

}