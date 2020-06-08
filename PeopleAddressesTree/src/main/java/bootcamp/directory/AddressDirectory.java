package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {

        directory = addressList.stream()
                .collect(Collectors.toMap(
                        PersonAddressPair::getPerson,
                        PersonAddressPair::getAddress,
                        getFirstPersonPair(),
                        TreeMap::new
                ));
    }

    // in the event of having two pairs with the same key (eg same person two addresses)
    // just use the first address
    // (may not be the best way in reality but good enough for this example)
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
