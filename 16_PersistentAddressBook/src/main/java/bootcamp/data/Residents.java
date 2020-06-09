package bootcamp.data;

import java.util.List;

public class Residents {
    public final Address address;
    public final List<Person> residents;

    public Residents(final Address address, final List<Person> residents) {
        this.address = address;
        this.residents = residents;
    }
}
