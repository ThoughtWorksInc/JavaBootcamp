package bootcamp.data;

public class Address {

    private final String firstLine; //FIXME
    private final String secondLine; //FIXME
    private final String postCode; //FIXME
    private final String city; //FIXME

    public Address(String firstLine, String secondLine, String postCode, String city) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postCode = postCode;
        this.city = city;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
