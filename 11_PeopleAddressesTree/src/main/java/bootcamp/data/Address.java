package bootcamp.data;

import java.util.Objects;

public class Address {
    private final String firstLine;
    private final String secondLine;
    private final String postCod;
    private final String city;

    public Address(String firstLine, String secondLine, String postCod, String city) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postCod = postCod;
        this.city = city;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String getPostCod() {
        return postCod;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(firstLine, address.firstLine) && Objects.equals(secondLine, address.secondLine) && Objects.equals(postCod, address.postCod) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstLine, secondLine, postCod, city);
    }
}
