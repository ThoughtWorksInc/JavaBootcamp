package bootcamp.reader;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static bootcamp.reader.TestData.*;
import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.Status;
import bootcamp.db.AddressRowMapper;
import bootcamp.db.PersonRowMapper;

public class AddressDirectoryTests {
    @Test
    public void getResidentsHandlesResidentsFoundScenario() {
        final var mockTemplate = mock(NamedParameterJdbcTemplate.class);
        final List<Address> address = Arrays.asList(kingsway);
        final List<Person> people = Arrays.asList(john, maria);
        when(mockTemplate.query(anyString(), anyMap(), any(AddressRowMapper.class))).thenReturn(address);
        when(mockTemplate.query(anyString(), anyMap(), any(PersonRowMapper.class))).thenReturn(people);

        final var addressDirectory = new AddressDirectory(mockTemplate);
        final var result = addressDirectory.getResidents(kingsway);

        assertThat(result.value.get().residents, contains(john, maria));
        assertThat(result.value.get().address, is(kingsway));
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.message, is("Success"));
    }

    @Test
    public void getResidentsHandlesNoResidentsScenario() {
        final var mockTemplate = mock(NamedParameterJdbcTemplate.class);
        final List<Address> emptyAddressList = new ArrayList<>();
        when(mockTemplate.query(anyString(), anyMap(), any(AddressRowMapper.class))).thenReturn(emptyAddressList);

        final var addressDirectory = new AddressDirectory(mockTemplate);
        final var result = addressDirectory.getResidents(kingsway);

        assertThat(result.status, is(Status.NO_RESIDENTS_FOUND));
        assertThat(result.message, is("No residents found"));
        assertThat(result.value.isPresent(), is(false));
    }

    @Test
    public void getAddressHandlesAddresessFoundScenario() {
        final var mockTemplate = mock(NamedParameterJdbcTemplate.class);
        when(mockTemplate.query(anyString(), anyMap(), any(PersonRowMapper.class))).thenReturn(Arrays.asList(john));
        when(mockTemplate.query(anyString(), anyMap(), any(AddressRowMapper.class))).thenReturn(Arrays.asList(kingsway));

        final var addressDirectory = new AddressDirectory(mockTemplate);
        final var result = addressDirectory.getAddress(john);

        assertThat(result.value.get().address, is(kingsway));
        assertThat(result.value.get().person, is(john));
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.message, is("Success"));
    }

    @Test
    public void getAddressHandlesPersonNotFoundScenario() {
        final var mockTemplate = mock(NamedParameterJdbcTemplate.class);
        when(mockTemplate.query(anyString(), anyMap(), any(PersonRowMapper.class))).thenReturn(Arrays.asList());

        final var addressDirectory = new AddressDirectory(mockTemplate);
        final var result = addressDirectory.getAddress(john);

        assertThat(result.status, is(Status.NO_RESIDENTS_FOUND));
        assertThat(result.message, is("No residents found"));
        assertThat(result.value.isPresent(), is(false));
    }

    @Test
    public void getAddressHandlesAddressNotFoundScenario() {
        final var mockTemplate = mock(NamedParameterJdbcTemplate.class);
        when(mockTemplate.query(anyString(), anyMap(), any(PersonRowMapper.class))).thenReturn(Arrays.asList(john));
        when(mockTemplate.query(anyString(), anyMap(), any(AddressRowMapper.class))).thenReturn(Arrays.asList());

        final var addressDirectory = new AddressDirectory(mockTemplate);
        final var result = addressDirectory.getAddress(john);

        assertThat(result.status, is(Status.NO_ADDRESS_FOUND));
        assertThat(result.message, is("No address found"));
        assertThat(result.value.isPresent(), is(false));
    }
}