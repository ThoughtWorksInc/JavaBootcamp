package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public ArrayList<Person> getPeople(Address searchAddress) {
        ArrayList<Person> results = new ArrayList<Person>();
        this.directory.forEach((person, address) -> {
            if (address.equals(searchAddress)) {
                results.add(person);
            }
        });
        return results;
    }

    public Enum updateAddress(PersonAddressPair personAddress) {
        if (this.directory.containsKey(personAddress.getPerson())) {
            this.directory.put(personAddress.getPerson(), personAddress.getAddress());
            return Status.SUCCESS;
        }
        else return Status.KEY_NOT_FOUND;
    }

    public Enum updateAddress(Address oldAddress, Address newAddress) {
        AtomicBoolean changed = new AtomicBoolean(false);
        this.directory.forEach(((person, address) -> {
            if (address.equals(oldAddress)) {
                this.directory.put(person, newAddress);
                changed.set(true);
            }
        }));
        if (changed.get()) {
            return Status.SUCCESS;
        }
        else return Status.KEY_NOT_FOUND;
    }

    public Enum remove(final Person person) {
        if (this.directory.containsKey(person)) {
            this.directory.remove(person);
            return Status.SUCCESS;
        }
        return Status.KEY_NOT_FOUND;
    }

    public Enum remove(final Address address) {
        ArrayList<Person> results = getPeople(address);
        if (results.size() == 0) {
            return Status.KEY_NOT_FOUND;
        }
        results.forEach(person -> {
            this.directory.remove(person);
        });
        return Status.SUCCESS;
    }
}
