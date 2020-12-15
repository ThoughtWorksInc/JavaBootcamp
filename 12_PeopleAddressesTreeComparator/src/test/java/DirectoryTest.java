import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.AddressDirectory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DirectoryTest {

    AddressDirectory directory;

    @Before
    public void beforeClass() {
        List<PersonAddressPair> pairList = new ArrayList<>() {{
            add(new PersonAddressPair(
                            new Person("John", "Smith"),
                            new Address("10 Old Kent Road", "", "E14 9XY", "London")
                    )
            );
            add(new PersonAddressPair(
                            new Person("Sally", "Sunday"),
                            new Address("3 Maxwell Crescent", "", "BF5 412", "Bradford")
                    )
            );
        }};
        this.directory = new AddressDirectory(pairList);
    }

    @Test
    public void testAddressExist() {
        Person john = new Person("John", "Smith");
        Assert.assertTrue(this.directory.getAddress(john).isPresent());
    }

    @Test
    public void testAddressNotExist() {
        Person john = new Person("John", "Smit");
        Assert.assertTrue(this.directory.getAddress(john).isEmpty());
    }

    @Test
    public void testUpdateAddressExist() {
        Person john = new Person("John", "Smith");
        Address newAddress = new Address("12 Old Kent Road", "","E14 9XZ", "London");
        boolean updated = this.directory.updateAddress(new PersonAddressPair(john, newAddress));
        Assert.assertTrue(updated);
    }

    @Test
    public void testUpdateAddressNotExist() {
        Person john = new Person("John", "Smit");
        Address newAddress = new Address("12 Old Kent Road", "","E14 9XZ", "London");
        boolean updated = this.directory.updateAddress(new PersonAddressPair(john, newAddress));
        Assert.assertFalse(updated);
    }

    @Test
    public void testRemoveAddress() {
        Person john = new Person("John", "Smith");
        Assert.assertTrue(this.directory.getAddress(john).isPresent());
        this.directory.remove(john);
        Assert.assertFalse(this.directory.getAddress(john).isPresent());
    }
}
