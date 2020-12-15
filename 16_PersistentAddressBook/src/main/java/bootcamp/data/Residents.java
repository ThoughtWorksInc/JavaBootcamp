package bootcamp.data;


import java.util.List;

public class Residents {
    private final Address address;
    private final List<Person> residents;

    public Residents(Address address, List<Person> residents) {
        this.address = address;
        this.residents = residents;
    }

    public Address getAddress() {
        return this.address;
    }

    public List<Person> getResidents() {
        return this.residents;
    }
}
