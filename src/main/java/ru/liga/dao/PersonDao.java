package ru.liga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.liga.domain.Person;

import java.util.List;

@Component
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id = ? ", new PersonRowMapper(), id);
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonRowMapper());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ? ", id);
    }

    public void insert(Person person) {
        jdbcTemplate.update("INSERT INTO Person(ID, NAME, RATE) VALUES (?,?,?)", person.getId(), person.getName(), person.getRate());
    }

    public void update(Person person) {
        jdbcTemplate.update("UPDATE Person SET name = ?, rate=? WHERE id = ?", person.getName(), person.getRate(), person.getId());
    }

}
