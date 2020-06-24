package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class PersonDirectory {

    private Map<Person, Address> personDirectory;

    public PersonDirectory(List<PersonAddressPair> addressList) {
        personDirectory = new TreeMap<>(Comparator.comparing(Person::getSecondName)
                .thenComparing(Person::getFirstName));
        addressList.forEach((p) -> personDirectory.put(p.getPerson(), p.getAddress()));
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(personDirectory.get(person));
    }

    public Status update(final Person person, Address address) {
        personDirectory.put(person, address);
        return Status.SUCCESS;
    }

    public Status remove(final Person person) {
        if(personDirectory.get(person) != null){
            personDirectory.remove(person);
            return Status.SUCCESS;
        }
        return Status.KEY_NOT_FOUND;
    }
}
