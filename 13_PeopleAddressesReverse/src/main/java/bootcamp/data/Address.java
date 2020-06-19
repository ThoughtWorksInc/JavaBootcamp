package bootcamp.data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(firstLine, address.firstLine) &&
                Objects.equals(secondLine, address.secondLine) &&
                Objects.equals(postCode, address.postCode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstLine, secondLine, postCode, city);
    }
}
