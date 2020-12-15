package bootcamp.db;

import bootcamp.data.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        final int id = Integer.parseInt(rs.getString("ID"));
        String firstName = rs.getString("FIRST_NAME");
        String secondName = rs.getString("SECOND_NAME");
        final int addressId = Integer.parseInt(rs.getString("ADDRESS"));
        return new Person(firstName, secondName, Optional.of(id), Optional.of(addressId));
    }
}
