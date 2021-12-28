package com.exemplo.unitario.query.repository;

import com.exemplo.unitario.query.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {

    @Query (value = "select * from person p where p.surname = :surname",
            nativeQuery = true)
    List<Person> findBySurnameQuery(@Param("surname") String surname);

}
