package com.exemplo.unitario.query.repository;

import com.exemplo.unitario.query.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class PersonRepositoryTest {


    @Autowired
    private PersonRepository personRepository;

    @Test
    @Sql("/sql/insert-person.sql")
    void findBySurnameQuery() {
        assertNotNull(personRepository);

        personRepository.save(new Person("Lucas", "Miranda", "1519"));

        List<Person> personList = personRepository.findBySurnameQuery("Miranda");
        assertEquals(2, personList.size());
        personList.forEach(person -> assertEquals("Miranda", person.getSurname()));

        System.err.println(personList);

    }
}