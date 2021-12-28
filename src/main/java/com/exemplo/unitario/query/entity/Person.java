package com.exemplo.unitario.query.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private String surname;
    @Id
    private String cpf;

}
