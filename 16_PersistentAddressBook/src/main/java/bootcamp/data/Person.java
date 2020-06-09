package bootcamp.data;

import java.util.Optional;

public class Person {
    public final String firstName;
    public final String secondName;
    public final Optional<Integer> id;
    public final Optional<Integer> addressId;

    public Person(final String firstName, final String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = Optional.empty();
        this.addressId = Optional.empty();
    }

    public Person(final String firstName, final String secondName, final int id, final int addressId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = Optional.of(id);
        this.addressId = Optional.of(addressId);
    }
}
