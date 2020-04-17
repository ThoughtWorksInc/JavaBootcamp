package bootcamp.reader;

import bootcamp.data.*;
import bootcamp.db.AddressRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

        final List<Address> addressFromDb = template.query(addressSql, addressParams, new AddressRowMapper());

        /**
         * TODO
         * 1. If no address is returned, return the result with appropriate status and message.
         * 2. If address is returned, use the ID to create the parameters map for person query.
         * 3. Execute the query to get a list of people in the address.
         * 4. Package the results in the Residents object and return a Result instance.
         * 5. In case of errors, return an appropriate Result instance.
         */

        return null; //FIXME
    }

    public Result<PersonAddressPair> getAddress(final Person person) {
        final String personSql = "SELECT * FROM PERSON WHERE FIRST_NAME = :firstName AND SECOND_NAME = :secondName";
        final String addressSql = "SELECT * FROM ADDRESS WHERE ID = :addressId";

        /**
         * TODO
         * 1. Create a Map<String, String> which contains the keys firstName and secondName and the first and second names
         * from the argument person.
         * 2. Execute the query method on the template giving it the personSql, the map in (1) and an instance of PersonRowMapper (you need to create one).
         * 3. If the person exists, take the address ID from the data returned.
         * 4. Create a Map<String, Integer> with addressID as key and ID from (3).
         * 5. Execute the query method on the template giving it the addressSql, the map in (4) and an instance of AddressRowMapper.
         * 6. Return the results.
         */

        return null; //FIXME
    }

}
