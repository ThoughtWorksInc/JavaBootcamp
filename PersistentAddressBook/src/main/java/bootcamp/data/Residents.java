package bootcamp.data;

import java.util.List;

public class Residents {
    private final Address address;
    private final List<Person> residents;

    public Residents(Address address, List<Person> residents) {
        this.address = address;
        this.residents = residents;
    }

    public List<Person> getResidents() {
        return residents;
    }

    public Address getAddress() {
        return address;
    }
}
