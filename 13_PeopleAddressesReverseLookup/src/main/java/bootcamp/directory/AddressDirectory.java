package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> personDirectory;
    private final Map<Address, List<Person>> addressDirectory;

    public AddressDirectory(List<PersonAddressPair> addressList) {
        personDirectory = new HashMap<>();
        addressDirectory = new HashMap<>();
        for (PersonAddressPair entry : addressList) {
            Person person = entry.getPerson();
            Address address = entry.getAddress();
            personDirectory.put(person, address);
            populateAddressDirectory(person, address);
        }
    }

    private void populateAddressDirectory(Person person, Address address) {
        if (addressDirectory.containsKey(address)) {
            var people = addressDirectory.get(address);
            people = new ArrayList<>(people);
            people.add(person);
            addressDirectory.replace(address, people);
        } else {
            addressDirectory.put(address, Collections.singletonList(person));
        }
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(this.personDirectory.get(person));
    }

    public List<Person> getPeople(final Address address) {
        return addressDirectory.getOrDefault(address, new ArrayList<>());
    }

    public Status updateAddress(final Address existingAddress, final Address newAddress) {
        List<Person> people = getPeople(existingAddress);
        for (Person person : people) {
            updateAddress(new PersonAddressPair(person, newAddress));
        }
        addressDirectory.remove(existingAddress, people);
        addressDirectory.put(newAddress, people);
        return getStatus(people);
    }

    private Status getStatus(List<Person> people) {
        if (people.isEmpty()) {
            return Status.KEY_NOT_FOUND;
        } else {
            return Status.SUCCESS;
        }
    }

    public Status updateAddress(final PersonAddressPair personAddress) {
        var person = personAddress.getPerson();
        var oldAddress = personDirectory.get(person);
        var newAddress = personAddress.getAddress();
        personDirectory.put(person, newAddress);
        removePerson(person, oldAddress);
        return Status.SUCCESS;
    }

    private void removePerson(Person person, Address address) {
        var people = getPeople(address);
        people = new ArrayList<>(people);
        people.remove(person);
        addressDirectory.replace(address, people);
    }



    public Status remove(final Person person) {
        if (personDirectory.containsKey(person)) {
            removePerson(person, getAddress(person).get());
            personDirectory.remove(person);
            return Status.SUCCESS;
        } else {
            return Status.KEY_NOT_FOUND;
        }
    }


    public void remove(final Address address) {
        List<Person> people = this.getPeople(address);
        for (Person person: people) {
            personDirectory.remove(person);
        }
        addressDirectory.remove(address, people);
    }
}
