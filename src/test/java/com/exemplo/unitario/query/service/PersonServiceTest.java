package com.exemplo.unitario.query.service;

import com.exemplo.unitario.query.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
class PersonServiceTest {

    @Autowired
    private PersonService ps;

    @Autowired
    private PersonRepository pr;

    @Test
    void transactionTest() {
        System.err.println("before: " + pr.findAll());
        try {
            ps.transactionTest();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        System.err.println("after: " + pr.findAll());
    }
}