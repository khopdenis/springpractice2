package ru.liga.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("rate")
        );
    }
}
