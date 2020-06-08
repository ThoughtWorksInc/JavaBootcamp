package bootcamp.directory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static bootcamp.directory.TestData.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bootcamp.data.PersonAddressPair;

public class AddressDirectoryTests {
    private AddressDirectory addressBook;

    @BeforeEach
    public void reInitializeAddressBook() {
        addressBook = new AddressDirectory(getInitialPairs());
    }

    @Test
    public void canGetAddress() {
        final var reysAddress = addressBook.getAddress(rey).get();
        assertThat(reysAddress, is(jakku));
    }

    @Test
    public void getsEmptyOptionalForNonExistentKey() {
        assertTrue(addressBook.getAddress(nonExistentPerson).isEmpty());
    }

    @Test
    public void canUpdateAddress() {
        final var reysNewHome = new PersonAddressPair(rey, millenniumFalcon);

        addressBook.updateAddress(reysNewHome);

        final var reysAddressFromAddressBook = addressBook.getAddress(rey).get();
        assertThat(reysAddressFromAddressBook, is(millenniumFalcon));
        assertThat(reysAddressFromAddressBook, is(not(jakku)));
    }

    @Test
    public void canRemoveEntry() {
        addressBook.remove(yoda);

        final var isYodaInAddressBook = addressBook.getAddress(yoda).isPresent();
        assertFalse(isYodaInAddressBook);
    }
}