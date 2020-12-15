package bootcamp.reader;

import bootcamp.data.*;
import bootcamp.db.AddressRowMapper;
import bootcamp.db.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class AddressDirectory {
    private final NamedParameterJdbcTemplate template;

    @Autowired
    public AddressDirectory(NamedParameterJdbcTemplate template){
        this.template = template;
    }

    public Result<Residents> getResidents(final Address address) {
        final String addressSql = "SELECT * FROM ADDRESS WHERE LINE_1 = :firstLine AND LINE_2 = :secondLine " +
                "AND CITY = :city AND POST_CODE = :postCode";
        final String personSql = "SELECT * FROM PERSON WHERE ADDRESS_ID = :addressId";

        final Map<String, String> addressParams = Map.of(
                "firstLine", address.getFirstLine(),
                "secondLine", address.getSecondLine(),
                "city", address.getCity(),
                "postCode", address.getPostCode());

        final List<Address> addressFromDb = this.template.query(addressSql, addressParams, new AddressRowMapper());

        if (addressFromDb == null) {
            return new Result<>(Status.ERROR);
        } else if (addressFromDb.isEmpty()) {
            return new Result<>(Status.ERROR, "No matching address record found");
        } else {
            int id = addressFromDb.get(0).getId().get();
            Map<String, Integer> params = Map.of("addressId", id);
            List<Person> people = this.template.query(personSql, params, new PersonRowMapper());
            return new Result<>(new Residents(address, people));
        }
    }

    public Result<PersonAddressPair> getAddress(final Person person) {
        final String personSql = "SELECT * FROM PERSON WHERE FIRST_NAME = :firstName AND SECOND_NAME = :secondName";
        final String addressSql = "SELECT * FROM ADDRESS WHERE ID = :addressId";
        Map<String, String> params = Map.of(
                ":firstName", person.getFirstName(),
                ":secondName", person.getSecondName());
        List<Person> people = this.template.query(personSql, params, new PersonRowMapper());
        if (people == null) {
            return new Result<>(Status.ERROR);
        } else if (people.isEmpty()) {
            return new Result<>(Status.ERROR, "No record for the given person was found");
        } else {
            Person foundPerson = people.get(0);
            Integer addressId = foundPerson.getAddressId().get();
            Map<String, Integer> addrParams = Map.of("addressId", addressId);
            List<Address> addresses = this.template.query(addressSql, addrParams, new AddressRowMapper());
            if (addresses == null) {
                return new Result<>(Status.ERROR);
            } else  if (addresses.isEmpty()) {
                return new Result<>(Status.DB_ERROR, "No address for the given person was found");
            } else {
                Address address = addresses.get(0);
                return new Result<>(new PersonAddressPair(person, address));
            }
        }
    }
}