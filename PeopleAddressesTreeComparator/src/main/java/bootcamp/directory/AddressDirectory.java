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
            public int compare(Person o1, Person o2) {
                if (o1.getFirstName().equals(o2.getFirstName()) && o1.getSecondName().equals(o2.getSecondName())) {
                    return 0;
                }
                else return (o1.toString().compareTo(o2.toString()));
            }
        });
        for(PersonAddressPair entry : addressList){
            directory.put(entry.getPerson(), entry.getAddress());
        };
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
