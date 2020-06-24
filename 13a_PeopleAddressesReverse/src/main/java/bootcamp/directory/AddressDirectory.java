package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {

    private Map<Address, List<Person>> addressDirectory;

    public AddressDirectory(List<PersonAddressPair> addressList) {
        addressDirectory = new TreeMap<>(Comparator.comparing(Address::getFirstLine).thenComparing(Address::getSecondLine)
                .thenComparing(Address::getPostCode).thenComparing(Address::getCity));
        addressList.forEach((p) -> createAddressDirectory(p));
    }

    public void createAddressDirectory(PersonAddressPair personAddressPair){
        Person person = personAddressPair.getPerson();
        Address address = personAddressPair.getAddress();
        if(addressDirectory.get(address) == null){
            List<Person> personList = new ArrayList<>();
            personList.add(person);
            addressDirectory.put(address, personList);
        } else {
            List<Person> people = addressDirectory.get(address);
            people.add(person);
            addressDirectory.put(address, people);
        }
    }

    public List<Person> getPeople(Address testAddress) {
        List<Person> people = new ArrayList<>();
        if(addressDirectory.containsKey(testAddress)){
            people = addressDirectory.get(testAddress);
        }
        return people;
    }

    public Status update(Address currentAddress, Address newAddress) {
        if(addressDirectory.containsKey(currentAddress)){
            List<Person> people = addressDirectory.get(currentAddress);
            addressDirectory.remove(currentAddress);
            addressDirectory.put(newAddress, people);
            return Status.SUCCESS;
        } else {
            return Status.KEY_NOT_FOUND;
        }
    }

    public Status add(Person newPerson, Address address) {
        List<Person> people = new ArrayList<>();
        if(addressDirectory.containsKey(address)){
            people.addAll(addressDirectory.get(address));
        }
        people.add(newPerson);
        addressDirectory.put(address, people);
        return Status.SUCCESS;
    }

    public Status remove(Address address) {
        if(addressDirectory.containsKey(address)){
            addressDirectory.remove(address);
            return Status.SUCCESS;
        }
        return Status.KEY_NOT_FOUND;
    }
}
