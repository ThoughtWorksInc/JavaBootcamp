package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        TreeMap<Person, Address> newDir = new TreeMap<Person, Address>();
        for(PersonAddressPair entry : addressList){
            newDir.put(entry.getPerson(), entry.getAddress());
        }
        this.directory = newDir;
    }

    public Optional<Address> getAddress(final Person person) {
        Address address = this.directory.get(person);
        if (address == null) {
            return Optional.empty();
        }
        return Optional.of(address);
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        this.directory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        this.directory.remove(person);
    }
}
