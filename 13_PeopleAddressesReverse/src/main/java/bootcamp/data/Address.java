package bootcamp.data;

import java.util.*;

public class Address {
    private final String firstLine; //FIXME
    private final String secondLine; //FIXME
    private final String postCode; //FIXME
    private final String city; //FIXME
    private List<Person> residents;

    public Address(String firstLine, String secondLine, String postCode, String city) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.postCode = postCode;
        this.city = city;
        residents = new ArrayList<Person>();
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

    public List<Person>  getResidents(){
        return residents;
    }

    public void addResident(Person newResident) {
        residents.add(newResident);
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

    @Override
    public String toString() {
        return "Address{" +
                "firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
