package com.exemplo.unitario.query.service;

import com.exemplo.unitario.query.entity.Person;
import com.exemplo.unitario.query.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionTestService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void call1() throws Exception {
        personRepository.save(new Person("Lucas", "Miranda", "123"));
        personRepository.save(null);
        System.err.println("call1: " + personRepository.findAll());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void call2() {
        personRepository.save(new Person("Fulano", "De Tal", "789"));
        System.err.println("call2: " + personRepository.findAll());
    }
}
