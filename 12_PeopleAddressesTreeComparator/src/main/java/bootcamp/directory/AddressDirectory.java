package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new TreeMap<>(Comparator.comparing(Person::getFirstName));
        addressList.forEach((p) -> directory.put(p.getPerson(), p.getAddress()));
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(directory.get(person));
    }

    public Status updateAddress(final PersonAddressPair personAddress) {
        directory.put(personAddress.getPerson(), personAddress.getAddress());
        return Status.SUCCESS;
    }

    public Status remove(final Person person) {
        directory.remove(person);
        return Status.SUCCESS;
    }
}
