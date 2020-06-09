package bootcamp.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bootcamp.data.Person;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String firstName = rs.getString("FIRST_NAME");
        final String secondName = rs.getString("LAST_NAME");
        final int id = rs.getInt("ID");
        final int addressId = rs.getInt("ADDRESS_ID");

        return new Person(firstName, secondName, id, addressId);
    }
}