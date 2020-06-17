package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new HashMap<>();
        addressList.forEach((p) -> directory.put(p.getPerson(), p.getAddress()));
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(directory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        directory.remove(person);
    }
}
