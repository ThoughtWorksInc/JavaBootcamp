package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return CharSequence.compare(person1.getFirstName(), person2.getFirstName());
            }
        });

        //TODO convert addressList to a TreeMap assigned to directory.

        addressList.forEach(personAddressPair -> directory.put(personAddressPair.getPerson(), personAddressPair.getAddress()));
    }

    private BinaryOperator<Address> getFirstPersonPair() {
        return (personPair1, personPair2) -> personPair1;
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
