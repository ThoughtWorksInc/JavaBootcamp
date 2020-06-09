package bootcamp.data;

import java.util.Optional;

public class Address {
    public final String firstLine;
    public final String secondLine;
    public final String postCode;
    public final String city;
    public final Optional<Integer> id;

    public Address(final String firstLine, final String secondLine, final String city, final String postCode) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.postCode = postCode;
        this.id = Optional.empty();
    }

    public Address(final String firstLine, final String secondLine, final String city, final String postCode,
            final int id) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.postCode = postCode;
        this.id = Optional.of(id);
    }
}
