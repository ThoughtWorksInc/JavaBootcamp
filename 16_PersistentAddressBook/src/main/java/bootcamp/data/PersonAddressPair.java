package bootcamp.data;

public class PersonAddressPair {
    private final Person person;
    private final Address address;

    public PersonAddressPair(final Person person, final Address address) {
        this.person = person;
        this.address = address;
    }

    public Person getPerson() {
        return this.person;
    }

    public Address getAddress() {
        return this.address;
    }
}
