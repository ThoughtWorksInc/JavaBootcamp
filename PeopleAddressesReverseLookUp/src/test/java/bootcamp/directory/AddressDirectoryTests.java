package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
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
        Status status = addressDirectory.updateAddress(personAddressPairUpdate);
        Optional<Address> result = addressDirectory.getAddress(person1);
        assertThat(result.get(), is(address2));
        assertThat(status, is(Status.SUCCESS));
    }

    @Test
    public void updateAddress_adds_persons_address_when_missing_in_dictionary() {
        assertThat(addressDirectory.getAddress(person2), is(Optional.empty()));
        Status status = addressDirectory.updateAddress(personAddressPair2);
        Optional<Address> result = addressDirectory.getAddress(person2);
        assertThat(result.get(), is(address2));
        assertThat(status, is(Status.SUCCESS));
    }

    @Test
    public void remove_deletes_person_from_dictionary() {
        Status status = addressDirectory.remove(person1);
        Optional<Address> result = addressDirectory.getAddress(person1);
        assertThat(result, is(Optional.empty()));
        assertThat(status, is(Status.SUCCESS));
    }

    @Test
    public void remove_returns_key_not_found_if_not_in_dictionary() {
        Status status = addressDirectory.remove(person2);
        assertThat(status, is(Status.KEY_NOT_FOUND));
    }

    @Test
    public void get_people_by_address_returns_list_of_people_at_address() {
        List result = addressDirectory.getPeopleByAddress(address1);
        System.out.println(result);
        assertThat(result.size(), is(2));
        assertThat(result.get(0), is(person1));
        assertThat(result.get(1), is(person3));

    }

    @Test
    public void updateAddress_updates_personToAddressPair_when_found_in_dictionary_by_person() {
        Status status = addressDirectory.updateAddress(address1, address2);
        Optional<Address> result = addressDirectory.getAddress(person1);
        Optional<Address> result2 = addressDirectory.getAddress(person3);
        assertThat(result.get(), is(address2));
        assertThat(result2.get(), is(address2));
        assertThat(status, is(Status.SUCCESS));
    }

    @Test
    public void updateAddress_updates_addressToPersonPair_when_found_in_dictionary_by_address() {
        Status status = addressDirectory.updateAddress(address1, address2);
        List<PersonAddressPair> result = addressDirectory.getPeopleByAddress(address2);
        List<PersonAddressPair> result2 = addressDirectory.getPeopleByAddress(address1);

        assertThat(result.size(), is(2));
        assertThat(result.get(0), is(person1));
        assertThat(result.get(1), is(person3));
        assertThat(result2, is(Collections.EMPTY_LIST));
        assertThat(status, is(Status.SUCCESS));
    }

    @Test
    public void removeAddress_removes_people_associated_withAddress_from_personToAddress() {
        Status status = addressDirectory.remove(address1);
        Optional<Address> result = addressDirectory.getAddress(person1);
        Optional<Address> result2 = addressDirectory.getAddress(person3);
        assertThat(result, is(Optional.empty()));
        assertThat(result2, is(Optional.empty()));
        assertThat(status, is(Status.SUCCESS));
    }

    @Test
    public void removeAddress_removes_people_associated_withAddress_from_addressToPerson() {
        Status status = addressDirectory.remove(address1);
        List<PersonAddressPair> result = addressDirectory.getPeopleByAddress(address1);
        assertThat(result, is(Collections.EMPTY_LIST));
        assertThat(status, is(Status.SUCCESS));

    }

    @Test
    public void removeAddress_returns_key_not_found_if_no_address_found() {
        Status status = addressDirectory.remove(address2);
        assertThat(status, is(Status.KEY_NOT_FOUND));
    }

}
