package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;
import java.util.function.Consumer;

public class AddressDirectory {
    private Map<Person, Address> directory = new TreeMap<Person, Address>(); //FIXME Treemap

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        Consumer<? super PersonAddressPair> addEntry = p -> directory.put(p.getPerson(), p.getAddress());
        addressList.stream().forEach(addEntry);
    }

    public Optional<Address> getAddress(final Person person) {

        return Optional.ofNullable(directory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        var person = personAddress.getPerson();
        var address = personAddress.getAddress();

        directory.put(person, address);
    }

    public void remove(final Person person) {
        directory.remove(person);
    }
}
