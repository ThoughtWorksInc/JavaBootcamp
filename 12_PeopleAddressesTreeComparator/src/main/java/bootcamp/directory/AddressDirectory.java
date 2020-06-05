package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new TreeMap<>(new Comparator<Person>() {
            //FIXME
        });
        //TODO convert addressList to a TreeMap assigned to directory.
    }

    public Optional<Address> getAddress(final Person person) {
        //FIXME
        return null;
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        //FIXME
    }

    public void remove(final Person person) {
        //FIXME
    }
}
