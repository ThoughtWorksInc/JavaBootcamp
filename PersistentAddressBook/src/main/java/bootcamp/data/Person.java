package bootcamp.data;

import java.util.Optional;

public class Person {
    private final String firstName;
    private final String secondName;
    private final Optional<Integer> id;
    private final Optional<Integer> addressId;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = Optional.empty();
        this.addressId = Optional.empty();
    }

    public Person(String firstName, String secondName, int id, int addressId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = Optional.of(id);
        this.addressId = Optional.of(addressId);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Optional<Integer> getId() {
        return id;
    }

    public Optional<Integer> getAddressId() {
        return addressId;
    }

}
