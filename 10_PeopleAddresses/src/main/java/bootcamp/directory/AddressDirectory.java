package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AddressDirectory {
    private final Map<Person, Address> addressBook;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        addressBook = new HashMap<Person, Address>();
        addressList.forEach(personAndAddressPair -> {
            if (!addressBook.containsKey(personAndAddressPair.person)) {
                addressBook.put(personAndAddressPair.person, personAndAddressPair.address);
            }
        });
    }

    public Optional<Address> getAddress(final Person person) {
        return addressBook.containsKey(person) ? Optional.of(addressBook.get(person)) : Optional.empty();
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        addressBook.put(personAddress.person, personAddress.address);
    }

    public void remove(final Person person) {
        if (addressBook.containsKey((person))) {
            addressBook.remove(person);
        }
    }
}
