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
            public int compare(Person personOne, Person personTwo) {
                return CharSequence.compare(personOne.getFirstName(), personTwo.getFirstName());
            }
        });
        for (PersonAddressPair pair : addressList) {
            directory.put(pair.getPerson(), pair.getAddress());
        }
    }

    public Optional<Address> getAddress(final Person person) {
        Optional<Address> address = Optional.ofNullable(directory.get(person));

        return address.isPresent() ? address : Optional.empty();
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        directory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        directory.remove(person);
    }
}
