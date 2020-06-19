package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        directory = new TreeMap<>(Comparator.comparing(Person::getSecondName).thenComparing(Person::getFirstName));
        addressList.forEach((p) -> directory.put(p.getPerson(), p.getAddress()));
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(directory.get(person));
    }

    public List<Person> getPeople(final Address queryAddress) {
        List<Person> people = new ArrayList<>();
        directory.forEach((person, address) -> {if(address.equals(queryAddress)) people.add(person);});
        return people;
    }

    public Status updateAddress(final Person person, Address address) {
        directory.put(person, address);
        if(directory.get(person) == null){
            return Status.KEY_NOT_FOUND;
        }
        return Status.SUCCESS;
    }

    public Status updateAddress(final Address currentAddress, final Address newAddress) {
        List<Person> people = getPeople(currentAddress);
        if(people.isEmpty()){
            return Status.KEY_NOT_FOUND;
        }
        people.forEach((person) -> updateAddress(person, newAddress));
        return Status.SUCCESS;
    }

    public Status remove(final Person person) {
        if(directory.get(person) != null){
            directory.remove(person);
            return Status.SUCCESS;
        }
        return Status.KEY_NOT_FOUND;
    }

    public Status remove(final Address address) {
        List<Person> people = getPeople(address);
        if(people.isEmpty()){
            return Status.KEY_NOT_FOUND;
        }
        people.forEach((person) -> remove(person));
        return Status.SUCCESS;
    }
}
