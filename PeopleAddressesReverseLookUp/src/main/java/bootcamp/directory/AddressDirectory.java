package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.*;

public class AddressDirectory {

    Map<Person, Address> personToAddressDirectory;
    Map<Address, List<Person>> addressToPersonDirectory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.personToAddressDirectory = new HashMap<>();
        this.addressToPersonDirectory = new HashMap<>();

        for (PersonAddressPair pair : addressList) {

            personToAddressDirectory.put(pair.getPerson(),
                    pair.getAddress());


            addressToPersonDirectory.computeIfPresent(pair.getAddress(), (k, v) -> {
                v.add(pair.getPerson());
                return v;
            });

            addressToPersonDirectory.computeIfAbsent(pair.getAddress(), k ->
                    new ArrayList<Person>() {{
                        add(pair.getPerson());
                    }});
        }

    }


    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(personToAddressDirectory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        personToAddressDirectory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    public void remove(final Person person) {
        personToAddressDirectory.remove(person);
    }

    public List<PersonAddressPair> getPeopleByAddress(Address address) {
        return addressToPersonDirectory.getOrDefault(address, Collections.EMPTY_LIST);
    }


}
