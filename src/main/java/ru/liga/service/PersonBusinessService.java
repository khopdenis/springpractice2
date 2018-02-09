package ru.liga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.dao.PersonDao;
import ru.liga.domain.Person;

import java.util.List;

@Component
public class PersonBusinessService {

    @Autowired
    private PersonDao personDao;

    public PersonBusinessService() {
    }

    public void multiplyRate(Double multiplier) {
        List<Person> all = personDao.findAll();
        all.stream().forEach(person -> {
                    person.setRate(person.getRate() * multiplier);
                    personDao.update(person);
                }
        );
    }

    public void printAll() {
        personDao.findAll().stream().forEach(person ->
                System.out.println(person)
        );
    }

}
