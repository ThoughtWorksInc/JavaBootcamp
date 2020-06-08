package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;
import java.util.stream.Collectors;

public class AddressDirectory {
    private final Map<Person, Address> directory;
//    private final Map<Person, Address> directory = new Map<>()

//    List here can be an ArrayList or LinkedList etc, it's not specified here
    public AddressDirectory(final List<PersonAddressPair> addressList) {

//        For Loop
//        for(int i = 0; i < addressList.size(); i++) {
//            directory.put(addressList.get(i).getPerson(), addressList.get(i).getAddress());
//        }

//        Lambda
//        addressList.forEach(personAddressPair -> directory.put(personAddressPair.getPerson(), personAddressPair.getAddress()));

        // Stream (Lists are streamable), allows you to use different functional methods like mapping
        // I want to collect this stream into a map- takes a list and returns a map.
        // If using this you don't need to create a map on ln 11, just the variable
        // First argument is a lambda to get the person as they key,
        // second is a lambda to get the address as the value
        directory = addressList.stream()
                .collect(Collectors.toMap(
                        PersonAddressPair::getPerson,
                        PersonAddressPair::getAddress
                ));
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
