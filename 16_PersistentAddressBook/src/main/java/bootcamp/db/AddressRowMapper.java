package bootcamp.db;

import bootcamp.data.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String line1 = rs.getString("LINE_1");
        final String line2 = rs.getString("LINE_2");
        final String city = rs.getString("CITY");
        final String postCode = rs.getString("POST_CODE");
        final int id = rs.getInt("ID");
        return new Address(line1, line2, city, postCode, id);
    }
}
