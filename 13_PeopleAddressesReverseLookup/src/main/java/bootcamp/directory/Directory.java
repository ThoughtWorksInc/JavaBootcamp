package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Directory {
    private final Map<Person, Address> personDirectory;
    private final Map<Address, List<Person>> addressDirectory;

    public Directory(List<PersonAddressPair> addressList) {
        personDirectory = addressList
                .stream()
                .collect(toMap(PersonAddressPair::getPerson, PersonAddressPair::getAddress));
        addressDirectory = addressList
                .stream()
                .collect(groupingBy(PersonAddressPair::getAddress, mapping(PersonAddressPair::getPerson, toList()) ));
    }

    private void populateAddressDirectory(Person person, Address address) {
        if (!addressDirectory.containsKey(address)) {
            List<Person> newList = new ArrayList<>();
            addressDirectory.put(address, newList);
        }
        List<Person> list = addressDirectory.get(address);
        list.add(person);
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(this.personDirectory.get(person));
    }

    public List<Person> getPeople(final Address address) {
        return addressDirectory.getOrDefault(address, new ArrayList<>());
    }

    public Status updateAddress(final Address existingAddress, final Address newAddress) {
        List<Person> people = getPeople(existingAddress);
        updatePersonDirectory(newAddress, people);
        updateAddressDirectory(existingAddress, newAddress, people);
        return getStatus(people);
    }

    private void updatePersonDirectory(Address newAddress, List<Person> people) {
        for (Person person : people) {
            updateAddress(new PersonAddressPair(person, newAddress));
        }
    }

    private void updateAddressDirectory(Address existingAddress, Address newAddress, List<Person> people) {
        addressDirectory.remove(existingAddress, people);
        addressDirectory.put(newAddress, people);
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
        populateAddressDirectory(person, newAddress);
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


    public Status remove(final Address address) {
        List<Person> people = this.getPeople(address);
        for (Person person: people) {
            personDirectory.remove(person);
        }
        addressDirectory.remove(address, people);
        return getStatus(people);
    }
}
