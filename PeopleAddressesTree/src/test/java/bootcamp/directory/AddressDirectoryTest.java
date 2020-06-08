package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import com.sun.jdi.request.ClassUnloadRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class AddressDirectoryTest {

    //    static so the variable is created on the class not on instances
    //    Creating constants for ease
    private static final Person PERSON_1 = new Person("Olivia", "Frost");
    private static final Person PERSON_2 = new Person("Will", "Powell");
    private static final Person PERSON_3 = new Person("Santa", "Claus");

    private static final Address ADDRESS_1 = new Address("A house", "A road", "A postcode", "A city");
    private static final Address ADDRESS_2=  new Address("A different house", "A different road", "A different postcode", "A different city");

    // so that it can be used in @Before but isn't then out of scope in the tests
    private AddressDirectory addressDirectory;

    @Before
    public void setup() {
        PersonAddressPair personAddressPair1 =
                new PersonAddressPair(PERSON_1, ADDRESS_1);

        PersonAddressPair personAddressPair2 =
                new PersonAddressPair(PERSON_2, ADDRESS_2);

        List<PersonAddressPair> personAddressPairList = List.of(personAddressPair1, personAddressPair2);

        addressDirectory = new AddressDirectory(personAddressPairList);
    }

    @Test
    public void shouldGetAddressWhenPersonExists() {
        Optional<Address> actual = addressDirectory.getAddress(PERSON_1);
        assertEquals(Optional.of(ADDRESS_1), actual);

    }

    @Test
    public void shouldGetAddressWhenSecondPersonExists() {
        Optional<Address> actual = addressDirectory.getAddress(PERSON_2);
        assertEquals(Optional.of(ADDRESS_2), actual);
    }

    @Test
    public void shouldReturnOptionalOfAddressWhenPersonDoesNotExist() {
        Optional<Address> actual = addressDirectory.getAddress(PERSON_3);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void shouldUpdateAddressWhenPersonExists() {
        PersonAddressPair PERSON_NEW_ADDRESS_PAIR = new PersonAddressPair(PERSON_1, ADDRESS_2);
        addressDirectory.updateAddress(PERSON_NEW_ADDRESS_PAIR);
        Optional<Address> actual = addressDirectory.getAddress(PERSON_1);
        assertEquals(Optional.of(ADDRESS_2), actual);
        assertNotEquals(Optional.of(ADDRESS_1), actual);
    }

    @Test
    public void shouldUpdateAddressWhenPersonDoesNotExist() {
        PersonAddressPair NEW_PERSON_NEW_ADDRESS_PAIR = new PersonAddressPair(PERSON_3, ADDRESS_2);
        addressDirectory.updateAddress(NEW_PERSON_NEW_ADDRESS_PAIR);
        Optional<Address> actual = addressDirectory.getAddress(PERSON_3);
        assertEquals(Optional.of(ADDRESS_2), actual);
    }

    @Test
    public void shouldRemoveAPersonsAddressFromTheDirectory() {
        addressDirectory.remove(PERSON_1);
        Optional<Address> actual = addressDirectory.getAddress(PERSON_1);
        assertEquals(Optional.empty(), actual);
    }
}