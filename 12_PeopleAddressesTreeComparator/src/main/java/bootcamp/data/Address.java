package bootcamp.data;

public class Address {
    public final String firstLine;
    public final String secondLine;
    public final String postCode;
    public final String city;

    public Address(final String firstLine, final String secondLine, final String postCode, final String city) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postCode = postCode;
        this.city = city;
    }
}
