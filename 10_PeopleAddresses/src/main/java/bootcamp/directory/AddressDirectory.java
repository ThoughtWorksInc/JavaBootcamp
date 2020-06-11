package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;

public class AddressDirectory {
    private Map<Person, Address> directory;
    private List<PersonAddressPair> addressList;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.addressList = addressList;
        populateMap();
    }

    public Optional<Address> getAddress(final Person person) {
        return directory.containsKey(person) ? Optional.of(directory.get(person)) : Optional.empty();
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        directory.remove(person);
    }

    public void populateMap() {
        directory = new HashMap<Person, Address>();
        addressList.forEach(pair -> directory.put(pair.getPerson(), pair.getAddress()));
    }
}
