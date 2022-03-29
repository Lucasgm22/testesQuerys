package com.exemplo.unitario.query.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonService {

    @Autowired
    TransactionTestService tts;

    @Transactional
    public void transactionTest() {
        try {
            tts.call1();
        } catch (Exception e) {
            System.err.println("call1 = " + e.getMessage());
        }

        try {
            tts.call2();
        } catch (Exception e) {
            System.err.println("call2 = " + e.getMessage());
        }
    }

}
