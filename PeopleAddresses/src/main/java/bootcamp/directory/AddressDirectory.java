package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;

public class AddressDirectory {

    Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.directory = new HashMap<>();
        for (PersonAddressPair pair : addressList)
            directory.put(pair.getPerson(),
                    pair.getAddress());
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
