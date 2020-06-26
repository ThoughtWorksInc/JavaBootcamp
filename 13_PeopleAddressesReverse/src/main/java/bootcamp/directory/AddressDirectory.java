package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;
import java.util.function.Consumer;

public class AddressDirectory {

    private Map<Person, Address> directory = new TreeMap<Person, Address>(new PersonComparator());

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        Consumer<? super PersonAddressPair> addEntry = p -> directory.put(p.getPerson(), p.getAddress());
        Consumer<? super PersonAddressPair> addResident = p -> p.getAddress().addResident(p.getPerson());

        for (PersonAddressPair p: addressList
             ) {
            var address = p.getAddress();
            var person = p.getPerson();
            address.addResident(person);
            directory.put(person, address);
        }
    }

    public Optional<Address> getAddress(final Person person) {

        return Optional.ofNullable(directory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        var person = personAddress.getPerson();
        var address = personAddress.getAddress();

        var residentsOldAddress = (getAddress(person).isEmpty()) ? null : getAddress(person).get().getResidents();

        if (residentsOldAddress != null){
            for (Person resident: residentsOldAddress
            ) {
                address.addResident(resident);
                directory.put(resident, address);
            }
        }
        else {
            address.addResident(person);
            directory.put(person, address);
        }
    }

    public void remove(final Person person) {
        directory.remove(person);
    }

    public List<Person> getPeople(Address address){
        return address.getResidents();
    }

}

