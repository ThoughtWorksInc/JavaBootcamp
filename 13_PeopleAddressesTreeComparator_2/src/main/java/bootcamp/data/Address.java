package bootcamp.data;

import java.util.Objects;

public class Address implements Comparable<Address> {
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
        return Objects.equals(firstLine, address.firstLine) && Objects.equals(secondLine, address.secondLine) && Objects.equals(postCode, address.postCode) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstLine, secondLine, postCode, city);
    }

    @Override
    public int compareTo(Address address) {

//            int comparePostCode = this.postCode.compareToIgnoreCase(address.getPostCode());
//            if (comparePostCode!=0) return comparePostCode;
//
//            int compareFirst = this.firstLine.compareToIgnoreCase(address.getFirstLine());
//            if (compareFirst != 0) return compareFirst;
//
//            int compareSecond = this.secondLine.compareToIgnoreCase(address.getSecondLine());
//            return compareSecond;
//            return ((this.getPostCode() + this.getFirstLine() + this.getSecondLine()).compareTo(address.getPostCode() + address.getFirstLine() + address.getSecondLine()));

            // or use String builder
        StringBuilder LocalAddress = new StringBuilder();
        LocalAddress.append(this.getCity().toLowerCase());
        LocalAddress.append(this.getPostCode().toLowerCase());
        LocalAddress.append(this.getSecondLine().toLowerCase());
        LocalAddress.append(this.getFirstLine().toLowerCase());

        StringBuilder PassedAddress = new StringBuilder();
        PassedAddress.append(address.getCity().toLowerCase());
        PassedAddress.append(address.getPostCode().toLowerCase());
        PassedAddress.append(address.getSecondLine().toLowerCase());
        PassedAddress.append(address.getFirstLine().toLowerCase());

        return LocalAddress.compareTo(PassedAddress);


        }
    }

