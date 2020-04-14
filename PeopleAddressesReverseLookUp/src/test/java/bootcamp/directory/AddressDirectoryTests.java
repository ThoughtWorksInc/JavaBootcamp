package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddressDirectoryTests {

    private AddressDirectory addressDirectory;
    private List<PersonAddressPair> personAddressPairList;
    private PersonAddressPair personAddressPair2;
    private PersonAddressPair personAddressPairUpdate;
    private Person person1;
    private Person person2;
    private Person person3;
    private Address address1;
    private Address address2;

    @Before
    public void setUp() {
        person1 = new Person("Will", "Ensoll");
        person2 = new Person("Bill", "Ensoll");
        person3 = new Person("Dill", "Ensoll");
        address1 = new Address("1", "road", "postcode", "city1");
        address2 = new Address("2", "road", "postcode", "city2");
        personAddressPair2 = new PersonAddressPair(person2, address2);
        personAddressPairUpdate = new PersonAddressPair(person1, address2);

        personAddressPairList = Arrays.asList(
                new PersonAddressPair(person1, address1),
                new PersonAddressPair(person3, address1)
        );

        addressDirectory = new AddressDirectory(personAddressPairList);
    }

    @Test
    public void getAddress_returns_address_of_person_in_directory() {
        Optional<Address> result = addressDirectory.getAddress(person1);
        assertThat(result.get(), is(address1));
    }

    @Test
    public void getAddress_returns_empty_optional_when_address_of_person_not_found() {
        Optional<Address> result = addressDirectory.getAddress(new Person("unknown", "person"));
        assertThat(result, is(Optional.empty()));
    }

    @Test
    public void updateAddress_updates_persons_address_when_found_in_dictionary() {
        addressDirectory.updateAddress(personAddressPairUpdate);
        Optional<Address> result = addressDirectory.getAddress(person1);
        assertThat(result.get(), is(address2));
    }

    @Test
    public void updateAddress_adds_persons_address_when_missing_in_dictionary() {
        assertThat(addressDirectory.getAddress(person2), is(Optional.empty()));
        addressDirectory.updateAddress(personAddressPair2);
        Optional<Address> result = addressDirectory.getAddress(person2);
        assertThat(result.get(), is(address2));
    }

    @Test
    public void remove_deletes_person_from_dictionary() {
        addressDirectory.remove(person1);
        Optional<Address> result = addressDirectory.getAddress(person1);
        assertThat(result, is(Optional.empty()));
    }

    @Test
    public void get_people_by_address_returns_list_of_people_at_address() {
        List result = addressDirectory.getPeopleByAddress(address1);
        System.out.println(result);
        assertThat(result.size(), is(2));
        assertThat(result.get(0), is(person1));
        assertThat(result.get(1), is(person3));

    }
}
