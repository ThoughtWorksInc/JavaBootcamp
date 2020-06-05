package bootcamp.data;

import java.util.Optional;

public class Address {
    private final String firstLine;
    private final String secondLine;
    private final String postCode;
    private final String city;
    private final Optional<Integer> id;

    /**
     * Used to construct a query.
     * @param firstLine
     * @param secondLine
     * @param city
     * @param postCode
     */
    public Address(final String firstLine, final String secondLine, final String city, final String postCode) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.postCode = postCode;
        this.id = Optional.empty();
    }

    /**
     * Used to construct a response from query.
     * @param firstLine
     * @param secondLine
     * @param city
     * @param postCode
     * @param id
     */
    public Address(final String firstLine, final String secondLine, final String city, final String postCode, final int id) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.postCode = postCode;
        this.id = Optional.of(id);
    }

    public String getFirstLine() {
        return this.firstLine;
    }

    public String getSecondLine() {
        return this.secondLine;
    }

    public String getCity () {
        return this.city;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public Optional<Integer> getId() {
        return this.id;
    }
}
