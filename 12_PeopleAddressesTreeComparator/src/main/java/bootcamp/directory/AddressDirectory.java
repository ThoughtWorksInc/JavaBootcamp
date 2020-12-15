package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;
public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.directory = new TreeMap<>(Person::compare);
        for (PersonAddressPair pair : addressList) {
            this.directory.put(pair.getPerson(), pair.getAddress());
        }
    }

    public Optional<Address> getAddress(final Person person) {
        Address address = this.directory.get(person);
        return Optional.ofNullable(address);
    }

    public boolean updateAddress(final PersonAddressPair personAddress) {
        return this.directory.replace(personAddress.getPerson(), personAddress.getAddress()) != null;
    }

    public boolean remove(final Person person) {
        return this.directory.remove(person) != null;
    }
}