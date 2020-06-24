package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectoryService {

    private PersonDirectory personDirectory;
    private AddressDirectory addressDirectory;

    public DirectoryService(List<PersonAddressPair> addressList) {
        this.personDirectory = new PersonDirectory(addressList);
        this.addressDirectory = new AddressDirectory(addressList);
    }

    public void updatePerson(Person person, Address newAddress) {
        Optional<Address> currentAddress = getAddress(person);
        if(currentAddress.isEmpty()){
            addressDirectory.add(person, newAddress);
        } else {
            addressDirectory.update(currentAddress.get(), newAddress);
        }
        personDirectory.update(person, newAddress);
    }

    public void updateAddress(Address currentAddress, Address newAddress){
        List<Person> people = addressDirectory.getPeople(currentAddress);
        for (Person p : people) {
            personDirectory.update(p, newAddress);
        }
        addressDirectory.update(currentAddress, newAddress);
    }

    public Optional<Address> getAddress(Person person) {
        return personDirectory.getAddress(person);
    }

    public List<Person> getPeople(Address address) {
        return addressDirectory.getPeople(address);
    }
}
