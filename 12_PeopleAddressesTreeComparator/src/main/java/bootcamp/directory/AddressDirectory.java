package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getFirstName().compareToIgnoreCase(t1.getFirstName());
            }
        });
        addressList.forEach((pair) -> directory.put(pair.getPerson(), pair.getAddress()));

    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(directory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.replace(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        directory.remove(person);
    }

    public boolean hasPerson (Person person) {
        if (directory.containsKey(person)) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDirectory directory1 = (AddressDirectory) o;
        return Objects.equals(directory, directory1.directory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directory);
    }
}
