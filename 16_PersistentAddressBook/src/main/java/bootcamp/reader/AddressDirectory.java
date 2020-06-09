package bootcamp.reader;

import bootcamp.data.*;
import bootcamp.db.AddressRowMapper;
import bootcamp.db.PersonRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AddressDirectory {
    private final NamedParameterJdbcTemplate template;

    @Autowired
    public AddressDirectory(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Result<Residents> getResidents(final Address address) {
        final String addressSql = "SELECT * FROM ADDRESS WHERE LINE_1 = :firstLine AND LINE_2 = :secondLine "
                + "AND CITY = :city AND POST_CODE = :postCode";
        final String personSql = "SELECT * FROM PERSON WHERE ADDRESS_ID = :addressId";

        final Map<String, String> addressParams = Map.of("firstLine", address.firstLine, "secondLine",
                address.secondLine, "city", address.city, "postCode", address.postCode);

        final List<Address> addressFromDb = template.query(addressSql, addressParams, new AddressRowMapper());

        if (addressFromDb.size() == 0) {
            return new Result<>(Status.NO_RESIDENTS_FOUND, "No residents found");
        }

        final Map<String, Integer> personParams = Map.of("addressId", addressFromDb.get(0).id.get());

        final List<Person> associationPeople = template.query(personSql, personParams, new PersonRowMapper());

        final var residents = new Residents(addressFromDb.get(0), associationPeople);

        return new Result<>(residents);
    }

    public Result<PersonAddressPair> getAddress(final Person person) {
        final String personSql = "SELECT * FROM PERSON WHERE FIRST_NAME = :firstName AND SECOND_NAME = :secondName";
        final String addressSql = "SELECT * FROM ADDRESS WHERE ID = :addressId";

        final Map<String, String> personParams = Map.of("firstName", person.firstName, "secondName", person.secondName);

        final var peopleFromDb = template.query(personSql, personParams, new PersonRowMapper());

        if (peopleFromDb.size() != 1) {
            return new Result<>(Status.NO_RESIDENTS_FOUND, "No residents found");
        }

        final Map<String, Integer> addressParams = Map.of("id", peopleFromDb.get(0).id.get());

        final var addresses = template.query(addressSql, addressParams, new AddressRowMapper());

        if (addresses.size() < 1) {
            return new Result<>(Status.NO_ADDRESS_FOUND, "No address found");
        }

        return new Result<>(new PersonAddressPair(peopleFromDb.get(0), addresses.get(0)));
    }
}
