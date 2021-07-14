package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> peopleDirectory;
    private  final Map<Address, List<Person>> addressDirectory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {

        peopleDirectory = new TreeMap<>();
        addressDirectory = new TreeMap<>();

        addressList.forEach((pair) -> peopleDirectory.put(pair.getPerson(), pair.getAddress()));

        addressList.forEach((pair) -> {
            if (addressDirectory.containsKey(pair.getAddress())) {
               List<Person> list = addressDirectory.get(pair.getAddress());
               list.add(pair.getPerson());
            } else {
                List<Person> list = new ArrayList();
                list.add(pair.getPerson());
                addressDirectory.put(pair.getAddress(), list);
            }
        });

    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(peopleDirectory.get(person));
    }

    public void updateAddress(final PersonAddressPair personAddress) {
        //change people
        if (!peopleDirectory.containsKey(personAddress.getPerson())) {
            peopleDirectory.put(personAddress.getPerson(), personAddress.getAddress());
        } else
            peopleDirectory.replace(personAddress.getPerson(), personAddress.getAddress());

        //change address
        if (addressDirectory.containsKey(personAddress.getAddress())) {
            List<Person> list = addressDirectory.get(personAddress.getAddress());
            list.add(personAddress.getPerson());
        } else {
            List<Person> list = new ArrayList();
            list.add(personAddress.getPerson());
            addressDirectory.put(personAddress.getAddress(), list);
        }
    }

    public Status remove(final Person person) {
        //people dir
        if (!peopleDirectory.containsKey(person)) return Status.KEY_NOT_FOUND;
        peopleDirectory.remove(person);

        //address dir
        addressDirectory.forEach((a,p) -> {
            Iterator<Person> iterator;
            iterator =  p.iterator();
            while (iterator.hasNext()) {
                if (person.equals(iterator.next())) iterator.remove();
            }
        });
        return Status.SUCCESS;
    }


    public List<Person> getPersonsAtAddress(Address address) {
        return addressDirectory.get(address)!= null ? addressDirectory.get(address) : new ArrayList<Person>();
    }

    public Status updateAddress(Address oldAddress, Address newAddress) {

        if (!addressDirectory.containsKey(oldAddress)) return Status.KEY_NOT_FOUND;

        //person dir
        List<Person> personsToUpdate =  addressDirectory.get(oldAddress);
        Iterator<Person> iterator = personsToUpdate.iterator();
        while (iterator.hasNext()) {
            updateAddress(new PersonAddressPair(iterator.next(), newAddress));
        }

        //address dir
        addressDirectory.put(newAddress, addressDirectory.get(oldAddress));
        addressDirectory.remove(oldAddress);
        return Status.SUCCESS;
    }

    public Status remove(Address address) {
        if (!addressDirectory.containsKey(address)) return Status.KEY_NOT_FOUND;

        for (Person p : addressDirectory.get(address)) {
            peopleDirectory.remove(p);
        }

        //address dir
        addressDirectory.remove(address);
        return Status.SUCCESS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDirectory directory = (AddressDirectory) o;
        return Objects.equals(peopleDirectory, directory.peopleDirectory) && Objects.equals(addressDirectory, directory.addressDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleDirectory, addressDirectory);
    }



}
