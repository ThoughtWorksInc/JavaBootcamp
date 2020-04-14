package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> personToAddressDirectory;
    private final Map<Address, List<Person>> addressToPeopleDirectory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.personToAddressDirectory = new HashMap<>();
        this.addressToPeopleDirectory = new HashMap<>();

        for (PersonAddressPair pair : addressList) {
            addToPersonToAddressDirectory(pair);
            addToAddressToPeopleDirectory(pair);
        }
    }

    private void addToPersonToAddressDirectory(final PersonAddressPair personAddress) {
        personToAddressDirectory.put(personAddress.getPerson(), personAddress.getAddress());
    }

    private void addToAddressToPeopleDirectory(final PersonAddressPair personAddress) {
        addressToPeopleDirectory.computeIfPresent(personAddress.getAddress(), (k, v) -> {
            v.add(personAddress.getPerson());
            return v;
        });
        addressToPeopleDirectory.computeIfAbsent(personAddress.getAddress(), k -> new ArrayList<>()).add(personAddress.getPerson());
    }

    public Optional<Address> getAddress(final Person person) {
        Optional<Address> address = Optional.ofNullable(personToAddressDirectory.get(person));

        return address.isPresent() ? address : Optional.empty();
    }

    public List<Person> getPeople(final Address address) {
        return addressToPeopleDirectory.getOrDefault(address, Collections.emptyList());
    }

    public Status updateAddress(final PersonAddressPair personAddressPair) {
        try {
            Address existingAddress = personToAddressDirectory.get(personAddressPair.getPerson());
            addToPersonToAddressDirectory(personAddressPair);
            addToAddressToPeopleDirectory(personAddressPair);

            if (existingAddress != null) {
                addressToPeopleDirectory.get(existingAddress).remove(personAddressPair.getPerson());
            }
            return Status.SUCCESS;
        } catch(Exception e) {
            return Status.UNKNOWN_ERROR;
        }
    }

    public Status updateAddress(final Address oldAddress, final Address newAddress) {
        boolean found = false;

        for (Person person : personToAddressDirectory.keySet()) {
            found = personToAddressDirectory.replace(person, oldAddress, newAddress) ? true : found;
        }

        List<Person> people = addressToPeopleDirectory.remove(oldAddress);
        if (people == null) {
            found = false;
        } else {
            addressToPeopleDirectory.put(newAddress, people);
        }

        return found ? Status.SUCCESS : Status.KEY_NOT_FOUND;
    }

    public Status remove(final Person person) {
        Address address = personToAddressDirectory.remove(person);
        List<Person> foundPeople = getPeople(address);

        if (foundPeople.isEmpty()) {
            return Status.KEY_NOT_FOUND;
        } else {
            foundPeople.remove(person);
            return Status.SUCCESS;
        }
    }

    public Status remove(final Address address) {
        List<Person> people = getPeople(address);
        Status status = Status.KEY_NOT_FOUND;
        for (Person person : people) {
            if (personToAddressDirectory.replace(person, address, null)) {
                status = Status.SUCCESS;
            };
        }
        if (!addressToPeopleDirectory.replace(address, people, Collections.emptyList())) {
            status = Status.KEY_NOT_FOUND;
        }
        return status;
    }
}
