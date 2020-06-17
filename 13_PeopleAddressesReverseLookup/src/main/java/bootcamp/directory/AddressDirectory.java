package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.Map.Entry;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.directory = new HashMap<>();
        for (PersonAddressPair entry : addressList) {
            this.directory.put(entry.getPerson(), entry.getAddress());
        }
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(this.directory.get(person));
    }

    public List<Person> getPeople(final Address address) {
        List<Person> people = new ArrayList<>();
        for (Entry entry : directory.entrySet())
            if (entry.getValue().equals(address)) {
                people.add((Person) entry.getKey());
            }
        return people;
    }

    public Status updateAddress(final Address existingAddress, final Address newAddress) {
        List<Person> people = getPeople(existingAddress);
        for (Person person : people) {
            updateAddress(new PersonAddressPair(person, newAddress));
        }
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
        this.directory.put(personAddress.getPerson(), personAddress.getAddress());
        return Status.SUCCESS;
    }

    public Status remove(final Person person) {
        if (directory.containsKey(person)) {
            directory.remove(person);
            return Status.SUCCESS;
        } else {
            return Status.KEY_NOT_FOUND;
        }
    }


    public Status remove(final Address address) {
        List<Person> people = this.getPeople(address);
        for (Person person: people) {
            this.directory.remove(person);
        }
        return getStatus(people);
    }
}
