package bootcamp.data;

public class Address {

    private final String firstLine;
    private final String secondLine;
    private final String postCode;
    private final String city;

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
